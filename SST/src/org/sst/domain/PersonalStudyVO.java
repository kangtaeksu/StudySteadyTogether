package org.sst.domain;

import java.io.Serializable;
import java.util.Date;

public class PersonalStudyVO implements Serializable{
	private String ps_num;
	private String ps_category;
	private String ps_time;
	private String ps_place;
	private Date ps_starttime;
	
	public PersonalStudyVO() {		
	}

	public PersonalStudyVO(String ps_num, String ps_category, String ps_time, String ps_place, Date ps_starttime) {
		super();
		this.ps_num = ps_num;
		this.ps_category = ps_category;
		this.ps_time = ps_time;
		this.ps_place = ps_place;
		this.ps_starttime = ps_starttime;
	}

	public String getPs_num() {
		return ps_num;
	}

	public void setPs_num(String ps_num) {
		this.ps_num = ps_num;
	}

	public String getPs_category() {
		return ps_category;
	}

	public void setPs_category(String ps_category) {
		this.ps_category = ps_category;
	}

	public String getPs_time() {
		return ps_time;
	}

	public void setPs_time(String ps_time) {
		this.ps_time = ps_time;
	}

	public String getPs_place() {
		return ps_place;
	}

	public void setPs_place(String ps_place) {
		this.ps_place = ps_place;
	}

	public Date getPs_starttime() {
		return ps_starttime;
	}

	public void setPs_starttime(Date ps_starttime) {
		this.ps_starttime = ps_starttime;
	}
	
}
