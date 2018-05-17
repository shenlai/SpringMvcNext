package com.sl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {
	
	
	@RequestMapping("/index")  //����URL·������/index��ͷ���������� ���� /index/* �� /index.html
	public ModelAndView helloWorld() {

		String message = "Hello Spring MVC";
		return new ModelAndView("index", "message", message);
	}
	
}
