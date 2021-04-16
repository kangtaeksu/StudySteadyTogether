package org.sst.domain;

import java.io.Serializable;

public class QuestionVO implements Serializable{
	private String q_num; //문제번호

	private String q_title;
	private String q_contents;
	private String q_answer;
	private String q_date;
	private String g_num;
	private String gm_num;

	
	public QuestionVO() {}

	@Override
	public String toString() {
		return "QuestionVO [q_num=" + q_num + ", q_title=" + q_title + ", q_contents=" + q_contents + ", q_answer="
				+ q_answer + ", q_date=" + q_date + ", g_num=" + g_num + ", gm_num=" + gm_num + "]";
	}

	public QuestionVO(String q_num, String q_title, String q_contents, String q_answer, String q_date, String g_num,
			String gm_num) {
		super();
		this.q_num = q_num;
		this.q_title = q_title;
		this.q_contents = q_contents;
		this.q_answer = q_answer;
		this.q_date = q_date;
		this.g_num = g_num;
		this.gm_num = gm_num;
	}

	public String getQ_num() {
		return q_num;
	}

	public void setQ_num(String q_num) {
		this.q_num = q_num;
	}

	public String getQ_title() {
		return q_title;
	}

	public void setQ_title(String q_title) {
		this.q_title = q_title;
	}

	public String getQ_contents() {
		return q_contents;
	}

	public void setQ_contents(String q_contents) {
		this.q_contents = q_contents;
	}

	public String getQ_answer() {
		return q_answer;
	}

	public void setQ_answer(String q_answer) {
		this.q_answer = q_answer;
	}

	public String getQ_date() {
		return q_date;
	}

	public void setQ_date(String q_date) {
		this.q_date = q_date;
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
