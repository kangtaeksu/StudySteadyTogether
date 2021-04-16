package org.sst.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SchoolTestVO implements Serializable{
	private String st_num;
	private String st_date;
	private int st_year;
	private int st_semester;
	private String st_test;
	private String rc_num;
	private int avg;
	
	private List<SchoolScoreVO> scorelist;

	
	public SchoolTestVO() {}


	public SchoolTestVO(String st_num, String st_date, int st_year, int st_semester, String st_test, String rc_num,
			int avg) {
		super();
		this.st_num = st_num;
		this.st_date = st_date;
		this.st_year = st_year;
		this.st_semester = st_semester;
		this.st_test = st_test;
		this.rc_num = rc_num;
		this.avg = avg;
	}


	public String getSt_num() {
		return st_num;
	}


	public void setSt_num(String st_num) {
		this.st_num = st_num;
	}


	public String getSt_date() {
		return st_date;
	}


	public void setSt_date(String st_date) {
		this.st_date = st_date;
	}


	public int getSt_year() {
		return st_year;
	}


	public void setSt_year(int st_year) {
		this.st_year = st_year;
	}


	public int getSt_semester() {
		return st_semester;
	}


	public void setSt_semester(int st_semester) {
		this.st_semester = st_semester;
	}


	public String getSt_test() {
		return st_test;
	}


	public void setSt_test(String st_test) {
		this.st_test = st_test;
	}


	public String getRc_num() {
		return rc_num;
	}


	public void setRc_num(String rc_num) {
		this.rc_num = rc_num;
	}


	public int getAvg() {
		return avg;
	}


	public void setAvg(int avg) {
		this.avg = avg;
	}


	@Override
	public String toString() {
		return "SchoolTestVO [st_num=" + st_num + ", st_date=" + st_date + ", st_year=" + st_year + ", st_semester="
				+ st_semester + ", st_test=" + st_test + ", rc_num=" + rc_num + ", avg=" + avg + "]";
	}
	
	public void addScoreList(List<SchoolScoreVO> score) {
		this.scorelist = new ArrayList<SchoolScoreVO>();
		this.scorelist = score;
	}


	public List<SchoolScoreVO> getScorelist() {
		return scorelist;
	}


	public void setScorelist(List<SchoolScoreVO> scorelist) {
		this.scorelist = scorelist;
	}
	
	
	
}
