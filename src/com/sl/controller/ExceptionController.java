package com.sl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("exception")
public class ExceptionController {

	// ʾ��1
		@RequestMapping("test")
		public ModelAndView test() {
	        System.out.println(10/0); //���쳣
			return new ModelAndView("order/info", "message", "test exception");
		}
		
		/*
		//Ĭ�ϴӵ�ǰ���в����쳣������
		@ExceptionHandler({ArithmeticException.class})
	    public String handleException(Exception e){
			System.out.println("ExceptionController.handleException");
	        System.out.println(e);
	        return "order/info";
	    }
		*/

}
