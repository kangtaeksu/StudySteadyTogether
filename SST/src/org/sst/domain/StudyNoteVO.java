package org.sst.domain;

import java.io.Serializable;

public class StudyNoteVO implements Serializable {

	private String sn_num; //노트번호    
	private String sn_title; //노트제목
	private String sn_contents; //노트 내용
	private String sn_date; //노트 작성날짜
	private String g_num; //어떤 그룹의 노트인지 알기위한 그룹고유번호 
	private String gm_num; //어떤 그룹원이 작성했는지 그룹원고유번호dfsdd
	
	public StudyNoteVO() {}

	public StudyNoteVO(String sn_num, String sn_title, String sn_contents, String sn_date, String g_num, String gm_num) {
		super();
		this.sn_num = sn_num;
		this.sn_title = sn_title;
		this.sn_contents = sn_contents;
		this.sn_date = sn_date;
		this.g_num = g_num;
		this.gm_num = gm_num;
	}

	public String getSn_num() {
		return sn_num;
	}

	public void setSn_num(String sn_num) {
		this.sn_num = sn_num;
	}

	public String getSn_title() {
		return sn_title;
	}

	public void setSn_title(String sn_title) {
		this.sn_title = sn_title;
	}

	public String getSn_contents() {
		return sn_contents;
	}

	public void setSn_contents(String sn_contents) {
		this.sn_contents = sn_contents;
	}

	public String getSn_date() {
		return sn_date;
	}

	public void setSn_date(String sn_date) {
		this.sn_date = sn_date;
	}

	public String getG_num() {
		return g_num;
	}

	public void setG_num(String g_num) {
		this.g_num = g_num;
	}

	public String getGm_num() {
		return gm_num;
	}

	public void setGm_num(String gm_num) {
		this.gm_num = gm_num;
	}


	
}
