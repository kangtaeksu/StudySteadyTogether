package org.sst.domain;

import java.io.Serializable;

public class LicenseScoreVO implements Serializable{
	private String ls_num;
	private String ls_name;
	private int ls_score;
	private int ls_goal;
	private String lt_num;
	
	public LicenseScoreVO() {}
	
	public LicenseScoreVO(String ls_num, String ls_name, int ls_score, int ls_goal, String lt_num) {
		super();
		this.ls_num = ls_num;
		this.ls_name = ls_name;
		this.ls_score = ls_score;
		this.ls_goal = ls_goal;
		this.lt_num = lt_num;
	}
	public String getLs_num() {
		return ls_num;
	}
	public void setLs_num(String ls_num) {
		this.ls_num = ls_num;
	}
	public String getLs_name() {
		return ls_name;
	}
	public void setLs_name(String ls_name) {
		this.ls_name = ls_name;
	}
	public int getLs_score() {
		return ls_score;
	}
	public void setLs_score(int ls_score) {
		this.ls_score = ls_score;
	}
	public int getLs_goal() {
		return ls_goal;
	}
	public void setLs_goal(int ls_goal) {
		this.ls_goal = ls_goal;
	}
	public String getLt_num() {
		return lt_num;
	}
	public void setLt_num(String lt_num) {
		this.lt_num = lt_num;
	}
	@Override
	public String toString() {
		return "LicenseScoreVO [ls_num=" + ls_num + ", ls_name=" + ls_name + ", ls_score=" + ls_score + ", ls_goal="
				+ ls_goal + ", lt_num=" + lt_num + "]";
	}
	
	

}
