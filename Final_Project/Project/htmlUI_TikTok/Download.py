#!/usr/bin/env python
# coding: utf-8

# In[31]:


#!/usr/bin/env python
# coding: utf-8

import os, sys, re, subprocess, requests, numpy as np
from urllib.parse import urljoin
from bs4 import BeautifulSoup

# keyword = 'airplane'
keyword = sys.argv[1]

subprocess.run(('rm -rf 0 1 2 3 4 5 6 7 8 9'), shell=True)


def saveFullHtmlPage(url, pagepath='page', session=requests.Session(), html=None):
    """Save web page html and supported contents        
        * pagepath : path-to-page   
        It will create a file  `'path-to-page'.html` and a folder `'path-to-page'_files`
    """
    def savenRename(soup, pagefolder, session, url, tag, inner):
        if not os.path.exists(pagefolder): # create only once
            os.mkdir(pagefolder)
        for res in soup.findAll(tag):   # images, css, etc..
            if res.has_attr(inner): # check inner tag (file object) MUST exists  
                try:
                    filename, ext = os.path.splitext(os.path.basename(res[inner])) # get name and extension
                    filename = re.sub('\W+', '', filename) + ext # clean special chars from name
                    fileurl = urljoin(url, res.get(inner))
                    filepath = os.path.join(pagefolder, filename)
                    # rename html ref so can move html and folder of files anywhere
                    res[inner] = os.path.join(os.path.basename(pagefolder), filename)
                    if not os.path.isfile(filepath): # was not downloaded
                        with open(filepath, 'wb') as file:
                            filebin = session.get(fileurl)
                            file.write(filebin.content)
                except Exception as exc:
                    print(exc, file=sys.stderr)
    if not html:
        html = session.get(url).text
    soup = BeautifulSoup(html, "html.parser")
    path, _ = os.path.splitext(pagepath)
    pagefolder = path+'_files' # page contents folder
    tags_inner = {'img': 'src', 'link': 'href', 'script': 'src'} # tag&inner tags to grab
    for tag, inner in tags_inner.items(): # saves resource files and rename refs
        savenRename(soup, pagefolder, session, url, tag, inner)
    with open(path+'.html', 'wb') as file: # saves modified html doc
        file.write(soup.prettify('utf-8'))

saveFullHtmlPage('https://www.tiktok.com/tag/' + keyword , keyword)



# In[32]:


with open(keyword + ".html") as fp:
    soup = BeautifulSoup(fp, 'html.parser')

videos = []
tags = soup.body.find_all('div')[1].find_all("a")
for link in tags:
    if "video" in str(link.get('href')) and "www.tiktok.com" in str(link.get('href')):
        videos.append(str(link.get('href')))


# In[33]:


videos


# In[34]:


subprocess.run(('rm '+ keyword + '.html'), shell=True)
subprocess.run(('rm -rf '+ keyword + '_files'), shell=True)


# In[35]:


videos = videos[:10]
videos


# In[36]:


def delete_first_line(filename):
    with open(filename, 'r') as fin:
        data = fin.read().splitlines(True)
    with open(filename, 'w') as fout:
        fout.writelines(data[1:])
        
def line_prepender(filename, line):
    with open(filename, 'r+') as f:
        content = f.read()
        f.seek(0, 0)
        f.write(line.rstrip('\r\n') + '\n' + content)
        
s = "let object = {link0:\""+videos[0]+"\", link1:\""+videos[1]+"\", link2:\""+videos[2]+"\", link3:\""+videos[3]+"\", link4:\""+videos[4]+"\", link5:\""+videos[5]+"\", link6:\""+videos[6]+"\", link7:\""+videos[7]+"\", link8:\""+videos[8]+"\", link9:\""+videos[9]+"\"}"
        
delete_first_line("script.js")
line_prepender("script.js", s)


# In[ ]:


# subprocess.run('python3 -m tiktok_downloader --url https://www.tiktok.com/@sneakyhero93/video/7159191712911363334 --snaptik --save tiktok.mp4', shell=True)



# In[ ]:


for i in range(10):
    subprocess.run('mkdir '+ str(i) + '; cd ' + str(i) + '; echo "import subprocess\nsubprocess.run(\'python3 -m tiktok_downloader --url '+videos[i]+' --snaptik --save tiktok.mp4 '+'; scenedetect --input *.mp4 detect-content save-images; magick *.jpg images.gif; rm -rf *.jpg\', shell=True)" > ' + str(i) + '.py; '
                , shell=True)


# In[ ]:


subprocess.run('cd 0; python3 0.py & cd .. ; cd 1; python3 1.py & cd .. ; cd 2; python3 2.py & cd .. ; cd 3; python3 3.py & cd .. ; cd 4; python3 4.py & cd .. ; cd 5; python3 5.py & cd .. ; cd 6; python3 6.py & cd .. ; cd 7; python3 7.py & cd .. ; cd 8; python3 8.py & cd .. ; cd 9; python3 9.py', shell=True)


# In[ ]:





# In[ ]:





# In[ ]:





# In[ ]:




