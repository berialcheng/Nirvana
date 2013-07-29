package mongo

class ContrainerController {

    def index() { 
		new Contrainer(father:new ChildTwo(fff:"ddd",name:'DummyName')).save()
	}
}
