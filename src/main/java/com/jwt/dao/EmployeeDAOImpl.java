package com.jwt.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jwt.model.Employee;
import com.jwt.model.Std;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addEmployee(Employee employee) {
		/*List<Std> stdList = new ArrayList<Std>();
		stdList = getStdId();
		for (int i = 0; i < stdList.size(); i++) {
			System.out.println("===>>> " + stdList.get(i).getId() + " " + stdList.get(i).getName());
		}*/
		sessionFactory.getCurrentSession().saveOrUpdate(employee);
		System.out.println("SaveOrUpdate : " + sessionFactory);

	}
	
	@Override
	public List<Std> getStdId() {
		return sessionFactory.getCurrentSession().createQuery("from Std")
				.list();
	}

	@Override
	public void uploadEmployee(List<Employee> employee) {
		System.out.println("In DAO");
		for (int i = 0; i < employee.size(); i++) {
			System.out.println(
					employee.get(i).getId() + " " + employee.get(i).getName() + " " + employee.get(i).getEmail() + " "
							+ employee.get(i).getAddress() + " " + employee.get(i).getTelephone() + " " + employee.get(i).getStd_id());
			System.out.println("Save : " + sessionFactory);
			List<Std> stdList = new ArrayList<Std>();
			stdList = getStdId();
			List<String> stdIdList = new ArrayList<String>();
			for (int j = 0; j < stdList.size(); j++) {
				System.out.println("===>>> " + stdList.get(j).getId() + " " + stdList.get(j).getName());
				stdIdList.add(stdList.get(j).getId());
			}
			if(stdIdList.contains(employee.get(i).getStd_id())) {
				employee.get(i).setStd_id(employee.get(i).getStd_id() + "_VALID");
			}
			else {
				employee.get(i).setStd_id(employee.get(i).getStd_id() + "_INVALID");
			}
			sessionFactory.getCurrentSession().save(employee.get(i));
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployees() {

		return sessionFactory.getCurrentSession().createQuery("from Employee")
				.list();
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		Employee employee = (Employee) sessionFactory.getCurrentSession().load(
				Employee.class, employeeId);
		if (null != employee) {
			this.sessionFactory.getCurrentSession().delete(employee);
		}

	}

	public Employee getEmployee(int empid) {
		return (Employee) sessionFactory.getCurrentSession().get(
				Employee.class, empid);
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);
		return employee;
	}

}