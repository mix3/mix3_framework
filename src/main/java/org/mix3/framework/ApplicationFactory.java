package org.mix3.framework;

public class ApplicationFactory {
	public Application createApplication(Mix3Filter filter) {
		String applicationClassName = 
			filter.getFilterConfig().getInitParameter("applicationClassName");
		return createApplication(applicationClassName);
	}
	public Application createApplication(String applicationClassName) {
		try {
			return (Application)Class.forName(applicationClassName).newInstance();
		} catch (InstantiationException e) {
			throw new Mix3RuntimeException();
		} catch (IllegalAccessException e) {
			throw new Mix3RuntimeException();
		} catch (ClassNotFoundException e) {
			throw new Mix3RuntimeException();
		}
	}
}
