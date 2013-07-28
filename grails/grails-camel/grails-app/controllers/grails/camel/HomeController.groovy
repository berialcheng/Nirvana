package grails.camel

class HomeController {

    def index() { }

    def test(){
    	sendMessage("seda:input" , "abc")
    }

    def exception(){
	sendMessage("seda:exception",params.exception)
    }
}
