package org.sst.service;

import javax.servlet.http.HttpServletRequest;

import org.sst.domain.GroupMemberVO;

public interface StudyGroupService {
	// 스터디 그룹 생성
	public String insertGroupService(HttpServletRequest request) throws Exception;
	// 스터디 그룹에 멤버 넣기 (스터디 그룹 생성한사람 : 스터디 그룹 신청한 사람 나눠야할듯)
	public int insertGroupMemberService(HttpServletRequest request, GroupMemberVO gmem) throws Exception;
	// 스터디 그룹 리스트 가져오기
	public void selectGroupListService(HttpServletRequest request) throws Exception;
}
