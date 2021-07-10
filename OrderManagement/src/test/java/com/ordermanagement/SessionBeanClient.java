package com.ordermanagement;

import javax.naming.Context;

import com.ordermanagement.beans.TestSessionBeanRemote;

public class SessionBeanClient {
	// Step 1 : getInitialContext
	// Step 2 : fetch your ejb
	public static void main(String[] args) throws Exception{
		Context context = EJBBeanHelper.getInitialContext();
		TestSessionBeanRemote lookup = (TestSessionBeanRemote)context.lookup("bean/testMappingBean#com.ordermanagement.beans.TestSessionBeanRemote");
		lookup.sayHi("AJ");
//		System.out.println("["+new Date().toString()+"]"+"timer created");
//		lookup.createTimer(10000);
//		
//		lookup.callAnotherEjbReference();

		
	}


}

