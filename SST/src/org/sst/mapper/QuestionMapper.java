package org.sst.mapper;

import java.util.List;


import org.sst.domain.QuestionVO;


public interface QuestionMapper {

	int insertQuestion(QuestionVO q);
	List<QuestionVO> listQuestion();
}
