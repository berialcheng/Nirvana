class Pet():
    def __init__(self):
        print 'Pet::__init__'
    def sayHello(self):
        print "Pet"

class Cat(Pet):
    def __init__(self):
        Pet.__init__(self)
        self.data = "Cat"
        print 'Cat::__init__'
    def __str__(self):
        return "Miao~"
    
    def sayHello(self):
        print "Cat"

h = Cat()
h.sayHello()
print h.data
