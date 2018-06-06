package com.sl.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//@Component
public class TestInterceptor implements HandlerInterceptor {
	
	 /**
     * ��Ŀ�귽��ִ��֮ǰ��ִ�д˷������������false���򲻻�ִ��Ŀ�귽����ͬ���ģ������������Ҳ����������
     * ����������Ȩ�ޣ���־��
     */
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        System.out.println("First preHandle �������������ִ��..");
        return true;
    }

    /**
     * ִ��Ŀ�귽��֮����ã���������Ⱦ��ͼ֮ǰ������ת��jspҳ��֮ǰ
     * ���Զ��������е����ԣ�������ͼ�����޸�
     */
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        System.out.println("First postHandle ִ��Ŀ�귽��֮����ã���������Ⱦ��ͼ֮ǰ������ת��jspҳ��֮ǰ����");
    }

    /**
     * ����Ⱦ��ͼ֮�󱻵���
     * �ͷ���Դ
     */
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("First afterCompletion ����Ⱦ��ͼ֮�󱻵���");
    }
}
