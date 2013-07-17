package grails.camel

class HomeController {

    def index() { }

    def test(){
    	sendMessage("seda:input" , "abc")
    }
}
