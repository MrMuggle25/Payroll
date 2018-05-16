package com.springboot.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.entities.DailyLog;
import com.springboot.entities.EmployeeInfo;
import com.springboot.repository.custom.DailyLogRepository;
import com.springboot.repository.custom.EmployeeRepository;

@Service
public class EmployeeService {
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private EmployeeRepository employeeRepository;
	private DailyLogRepository dailyLogRepository;


	public boolean addEmployee(String name, String position, String businessUnit,float hourlyRate) {
		boolean result = false;
		EmployeeInfo employee = new EmployeeInfo();
		employee.setName(name);
		employee.setPosition(position);
		employee.setBusinessUnit(businessUnit);
		employee.setHourlyRate(hourlyRate);
		result = employeeRepository.addEmployee(em,employee);

		return result;
	}
	public void timeIn(int id){
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		DailyLog dLog = new DailyLog();
		date.setDate(10);
		date.setMonth(5);
		date.setYear(2018);
		date.setHours(8);
		date.setMinutes(15);
		dLog.setDate(date);
		dLog.setEmployeeInfo(getEmployeeById(id));
//		dLog.setTimeIn(sdf.format(date));
		
	}
	
	/*
	public void Calculate(int id){
		List<DailyLog> tempLogs = getLogsByEmployeeId(id);
		for(int i=0;i<tempLogs.size();i++){
			tempLogs
		}
	}
	public List<DailyLog> getLogsByEmployeeId(int id){
		return dailyLogRepository.getLogs(em,id);
	}*/
	

	public List<EmployeeInfo> getEmployees() {
		System.out.println("Service");
		return employeeRepository.getEmployees(em);
	}

	public EmployeeInfo getEmployeeById(int id) {
		return employeeRepository.getEmployeeById(em, id);
	}

	public void updateEmployee(int id, String name, String position, String businessUnit,float hourlyRate) {
		EmployeeInfo employeeToUpdate = employeeRepository.getEmployeeById(em, id);
		employeeToUpdate.setName(name);
		employeeToUpdate.setPosition(position);
		employeeToUpdate.setBusinessUnit(businessUnit);
		employeeToUpdate.setHourlyRate(hourlyRate);
		employeeRepository.updateEmployee(em,employeeToUpdate);
		
	}

	public void removeEmployees(String[] employeesToDelete) {
		employeeRepository.removeEmployees(em, employeesToDelete);
		
	}
}
