package com.sl.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//@Component
public class TestInterceptor implements HandlerInterceptor {
	
	 /**
     * 当目标方法执行之前，执行此方法，如果返回false，则不会执行目标方法，同样的，后面的拦截器也不会起作用
     * 可以用来做权限，日志等
     */
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        System.out.println("First preHandle 这个方法会最先执行..");
        return true;
    }

    /**
     * 执行目标方法之后调用，但是在渲染视图之前，就是转向jsp页面之前
     * 可以对请求域中的属性，或者视图进行修改
     */
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        System.out.println("First postHandle 执行目标方法之后调用，但是在渲染视图之前，就是转向jsp页面之前调用");
    }

    /**
     * 在渲染视图之后被调用
     * 释放资源
     */
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("First afterCompletion 在渲染视图之后被调用");
    }
}
