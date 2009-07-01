package org.mix3.framework;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class SimpleWrapper extends HttpServletResponseWrapper{
	private CharArrayWriter caw = null;
	
	public SimpleWrapper(HttpServletResponse response) {
		super(response);
		caw  = new CharArrayWriter();
	}
	
	public String toString(){
		return caw.toString();
	}
	
	public PrintWriter getWriter(){
		return new PrintWriter(caw);
	}
	
	public ServletOutputStream getOutputStream(){
		return new SampleServletOutputStream(caw);
	}
	
	class SampleServletOutputStream extends ServletOutputStream{
		private CharArrayWriter buffer = null;
		public SampleServletOutputStream(CharArrayWriter charArrayWriter){
			super();
			buffer = charArrayWriter;
		}
		
		@Override
		public void write(int b) throws IOException {
			buffer.write(b);
		}
	}
}
