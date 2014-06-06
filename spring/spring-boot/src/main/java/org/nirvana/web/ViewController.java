package org.nirvana.web;

import java.util.ArrayList;
import java.util.List;

import org.nirvana.domain.Product;
import org.nirvana.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ViewController {
	
	@Autowired
	MessageService messageService;
	
	@RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }
	
	@RequestMapping("/fragment_layout")
    String index(Model model) {
		model.addAttribute("msgs.headers.name","测试名字");
		model.addAttribute("msgs.headers.price","测试");
		List allProducts = new ArrayList<Product>();
		Product product1 = new Product();
		product1.setName("HP Laptop Folio 9470m");
		product1.setPrice((float) 1.1113);
		
		Product product2 = new Product();
		product2.setName("HP Laptop Elite 8440p");
		product2.setPrice((float) 1.1413);
		
		allProducts.add(product1);
		allProducts.add(product2);
		
		model.addAttribute("allProducts", allProducts);
		model.addAttribute("msgs", messageService);
		
        return "fragment_view";
    }
	
	@RequestMapping("/decorator_layout")
    String index2(Model model) {
		model.addAttribute("msgs.headers.name","测试名字");
		model.addAttribute("msgs.headers.price","测试");
		List allProducts = new ArrayList<Product>();
		Product product1 = new Product();
		product1.setName("HP Laptop Folio 9470m");
		product1.setPrice((float) 1.1113);
		
		Product product2 = new Product();
		product2.setName("HP Laptop Elite 8440p");
		product2.setPrice((float) 1.1413);
		
		allProducts.add(product1);
		allProducts.add(product2);
		
		model.addAttribute("allProducts", allProducts);
		model.addAttribute("msgs", messageService);	
		
        return "decorator_view";
    }
}