package org.sst.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;


import org.sst.domain.StudyNoteListVO;

import org.sst.domain.StudyNoteVO;
import org.sst.repository.StudyNoteDAO;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;



public class StudyNoteServiceImpl implements StudyNoteService{
	
	private static StudyNoteServiceImpl service = new StudyNoteServiceImpl();
	private static StudyNoteDAO dao;
	
	public StudyNoteServiceImpl() {}
	
	public static StudyNoteServiceImpl getInstance() {
		dao = StudyNoteDAO.getInstance();
		return service;
	}
	
	public int studyNoteInsertService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		
		StudyNoteVO snv = new StudyNoteVO();
		snv.setSn_num(request.getParameter("sn_num"));
		snv.setSn_title(request.getParameter("sn_title"));
		snv.setSn_contents(request.getParameter("sn_contents"));
		snv.setSn_date(request.getParameter("sn_date"));
		snv.setG_num(request.getParameter("g_num"));
		snv.setGm_num(request.getParameter("gm_num"));
		
		return dao.insertStudyNote(snv);
	}
	
	

	
	
	public List<StudyNoteVO> studyNoteListService(HttpServletRequest request) throws Exception{
		
	
		return	dao.studyNoteList();
	}
}
