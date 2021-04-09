package org.sst.domain;

public class QuestionVO {
	private String q_num; //문제번호
	private String q_contents; //문제 내용
	private String q_writer; //문제 작성자
	private String gm_num; // 그룹원의 고유 번호
	private String g_num; // 그룹고유번호  (어떤그룹인지)
	
	public QuestionVO() {}

	public QuestionVO(String q_num, String q_contents, String q_writer, String gm_num, String g_num) {
		super();
		this.q_num = q_num;
		this.q_contents = q_contents;
		this.q_writer = q_writer;
		this.gm_num = gm_num;
		this.g_num = g_num;
	}

	public String getQ_num() {
		return q_num;
	}

	public void setQ_num(String q_num) {
		this.q_num = q_num;
	}

	public String getQ_contents() {
		return q_contents;
	}

	public void setQ_contents(String q_contents) {
		this.q_contents = q_contents;
	}

	public String getQ_writer() {
		return q_writer;
	}

	public void setQ_writer(String q_writer) {
		this.q_writer = q_writer;
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
