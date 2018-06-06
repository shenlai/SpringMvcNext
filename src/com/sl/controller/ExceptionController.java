package com.sl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("exception")
public class ExceptionController {

	// 示例1
		@RequestMapping("test")
		public ModelAndView test() {
	        System.out.println(10/0); //抛异常
			return new ModelAndView("order/info", "message", "test exception");
		}
		
		/*
		//默认从当前类中查找异常处理方法
		@ExceptionHandler({ArithmeticException.class})
	    public String handleException(Exception e){
			System.out.println("ExceptionController.handleException");
	        System.out.println(e);
	        return "order/info";
	    }
		*/

}
