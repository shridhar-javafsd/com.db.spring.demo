package com.db.spring.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {

	private String message = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "\r\n" + "<head>\r\n" + "\r\n" + "</head>\r\n"
			+ "\r\n" + "<body>\r\n" + "    <h1 style=\"color:blue\">Heading</h1>\r\n" + "    <p>Paragraph</p>\r\n" + "\r\n" + "</body>\r\n"
			+ "\r\n" + "</html>";

	@RequestMapping("/hello")
	public String hello() {
		 
//		return this.message;

		return "Hello world!";
		
	}

}
