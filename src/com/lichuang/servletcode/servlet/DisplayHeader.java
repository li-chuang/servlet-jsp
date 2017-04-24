package com.lichuang.servletcode.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayHeader
 */
@WebServlet("/DisplayHeader")
public class DisplayHeader extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayHeader() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();		
		String title = "HTTP Header 请求实例 - 菜鸟教程实例";
		String docType =
				"<!DOCTYPE html> \n";
				out.println(docType +
				"<html>\n" +
				"<head><meta charset=\"utf-8\"><title>" + title + "</title></head>\n"+
				"<body bgcolor=\"#f0f0f0\">\n" +
				"<h1 align=\"center\">" + title + "</h1>\n" +
				"<table width=\"100%\" border=\"1\" align=\"center\">\n" +
				"<tr bgcolor=\"#949494\">\n" +
				"<th>Header 名称</th><th>Header 值</th>\n"+
				"</tr>\n");
				
		Enumeration<String> headNames = request.getHeaderNames();// 返回一个枚举，包含在该请求中包含的所有的头名
		while(headNames.hasMoreElements()){
			String paramName = headNames.nextElement();
			out.print("<tr><td>" + paramName + "</td>\n");
			String paramValue = request.getHeader(paramName);// 以字符串形式返回指定的请求头的值
			out.println("<td> " + paramValue + "</td></tr>\n");		
		}
		out.println("</table>\n</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
