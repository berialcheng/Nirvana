package org.nirvana.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/welcome")
public class HelloWorldController {
	
	@RequestMapping(value="/{name}", method = RequestMethod.GET)
	public String handle(@PathVariable String name,ModelMap model)
	{
		
		model.addAttribute("message", "Spring 3 MVC Hello World");
		model.addAttribute("name", name);

		return "hello";
	}
}
