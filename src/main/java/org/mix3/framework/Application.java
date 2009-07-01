package org.mix3.framework;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public abstract class Application {
	public void setMix3Filter(Mix3Filter mix3Filter){}
	public void run(HttpServletRequest request, SimpleWrapper response) throws IOException {
		System.out.println("path:"+getURI(request));
		System.out.print("param:?");
		
		int i = 0;
		for(Object o : request.getParameterMap().entrySet()){
			Map.Entry<String, String[]> e = (Map.Entry<String, String[]>)o;
			if(i != 0){
				System.out.print("&");
			}
			
			System.out.print(e.getKey()+"="+e.getValue()[0]);
			i++;
		}
		System.out.println();
		URL url = this.getClass().getResource(getURI(request)+".html");
		Boolean exist = new File(url.getPath()).exists();
		response.getResponse().getOutputStream().println("<html><body>test</body></html>");
	}
	
	public String getURI(HttpServletRequest request){
		String uri = request.getRequestURI();
		uri = uri.replaceFirst("^/", "");
		uri = uri.replaceFirst("/$", "");
		return uri;
	}
	abstract public void init();
}
