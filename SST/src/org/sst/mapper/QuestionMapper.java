package org.sst.mapper;

import java.util.List;

import org.sst.domain.QuestionReplyVO;
import org.sst.domain.QuestionVO;
import org.sst.domain.StudyNoteVO;


public interface QuestionMapper {

	int insertQuestion(QuestionVO q);
	List<QuestionVO> listQuestion();
	QuestionVO detailQuestion(String q_num);
	
	int insertQuestionReply(QuestionReplyVO q_reply);
	List<QuestionReplyVO> listQuestionReply(String q_num); 
}
