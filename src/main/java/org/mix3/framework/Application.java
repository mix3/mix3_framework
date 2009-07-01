package org.mix3.framework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

public abstract class Application {
	public void setMix3Filter(Mix3Filter mix3Filter){}
	public void run(HttpServletRequest request, SimpleWrapper response){
		System.out.println("run");
		File file = null;
		try{
			file = new File(getClass().getResource(getURI(request)+".html").getPath());
			System.out.println("true");
		}catch(NullPointerException e){
			System.out.println("false");
		}
		try{
			BufferedReader in
			   = new BufferedReader(
			           new InputStreamReader(
			                  new FileInputStream(file),"utf8"));
			String str = "";
			while((str = in.readLine()) != null){
				response.getResponse().getOutputStream().println(str);
			}
			in.close();
		}catch(IOException e){
			throw new Mix3RuntimeException(e);
		}
	}
	
	public String getURI(HttpServletRequest request){
		String uri = request.getRequestURI();
		uri = uri.replaceFirst("^/", "");
		uri = uri.replaceFirst("/$", "");
		return uri;
	}
	abstract public void init();
}
