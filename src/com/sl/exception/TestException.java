package com.sl.exception;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

//https://www.cnblogs.com/junzi2099/p/7840294.html

//进行全局的异常控制
//@Component
public class TestException implements HandlerExceptionResolver{

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		if(ex instanceof IOException){
			return new ModelAndView("ioexp");
		}else if(ex instanceof SQLException){
			return new ModelAndView("sqlexp");
		}else {
			return new ModelAndView("home");
		}
		
	}
	

}
