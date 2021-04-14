package org.sst.repository;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.sst.domain.QuestionReplyVO;
import org.sst.domain.QuestionVO;
import org.sst.domain.RecDTO;
import org.sst.domain.StudyNoteSearchVO;
import org.sst.domain.StudyNoteVO;
import org.sst.mapper.QuestionMapper;
import org.sst.mapper.StudyNoteMapper;



public class QuestionDAO {

	private static QuestionDAO dao = new QuestionDAO();
	
	public static QuestionDAO getInstance() {
		return dao;
	}
	
	public SqlSessionFactory getSqlSessionFactory() {
		String resource ="mybatis-config.xml"; //src에 바로 파일을 넣으면 경로를 바로 읽어올 수 있다.
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream(resource);
			//mybatis-config.xml에 input스트림을 연결하는것과 같다.
			//import org.apache.ibatis.io.Resources; 필요함
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new SqlSessionFactoryBuilder().build(in);
		//이렇게하면 SqlSessionFactory객체를 리턴한다.
	}
	
	public int insertQuestion(QuestionVO q) {
		int re=-1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(QuestionMapper.class).insertQuestion(q);
			if(re>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}

		return re;
	}
	
	public List<QuestionVO> questionList(){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		List<QuestionVO> list=null;
		
		try {
			list = sqlSession.getMapper(QuestionMapper.class).listQuestion();
			System.out.println("DAO");
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return list;
	}
	
	public QuestionVO detailQuestion(String q_num) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		QuestionVO q = null;
		try {
			q = sqlSession.getMapper(QuestionMapper.class).detailQuestion(q_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return q;
	}
	
	public int insertQuestionReply(QuestionReplyVO q_reply) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		
		try {
			re = sqlSession.getMapper(QuestionMapper.class).insertQuestionReply(q_reply);
			if(re>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return re;
	}
	
	public List<QuestionReplyVO> listQuestionReply(String q_num){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<QuestionReplyVO> list = null;
		
		try {
			list = sqlSession.getMapper(QuestionMapper.class).listQuestionReply(q_num);			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return list;
	}
	
	// 추천체크 public int insertQuestionReply(QuestionReplyVO q_reply) {
	public int recCheck(RecDTO  m){

		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		//.(Integer).selectOne("board.rec_check", m);
		try {
			re = sqlSession.getMapper(QuestionMapper.class).rec_check(m);
			if(re>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return re;
	}
	
	// 추천클릭 public int insertQuestionReply(QuestionReplyVO q_reply) {
	public int recUpdate(RecDTO m){
		
		int re=-1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(QuestionMapper.class).rec_update(m);
			if(re>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}

		return re;
	}
	
//추천삭제 public int insertQuestionReply(QuestionReplyVO q_reply) {
	public int recDelete(RecDTO m){
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re=-1;
		
		try {
			re=sqlSession.getMapper(QuestionMapper.class).rec_delete(m);
			
			if(re>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
						
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return re;
	}
	
	//추천개수세기 public int insertQuestionReply(QuestionReplyVO q_reply) {
	public int recCount(int no){
	
		
	
	SqlSession sqlSession = getSqlSessionFactory().openSession();
	int re = 0;
	try {
		re = sqlSession.getMapper(QuestionMapper.class).rec_count(no);
	} catch (Exception e) {
		e.printStackTrace();
	}finally {
		if(sqlSession != null) {
			sqlSession.close();
		}
	}
	
	return re;
	
}
}