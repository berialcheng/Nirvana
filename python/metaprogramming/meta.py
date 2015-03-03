from types import FunctionType
from datetime import datetime

def aop(func):
    def wrapper(*args, **kwds):
        begin = datetime.now()
        value = func(*args, **kwds) 
        end = datetime.now()
        print  "#Profiling# , " , func.__module__, " , " , func.__name__, " , ", (end - begin).total_seconds()
        return value 
    return wrapper

class ProfilingDecorator(type):  
    def __new__(cls, name, bases, dct):  
        for name, value in dct.iteritems():  
            if name not in ('__metaclass__', '__init__', '__module__') and type(value) == FunctionType:  
                value = aop(value)
            dct[name] = value  
        return type.__new__(cls, name, bases, dct)
