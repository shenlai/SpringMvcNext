package com.sl.view;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

@RequestMapping("product")
@Component
public class MyView implements View {

	@Override
	public String getContentType() {
		// TODO �Զ����ɵķ������
		return "text/html";
	}

	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO �Զ����ɵķ������
		
		System.out.println("executed render function");
        response.getWriter().println("view");
		
	}

}
