package org.sst.domain;

import java.io.Serializable;

public class StudyGroupVO implements Serializable {
	
	private String g_num;
	private String g_name;
	private String g_contents;
	private String g_secreat; //비밀번호를 할지말지
	private String g_passwd; // 비밀번호
	private String g_category; // 그룹 카테고리
	private String g_memnum;
	
	public StudyGroupVO() {}

	public StudyGroupVO(String g_num, String g_name, String g_contents, String g_secreat, String g_passwd,
			String g_category, String g_memnum) {
		super();
		this.g_num = g_num;
		this.g_name = g_name;
		this.g_contents = g_contents;
		this.g_secreat = g_secreat;
		this.g_passwd = g_passwd;
		this.g_category = g_category;
		this.g_memnum = g_memnum;
	}

	public String getG_num() {
		return g_num;
	}

	public void setG_num(String g_num) {
		this.g_num = g_num;
	}

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

	public String getG_contents() {
		return g_contents;
	}

	public void setG_contents(String g_contents) {
		this.g_contents = g_contents;
	}

	public String getG_secreat() {
		return g_secreat;
	}

	public void setG_secreat(String g_secreat) {
		this.g_secreat = g_secreat;
	}

	public String getG_passwd() {
		return g_passwd;
	}

	public void setG_passwd(String g_passwd) {
		this.g_passwd = g_passwd;
	}

	public String getG_category() {
		return g_category;
	}

	public void setG_category(String g_category) {
		this.g_category = g_category;
	}

	public String getG_memnum() {
		return g_memnum;
	}

	public void setG_memnum(String g_memnum) {
		this.g_memnum = g_memnum;
	}
	
	
}
