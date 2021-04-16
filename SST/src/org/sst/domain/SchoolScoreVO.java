package org.sst.domain;

import java.io.Serializable;

public class SchoolScoreVO implements Serializable{
	private String ss_num;
	private String ss_name;
	private int ss_score;
	private String st_num;
	
	public SchoolScoreVO() {}

	public SchoolScoreVO(String ss_num, String ss_name, int ss_score, String st_num) {
		super();
		this.ss_num = ss_num;
		this.ss_name = ss_name;
		this.ss_score = ss_score;
		this.st_num = st_num;
	}

	public String getSs_num() {
		return ss_num;
	}

	public void setSs_num(String ss_num) {
		this.ss_num = ss_num;
	}

	public String getSs_name() {
		return ss_name;
	}

	public void setSs_name(String ss_name) {
		this.ss_name = ss_name;
	}

	public int getSs_score() {
		return ss_score;
	}

	public void setSs_score(int ss_score) {
		this.ss_score = ss_score;
	}

	public String getSt_num() {
		return st_num;
	}

	public void setSt_num(String st_num) {
		this.st_num = st_num;
	}

	@Override
	public String toString() {
		return "SchoolScoreVO [ss_num=" + ss_num + ", ss_name=" + ss_name + ", ss_score=" + ss_score + ", st_num="
				+ st_num + "]";
	}
	
	
	
	
}
