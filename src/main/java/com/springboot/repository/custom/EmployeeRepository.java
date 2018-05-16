package com.springboot.repository.custom;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.springboot.entities.EmployeeInfo;

@Repository
@Transactional
public class EmployeeRepository {
	
	public boolean addEmployee(EntityManager entityManager, EmployeeInfo employee) {
		boolean result = false;

		entityManager.persist(employee);// insert into table
		
		return result;
	}

	public List<EmployeeInfo> getEmployees(EntityManager em) {
		System.out.println("Repo");
		StringBuilder employeeQuery = new StringBuilder("FROM employee_info");
		Query query = em.createQuery(employeeQuery.toString());
		List<EmployeeInfo> studentList = query.getResultList();
		return studentList;
	}

	public EmployeeInfo getEmployeeById(EntityManager em, int id) {
		StringBuilder employeeQuery = new StringBuilder("FROM employee_info WHERE id = :id");
		Query query = em.createQuery(employeeQuery.toString());
		query.setParameter("id",id);
		EmployeeInfo employee = (EmployeeInfo) query.getSingleResult();
		return employee;
	}

	public void updateEmployee(EntityManager em, EmployeeInfo employeeToUpdate) {

		em.merge(employeeToUpdate);// update into table
		
	}

	public void removeEmployees(EntityManager em, String[] employeesToDelete) {
		//delete from student where id='1';
		//delete from student where id='2';
		//.....
	
//		for(String studentToDelete : studentsToDelete) {
//			Query query = em.createQuery("DELETE FROM Student where id = :studentId");
//			query.setParameter("studentId", Integer.parseInt(studentToDelete));
//			query.executeUpdate();
//		}
		
		//delete from student where id IN('1','2',...);
		
		Query query = em.createQuery("DELETE FROM employee_info where id IN :emp_id");
		List<Integer> employeeList = new ArrayList<Integer>();
		for(String employeeToDelete : employeesToDelete) {
			employeeList.add(Integer.parseInt(employeeToDelete));
		}
		query.setParameter("emp_id",employeeList);
		query.executeUpdate();
	}
}
