package org.sst.repository;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.sst.domain.CalendarTodoVO;
import org.sst.mapper.CalendarMapper;
import org.sst.service.CalendarService;

public class CalendarDAO {
private static CalendarDAO dao = new CalendarDAO();
	
	public static CalendarDAO getInstance() {
		return dao;
	}
	
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
	public int insertTodo(CalendarTodoVO todo){
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(CalendarMapper.class).insertTodo(todo);
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
	public List<CalendarTodoVO> listTodo() {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<CalendarTodoVO> list = null;
		
		try {
			list = sqlSession.getMapper(CalendarMapper.class).listTodo();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		System.out.println( list+"dao list입니다.");
		return list;
		
	}
	public int updateCheckTodo(CalendarTodoVO todo){
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(CalendarMapper.class).updateCheckTodo(todo);
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
	public int updateNonCheckTodo(CalendarTodoVO todo){
		System.out.println("==1-3-5-1==");
		int re = -1;
		System.out.println("==1-3-5-2==");
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		System.out.println("==1-3-5-3==");
		try {
			System.out.println("==1-3-5-4==");
			re = sqlSession.getMapper(CalendarMapper.class).updateNonCheckTodo(todo);
			System.out.println("==1-3-5-5==");
			if(re>0) {
				System.out.println("==1-3-5-6==");
				sqlSession.commit();
			}else {
				System.out.println("==1-3-5-7==");
				sqlSession.rollback();
			}
		} catch (Exception e) {
			System.out.println("==1-3-5-8==");
			e.printStackTrace();
		}finally {
			System.out.println("==1-3-5-9==");
			if(sqlSession != null) {
				System.out.println("==1-3-5-10==");
				sqlSession.close();
				System.out.println("==1-3-5-11==");
			}
		}
		System.out.println("==1-3-5-12==");
		return re;
	}
	public int deleteTodo(CalendarTodoVO todo){
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(CalendarMapper.class).deleteTodo(todo);
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
