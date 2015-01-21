from types import FunctionType,MethodType
from utils import CustomUtils

def aop(func):
    def wrapper(*args, **kwds):
    	print "==========================="
        print "before call"
        value = func(*args, **kwds) 
        print "after call"
        print "==========================="
        return value 
    return wrapper

def monkey_patch(name, bases, dct):
    assert len(bases) == 1  
    base = bases[0]
    #print name, type(base),dir(base), type(dct), dir(dct)

    #add additional method
    '''for name, value in dct.iteritems():  
        if name not in ('__module__', '__metaclass__') and type(value) == FunctionType:  
            setattr(base, name, aop(value))'''

    #do the AOP wrapper
    for attr in dir(base):
   		m = getattr(base,attr)
   		if type(m) in [FunctionType,MethodType]:
   			print attr,type(m)
   			setattr(base,attr, aop(m))
    return base

class PatchA(CustomUtils):
    __metaclass__ = monkey_patch
    def patcha_method(self):
        print 'this is a method patched for class CustomUtils'
