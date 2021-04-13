package org.sst.domain;

import java.io.Serializable;
import java.util.Date;

public class CalendarTodoVO implements Serializable {
	private String t_num;
	private String t_category;
	private String t_title;
	private String t_contents;
	private Date t_startdate;
	private Date t_enddate;
	
	public CalendarTodoVO() {}

	public CalendarTodoVO(String t_num, String t_category, String t_title, String t_contents, Date t_startdate, Date t_enddate) {
		super();
		this.t_num = t_num;
		this.t_category = t_category;
		this.t_title = t_title;
		this.t_contents = t_contents;
		this.t_startdate = t_startdate;
		this.t_enddate = t_enddate;
	}

	public String getT_num() {
		return t_num;
	}

	public void setT_num(String t_num) {
		this.t_num = t_num;
	}

	public String getT_category() {
		return t_category;
	}

	public void setT_category(String t_category) {
		this.t_category = t_category;
	}

	public String getT_title() {
		return t_title;
	}

	public void setT_title(String t_title) {
		this.t_title = t_title;
	}

	public String getT_contents() {
		return t_contents;
	}

	public void setT_contents(String t_contents) {
		this.t_contents = t_contents;
	}

	public Date getT_startdate() {
		return t_startdate;
	}

	public void setT_startdate(Date t_startdate) {
		this.t_startdate = t_startdate;
	}

	public Date getT_enddate() {
		return t_enddate;
	}

	public void setT_enddate(Date t_enddate) {
		this.t_enddate = t_enddate;
	}

	@Override
	public String toString() {
		return "Todo [t_num=" + t_num + ", t_category=" + t_category + ", t_title=" + t_title + ", t_contents="
				+ t_contents + ", t_startdate=" + t_startdate + ", t_enddate=" + t_enddate + "]";
	}
	
	
}
