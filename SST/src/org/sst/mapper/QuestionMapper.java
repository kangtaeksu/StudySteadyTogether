package org.sst.mapper;

import java.util.List;
import java.util.Map;

import org.sst.domain.QuestionReplyVO;
import org.sst.domain.QuestionVO;



public interface QuestionMapper {

	int insertQuestion(QuestionVO q);
	List<QuestionVO> listQuestion();
	QuestionVO detailQuestion(String q_num);
	
	int insertQuestionReply(QuestionReplyVO q_reply);
	List<QuestionReplyVO> listQuestionReply(String q_num); 
	int recCheck(Map<String, Object> m);
	void recUpdate(Map<String, Object> m);
	void recDelete(Map<String, Object> m);
	int recCount(int c_like);
}
