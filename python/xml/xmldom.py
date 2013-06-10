'''
Created on Apr 13, 2013

@author: zhongch
'''

from xml.dom import minidom

print "start"

xmldoc = minidom.parse("demo.xml")
itemlist = xmldoc.getElementsByTagName("item")
print len(itemlist);
print itemlist[0].attributes['name'].value
for s in itemlist:
    print s.attributes['name'].value
    
print "finish"