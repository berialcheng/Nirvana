from setuptools import setup, find_packages  

setup(name='black_cat',
      version='1.0.0',
      author='Adrian Zhong',
      author_email='czhong@hp.com',
      packages = find_packages(),  
      description = 'a demo for python package management',
      install_requires=[
          'cat',
          'jsonschema==2.3.0',
      ],
      )