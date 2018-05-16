package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the weekly database table.
 * 
 */
@Entity
@NamedQuery(name="Weekly.findAll", query="SELECT w FROM Weekly w")
public class Weekly implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int wid;

	@Column(name="week_num")
	private int weekNum;

	//bi-directional many-to-one association to DailyLog
	@OneToMany(mappedBy="weekly")
	private List<DailyLog> dailyLogs;

	//bi-directional many-to-one association to Monthly
	@ManyToOne
	@JoinColumn(name="fk_mid")
	private Monthly monthly;

	public Weekly() {
	}

	public int getWid() {
		return this.wid;
	}

	public void setWid(int wid) {
		this.wid = wid;
	}

	public int getWeekNum() {
		return this.weekNum;
	}

	public void setWeekNum(int weekNum) {
		this.weekNum = weekNum;
	}

	public List<DailyLog> getDailyLogs() {
		return this.dailyLogs;
	}

	public void setDailyLogs(List<DailyLog> dailyLogs) {
		this.dailyLogs = dailyLogs;
	}

	public DailyLog addDailyLog(DailyLog dailyLog) {
		getDailyLogs().add(dailyLog);
		dailyLog.setWeekly(this);

		return dailyLog;
	}

	public DailyLog removeDailyLog(DailyLog dailyLog) {
		getDailyLogs().remove(dailyLog);
		dailyLog.setWeekly(null);

		return dailyLog;
	}

	public Monthly getMonthly() {
		return this.monthly;
	}

	public void setMonthly(Monthly monthly) {
		this.monthly = monthly;
	}

}