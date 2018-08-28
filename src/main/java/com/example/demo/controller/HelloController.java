package com.example.demo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	@RequestMapping("/hello")
	public String hello(HttpServletResponse response) throws IOException {
		System.out.println("hello contoller");
//		response.getWriter().println("hello world");
		return "hello/index";
	}
	
	/*@RequestMapping("/test1")
	public String test1() {
		System.out.println("test1 controller");
		return "test1";
	}*/
}
