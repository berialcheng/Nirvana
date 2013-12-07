package org.nirvana.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalDefualtController {
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public ModelMap defaultExceptionHandler(HttpServletRequest request, Exception exception) {
		return new ModelMap().addAttribute("request", request.getRequestURI())
				.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value())
				.addAttribute("exception", exception.getMessage());
	}
}
