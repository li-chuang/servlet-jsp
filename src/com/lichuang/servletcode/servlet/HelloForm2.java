package com.lichuang.servletcode.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloForm2
 */
@WebServlet("/HelloForm2")
public class HelloForm2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HelloForm2() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// 设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");	
		//response.setContentType("application/x-www-form-urlencoded; charset=UTF-8");

		PrintWriter out = response.getWriter();

		String title = "读取表单数据";
		String username = new String(request.getParameter("username").getBytes(
				"ISO8859-1"), "UTF-8");
		String password = request.getParameter("password");
		String worktype = new String(request.getParameter("people").getBytes("ISO8859-1"),"UTF-8");
		String quater = new String(request.getParameter("quater").getBytes("ISO8859-1"),"UTF-8");
		
		out.println("<!DOCTYPE html> \n" 
				+ "<html> \n" 
				+ "<head><title>"+ title + "</title></head>" 
				+ "<body bgcolor=\"#f0f0f0\">\n"
				+ "<h1 align=\"center\">" + title + "</h1>\n" 
				+ "<ul>\n"
				+ "  <li><b>用户名</b>：" + username + "\n" 
				+ "  <li><b>密码</b>：" + password + "\n" 
				+ "  <li><b>人员类型</b>：" + worktype + "\n" 
				+ "  <li><b>所在季度</b>：" + quater + "\n" 
				+ "</ul>\n" 
				+ "</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
