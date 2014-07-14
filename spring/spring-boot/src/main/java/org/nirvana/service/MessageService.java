package org.nirvana.service;

import org.nirvana.domain.Product;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
	
	public String method1(){
		return "call MessageService.method()";
	}
	
	public Object method2(){
		Product product = new Product();
		product.setName("banana");
		return product;
	}
	
}
