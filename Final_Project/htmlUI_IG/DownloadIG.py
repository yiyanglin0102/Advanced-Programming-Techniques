#!/usr/bin/env python
# coding: utf-8

# In[3]:


#!/usr/bin/env python
# coding: utf-8

import os, sys, re, subprocess, requests, numpy as np, glob
from instaloader import Instaloader, Profile, instaloader
from urllib.parse import urljoin
from bs4 import BeautifulSoup


subprocess.run(('rm -rf 0 1 2 3 4 5 6 7 8 9'), shell=True)

inputString = 'airplane'
keyword = '#' + inputString
p = subprocess.Popen('instaloader --login=ylin363 --post-filter="is_video" ' + '\"' + keyword + '\"', stdout=subprocess.PIPE, shell=True)

path = os.getcwd() + "/" + keyword

while True:
    counter = len(glob.glob1(path,"*.mp4"))
    if counter >= 10:
        p.kill()
        break

subprocess.run('cd ' + '.\/' + keyword + ' ; rm -rf *.jpg ; rm -rf *.txt ; rm -rf *.xz ; cd .. ; mv ' + '.\/' + keyword + ' ' + inputString, shell=True)

fileNameList = os.listdir('./' + inputString)


for i, name in enumerate(fileNameList):
    subprocess.run('mkdir ' + str(i), shell=True)
    subprocess.run('mv ' + inputString +'\/' + name + ' '+ str(i), shell=True)

subprocess.run('rmdir ' + inputString, shell=True)


# In[ ]:





# In[22]:


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
        
s = "let object = {link0:\""+os.getcwd() + '/0/' +fileNameList[0]+"\", link1:\""+os.getcwd() + '/1/' +fileNameList[1]+"\", link2:\""+os.getcwd() + '/2/' +fileNameList[2]+"\",  link3:\""+os.getcwd() + '/3/' +fileNameList[3]+"\", link4:\""+os.getcwd() + '/4/' +fileNameList[4]+"\", link5:\""+os.getcwd() + '/5/' +fileNameList[5]+"\", link6:\""+os.getcwd() + '/6/' +fileNameList[6]+"\", link7:\""+os.getcwd() + '/7/' +fileNameList[7]+"\", link8:\""+os.getcwd() + '/8/' +fileNameList[8]+"\", link9:\""+os.getcwd() + '/9/' +fileNameList[9]+"\"}"
        
delete_first_line("script.js")
line_prepender("script.js", s)


# In[5]:


for i in range(10):
    subprocess.run('cd ' + str(i) + '; echo "import subprocess\nsubprocess.run(\'scenedetect --input *.mp4 detect-content save-images; magick *.jpg images.gif; rm -rf *.jpg\', shell=True)" > ' + str(i) + '.py; '
                , shell=True)


# In[6]:


subprocess.run('cd 0; python3 0.py & cd .. ; cd 1; python3 1.py & cd .. ; cd 2; python3 2.py & cd .. ; cd 3; python3 3.py & cd .. ; cd 4; python3 4.py & cd .. ; cd 5; python3 5.py & cd .. ; cd 6; python3 6.py & cd .. ; cd 7; python3 7.py & cd .. ; cd 8; python3 8.py & cd .. ; cd 9; python3 9.py', shell=True)


# In[ ]:




