package org.sst.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.sst.domain.LicenseScoreVO;
import org.sst.domain.LicenseTestVO;
import org.sst.domain.MemberSessionVO;
import org.sst.repository.ReportCardDAO;
import org.sst.domain.ReportCardVO;
import org.sst.domain.SchoolScoreVO;
import org.sst.domain.SchoolTestVO;

public class ReportCardService {
	public static ReportCardService service= new ReportCardService();
	public static ReportCardDAO dao = ReportCardDAO.getInstance();
	
	public static ReportCardService getInstance() {
		dao = ReportCardDAO.getInstance();
		return service;
	}
	
	//ReportCard
	public int insertReportCard(HttpServletRequest request) throws Exception{
		request.setCharacterEncoding("utf-8");
		ReportCardVO rc = new ReportCardVO();
		rc.setRc_title(request.getParameter("rc_title"));
		rc.setRc_type(request.getParameter("rc_type"));
		if(request.getParameter("rc_type").endsWith("성적")) {
			rc.setRc_subtype("학교성적");
		}else {
			rc.setRc_subtype(request.getParameter("rc_subtype"));
		}
		HttpSession session = request.getSession();
		MemberSessionVO mem =(MemberSessionVO)session.getAttribute("loginsession");
		rc.setM_id(mem.getId());
		return dao.insertReportCard(rc);
	}
	
	public List<ReportCardVO> listReportCard(HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		MemberSessionVO mem =(MemberSessionVO)session.getAttribute("loginsession");
		return dao.listReportCard(mem.getId());
	}
	public ReportCardVO selectReportCard(HttpServletRequest request) throws Exception{
		ReportCardVO rc = dao.selectReportCard(request.getParameter("rc_num"));
		return rc;
	}
	
	public int deleteReportCard(HttpServletRequest request) throws Exception{
		int re=-1;
		if(request.getParameter("rc_type").endsWith("성적")) {
			List<SchoolTestVO> list = dao.listSchoolTest(request.getParameter("rc_num"));
			
			for(SchoolTestVO st : list) {
				String st_num = st.getSt_num();
				System.out.println(st_num);
				dao.deleteSchoolTestScore(st_num);
				re = dao.deleteSchoolTest(st_num);
			}
		}else {
			List<LicenseTestVO> list = dao.listLicenseTest(request.getParameter("rc_num"));
			for(LicenseTestVO lt : list) {
				String lt_num = lt.getLt_num();
				dao.deleteLicenseTestScore(lt_num);
				re = dao.deleteLicenseTest(lt_num);
			}
		}
		
		re =dao.deleteReportCard(request.getParameter("rc_num"));
		return re;
	}
	
	//SchoolTest
	
	//처음 시험등록할 때 성적 여러개 입력
	public int insertSchoolTest(HttpServletRequest request) throws Exception{
		int re=-1;
		request.setCharacterEncoding("utf-8");
		
		SchoolTestVO st = new SchoolTestVO();
		st.setRc_num(request.getParameter("rc_num"));
		st.setSt_year(Integer.parseInt(request.getParameter("st_year")));
		st.setSt_semester(Integer.parseInt(request.getParameter("st_semester")));
		st.setSt_date(request.getParameter("st_date"));
		st.setSt_test(request.getParameter("st_test"));
		String st_num = dao.insertSchoolTest(st);
		
		for(int i=1; i<=10; i++) {
			if(request.getParameter("ss_name"+i) !=null) {
				SchoolScoreVO ss = new SchoolScoreVO();
				ss.setSs_name(request.getParameter("ss_name"+i));
				ss.setSs_score(Integer.parseInt(request.getParameter("ss_score"+i)));
				ss.setSt_num(st_num);
				re=dao.firstInsertSchoolScore(ss);
			}
		}
		return re;
	}
	public int updateSchoolTest(HttpServletRequest request) throws Exception{
		int re=-1;
		request.setCharacterEncoding("utf-8");
		
		SchoolTestVO st = new SchoolTestVO();
		st.setSt_num(request.getParameter("st_num"));
		st.setSt_year(Integer.parseInt(request.getParameter("st_year")));
		st.setSt_semester(Integer.parseInt(request.getParameter("st_semester")));
		st.setSt_date(request.getParameter("st_date"));
		st.setSt_test(request.getParameter("st_test"));
		re = dao.updateSchoolTest(st);
		
		for(int i=1; i<=10; i++) {
			if(request.getParameter("ss_name"+i) !=null) {
				SchoolScoreVO ss = new SchoolScoreVO();
				ss.setSs_name(request.getParameter("ss_name"+i));
				ss.setSs_score(Integer.parseInt(request.getParameter("ss_score"+i)));
				ss.setSs_num(request.getParameter("ss_num"+i));
				re=dao.updateSchoolScore(ss);
			}
		}
		return re;
	}
	public List<SchoolTestVO> listSchoolTest(HttpServletRequest request) throws Exception{
		List<SchoolTestVO> list = dao.listSchoolTest(request.getParameter("rc_num"));
		for(SchoolTestVO st : list) {
			List<SchoolScoreVO> scorelist = dao.listSchoolScore(st.getSt_num());
			st.addScoreList(scorelist);
		}
		return list;
	}
	public SchoolTestVO selectSchoolTest(HttpServletRequest request) throws Exception{
		SchoolTestVO st = dao.selectSchoolTest(request.getParameter("st_num"));
		List<SchoolScoreVO> scorelist = dao.listSchoolScore(st.getSt_num());
		st.addScoreList(scorelist);
		
		return st;
	}
	public int deleteSchoolTest(HttpServletRequest request) throws Exception{
		int re=-1;
		dao.deleteSchoolTestScore(request.getParameter("st_num"));
		re = dao.deleteSchoolTest(request.getParameter("st_num"));
		return re;
	}
	
	
	//SchoolScore
	public int insertSchoolScore(HttpServletRequest request) throws Exception{
		int re=-1;
		request.setCharacterEncoding("utf-8");
		SchoolScoreVO ss = new SchoolScoreVO();
		ss.setSs_name(request.getParameter("ss_name"));
		ss.setSs_score(Integer.parseInt(request.getParameter("ss_score")));
		ss.setSt_num(request.getParameter("st_num"));
		re= dao.firstInsertSchoolScore(ss);
		return re;
		
	}
	public int deleteSchoolScore(HttpServletRequest request) throws Exception{
		int re=-1;
		re = dao.deleteSchoolScore(request.getParameter("ss_num"));
		return re;
	}
	
	
	//LicenseTest
	public int insertLicenseTest(HttpServletRequest request) throws Exception{
		int re=-1;
		request.setCharacterEncoding("utf-8");
		
		LicenseTestVO lt = new LicenseTestVO();
		lt.setLt_test(request.getParameter("lt_test"));
		lt.setRc_num(request.getParameter("rc_num"));
		lt.setLt_round(Integer.parseInt(request.getParameter("lt_round")));
		lt.setLt_date(request.getParameter("lt_date"));
		String lt_num = dao.insertLicenseTest(lt);
		
		for(int i=1; i<=10; i++) {
			if(request.getParameter("ls_name"+i) !=null) {
				LicenseScoreVO ls =new LicenseScoreVO();
				ls.setLs_name(request.getParameter("ls_name"+i));
				ls.setLs_score(Integer.parseInt(request.getParameter("ls_score"+i)));
				ls.setLs_goal(Integer.parseInt(request.getParameter("ls_goal"+i)));
				ls.setLt_num(lt_num);
				
				re=dao.insertLicenseScore(ls);
			}
		}
		return re;
	}
	
