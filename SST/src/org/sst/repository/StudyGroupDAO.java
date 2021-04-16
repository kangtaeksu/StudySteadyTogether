package org.sst.repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.sst.domain.GroupMemberVO;
import org.sst.domain.StudyGroupVO;
import org.sst.mapper.StudyGroupMapper;

public class StudyGroupDAO {
	private static StudyGroupDAO groupdao = new StudyGroupDAO();
	public static StudyGroupDAO getInstance() {
		return groupdao;
	}
	
	// DB연결과 SQL실행
	public SqlSessionFactory getSqlSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	// 스터디 그룹 생성
	public String insertStudyGroup(StudyGroupVO vo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String g_num = null;
		int re = 0;
		try {
			re = sqlSession.getMapper(StudyGroupMapper.class).insertStudyGroup(vo);
			g_num = vo.getG_num();
			System.out.println("g_num : " + g_num);
			if(re>0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// g_num = vo.getG_num();
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return g_num;
	}
	
	// 스터디 그룹 멤버 추가
	public int insertGroupMember(GroupMemberVO vo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(StudyGroupMapper.class).insertGroupMember(vo);
			if(re>0) {
				sqlSession.commit();
			} else {
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
	
	
	// 스터디 그룹 목록 가져오기
//	public List<StudyGroupVO> selectStudyGroup() {
//		SqlSession sqlSession = getSqlSessionFactory().openSession();
//		int re = -1;
//		// List<StudyGroup>
//		try {
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		//return re;
//		return null;
//	}
}
