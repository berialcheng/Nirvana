'''
Created on Apr 13, 2013

@author: zhongch
'''

from xml.etree import ElementTree

print 'start'

tree = ElementTree.parse("demo.xml");
#print tree.findall("items")
for items in tree.findall("items"):
    for item in items.findall("item"):
        print item.get('name')
        
print 'finish' 
