package com.lichuang.servletcode.errorhandler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ErrorHandler1
 */
@WebServlet("/ErrorHandler")
public class ErrorHandler1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ErrorHandler1() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Throwable throwable = (Throwable) request
				.getAttribute("javax.servlet.error.exception");//异常产生的信息
		Integer statusCode = (Integer) request
				.getAttribute("javax.servlet.error.status_code");//获取状态码
		Object exceptionType =  request
				.getAttribute("javax.servlet.error.exception_type");// 给出异常类型的信息
		String message = (String) request
				.getAttribute("javax.servlet.error.message");// 给出确切错误消息的信息
		String servletName = (String) request
				.getAttribute("javax.servlet.error.servlet_name");// Servlet 的名称
//		String requestUri = (String) request
//				.getAttribute("javax.servlet.error.request_uri");// 给出有关 URL 调用 Servlet 的信息
		if (servletName == null) {
			servletName = "Unknown";
		}
		String requestUri = (String) request
				.getAttribute("javax.servlet.error.request_uri");// 给出有关 URL 调用 Servlet 的信息
		if (requestUri == null) {
			requestUri = "Unknown";
		}
		// 设置响应内容类型
		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();
		String title = "菜鸟教程 Error/Exception 信息";

		String docType = "<!DOCTYPE html>\n";
		out.println(docType + "<html>\n" + "<head><title>" + title
				+ "</title></head>\n" + "<body bgcolor=\"#f0f0f0\">\n");
		out.println("<h1>菜鸟教程异常信息实例演示</h1>");
		if (throwable == null && statusCode == null) {
			out.println("<h2>错误信息丢失</h2>");
			out.println("请返回 <a href=\""
					+ response.encodeURL("http://localhost:8080/")
					+ "\">主页</a>。");
		} else if (statusCode != null) {
			out.println("错误代码 : " + statusCode);
		} else {
			out.println("<h2>错误信息</h2>");
			out.println("Servlet Name : " + servletName + "</br></br>");
			out.println("异常类型 : " + throwable.getClass().getName()
					+ "</br></br>");
			out.println("请求 URI: " + requestUri + "<br><br>");
			out.println("异常信息: " + throwable.getMessage());
		}
		out.println("</body>");
		out.println("</html>");
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
