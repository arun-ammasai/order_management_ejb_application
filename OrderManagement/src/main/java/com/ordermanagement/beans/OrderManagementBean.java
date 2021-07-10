package com.ordermanagement.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ordermanagement.beans.entities.Employee;
import com.ordermanagement.beans.entities.Office;
import com.ordermanagement.beans.entities.Order;
import com.ordermanagement.beans.entities.Student;

/**
 * Session Bean implementation class OrderManagementBean
 */
@Stateless(mappedName = "bean/OrderManagement")
@LocalBean
public class OrderManagementBean implements OrderManagementBeanRemote {

	/**
	 * Default constructor.
	 */
	public OrderManagementBean() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "OrderManagement")
	EntityManager em;
//	static EntityManagerFactory factory = Persistence.createEntityManagerFactory("OrderManagement");
//	static EntityManager em = factory.createEntityManager();

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> getAllStudents() {
		return em.createNamedQuery("Student.findAll").getResultList();
	}

	@Override
	public Student findByName(String name) {
		// List<Student> resultList =
		// em.createNamedQuery("Student.findByName").setParameter("name",name).getResultList();
		@SuppressWarnings("unchecked")
		List<Student> resultList = em.createQuery("select stu from Student stu where stu.name=:name")
				.setParameter("name", name).getResultList();
		return resultList.size() > 0 ? resultList.get(0) : null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> getAllStudentsByNative() {
		List<Object> resultList = em.createNativeQuery("select * from student").getResultList();
		return resultList;
	}

	@Override
	public List<Employee> getEmployeeByCity(String cityName) {
		@SuppressWarnings("unchecked")
		List<Employee> list = em.createQuery(
				"select emp from Employee emp,Office off where off.officeCode = emp.office.officeCode and off.city = :city")
				.setParameter("city", cityName).getResultList();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getOrdersByEmployee(int employeeNumber) {
		Query query = em.createQuery(
				"select odr from Employee emp,Customer cust,Order odr where emp.employeeNumber = cust.employee.employeeNumber\n"
						+ "and cust.customerNumber = odr.customer.customerNumber and emp.employeeNumber = :empNumber");
		query.setParameter("empNumber", employeeNumber);
		return query.getResultList();
	}

	@Override
	public void updateEmployeeDetails(int employeeNumber, String firstName, String lastName) {
		//Approach Number 1
		String query = "update Employee emp set emp.firstName= :fName , emp.lastName= :lName "
				+ "where emp.employeeNumber =:empNumber";
		em.getTransaction().begin();
		Query qry = em.createQuery(query);
		qry.setParameter("empNumber", employeeNumber);
		qry.setParameter("fName", firstName);
		qry.setParameter("lName", lastName);
		qry.executeUpdate();
		em.getTransaction().commit();
		
		// Approach Number 2
		Employee emp = (Employee)em.createQuery("select emp from Employee emp where emp.employeeNumber = :empNumber")
				.setParameter("empNumber", employeeNumber)
				.getResultList()
				.get(0);
		emp.setFirstName(firstName);
		emp.setLastName(lastName);
		em.merge(emp);
	}

	@Override
	public void addOfficeDetails(Office office) {
//		em.getTransaction().begin();
		em.persist(office);
//		em.getTransaction().commit();
		
	}
	
	
	
}
