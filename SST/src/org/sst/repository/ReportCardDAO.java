package org.sst.repository;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.sst.domain.LicenseScoreVO;
import org.sst.domain.LicenseTestVO;
import org.sst.domain.ReportCardVO;
import org.sst.domain.SchoolScoreVO;
import org.sst.domain.SchoolTestVO;
import org.sst.mapper.ReportCardMapper;


public class ReportCardDAO {
	public static ReportCardDAO dao = new ReportCardDAO();
	public static ReportCardDAO getInstance() {
		return dao;
	}
	
	public SqlSessionFactory getSqlSessionFactory() {
		String resource ="mybatis-config.xml";
		InputStream in =null;
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new SqlSessionFactoryBuilder().build(in); 
	}
	
	//ReportCard
	public int insertReportCard(ReportCardVO rc) {
		int re=-1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(ReportCardMapper.class).insertReportCard(rc);
			if(re>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return re;
	}
	
	public List<ReportCardVO> listReportCard(String m_id) {
		List<ReportCardVO> list =null;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			list = sqlSession.getMapper(ReportCardMapper.class).listReportCard(m_id);
		} catch (Exception e) {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return list;
	}
	
	public ReportCardVO selectReportCard(String rc_num) {
		ReportCardVO rc =null;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			rc = sqlSession.getMapper(ReportCardMapper.class).selectReportCard(rc_num);
		} catch (Exception e) {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return rc;
	}
	
	public int deleteReportCard(String rc_num) {
		int re=-1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(ReportCardMapper.class).deleteReportCard(rc_num);
			if(re>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return re;
	}
	
	//SchoolTest
	public String insertSchoolTest(SchoolTestVO st) {
		int re=-1;
		String st_num="";
		System.out.println(st.toString());
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(ReportCardMapper.class).insertSchoolTest(st);
			st_num = st.getSt_num();
			if(re>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return st_num;
	}
	
	public List<SchoolTestVO> listSchoolTest(String rc_num) {
		List<SchoolTestVO> list =null;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			list = sqlSession.getMapper(ReportCardMapper.class).listSchoolTest(rc_num);
		} catch (Exception e) {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return list;
	}
	public SchoolTestVO selectSchoolTest(String st_num) {
		SchoolTestVO schooltest =null;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			schooltest = sqlSession.getMapper(ReportCardMapper.class).selectSchoolTest(st_num);
		} catch (Exception e) {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return schooltest;
	}
	
	public int deleteSchoolTest(String st_num) {
		int re=-1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(ReportCardMapper.class).deleteSchoolTest(st_num);
			if(re>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return re;
	}
	
	public int updateSchoolTest(SchoolTestVO st) {
		int re=-1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(ReportCardMapper.class).updateSchoolTest(st);
			if(re>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return re;
	}
	
	//SchoolScore
	
	public int firstInsertSchoolScore(SchoolScoreVO ss) {
		int re=-1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(ReportCardMapper.class).firstInsertSchoolScore(ss);
			if(re>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return re;
	}
	
	public List<SchoolScoreVO> listSchoolScore(String st_num) {
		List<SchoolScoreVO> list =null;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			list = sqlSession.getMapper(ReportCardMapper.class).listSchoolScore(st_num);
		} catch (Exception e) {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return list;
	}
	
	public int deleteSchoolTestScore(String st_num) {
		int re=-1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(ReportCardMapper.class).deleteSchoolTestScore(st_num);
			if(re>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return re;
	}
	
	public int deleteSchoolScore(String ss_num) {
		int re=-1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(ReportCardMapper.class).deleteSchoolScore(ss_num);
			if(re>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return re;
	}
	
	public int updateSchoolScore(SchoolScoreVO ss) {
		int re=-1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(ReportCardMapper.class).updateSchoolScore(ss);
			if(re>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return re;
	}
	
	//LicenseTest
	public String insertLicenseTest(LicenseTestVO lt) {
		int re=-1;
		String lt_num="";
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(ReportCardMapper.class).insertLicenseTest(lt);
			lt_num = lt.getLt_num();
			if(re>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return lt_num;
	}
	public List<LicenseTestVO> listLicenseTest(String rc_num) {
		List<LicenseTestVO> list =null;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			list = sqlSession.getMapper(ReportCardMapper.class).listLicenseTest(rc_num);
		} catch (Exception e) {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return list;
	}
	public LicenseTestVO selectLicenseTest(String lt_num) {
		LicenseTestVO lt =null;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			lt = sqlSession.getMapper(ReportCardMapper.class).selectLicenseTest(lt_num);
		} catch (Exception e) {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return lt;
	}
	public int updateLicenseTest(LicenseTestVO lt) {
		int re=-1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(ReportCardMapper.class).updateLicenseTest(lt);
			if(re>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return re;
	}
	public int deleteLicenseTest(String lt_num) {
		int re=-1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(ReportCardMapper.class).deleteLicenseTest(lt_num);
			if(re>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return re;
	}
	
	
	
	
	//LicenseScore
	public int insertLicenseScore(LicenseScoreVO ls) {
		int re=-1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(ReportCardMapper.class).insertLicenseScore(ls);
			if(re>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return re;
	}
	public List<LicenseScoreVO> listLicenseScore(String lt_num) {
		List<LicenseScoreVO> list =null;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			list = sqlSession.getMapper(ReportCardMapper.class).listLicenseScore(lt_num);
		} catch (Exception e) {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return list;
	}
	public int updateLicenseScore(LicenseScoreVO ls) {
		int re=-1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(ReportCardMapper.class).updateLicenseScore(ls);
			if(re>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return re;
	}
	public int deleteLicenseScore(String ls_num) {
		int re=-1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(ReportCardMapper.class).deleteLicenseScore(ls_num);
			if(re>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return re;
	}
	public int deleteLicenseTestScore(String lt_num) {
		int re=-1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(ReportCardMapper.class).deleteLicenseTestScore(lt_num);
			if(re>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return re;
	}
	

	//chart data
	public List<SchoolTestVO> averageSchoolTest(String rc_num){
		List<SchoolTestVO> list = null;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			list = sqlSession.getMapper(ReportCardMapper.class).averageSchoolTest(rc_num);
		} catch (Exception e) {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return list;
	}
	public List<HashMap> allSubjectAverage(HashMap map){
		List<HashMap> result=null;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			result = sqlSession.getMapper(ReportCardMapper.class).allSubjectAverage(map);
		} catch (Exception e) {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return result;
	}
	
	

	public List<String> selectReportCardSubject(String rc_num) {
		List<String> list = null;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			list = sqlSession.getMapper(ReportCardMapper.class).selectReportCardSubject(rc_num);
		} catch (Exception e) {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return list;
	}
	
	public List<String> selectRCLicenseTestSubject(String rc_num) {
		List<String> list = null;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			list = sqlSession.getMapper(ReportCardMapper.class).selectRCLicenseTestSubject(rc_num);
		} catch (Exception e) {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return list;
	}
	
	public List<HashMap> allLicenseSubjectAverage(HashMap map){
		List<HashMap> result=null;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			result = sqlSession.getMapper(ReportCardMapper.class).allLicenseSubjectAverage(map);
		} catch (Exception e) {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return result;
	}
}
