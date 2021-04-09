package org.sst.repository;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.sst.domain.MemberVO;
import org.sst.mapper.MemberMapper;

// db작업은 dao에서
public class MemberDAO {
	
	private static MemberDAO memdao = new MemberDAO();
	public static MemberDAO getInstance() {
		return memdao;
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
	
	public int joinMember(MemberVO member) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = 0;
		try {
			re = sqlSession.getMapper(MemberMapper.class).insertMember(member);
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
	
	public MemberVO selectLoginMember(MemberVO member) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		MemberVO selmem = null;
		try {
			selmem = sqlSession.getMapper(MemberMapper.class).selectLoginMember(member);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return selmem;
	}
}
