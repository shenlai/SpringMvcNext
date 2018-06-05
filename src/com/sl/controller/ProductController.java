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

	/***************** ��ȡ������� *********************/

	// ��1���������ͣ��Զ������ʹ���
	// ��2����ʹ��ע��
	// ��3����ʹ��ԭ��

	// RequestParamzע��
	@RequestMapping("info")
	public String productInfo(Model model, @RequestParam(name = "name", defaultValue = "test") String productName,
			@RequestParam(required = true) Integer productId) {
		model.addAttribute("message", "name��" + productName + "  productid:" + productId);
		return "product/info";
	}

	// ͨ��RequestHeaderע���ȡ����ͷ����Ϣ
	@RequestMapping("info2")
	public String productInfo2(Model model, @RequestHeader("User-Agent") String browser,
			@RequestHeader(value = "Accept-Language", required = false, defaultValue = "null") String language) {

		model.addAttribute("message", "browser��" + browser + "  language:" + language);
		return "product/info";
	}

	// ͨ��CookieValueע���ȡ����ͷ����Ϣ
	@RequestMapping("info3")
	public String productInfo3(Model model, @CookieValue("JSESSIONID") String cookie) {

		model.addAttribute("message", "JSESSIONID��" + cookie);
		return "product/info";
	}

	// ʹ��pojo����

	// ʹ��HttpServletRequest
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

	/*********************** Action ����ֵ ********************************/
	// 1.����ModelAndView

	// ����ModelAndView����ָ����ͼ����model���ݣ�ModelAndView�ṩ��addObject�����������ģ��������ݣ���ӵ���һ����ֵ�Ե�����
	@RequestMapping("info5")
	public ModelAndView productInfo5() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("product/detail");
		modelAndView.addObject("message", "return modelandview");
		//modelAndView.addObject("xxx", "yyy");
		return modelAndView;
	}

	//2.����void,Map,Model
	
	//2-1 ����Map
	// ����void,Map,Model ʱ�����ض�Ӧ���߼���ͼ���ƾ�������url����Ȼ��ѭ��prefixǰ׺+��ͼ���� +suffix��׺���
	// ������ͼ�� /springMvcNext/WEB-INF/view/product/detail.jsp
	@RequestMapping("detail")
	public Map<String, Object> detail2313() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "product detail");
		return map;
	}
	
	//2-2 ����void
	//����voidʱ������Ӧ����ͼҳ���ӦΪ���ʵ�ַ 
	//������ͼ�� /springMvcNext/WEB-INF/view/product/info6.jsp
	@RequestMapping("info6")
	public void productInfo6() {
		
	}
	
	//��������д����������ʱ���򲻻�ȥ������ͼ�����ǽ��������е�����ֱ����Ӧ���ͻ��ˣ���Ӧ�����������Ǵ��ı�
	@RequestMapping("info7")
	public void productInfo7(HttpServletResponse response) throws IOException {
		 response.getWriter().write("<h2>void method</h2>");//ֱ����Ӧ���
		 
	}
	@RequestMapping("info8")
	public void productInfo8(HttpServletResponse response) throws IOException {
		response.sendRedirect("detail");  //�ض���  ���ʣ�http://localhost:8080/springMvcNext/product/detail
	}
	
	//2-3 ����Model model���������ҳ����Ⱦ����ͼ·��ʹ�÷���������void���ơ�ʾ���������£�
		@RequestMapping("info9")
		public Model productInfo9(Model model) {
			model.addAttribute("message", "product detail");
	        return model;
		}
	
	  //3����String(��ͼ��)
		
		 //������ͼ����Controller�෽�������ַ�������ָ���߼���ͼ����ͨ����ͼ����������Ϊ������ͼ��ַ��
	    @RequestMapping("info10")
	    public String productInfo10(Model model)
	    {
	    	model.addAttribute("message", "productInfo10");
	        return "product/detail";
	    }
	
	/************************* ת�����ض���  **************************************/
	 //1 <mvc:view-controller>��ǩ
	    
	//2 �Զ�����ͼ
	@RequestMapping("myview")
	public String myView() {
		System.out.println("�Զ�������ͼ");
		
		//return "product/myView";  //ʧ��
		return "myView";  // beanName  ��MyView��render����response.getWriter().println("view");�����ҳ��
	}
	
	//3 �ض���
	//ֻҪ�ַ�������forward����redirect��ͷ����ôspringMVC�ͻ���������ɹؼ��֣�Ȼ�������Ӧ��ת���������ض������
	
	
	@RequestMapping("redirecttest")
	public String redirecttest(Model model) {
		 model.addAttribute("redirectparas", "test redirect");  //��������ת
		 return "redirect:/product/info10";
	}
	
	@RequestMapping("forwardtest")
    public String forwardtest(Model model){
		model.addAttribute("forwardparas", "test forward");  //��������ת
		 return "redirect:/product/info10";
    }
	
	
	/***************������֤**************************************************************/
	
	
	

}
