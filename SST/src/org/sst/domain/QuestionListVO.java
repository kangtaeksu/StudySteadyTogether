package org.sst.domain;

import java.util.List;

public class QuestionListVO {

	private List<QuestionVO> list;

	
	public QuestionListVO() {}


	public QuestionListVO(List<QuestionVO> list) {
		super();
		this.list = list;
	}


	public List<QuestionVO> getList() {
		return list;
	}


	public void setList(List<QuestionVO> list) {
		this.list = list;
	}

	

	
	
}
