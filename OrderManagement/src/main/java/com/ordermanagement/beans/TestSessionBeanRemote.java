package com.ordermanagement.beans;

import javax.ejb.Remote;

@Remote
public interface TestSessionBeanRemote {
	
	void sayHi(String name);	
	
	void createTimer(long miliseconds);
	
	void callAnotherEjbReference() throws Exception;
	
 }
