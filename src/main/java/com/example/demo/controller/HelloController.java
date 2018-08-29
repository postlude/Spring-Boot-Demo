package com.example.demo.controller;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.HelloService;

@Controller
@RequestMapping("/hello")
public class HelloController {
	@Autowired
	private HelloService helloService;
	
	/*@RequestMapping("/hello")
	public String hello(HttpServletResponse response) throws IOException {
		System.out.println("hello contoller");
//		response.getWriter().println("hello world");
		return "hello/index";
	}*/
	
	/*@RequestMapping("/test1")
	public String test1() {
		System.out.println("test1 controller");
		return "test1";
	}*/
	
	// get 방식을 맵핑 (@PostMapping : post 방식 맵핑)
	@GetMapping("")
	public String get(ModelMap modelMap) throws Exception {
//		Map<String, String> test = Collections.singletonMap("name", "테스트");
//		Map<String, Object> result = Collections.singletonMap("test", test);
//
//		modelMap.put("result", result);
		
		modelMap.put("result", helloService.getTest());

		return "/hello/get";
	}
}
