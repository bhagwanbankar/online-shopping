package org.bhagwan.onlineshopping.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException(){
		ModelAndView mv= new ModelAndView("error");
		mv.addObject("errorTitle","The page is not Constructed");
		mv.addObject("errorDecritpion","The page you are looking not available now!!");
		mv.addObject("title","404 error page");
		return mv;
		
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException(){
		ModelAndView mv= new ModelAndView("error");
		mv.addObject("errorTitle","The product not available");
		mv.addObject("errorDecritpion","The product you are looking for not available now!!");
		mv.addObject("title","product not available");
		return mv;
		
	}
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex){
		ModelAndView mv= new ModelAndView("error");
		mv.addObject("errorTitle","Contact your Administrator");
		/*
		 * only for debugging
		 */
		StringWriter sw= new StringWriter();
		PrintWriter pw= new PrintWriter(sw);
		ex.printStackTrace(pw);
		mv.addObject("errorDecritpion",sw.toString());
		mv.addObject("title","Error");
		return mv;
		
	}
	
}
