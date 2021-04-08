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
	
		
		
		
		return 0;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<StudyNoteVO> studyNoteListService(HttpServletRequest request) throws Exception{
		
	
		return	dao.studyNoteList();
	}
}
