package org.sst.domain;

public class QACommentVO {

	private String c_num;
	private String c_contents;
	private String c_date;
	private String q_num;
	private String gm_num;
	private String g_num;
	
	public QACommentVO() {}

	public QACommentVO(String c_num, String c_contents, String c_date, String q_num, String gm_num, String g_num) {
		super();
		this.c_num = c_num;
		this.c_contents = c_contents;
		this.c_date = c_date;
		this.q_num = q_num;
		this.gm_num = gm_num;
		this.g_num = g_num;
	}

	public String getC_num() {
		return c_num;
	}

	public void setC_num(String c_num) {
		this.c_num = c_num;
	}

	public String getC_contents() {
		return c_contents;
	}

	public void setC_contents(String c_contents) {
		this.c_contents = c_contents;
	}

	public String getC_date() {
		return c_date;
	}

	public void setC_date(String c_date) {
		this.c_date = c_date;
	}

	public String getQ_num() {
		return q_num;
	}

	public void setQ_num(String q_num) {
		this.q_num = q_num;
	}

	public String getGm_num() {
		return gm_num;
	}

	public void setGm_num(String gm_num) {
		this.gm_num = gm_num;
	}

	public String getG_num() {
		return g_num;
	}

	public void setG_num(String g_num) {
		this.g_num = g_num;
	}
	
	
}
