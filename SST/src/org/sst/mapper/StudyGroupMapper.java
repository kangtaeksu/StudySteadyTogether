package org.sst.mapper;

import java.util.List;

import org.sst.domain.GroupMemberVO;
import org.sst.domain.StudyGroupVO;

public interface StudyGroupMapper {
	int insertStudyGroup(StudyGroupVO vo);
	int insertGroupMember(GroupMemberVO vo);
	List<StudyGroupVO> selectStudyGroup();
}
