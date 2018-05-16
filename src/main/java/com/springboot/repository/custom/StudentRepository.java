package com.springboot.repository.custom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.springboot.entities.Student;

@Repository
@Transactional
public class StudentRepository {

	public boolean addStudent(EntityManager entityManager, Student student) {
		boolean result = false;

		entityManager.persist(student);// insert into table
		
		return result;
	}

	public List<Student> getStudents(EntityManager em) {
		StringBuilder studentQuery = new StringBuilder("FROM Student");
		Query query = em.createQuery(studentQuery.toString());
		List<Student> studentList = query.getResultList();
		return studentList;
	}

	public Student getStudentById(EntityManager em, String id) {
		StringBuilder studentQuery = new StringBuilder("FROM Student WHERE id = :id");
		Query query = em.createQuery(studentQuery.toString());
		query.setParameter("id", Integer.parseInt(id));
		Student student = (Student) query.getSingleResult();
		return student;
	}

	public void updateStudent(EntityManager em, Student studentToUpdate) {

		em.merge(studentToUpdate);// update into table
		
	}

	public void removeUsers(EntityManager em, String[] studentsToDelete) {
		//delete from student where id='1';
		//delete from student where id='2';
		//.....
	
//		for(String studentToDelete : studentsToDelete) {
//			Query query = em.createQuery("DELETE FROM Student where id = :studentId");
//			query.setParameter("studentId", Integer.parseInt(studentToDelete));
//			query.executeUpdate();
//		}
		
		//delete from student where id IN('1','2',...);
		
		Query query = em.createQuery("DELETE FROM Student where id IN :studentId");
		List<Integer> studentList = new ArrayList<Integer>();
		for(String studentToDelete : studentsToDelete) {
			studentList.add(Integer.parseInt(studentToDelete));
		}
		query.setParameter("studentId",studentList);
		query.executeUpdate();
	}
}
