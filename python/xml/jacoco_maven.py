'''
Created on Apr 15, 2013

@author: zhongch
'''
from xml.etree import ElementTree

def add_jacoco_support(file, is_it_project):
    pom = ElementTree.parse(file)
    root = pom.getroot()
    if root.tag == 'project' :
        add_jacoco_properties(root)
        add_jacoco_plugin(root, is_it_project)
    else :
        print 'target file['+ file + '] is not maven project xml!'
        return
    pom.write(file)
    
def add_jacoco_properties(element_root):
    
    def add_coverage_plugin(properties):
        if properties.find('sonar.java.coveragePlugin') != None:
            print 'already have property sonar.java.coveragePlugin'
        else:
            coveragePlugin = ElementTree.Element('sonar.java.coveragePlugin')
            coveragePlugin.text = 'jacoco'
            properties.append(coveragePlugin)
        
    def add_dynamic_analysis(properties):
        if properties.find('sonar.dynamicAnalysis') != None:
            print 'already have property sonar.dynamicAnalysis'
        else:
            dynamicAnalysis = ElementTree.Element('sonar.dynamicAnalysis')
            dynamicAnalysis.text = 'reuseReports'
            properties.append(dynamicAnalysis)
        
    def add_it_report_path(properties):
        if properties.find('sonar.jacoco.itReportPath') != None:
            print 'already have property sonar.jacoco.itReportPath'
        else:
            itReportPath = ElementTree.Element('sonar.jacoco.itReportPath')
            itReportPath.text = '${project.basedir}/../target/jacoco-it.exec'
            properties.append(itReportPath)
        
    properties = element_root.find("properties")
    if properties == None:
        properties = ElementTree.Element('properties')
        element_root.append(properties)
    
    add_coverage_plugin(properties)
    add_dynamic_analysis(properties)
    add_it_report_path(properties)
    return 
    
def add_jacoco_plugin(element_root, is_it_project):
    if len(filter(lambda x:x.text == 'jacoco-maven-plugin', element_root.findall('build/plugins/plugin/artifactId'))) == 1:
        print 'already have plugin:jacoco-maven-plugin'
    else:
        build_tag = element_root.find("build")
        if build_tag == None:
            build_tag = ElementTree.Element('build')
            element_root.append(build_tag)
        
        plugins_tag = build_tag.find('plugins')
        if plugins_tag == None:
            plugins_tag = ElementTree.Element('plugins')
            build_tag.append(plugins_tag)
            
        if is_it_project == False:
            print 'add jacoco_plugin'
            plugin_tag = ElementTree.parse('jacoco_plugin.xml').getroot()
            plugins_tag.append(plugin_tag)
        else:
            print 'add jacoco_it_plugin'
            plugin_tag = ElementTree.parse('jacoco_plugin_it.xml').getroot()
            plugins_tag.append(plugin_tag)
    

if __name__ == "__main__":
    add_jacoco_support('target/pom.xml', False)
    
