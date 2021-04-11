package org.sst.service;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kosta.model.Board;
import kosta.model.BoardDao2;
import kosta.model.ImageUtil;
import kosta.model.ListModel;
import kosta.model.Reply;
import kosta.model.Search;

public class BoardService {
	private static BoardService service = new BoardService();
	private static BoardDao2 dao;//다옹
	private static final int PAGE_SIZE = 2;
	
	public static BoardService getInstance() {
		dao = BoardDao2.getInstance();
		return service;
	}
	
	public int insertBoardService(HttpServletRequest request)throws Exception{
		request.setCharacterEncoding("utf-8");
		String uploadPath = request.getRealPath("upload");
		int size = 20 * 1024 * 1024; //20MB
		
		MultipartRequest multi =
				new MultipartRequest(request, uploadPath, size, "utf-8",
						new DefaultFileRenamePolicy());
		
		
		Board board = new Board();
		board.setTitle(multi.getParameter("title"));
		board.setWriter(multi.getParameter("writer"));
		board.setContents(multi.getParameter("contents"));
		board.setFname("");
		
		if(multi.getFilesystemName("fname") != null) {
			String fname = (String)multi.getFilesystemName("fname");
			board.setFname(fname);
			
			String pattern = fname.substring(fname.indexOf(".")+1);//gif, jpg
			String head = fname.substring(0, fname.indexOf("."));//aa
			
			String imagePath = uploadPath + "\\" + fname;
			File src = new File(imagePath);
			
			String thumPath = uploadPath + "\\" + head + "_small." + pattern;
			File dest = new File(thumPath);
			
			if(pattern.equals("gif") || pattern.equals("jpg")) {
				ImageUtil.resize(src, dest, 100, ImageUtil.RATIO);
			}
			
		}
		
		return dao.insertBoard(board);
	}
	////////////////////////////
	//리스트보드를 보여주는 서비
	
	public ListModel listBoardService(HttpServletRequest request)throws Exception{
		request.setCharacterEncoding("utf-8");
		Search search = new Search();
		HttpSession session = request.getSession();
		
	//Search
		if(request.getParameterValues("area") != null) {
			session.removeAttribute("search");
			search.setArea(request.getParameterValues("area"));
			search.setSearchKey("%" + request.getParameter("searchKey")  + "%");
			session.setAttribute("search", search);
		}
		else if(request.getParameterValues("area") == null
				&& request.getParameter("pageNum") == null){
			session.removeAttribute("search");
		}	
		if(session.getAttribute("search") != null) {
			search = (Search)session.getAttribute("search");
		}
		//카운트값		
		int totalCount = dao.countBoard(search);
		int totalPageCount = totalCount/PAGE_SIZE;
		if(totalCount%PAGE_SIZE > 0) {
			totalPageCount++;
		}
		
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		int requestPage = Integer.parseInt(pageNum);
		int startPage = requestPage - (requestPage - 1) % 5;
		
		//endPage
		int endPage = startPage + 4;
		if(endPage > totalPageCount) {
			endPage = totalPageCount;
		}
		//startRow =
		int startRow = (requestPage - 1) * PAGE_SIZE;	
		List<Board> list = dao.listBoard(search, startRow);
		ListModel listModel =
				new ListModel(list, requestPage, totalPageCount, startPage, endPage);
		return listModel;
	}
	
	///////////////////////////
	
	public Board detailBoardService(int seq)throws Exception{
		return dao.detailBoard(seq);
	}
	
	public int updateBoardService(Board board)throws Exception{
		return dao.updateBoard(board);
	}
	
	public int insertReplyService(HttpServletRequest request)throws Exception{
		
		Reply reply = new Reply();
		reply.setR_title(request.getParameter("r_no"));
		reply.setR_title(request.getParameter("r_title"));
		reply.setR_title(request.getParameter("r_writer"));
		reply.setR_title(request.getParameter("r_contents"));
		reply.setR_title(request.getParameter("regdate"));
		return dao.insertReply(reply);
	}
	
	public List<Reply> listReplyService(int seq){
		return dao.listReply(seq);
	}
}











