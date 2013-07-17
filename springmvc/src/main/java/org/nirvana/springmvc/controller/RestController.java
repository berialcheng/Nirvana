package org.nirvana.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nirvana.springmvc.domain.Person;

@Controller
@RequestMapping("/rest")
public class RestController {
	
	/**
	 * appPath/servletPath/rest/html/name
	 * 
	 * @param name
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/html/{name}", method = RequestMethod.GET)
	public String printWelcome(@PathVariable String name,ModelMap model)
	{
		
		model.addAttribute("message", "Spring 3 MVC Hello World");
		model.addAttribute("name", name);

		return "hello";
	}
	
	/**
	 * appPath/servletPath/rest/json/firstName/lastName
	 * 
	 * @param firstname
	 * @param lastname
	 * @return
	 */
	@RequestMapping(value="/json/{firstname}/{lastname}", method = RequestMethod.GET)
	@ResponseBody
	public Person getPersonInJson(@PathVariable String firstname, @PathVariable String lastname)
	{
		return new Person(firstname, lastname);
	}
}
