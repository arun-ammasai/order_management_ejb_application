package com.ordermanagement.beans;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class SecondarySessionBean
 */
@Stateless(mappedName = "bean/SecondaryBean")
@LocalBean
public class SecondarySessionBean implements SecondarySessionBeanRemote {

    /**
     * Default constructor. 
     */
    public SecondarySessionBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void secondarySessionMethod() {
		System.out.println("Welcome to Secondary Session Bean");
	}

}
