

import org.apache.camel.builder.RouteBuilder

class TemplateRoute extends RouteBuilder {
	def grailsApplication

    @Override
    void configure() {
		def config = grailsApplication?.config

        // example:
        from('seda:input').process{
        	it.getIn().setHeader("firstName", "Claus");
    		it.getIn().setHeader("lastName", "Ibsen");
    		it.getIn().setHeader("item", "Camel in Action");
    		it.getIn().setBody("PS: Next beer is on me, James");
        }
    	.to("velocity:letter.vm")
    	.to('stream:out')
    }
}
