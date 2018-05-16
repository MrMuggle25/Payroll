package com.springboot.repository.custom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.springboot.entities.DailyLog;
import com.springboot.entities.EmployeeInfo;

@Repository
@Transactional
public class DailyLogRepository {
	
	public List<DailyLog> getLogs(EntityManager em, int id){
		StringBuilder logQuery = new StringBuilder("FROM daily_log WHERE id = fk_emp");
		Query query = em.createQuery(logQuery.toString());
		List<DailyLog> logList = query.getResultList();
		return logList;
	}
	public void timeIn(EntityManager em, int id){
		
	}
}
