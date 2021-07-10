package com.ordermanagement.beans.dtos;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class InterceptorTestClass {
	
	@AroundInvoke
	public Object methodInterceptor(InvocationContext context) throws Exception {
		System.out.println("Interceptor Class Calles and the method intercepted is:"+context.getMethod().getName());
		return context.proceed();
	}
}
