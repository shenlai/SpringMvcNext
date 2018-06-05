package com.sl.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("product")
public class ProductController {

	/***************** 获取请求参数 *********************/

	// 【1】：简单类型，自定义类型传递
	// 【2】：使用注解
	// 【3】：使用原生

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

	// 使用pojo传递

	// 使用HttpServletRequest
	@RequestMapping("info4")
	public String productInfo(String houseUnitInfo, HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		String productid = (String) request.getAttribute("productId");

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
		// System.out.println(wholeStr);
		return wholeStr;
	}

	/*********************** Action 返回值 ********************************/
	// 1.返回ModelAndView

	// 返回ModelAndView可以指定视图名和model数据，ModelAndView提供的addObject方法来给这个模型添加数据，添加的是一个键值对的数据
	@RequestMapping("info5")
	public ModelAndView productInfo5() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("product/detail");
		modelAndView.addObject("message", "return modelandview");
		//modelAndView.addObject("xxx", "yyy");
		return modelAndView;
	}

	//2.返回void,Map,Model
	
	//2-1 返回Map
	// 返回void,Map,Model 时，返回对应的逻辑视图名称就是请求url，仍然遵循：prefix前缀+视图名称 +suffix后缀组成
	// 访问视图： /springMvcNext/WEB-INF/view/product/detail.jsp
	@RequestMapping("detail")
	public Map<String, Object> detail2313() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "product detail");
		return map;
	}
	
	//2-2 返回void
	//返回void时，则响应的视图页面对应为访问地址 
	//访问视图： /springMvcNext/WEB-INF/view/product/info6.jsp
	@RequestMapping("info6")
	public void productInfo6() {
		
	}
	
	//但输出流中存在输出内容时，则不会去查找视图，而是将输入流中的内容直接响应到客户端，响应的内容类型是纯文本
	@RequestMapping("info7")
	public void productInfo7(HttpServletResponse response) throws IOException {
		 response.getWriter().write("<h2>void method</h2>");//直接相应结果
		 
	}
	@RequestMapping("info8")
	public void productInfo8(HttpServletResponse response) throws IOException {
		response.sendRedirect("detail");  //重定向  访问：http://localhost:8080/springMvcNext/product/detail
	}
	
	//2-3 返回Model model对象会用于页面渲染，视图路径使用方法名，与void类似。示例代码如下：
		@RequestMapping("info9")
		public Model productInfo9(Model model) {
			model.addAttribute("message", "product detail");
	        return model;
		}
	
	  //3返回String(视图名)
		
		 //返回视图名：Controller类方法返回字符串可以指定逻辑视图名，通过视图解析器解析为物理视图地址。
	    @RequestMapping("info10")
	    public String productInfo10(Model model)
	    {
	    	model.addAttribute("message", "productInfo10");
	        return "product/detail";
	    }
	
	/************************* 转发与重定向  **************************************/
	 //1 <mvc:view-controller>标签
	    
	//2 自定义视图
	@RequestMapping("myview")
	public String myView() {
		System.out.println("自定义是视图");
		
		//return "product/myView";  //失败
		return "myView";  // beanName  将MyView中render函数response.getWriter().println("view");输出到页面
	}
	
	//3 重定向
	//只要字符串中以forward或者redirect开头，那么springMVC就会把它解析成关键字，然后进行相应的转发，或者重定向操作
	
	
	@RequestMapping("redirecttest")
	public String redirecttest(Model model) {
		 model.addAttribute("redirectparas", "test redirect");  //带参数跳转
		 return "redirect:/product/info10";
	}
	
	@RequestMapping("forwardtest")
    public String forwardtest(Model model){
		model.addAttribute("forwardparas", "test forward");  //带参数跳转
		 return "redirect:/product/info10";
    }
	
	
	/***************数据验证**************************************************************/
	
	
	

}
