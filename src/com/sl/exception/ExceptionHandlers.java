package com.sl.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
@ResponseBody
public class ExceptionHandlers {
	
	/*
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	     @ExceptionHandler(Exception.class)
	     public ServiceResponse handleException(Exception e) {
	         if (e instanceof BusinessException){
	             return ServiceResponseHandle.failed("BUSINESS_ERROR", e.getMessage());
	         }
	         
	         logger.error("服务运行异常", e);
	         e.printStackTrace();
	         return ServiceResponseHandle.failed("server_error");
	     }
	*/
	
	@ExceptionHandler({ArithmeticException.class})
    public ModelAndView toException(Exception e){
        ModelAndView mv = new ModelAndView("home");
        System.out.println("gobal handler exception");
        //虽然不能使用Map往request中存值，但是可以使用下面的方法
        mv.addObject("error", e);
        System.out.println(e);
        return mv;
    }

}
