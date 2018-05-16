package model;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the daily_log database table.
 * 
 */
@Entity
@Table(name="daily_log")
@NamedQuery(name="DailyLog.findAll", query="SELECT d FROM DailyLog d")
public class DailyLog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="log_id")
	private int logId;

	@Temporal(TemporalType.DATE)
	private Date date;

	private float deduction;

	@Column(name="ot_hrs")
	private int otHrs;

	@Column(name="time_in")
	private Time timeIn;

	@Column(name="time_out")
	private Time timeOut;

	//bi-directional many-to-one association to EmployeeInfo
	@ManyToOne
	@JoinColumn(name="fk_emp")
	private EmployeeInfo employeeInfo;

	//bi-directional many-to-one association to Weekly
	@ManyToOne
	@JoinColumn(name="fk_wid")
	private Weekly weekly;

	public DailyLog() {
	}

	public int getLogId() {
		return this.logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getDeduction() {
		return this.deduction;
	}

	public void setDeduction(float deduction) {
		this.deduction = deduction;
	}

	public int getOtHrs() {
		return this.otHrs;
	}

	public void setOtHrs(int otHrs) {
		this.otHrs = otHrs;
	}

	public Time getTimeIn() {
		return this.timeIn;
	}

	public void setTimeIn(Time timeIn) {
		this.timeIn = timeIn;
	}

	public Time getTimeOut() {
		return this.timeOut;
	}

	public void setTimeOut(Time timeOut) {
		this.timeOut = timeOut;
	}

	public EmployeeInfo getEmployeeInfo() {
		return this.employeeInfo;
	}

	public void setEmployeeInfo(EmployeeInfo employeeInfo) {
		this.employeeInfo = employeeInfo;
	}

	public Weekly getWeekly() {
		return this.weekly;
	}

	public void setWeekly(Weekly weekly) {
		this.weekly = weekly;
	}

}