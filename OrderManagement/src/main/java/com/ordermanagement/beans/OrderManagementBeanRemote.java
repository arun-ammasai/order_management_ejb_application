package com.ordermanagement.beans;

import java.util.List;

import javax.ejb.Remote;

import com.ordermanagement.beans.entities.Employee;
import com.ordermanagement.beans.entities.Office;
import com.ordermanagement.beans.entities.Order;
import com.ordermanagement.beans.entities.Student;

@Remote
public interface OrderManagementBeanRemote {
	
	List<Student> getAllStudents();
	
	Student findByName(String name);
	
	List<Object> getAllStudentsByNative();
	
	List<Employee> getEmployeeByCity(String cityName);
	
	List<Order> getOrdersByEmployee(int employeeNumber);

	void updateEmployeeDetails(int employeeNumber, String fName, String lName);
	
	void addOfficeDetails(Office office);
}
