package com.ordermanagement.beans;

import java.util.concurrent.TimeUnit;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;

/**
 * Session Bean implementation class StatefulSessionBean
 */
@Stateful
@StatefulTimeout(unit = TimeUnit.MINUTES, value = 20)
@LocalBean
public class StatefulSessionBean {

    /**
     * Default constructor. 
     */
    public StatefulSessionBean() {
        // TODO Auto-generated constructor stub
    }

}
