package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the employee_info database table.
 * 
 */
@Entity
@Table(name="employee_info")
@NamedQuery(name="EmployeeInfo.findAll", query="SELECT e FROM EmployeeInfo e")
public class EmployeeInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="emp_id")
	private int empId;

	@Column(name="business_unit")
	private String businessUnit;

	private float hourlyRate;

	private String name;

	private String position;

	//bi-directional many-to-one association to DailyLog
	@OneToMany(mappedBy="employeeInfo")
	private List<DailyLog> dailyLogs;

	public EmployeeInfo() {
	}

	public int getEmpId() {
		return this.empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getBusinessUnit() {
		return this.businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public float getHourlyRate() {
		return this.hourlyRate;
	}

	public void setHourlyRate(float hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public List<DailyLog> getDailyLogs() {
		return this.dailyLogs;
	}

	public void setDailyLogs(List<DailyLog> dailyLogs) {
		this.dailyLogs = dailyLogs;
	}

	public DailyLog addDailyLog(DailyLog dailyLog) {
		getDailyLogs().add(dailyLog);
		dailyLog.setEmployeeInfo(this);

		return dailyLog;
	}

	public DailyLog removeDailyLog(DailyLog dailyLog) {
		getDailyLogs().remove(dailyLog);
		dailyLog.setEmployeeInfo(null);

		return dailyLog;
	}

}