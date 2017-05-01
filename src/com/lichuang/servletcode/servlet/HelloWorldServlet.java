package com.lichuang.servletcode;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private String message = "Hello World !";

	public void init() {
		System.out.println("init()执行。。。。。。");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		try {
			doPost(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html");

		try {
			PrintWriter writer = response.getWriter();
			writer.println("<h1>" + message + "</h1>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public void destroy() {
		System.out.println("destroy()开始执行。。。。。。");
	}
	
}
