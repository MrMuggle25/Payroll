package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the monthly database table.
 * 
 */
@Entity
@NamedQuery(name="Monthly.findAll", query="SELECT m FROM Monthly m")
public class Monthly implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int mid;

	private String mname;

	private float totalExpense;

	private float totalSalary;

	private int year;

	//bi-directional many-to-one association to Weekly
	@OneToMany(mappedBy="monthly")
	private List<Weekly> weeklies;

	public Monthly() {
	}

	public int getMid() {
		return this.mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMname() {
		return this.mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public float getTotalExpense() {
		return this.totalExpense;
	}

	public void setTotalExpense(float totalExpense) {
		this.totalExpense = totalExpense;
	}

	public float getTotalSalary() {
		return this.totalSalary;
	}

	public void setTotalSalary(float totalSalary) {
		this.totalSalary = totalSalary;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<Weekly> getWeeklies() {
		return this.weeklies;
	}

	public void setWeeklies(List<Weekly> weeklies) {
		this.weeklies = weeklies;
	}

	public Weekly addWeekly(Weekly weekly) {
		getWeeklies().add(weekly);
		weekly.setMonthly(this);

		return weekly;
	}

	public Weekly removeWeekly(Weekly weekly) {
		getWeeklies().remove(weekly);
		weekly.setMonthly(null);

		return weekly;
	}

}