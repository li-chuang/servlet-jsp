package com.lichuang.servletcode.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloForm
 * 
 * http://localhost:8080/MyServlet/HelloForm?name=%E8%8F%9C%E9%B8%9F%E6%95%99%E7%A8%8B&url=www.runoob.com
 * 
 * 注意@WebServlet这个注解，这个注解与springMVC的注解很类似，可以代替web.xml中的配置，很方便
 */
@WebServlet("/HelloForm")
public class HelloForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloForm() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String title = "使用 GET 方法读取表单数据";
		
		// 注意，假如有汉字，需要这样转码
		// 先将汉字用ISO8859-1编码格式解析为字符数组形式，然后将此字符数组用UTF-8转码为通用格式
		String name = new String(request.getParameter("name").getBytes("ISO8859-1"),"UTF-8");
		String url = request.getParameter("url");
		
		// 这里是直接将html写在Servlet中，实际上应该再用一个文件写前端代码
		String docType = "<!DOCTYPE html> \n";
		out.println(docType +
		    "<html>\n" +
		    "<head><title>" + title + "</title></head>\n" +
		    "<body bgcolor=\"#f0f0f0\">\n" +
		    "<h1 align=\"center\">" + title + "</h1>\n" +
		    "<ul>\n" +
		    "  <li><b>站点名</b>："
		    + name + "\n" +
		    "  <li><b>网址</b>："
		    + url + "\n" +
		    "</ul>\n" +
		    "</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
