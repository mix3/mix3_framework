package org.mix3.framework;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class MyFilter implements Filter{
	private FilterConfig filterConfig;
	
	public void destroy() {
		filterConfig = null;
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter");
		System.out.println(this.filterConfig.getInitParameter("applicationClassName"));
		System.out.println("URI:"+((HttpServletRequest)request).getRequestURI());
		for(Object o : request.getParameterMap().keySet()){
			String key = (String)o;
			System.out.println("key:"+key+" value:"+request.getParameter(key));
		}
//		System.out.println(((HttpServletRequest) request).getRequestURL() + "：" + new java.util.Date());
//		long start = System.currentTimeMillis();
//		System.out.println("Milliseconds in: " + start);
		chain.doFilter(request, response);
//		long end = System.currentTimeMillis();
//		System.out.println("Milliseconds out: " + end);
	}
	
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init");
		this.filterConfig = filterConfig;
	}
}
