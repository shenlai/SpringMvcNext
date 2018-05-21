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

	// ʾ��1
	@RequestMapping("orderinfo")
	public ModelAndView OrderInfo1() {

		return new ModelAndView("order/info", "message", "OrderInfo");
	}

	// ʾ��2
	@RequestMapping({ "info", "index" }) // ����@RequestMapping(value={"info","index"})
	public ModelAndView OrderInfo2() {

		return new ModelAndView("order/info", "message", "OrderInfo2");
	}

	// ʾ��3
	@RequestMapping
	public ModelAndView OrderInfo3() {
		return new ModelAndView("order/info", "message", "OrderInfo3");
	}

	// ʾ��4 method
	@RequestMapping(value = "detail", method = RequestMethod.GET) // @GetMapping("detail")
	public ModelAndView Detail() {
		return new ModelAndView("order/info", "message", "Info");
	}

	// ʾ��5 params �޶���������orderNumber
	@RequestMapping(value = "detail2", params = "orderNumber")
	public ModelAndView Detail2(String orderNumber) {
		return new ModelAndView("order/info", "message", orderNumber);
	}

	// ʾ��6 params �޶�����ֵ
	@RequestMapping(value = "detail3", params = "orderNumber!=1222")
	public ModelAndView Detail3(String orderNumber) {
		return new ModelAndView("order/info", "message", orderNumber);
	}

	// ʾ��8 consumes �޶������������Ϊapplication/json
	@RequestMapping(value = "consumes", method = RequestMethod.POST, consumes = "application/json")
	public ModelAndView Consumes(String orderNumber) {
		return new ModelAndView("order/info", "message", orderNumber);
	}

	// ʾ��9 produces �޶���������application/json
	@RequestMapping(value = "produces", method = RequestMethod.GET, produces = "application/json")
	public ModelAndView Produces(String orderNumber) {
		return new ModelAndView("order/info", "message", orderNumber);
	}

	// ʾ��10 ��ռλ����URL
	@RequestMapping(value = "order*", method = RequestMethod.GET)
	public ModelAndView OrderInfo4(String orderNumber) {
		return new ModelAndView("order/info", "message", "OrderInfo4");
	}

	// ʾ��10 ��ռλ����URL
	@RequestMapping(value = "user/{userId}/order/{orderNumber}", method = RequestMethod.GET)
	public ModelAndView OrderInfo5(@PathVariable int userId, @PathVariable String orderNumber) {
		return new ModelAndView("order/info", "message", "userid:" + userId + " orderNumber:" + orderNumber);
	}

}
