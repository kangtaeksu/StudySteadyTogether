package org.sst.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.sst.domain.StudyNoteSearchVO;
import org.sst.domain.StudyNoteVO;



public interface StudyNoteMapper {
	int insertStudyNote(StudyNoteVO stdNote);

	List<StudyNoteVO> listStudyNote(StudyNoteSearchVO search, RowBounds row);
	StudyNoteVO detailStudyNote(String sn_num);

	int updateStudyNote(StudyNoteVO studynote);

	int countStudyNote(StudyNoteSearchVO search);
	int deleteStudyNote(String sn_num);

}
