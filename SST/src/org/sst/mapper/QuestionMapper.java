package org.sst.mapper;

import java.util.List;
import java.util.Map;

import org.sst.domain.QuestionReplyVO;
import org.sst.domain.QuestionVO;
import org.sst.domain.RecDTO;



public interface QuestionMapper {

	int insertQuestion(QuestionVO q);
	List<QuestionVO> listQuestion();
	QuestionVO detailQuestion(String q_num);
	
	int insertQuestionReply(QuestionReplyVO q_reply);
	List<QuestionReplyVO> listQuestionReply(String q_num); 
	
	
	int rec_update(RecDTO m);
	int rec_count(int no);
	
	

}
