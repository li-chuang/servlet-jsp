package com.lichuang.servletcode.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Refresh
 */
@WebServlet("/Refresh")
public class Refresh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Refresh() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 设置刷新自动加载时间为5秒
		response.setIntHeader("Refresh", 5);// 设置一个带有给定的名称和整数值的响应报头。
		// 设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");
		
		// 使用默认时区和语言环境获得一个日历
		Calendar cal = Calendar.getInstance();
		// 将日历类型转换为时间类型
		Date date = cal.getTime();
		// 将时间按照给定的格式输出为字符串
		String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
		
		String title = "自动刷新 Header 设置";
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html> \n" + 
				"<html>\n"+
				"<head><title>"+title+"</title></head>"+
				"<body bgcolor=\"#f0f0f0\"> \n"+
				"<h1 align='center'>"+title +"</h1>\n"+
				"<p>当前时间是："+nowTime+"</p>\n"+
				"</body>"+
				"</html>"			
				);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
