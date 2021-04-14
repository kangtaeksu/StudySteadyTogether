package org.sst.service;

import javax.servlet.http.HttpServletRequest;

import org.sst.domain.MemberVO;

public interface MemberService {
	// 회원가입
	public int insertMemberService(HttpServletRequest request) throws Exception;
	// 로그인
	public MemberVO loginMemberService(HttpServletRequest request) throws Exception;
}
