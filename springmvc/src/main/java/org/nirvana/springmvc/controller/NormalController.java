package org.nirvana.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.nirvana.springmvc.domain.Book;

@Controller
@RequestMapping("/normal")
public class NormalController {
	
	/**
	 * appPath/servletPath/normal
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String printWelcome(ModelMap model)
	{
		model.addAttribute("message", "Spring 3 MVC Hello World");
		model.addAttribute("name", "XXX");

		return "hello";
	}
	
	/**
	 * Initialize form
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/form",method = RequestMethod.GET)
	public String initForm(ModelMap model){
		
		Book book = new Book("Star War");
		model.addAttribute("book", book);
		
		return "form";
	}
	
	/**
	 * process onSubmit
	 * 
	 * @param book
	 * @param result
	 * @param status
	 * @return
	 */
	@RequestMapping(value="/form",method = RequestMethod.POST)
	public String processSubmit(
		@ModelAttribute("book") Book book,
		BindingResult result, SessionStatus status) {
		
		System.out.println(book.getName());
 
		//clear the command object from the session
		status.setComplete(); 
 
		//return form success view
		return "success";
	}
}
