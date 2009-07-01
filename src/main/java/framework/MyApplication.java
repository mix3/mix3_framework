package framework;

import javax.servlet.http.HttpServletRequest;

import org.mix3.framework.Application;
import org.mix3.framework.SimpleWrapper;

public class MyApplication extends Application{
	@Override
	public void run(HttpServletRequest request, SimpleWrapper response) {
		super.run(request, response);
		System.out.println("\t#--[MyAppilcation Run]--#");
		System.out.println("\t#-----------------------#");
	}

	@Override
	public void init() {
		System.out.println("MyAppilcation Init");
	}
}
