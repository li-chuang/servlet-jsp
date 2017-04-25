package com.lichuang.servletcode.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class Authentication
 * 
 * @WebFilter 的属性
 * filterName 		String 	 		指定过滤器的 name 属性，等价于 <filter-name>
 * value 			String[] 		该属性等价于 urlPatterns 属性。但是两者不应该同时使用。
 * urlPatterns 		String[] 		指定一组过滤器的 URL 匹配模式。等价于 <url-pattern> 标签。
 * servletNames 	String[] 		指定过滤器将应用于哪些 Servlet。取值是 @WebServlet 中的 name 属性的取值，或者是 web.xml 中 <servlet-name> 的取值。
 * dispatcherTypes 	DispatcherType 	指定过滤器的转发模式。具体取值包括： ASYNC、ERROR、FORWARD、INCLUDE、REQUEST。
 * initParams 		WebInitParam[] 	指定一组过滤器初始化参数，等价于 <init-param> 标签。
 * asyncSupported 	boolean 		声明过滤器是否支持异步操作模式，等价于 <async-supported> 标签。
 * description 		String 			该过滤器的描述信息，等价于 <description> 标签。
 * displayName 		String 			该过滤器的显示名，通常配合工具使用，等价于 <display-name> 标签。
 */
@WebFilter("/*")
public class AuthenticationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthenticationFilter() {

    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("Filter destroy !!");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 输出站点名称
		System.out.println("站点网址：http://www.runoob.com");

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig config) throws ServletException {
		// 获取初始化参数
		String site = config.getInitParameter("Site"); 
		// 输出初始化参数
		System.out.println("网站名称: " + site); 
	}

}
