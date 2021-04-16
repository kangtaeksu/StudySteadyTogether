package org.sst.domain;

import java.io.Serializable;

public class ReportCardVO implements Serializable{
	private String rc_num;
	private String rc_type;
	private String m_id;
	private String rc_title;
	private String rc_subtype;
	
	
	public ReportCardVO() {}


	public ReportCardVO(String rc_num, String rc_type, String m_id, String rc_title, String rc_subtype) {
		super();
		this.rc_num = rc_num;
		this.rc_type = rc_type;
		this.m_id = m_id;
		this.rc_title = rc_title;
		this.rc_subtype = rc_subtype;
	}


	public String getRc_num() {
		return rc_num;
	}


	public void setRc_num(String rc_num) {
		this.rc_num = rc_num;
	}


	public String getRc_type() {
		return rc_type;
	}


	public void setRc_type(String rc_type) {
		this.rc_type = rc_type;
	}


	public String getM_id() {
		return m_id;
	}


	public void setM_id(String m_id) {
		this.m_id = m_id;
	}


	public String getRc_title() {
		return rc_title;
	}


	public void setRc_title(String rc_title) {
		this.rc_title = rc_title;
	}


	public String getRc_subtype() {
		return rc_subtype;
	}


	public void setRc_subtype(String rc_subtype) {
		this.rc_subtype = rc_subtype;
	}

	@Override
	public String toString() {
		return "ReportCardVO [rc_num=" + rc_num + ", rc_type=" + rc_type + ", m_id=" + m_id + ", rc_title=" + rc_title
				+ ", rc_subtype=" + rc_subtype + "]";
	}

}
