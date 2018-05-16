package com.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springboot.entities.EmployeeInfo;
import com.springboot.service.EmployeeService;


@Controller
public class IndexController {

	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	private EmployeeService es;
	// inject via application.properties
	@Value("${welcome.message:test}")
	private String message = "Hello World";

	@RequestMapping("/")
	public String welcome(ModelMap model) {
		List<EmployeeInfo> emps = es.getEmployees();
		model.addAttribute("employees", emps);
		return "test";
	}
	

	@RequestMapping("/test")
	public String loadTest(ModelMap model) {
		model.put("message", this.message);
		return "test";
	}
	

}