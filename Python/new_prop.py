import sys

link = sys.argv[1]
temp = link
start_index = 38
link = link[start_index:]
end_index = link.find('/')
link = link[:end_index]

print(link)
import os
if not os.path.exists(link):
    os.makedirs(link)

file = open(link+'/README.md','w') 
file.write('this is the link for the problem \n')
file.write(temp)
file.close()

file = open(link+'/'+link+'.py','w') 
file.write('')
file.close()

from subprocess import call
call(["git", "add", "."])
call(["git", "commit", "-m", "initial directory for "+link])