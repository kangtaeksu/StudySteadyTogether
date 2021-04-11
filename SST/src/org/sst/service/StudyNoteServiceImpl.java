package org.sst.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.sst.domain.StudyNoteListVO;
import org.sst.domain.StudyNoteSearchVO;
import org.sst.domain.StudyNoteVO;
import org.sst.repository.StudyNoteDAO;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;



public class StudyNoteServiceImpl implements StudyNoteService {

	private static StudyNoteServiceImpl service = new StudyNoteServiceImpl();
	private static StudyNoteDAO dao;
	private static final int PAGE_SIZE = 3;
	
	
	public StudyNoteServiceImpl() {
	}

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

	public StudyNoteListVO studyNoteListService(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		StudyNoteSearchVO search = new StudyNoteSearchVO();
		HttpSession session = request.getSession();

		if (request.getParameterValues("area") != null) {
			session.removeAttribute("search");
			search.setArea(request.getParameterValues("area"));
			search.setSearchKey("%" + request.getParameter("searchKey") + "%");
			session.setAttribute("search", search);
		} // 체크해제 후 검색버튼만 클릭(전체 목록으로 돌아가기)
		else if (request.getParameterValues("area") == null && request.getParameter("pageNum") == null) {
			session.removeAttribute("search");// 세션에서 검색 정보 삭제
		}
		// 세션에 검색 정보가 있는 경우
		if (session.getAttribute("search") != null) {
			search = (StudyNoteSearchVO) session.getAttribute("search");
		}

		// 페이지처리 필수사항
		// 페이지당 글갯수, 총글갯수, 총페이지수, 현재페이지, startPage, endPage, startRow

		// 총글갯수
		int totalCount = dao.countStudyNote(search);

		// 총페이지수
		int totalPageCount = totalCount / PAGE_SIZE;
		if (totalCount % PAGE_SIZE > 0) {
			totalPageCount++;
		}

		// 현재페이지
		String pageNum = request.getParameter("pageNum");
		if (pageNum == null) {
			pageNum = "1";
		}
		int requestPage = Integer.parseInt(pageNum);

		// startPage = 현재페이지 - (현재페이지 -1) % 5
		int startPage = requestPage - (requestPage - 1) % 5;

		// endPage
		int endPage = startPage + 4;
		if (endPage > totalPageCount) {
			endPage = totalPageCount;
		}

		// startRow = (현재페이지 -1) * 페이지당글갯수
		int startRow = (requestPage - 1) * PAGE_SIZE;

		List<StudyNoteVO> list = dao.studyNoteList(search,startRow);
		StudyNoteListVO studyNoteListVO = new StudyNoteListVO(list, requestPage, totalPageCount, startPage, endPage);
		return studyNoteListVO;
	}

	public StudyNoteVO detailStudyNoteService(String sn_num) throws Exception {
		return dao.detailStudyNote(sn_num);
	}

	public int updateStudyNoteService(StudyNoteVO studynote) throws Exception {
		return dao.updateStudyNote(studynote);
	}

}
