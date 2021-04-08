package org.sst.repository;

import java.io.InputStream;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.sst.domain.StudyNoteVO;
import org.sst.mapper.StudyNoteMapper;

public class StudyNoteDAO {
	private static StudyNoteDAO dao = new StudyNoteDAO();

	public static StudyNoteDAO getInstance() {
		return dao;
	}
	
	public SqlSessionFactory getSqlSessionFactory() {
		String resource ="mybatis-config.xml"; //src에 바로 파일을 넣으면 경로를 바로 읽어올 수 있다.
		InputStream in = null;
		
		//mybatis-config.xml를 inputStream으로 먼저 읽어오는 작업을 할거야
		
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
	
	public int insertStudyNote(StudyNoteVO stdNote) {
		int re=-1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(StudyNoteMapper.class).insertStudyNote(stdNote);
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
	
}
