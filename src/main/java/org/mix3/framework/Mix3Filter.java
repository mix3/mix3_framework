package org.mix3.framework;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Mix3Filter implements Filter{
	private FilterConfig filterConfig;
	private Application application;
	
	public void destroy() {
		filterConfig = null;
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		SimpleWrapper wrapper = new SimpleWrapper(httpServletResponse);
		
		System.out.println("#--[doFilter]--#");
		application.run(httpServletRequest, wrapper);
		System.out.println("#--------------#");
	}
	
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter Init");
		this.filterConfig = filterConfig;
		
		ApplicationFactory applicationFactory = new ApplicationFactory();
		application = applicationFactory.createApplication(this);
		application.setMix3Filter(this);
		application.init();
	}
	
	public FilterConfig getFilterConfig(){
		return filterConfig;
	}
}
