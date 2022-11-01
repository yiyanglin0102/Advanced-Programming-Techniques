#!/usr/bin/env python
# coding: utf-8

# In[1]:


import os, sys, re
import requests
import numpy as np
from urllib.parse import urljoin
from bs4 import BeautifulSoup


# In[2]:


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


# In[3]:


saveFullHtmlPage('https://www.youtube.com/results?search_query=love', 'love')


# In[4]:


with open("love.html") as fp:
        soup = BeautifulSoup(fp, 'html.parser')


# In[5]:


print(type(soup.select("body")[0].select("script")[13]))
# "videoIds": ["


# In[6]:


a = soup.select("body")[0]


# In[7]:


paragraphs = []
for x in a:
    paragraphs.append(str(x))


# In[8]:


paragraphs


# In[9]:


for i, a in enumerate(paragraphs):
    if "\"videoIds\":[\"" in a:
        b = paragraphs[31]


# In[ ]:





# In[10]:


"\"videoIds\":[\"" in b


# In[ ]:





# In[11]:


match=(re.search("videoIds", b))


# In[12]:


match


# In[13]:


b[7998: 8009]


# In[14]:


result = [_.start() for _ in re.finditer("\"videoIds\":", b)]
result


# In[15]:


b[7985]+ b[7986] + b[7987]+ b[7988]+ b[7989]+ b[7990]+ b[7991]+ b[7992]+ b[7993]+ b[7994]+ b[7995]+ b[7996]


# In[16]:


result


# In[17]:


result = np.add(result, 13).tolist()


# In[18]:


result


# In[19]:


settt = set()
for n in result:
    settt.add(b[n:n+11])


# In[20]:


settt = list(settt)


# In[21]:


settt


# In[22]:


for i in range(len(settt)):
    settt[i] = "youtube.com/watch?v=" + settt[i]


# In[23]:


settt


# In[ ]:





# In[ ]:




