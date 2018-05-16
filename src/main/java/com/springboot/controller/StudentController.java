package com.springboot.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.entities.Student;
import com.springboot.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/add")
	public String loadAddUserScreen() {
		return "student/add"; 
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addUser(HttpServletRequest request, ModelMap map) {
		System.out.println("I GOT IN HERE.");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		studentService.addUser(name, age);
		return listUser(map);
	}
	
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public String updateUser(HttpServletRequest request, ModelMap map) {
		String id = request.getParameter("studentId");
		Student selectedStudent = studentService.getStudentById(id);
		map.addAttribute("selectedStudent", selectedStudent);
		return "student/update";
	}
	
	@RequestMapping(value="/update", method=RequestMethod.POST)
	public String executeUpdateUser(HttpServletRequest request, ModelMap map) {
		String id = request.getParameter("studentId");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		studentService.updateStudent(id,name,age);
		
		return listUser(map);
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.POST)
	public String removeUser(HttpServletRequest request, ModelMap map) {
		String[] studentsToDelete = request.getParameterValues("studentIdToDelete");
		studentService.removeUsers(studentsToDelete);
		return listUser(map);
	}
	
	@RequestMapping(value="/list")
	public String listUser(ModelMap map) {
		List<Student> studentList = studentService.getStudents();
		map.addAttribute("studentList", studentList);
		return "student/add";
	}
}
