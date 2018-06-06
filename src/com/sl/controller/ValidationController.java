package com.sl.controller;
//import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("validate")
@Controller
public class ValidationController {

	@RequestMapping("test")
	public String test() {
		//@Valid Product product
		return "validate/info"; 
	}
}
