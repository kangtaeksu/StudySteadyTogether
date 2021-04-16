package org.sst.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sst.action.Action;
import org.sst.action.ActionForward;
import org.sst.action.LicenseScore_InsertAction;
import org.sst.action.LicenseTest_DeleteAction;
import org.sst.action.LicenseTest_InsertAction;
import org.sst.action.LicenseTest_InsertFormAction;
import org.sst.action.LicenseTest_UpdateAction;
import org.sst.action.LicenseTest_UpdateFormAction;
import org.sst.action.RC_AverageCahrtAction;
import org.sst.action.RC_DeleteAction;
import org.sst.action.RC_DetailAction;
import org.sst.action.RC_InsertAction;
import org.sst.action.RC_InsertFormAction;
import org.sst.action.RC_LicenseAverageChartAction;
import org.sst.action.RC_ListAction;
import org.sst.action.SchoolScore_insertAction;
import org.sst.action.SchoolTest_DeleteAction;
import org.sst.action.SchoolTest_InsertAction;
import org.sst.action.SchoolTest_InsertFormAction;
import org.sst.action.SchoolTest_UpdateAction;
import org.sst.action.SchoolTest_UpdateForm;

/**
 * Servlet implementation class ReportCardController
 */
@WebServlet("/ReportCard/*")
public class ReportCardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ReportCardController() {
        super();
    }
    public void doProcess(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	String requestURI = request.getRequestURI();
    	
    	String contextPath = request.getContextPath();
    	String command = requestURI.substring(contextPath.length() + 12);
    	Action action = null;
		ActionForward forward = null;
		
		
		if (command.equals("insertReportCardAction.do")) {
			action = new RC_InsertAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("insertReportCardForm.do")) {
			action = new RC_InsertFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("listReportCardAction.do")) {
			action = new RC_ListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("deleteReportCardAction.do")) {
			action = new RC_DeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("insertSchoolTestForm.do")) {
			action = new SchoolTest_InsertFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("insertSchoolTestAction.do")) {
			action = new SchoolTest_InsertAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("detailReportCardAction.do")) {
			action = new RC_DetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("averageChartRCAction.do")) {
			action = new RC_AverageCahrtAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("seleteSchoolTestAction.do")) {
			action = new RC_AverageCahrtAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("deleteSchoolTestAction.do")) {
			action = new SchoolTest_DeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("updateSchoolTestForm.do")) {
			action = new SchoolTest_UpdateForm();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("updateSchoolTestAction.do")) {
			action = new SchoolTest_UpdateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("insertSchoolScoreAction.do")) {
			action = new SchoolScore_insertAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("insertLicenseTestAction.do")) {
			action = new LicenseTest_InsertAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("insertLicenseTestForm.do")) {
			action = new LicenseTest_InsertFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("updateLicenseTestForm.do")) {
			action = new LicenseTest_UpdateFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("updateLicenseTestAction.do")) {
			action = new LicenseTest_UpdateAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("insertLicenseScoreAction.do")) {
			action = new LicenseScore_InsertAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("deleteLicenseTestAction.do")) {
			action = new LicenseTest_DeleteAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("averageALLLicenseRCAction.do")) {
			action = new RC_LicenseAverageChartAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
