package com.sl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "order")
public class OrderInfoController {

	// 示例1
	@RequestMapping("orderinfo")
	public ModelAndView OrderInfo1() {

		return new ModelAndView("order/info", "message", "OrderInfo");
	}

	// 示例2
	@RequestMapping({ "info", "index" }) // 或者@RequestMapping(value={"info","index"})
	public ModelAndView OrderInfo2() {

		return new ModelAndView("order/info", "message", "OrderInfo2");
	}

	// 示例3
	@RequestMapping
	public ModelAndView OrderInfo3() {
		return new ModelAndView("order/info", "message", "OrderInfo3");
	}

	// 示例4 method
	@RequestMapping(value = "detail", method = RequestMethod.GET) // @GetMapping("detail")
	public ModelAndView Detail() {
		return new ModelAndView("order/info", "message", "Info");
	}

	// 示例5 params 限定参数包含orderNumber
	@RequestMapping(value = "detail2", params = "orderNumber")
	public ModelAndView Detail2(String orderNumber) {
		return new ModelAndView("order/info", "message", orderNumber);
	}

	// 示例6 params 限定参数值
	@RequestMapping(value = "detail3", params = "orderNumber!=1222")
	public ModelAndView Detail3(String orderNumber) {
		return new ModelAndView("order/info", "message", orderNumber);
	}

	// 示例8 consumes 限定请求参数类型为application/json
	@RequestMapping(value = "consumes", method = RequestMethod.POST, consumes = "application/json")
	public ModelAndView Consumes(String orderNumber) {
		return new ModelAndView("order/info", "message", orderNumber);
	}

	// 示例9 produces 限定返回数据application/json
	@RequestMapping(value = "produces", method = RequestMethod.GET, produces = "application/json")
	public ModelAndView Produces(String orderNumber) {
		return new ModelAndView("order/info", "message", orderNumber);
	}

	// 示例10 带占位符的URL
	@RequestMapping(value = "order*", method = RequestMethod.GET)
	public ModelAndView OrderInfo4(String orderNumber) {
		return new ModelAndView("order/info", "message", "OrderInfo4");
	}

	// 示例10 带占位符的URL
	@RequestMapping(value = "user/{userId}/order/{orderNumber}", method = RequestMethod.GET)
	public ModelAndView OrderInfo5(@PathVariable int userId, @PathVariable String orderNumber) {
		return new ModelAndView("order/info", "message", "userid:" + userId + " orderNumber:" + orderNumber);
	}

}
