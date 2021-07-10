package com.ordermanagement.beans;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;

import com.ordermanagement.beans.dtos.InterceptorTestClass;


/**
 * Session Bean implementation class TestSessionBean
 */
@Interceptors({InterceptorTestClass.class})
@Stateless(mappedName = "bean/testMappingBean")
@LocalBean
//@TransactionManagement(TransactionManagementType.BEAN)
public class TestSessionBean implements TestSessionBeanRemote {

	/**
	 * Default constructor.
	 */
	public TestSessionBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void sayHi(String name) {
		System.out.println("Hello Mr." + name);

	}
	
	@Resource
	SessionContext context;

	@Override
	public void createTimer(long miliseconds) {
		context.getTimerService().createTimer(miliseconds, "Timer Service");
	}
	
	@Timeout
	public void timeOutHandler(Timer timer) {
		System.out.println("timeout handler :"+timer.getInfo());
	}
	
	@EJB
	SecondarySessionBeanRemote ejbReference;

//	@Resource
//	UserTransaction userTransaction;
	
	@Override
	public void callAnotherEjbReference()throws Exception {
		System.out.println("Invoke Secondary EJB");
		//userTransaction.begin();
		ejbReference.secondarySessionMethod();
		//userTransaction.commit();
		//userTransaction.rollback();
	}
	
	
}