	public int updateLicenseTest(HttpServletRequest request) throws Exception{
		int re=-1;
		request.setCharacterEncoding("utf-8");
		
		LicenseTestVO lt = new LicenseTestVO();
		lt.setLt_test(request.getParameter("lt_test"));
		lt.setLt_round(Integer.parseInt(request.getParameter("lt_round")));
		lt.setLt_date(request.getParameter("lt_date"));
		lt.setLt_num(request.getParameter("lt_num"));
		dao.updateLicenseTest(lt);
		
		for(int i=1; i<=10; i++) {
			if(request.getParameter("ls_name"+i) !=null) {
				LicenseScoreVO ls =new LicenseScoreVO();
				ls.setLs_name(request.getParameter("ls_name"+i));
				ls.setLs_score(Integer.parseInt(request.getParameter("ls_score"+i)));
				ls.setLs_goal(Integer.parseInt(request.getParameter("ls_goal"+i)));
				ls.setLs_num(request.getParameter("ls_num"+i));
				
				re=dao.updateLicenseScore(ls);
			}
		}
		return re;
	}
	
	public List<LicenseTestVO> listLicenseTest(HttpServletRequest request) throws Exception{
		List<LicenseTestVO> list = dao.listLicenseTest(request.getParameter("rc_num"));
		for(LicenseTestVO lt : list) {
			List<LicenseScoreVO> scorelist = dao.listLicenseScore(lt.getLt_num());
			lt.addScoreList(scorelist);
		}
		return list;
	}
	public LicenseTestVO selectLicenseTest(HttpServletRequest request) throws Exception{
		LicenseTestVO lt = dao.selectLicenseTest(request.getParameter("lt_num"));
		List<LicenseScoreVO> scorelist = dao.listLicenseScore(lt.getLt_num());
		lt.addScoreList(scorelist);
		
		return lt;
	}
	
	public int deleteLicenseTest(HttpServletRequest request) throws Exception{
		int re=-1;
		dao.deleteLicenseTestScore(request.getParameter("lt_num"));
		re = dao.deleteLicenseTest(request.getParameter("lt_num"));
		return re;
	}
	
	//LicenseScore
	public int insertLicenseScore(HttpServletRequest request) throws Exception{
		int re=-1;
		request.setCharacterEncoding("utf-8");
		LicenseScoreVO ls = new LicenseScoreVO();
		ls.setLs_name(request.getParameter("ls_name"));
		ls.setLs_score(Integer.parseInt(request.getParameter("ls_score")));
		ls.setLs_goal(Integer.parseInt(request.getParameter("ls_goal")));
		ls.setLt_num(request.getParameter("lt_num"));
		re=dao.insertLicenseScore(ls);
		return re;
		
	}

	//차트 데이터
	
	public List<SchoolTestVO> averageSchoolTest(HttpServletRequest request) throws Exception{
		List<SchoolTestVO> list = dao.averageSchoolTest(request.getParameter("rc_num"));
		return list;
	}
	public List<HashMap> averageReportCard(HttpServletRequest request) throws Exception{
		HashMap map = new HashMap();
		map.put("rc_num",request.getParameter("rc_num"));
		List<String> list2 = dao.selectReportCardSubject(request.getParameter("rc_num"));
		request.setAttribute("subjectList", list2);
		map.put("list",list2);
		List<HashMap> list = dao.allSubjectAverage(map);
		return list;
	}
	
	public List<HashMap> averageLicenseReportCard(HttpServletRequest request) throws Exception{
		HashMap map = new HashMap();
		map.put("rc_num",request.getParameter("rc_num"));
		List<String> list2 = dao.selectRCLicenseTestSubject(request.getParameter("rc_num"));
		request.setAttribute("subjectList", list2);
		map.put("list",list2);
		List<HashMap> list = dao.allLicenseSubjectAverage(map);
		return list;
	}

}
