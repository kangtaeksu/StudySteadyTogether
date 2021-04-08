package org.sst.domain;

public class StudyGroup {
	
	private String g_num;
	private String g_name;
	private String g_contents;
	private String g_secreat; //비밀번호를 할지말지
	private String g_passwd; // 비밀번호
	
	
	public StudyGroup() {}

	public StudyGroup(String g_num, String g_name, String g_contents, String g_secreat, String g_passwd) {
		super();
		this.g_num = g_num;
		this.g_name = g_name;
		this.g_contents = g_contents;
		this.g_secreat = g_secreat;
		this.g_passwd = g_passwd;
		
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

	

}
