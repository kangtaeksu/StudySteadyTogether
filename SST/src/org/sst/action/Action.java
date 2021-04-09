package org.sst.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
public interface Action {
	public ActionForward execute(HttpServletRequest request, 
			HttpServletResponse response) throws Exception;
=======
import org.sst.action.ActionForward;

public interface Action {
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response)throws Exception;
}
