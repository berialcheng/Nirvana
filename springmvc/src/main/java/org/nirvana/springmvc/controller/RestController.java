package org.nirvana.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nirvana.springmvc.domain.Book;
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
	 * appPath/servletPath/rest/xml/firstName/lastName
	 * 
	 * @param firstname
	 * @param lastname
	 * @return
	 */
	@RequestMapping(value="/xml/{firstname}/{lastname}", method = RequestMethod.GET)
	@ResponseBody
	public Person getPersonInXml(@PathVariable String firstname, @PathVariable String lastname)
	{
		return new Person(firstname, lastname);
	}
	
	/**
	 * appPath/servletPath/rest/json/name
	 * 
	 * @param firstname
	 * @param lastname
	 * @return
	 */
	@RequestMapping(value="/json/{name}", method = RequestMethod.GET)
	@ResponseBody
	public Book getBookInJson(@PathVariable String name)
	{
		return new Book(name);
	}
	
	/**
	 * appPath/servletPath/rest/json/book 
	 * 	POST	{"name":"dummyBookName"}
	 * @param book
	 * @return
	 */
	@RequestMapping(value="/json/book", method = RequestMethod.POST)
	@ResponseBody
	public String addBook(@RequestBody Book book)
	{
		System.out.println(book.getName());
		return "success";
	}
}
