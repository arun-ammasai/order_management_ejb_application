package com.ordermanagement;

import java.io.File;
import java.util.stream.Stream;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.naming.Context;

import com.ordermanagement.beans.OrderManagementBeanRemote;
import com.ordermanagement.beans.entities.Office;

@TransactionManagement(TransactionManagementType.BEAN)
public class OrderManagementTest {

	@Resource
	private static SessionContext ejbContext;

	public static void main1(String[] args) throws Exception {

		Context context = EJBBeanHelper.getInitialContext();
		OrderManagementBeanRemote lookup = (OrderManagementBeanRemote) context
				.lookup("bean/OrderManagement#com.ordermanagement.beans.OrderManagementBeanRemote");

		// lookup.getAllStudents().forEach(System.out::println);

//		Student findByName = lookup.findByName("John");
//		System.out.println(findByName);

//		List<Object> list = lookup.getAllStudentsByNative();
//		list.forEach(obj -> {
//			Object[] data = (Object[]) obj;
//			Stream.of(data).forEach(System.out ::println);
//		});

//		List<Employee> employeeByCity = lookup.getEmployeeByCity("paris");
//		employeeByCity.forEach(System.out :: println);

//		List<Order> orders = lookup.getOrdersByEmployee(1216);
//		orders.forEach(System.out::println);

//		lookup.updateEmployeeDetails(1143, "John", "Dennis");
//		System.out.println("Employee Update Complete");

		Office office = new Office();
		office.setAddressLine1("St John St");
		office.setAddressLine2("2nd main road");
		office.setCity("Chennai");
		office.setCountry("India");
		office.setPhone("987654321");
		office.setPostalCode("600098");
		office.setState("Tamilnadu");
		office.setTerritory("XXX");
		office.setOfficeCode("8");
		lookup.addOfficeDetails(office);
		System.out.println("New Office Details has been Inserted");

	}

	public static void main(String[] args) {
		File file = new File("/Users/arun/Vlog - The Programming Guy/Vlog Videos/Java EJB/videos");
		String[] fileList = file.list();
		Stream.of(fileList).sorted().forEach(fileName -> System.out.println(fileName));
		for (String name : fileList) {
			//System.out.println(name);
		}
	}
}
