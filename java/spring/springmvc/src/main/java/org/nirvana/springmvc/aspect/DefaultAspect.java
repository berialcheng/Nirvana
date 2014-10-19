package org.nirvana.springmvc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

@Aspect
public class DefaultAspect {

	@Around("within(org.nirvana.springmvc.controller..*)")
	public Object aroundAdvice(final ProceedingJoinPoint pjp) throws Throwable {
		// this is your response body
		Object responseBody = pjp.proceed();
		System.out.println("enter around advice");
		return new ModelMap().addAttribute("result", responseBody);
	}
}
