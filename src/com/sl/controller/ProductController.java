package com.sl.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//获取请求参数
@Controller
@RequestMapping("product")
public class ProductController {

	//【1】：简单类型，自定义类型传递
	//【2】：使用注解
	//【3】：使用原生
	
	// RequestParamz注解
	@RequestMapping("info")
	public String productInfo(Model model, @RequestParam(name = "name", defaultValue = "test") String productName,
			@RequestParam(required = true) Integer productId) {
		model.addAttribute("message", "name：" + productName + "  productid:" + productId);
		return "product/info";
	}

	// 通过RequestHeader注解获取请求头的信息
	@RequestMapping("info2")
	public String productInfo2(Model model, @RequestHeader("User-Agent") String browser,
			@RequestHeader(value = "Accept-Language", required = false, defaultValue = "null") String language) {

		model.addAttribute("message", "browser：" + browser + "  language:" + language);
		return "product/info";
	}

	// 通过CookieValue注解获取请求头的信息
	@RequestMapping("info3")
	public String productInfo3(Model model, @CookieValue("JSESSIONID") String cookie) {

		model.addAttribute("message", "JSESSIONID：" + cookie);
		return "product/info";
	}
	
	//使用pojo传递
	
	
	//使用HttpServletRequest
	@RequestMapping("info4")
	public String productInfo(String houseUnitInfo,HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		String  productid = (String)request.getAttribute("productId");
		
		String requestStr = charReader(request);
		
		System.out.println(productid);
		System.out.println(requestStr);
		
		return "product/info";
	}
	
	private String charReader(HttpServletRequest request) throws IOException {
		BufferedReader br = request.getReader();
		String str, wholeStr = "";
		while ((str = br.readLine()) != null) {
			wholeStr += str;
		}
		//System.out.println(wholeStr);
		return wholeStr;
	}
	

}
