package org.nirvana.webservice;

import static org.junit.Assert.*;

import javax.xml.ws.Endpoint;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.junit.Before;
import org.junit.Test;

public class ServiceTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("Starting Server");
		HelloWorldImpl implementor = new HelloWorldImpl();
		String address = "http://localhost:9000/helloWorld";
		Endpoint.publish(address, implementor);
	}

	@Test
	public void test() {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		//factory.getInInterceptors().add(new LoggingInInterceptor());
		//factory.getOutInterceptors().add(new LoggingOutInterceptor());
		factory.setServiceClass(HelloWorld.class);
		factory.setAddress("http://localhost:9000/helloWorld");
		HelloWorld client = (HelloWorld) factory.create();

		String reply = client.sayHi("HI");
		System.out.println("Server said: " + reply);
	}

}
