package org.sst.mapper;

import java.util.List;

import org.sst.domain.StudyNoteVO;



public interface StudyNoteMapper {
	int insertStudyNote(StudyNoteVO stdNote);

	List<StudyNoteVO> listStudyNote();
	StudyNoteVO detailStudyNote(String sn_num);
	int updateStudyNote(StudyNoteVO studynote);
}
