package org.sst.repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.sst.domain.QuestionVO;
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
	
	
	
}
