package org.sst.mapper;

import org.sst.domain.MemberVO;

public interface MemberMapper {
	int insertMember(MemberVO member);
	MemberVO selectLoginMember(MemberVO member);
	MemberVO selectInfoMember(String id);
	int updateMember(MemberVO member);
}
