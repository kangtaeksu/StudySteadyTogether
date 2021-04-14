package org.sst.service;

import javax.servlet.http.HttpServletRequest;

public interface StudyGroupService {
	// 스터디 그룹 생성
	public int insertGroupService(HttpServletRequest request) throws Exception;
	
}
