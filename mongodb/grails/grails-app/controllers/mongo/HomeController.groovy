package mongo

class HomeController {

    def index() { 
    	/* success */
    	//new Person(name:"Adrian",sex:Sex.MALE).save()
    	/* error */
    	//def p = new Person(sex:Sex.FEMALE)
    	//p.save()
    	//println "The error is : ${p.errors}"

    	/* embed success */
    	//def p2 = new Person(name:"Adrian",sex:Sex.MALE,address:new Address(location:'dummy street'))
    	//p2.save()
    	//println p2.errors
    	/* embed success */
    	//def p2 = new Person(name:"Adrian",sex:Sex.MALE,address:new Address())
    	//p2.save()
    	//println p2.errors
    	/* embed add nullable constraint */
    	//def p2 = new Person(name:"Adrian",sex:Sex.MALE,address:new Address())
    	//p2.save()
    	//println p2.errors

        /* embed list */
        def p3 = new Person(name:"Adrian",sex:Sex.MALE,address:new Address(location:'dummy street'),otherAddresses:[new Address(location:'dummy street in list')])
        p3.save()
        println p3.errors
    }
}
