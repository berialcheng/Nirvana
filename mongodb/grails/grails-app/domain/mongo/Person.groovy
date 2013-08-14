package mongo

class Person {

	String name
	Sex sex
	Address address
	Collection<Address> otherAddresses

    static constraints = {
    }

    static mapping = {
    	name attr:"first_name"
    	collection "person_collection"
    }

    static embedded = ['address']
}

enum Sex{
	MALE,
	FEMALE
}

class Address{
	String location

	static constraints = {
		//location nullable:true
    }
}
