package com.ordermanagement;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

public class EJBBeanHelper {

	static InitialContext getInitialContext() throws Exception {
		Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
		properties.put(Context.PROVIDER_URL, "t3://localhost:7001");
		properties.put(Context.SECURITY_PRINCIPAL, "weblogic");
		properties.put(Context.SECURITY_CREDENTIALS, "zaq1ZAQ!");
		return new InitialContext(properties);
	}
}
