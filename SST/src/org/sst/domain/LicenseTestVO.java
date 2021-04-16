package org.sst.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LicenseTestVO implements Serializable{
	private String lt_num;
	private String lt_date;
	private String lt_test;
	private int lt_round;
	private String rc_num;
	
	private List<LicenseScoreVO> scorelist;
	
	public LicenseTestVO() {}

	public LicenseTestVO(String lt_num, String lt_date, String lt_test, int lt_round, String rc_num) {
		super();
		this.lt_num = lt_num;
		this.lt_date = lt_date;
		this.lt_test = lt_test;
		this.lt_round = lt_round;
		this.rc_num = rc_num;
	}

	public String getLt_num() {
		return lt_num;
	}

	public void setLt_num(String lt_num) {
		this.lt_num = lt_num;
	}

	public String getLt_date() {
		return lt_date;
	}

	public void setLt_date(String lt_date) {
		this.lt_date = lt_date;
	}

	public String getLt_test() {
		return lt_test;
	}

	public void setLt_test(String lt_test) {
		this.lt_test = lt_test;
	}

	public int getLt_round() {
		return lt_round;
	}

	public void setLt_round(int lt_round) {
		this.lt_round = lt_round;
	}

	public String getRc_num() {
		return rc_num;
	}

	public void setRc_num(String rc_num) {
		this.rc_num = rc_num;
	}
	
	public List<LicenseScoreVO> getScorelist() {
		return scorelist;
	}

	public void setScoreList(List<LicenseScoreVO> list) {
		this.scorelist = list;
	}

	@Override
	public String toString() {
		return "LicenseTestVO [lt_num=" + lt_num + ", lt_date=" + lt_date + ", lt_test=" + lt_test + ", lt_round="
				+ lt_round + ", rc_num=" + rc_num + "]";
	}
	
	public void addScoreList(List<LicenseScoreVO> score) {
		this.scorelist = new ArrayList<LicenseScoreVO>();
		this.scorelist = score;
	}
	
	

}
