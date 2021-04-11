package org.sst.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.domain.StudyNoteListVO;
import org.sst.domain.StudyNoteVO;
import org.sst.service.StudyNoteServiceImpl;

public class StudyNote_ListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		List<StudyNoteVO> list = null;
		
		StudyNoteServiceImpl service = StudyNoteServiceImpl.getInstance();
		
		list = service.studyNoteListService(request);
		
		StudyNoteListVO snlVO = new StudyNoteListVO(list,1,5,1,5);
		request.setAttribute("StudyNoteListVO", snlVO);
		
		forward.setPath("/views/studynote/studynote_list.jsp");
		System.out.println("스터디노트_리스트액션");
		System.out.println(list);
		forward.setRedirect(false);
		
		return forward;
	}

}
