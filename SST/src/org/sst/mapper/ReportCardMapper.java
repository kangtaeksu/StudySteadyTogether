package org.sst.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sst.domain.LicenseScoreVO;
import org.sst.domain.LicenseTestVO;
import org.sst.domain.ReportCardVO;
import org.sst.domain.SchoolScoreVO;
import org.sst.domain.SchoolTestVO;

public interface ReportCardMapper {
	int insertReportCard(ReportCardVO rc);
	List<ReportCardVO> listReportCard(String m_id);
	ReportCardVO selectReportCard(String st_num);
	int deleteReportCard(String rc_num);
	
	int insertSchoolTest(SchoolTestVO st);
	List<SchoolTestVO> listSchoolTest(String rc_num);
	int deleteSchoolTest(String st_num);
	SchoolTestVO selectSchoolTest(String st_num);
	int updateSchoolTest(SchoolTestVO st);
	
	int firstInsertSchoolScore(SchoolScoreVO ss);
	List<SchoolScoreVO> listSchoolScore(String st_num);
	int deleteSchoolTestScore(String st_num);
	int deleteSchoolScore(String ss_num);
	int updateSchoolScore(SchoolScoreVO ss);
	
	int insertLicenseTest(LicenseTestVO lt);
	List<LicenseTestVO> listLicenseTest(String rc_num);
	LicenseTestVO selectLicenseTest(String lt_num);
	int deleteLicenseTest(String lt_num);
	int updateLicenseTest(LicenseTestVO lt);
	
	int insertLicenseScore(LicenseScoreVO ls);
	List<LicenseScoreVO> listLicenseScore(String lt_num);
	int deleteLicenseTestScore(String lt_num);
	int deleteLicenseScore(String ls_num);
	int updateLicenseScore(LicenseScoreVO ls);
	
	
	List<SchoolTestVO> averageSchoolTest(String rc_num);
	List<HashMap> allSubjectAverage(HashMap map);
	List<String> selectReportCardSubject(String rc_num);
	
	List<HashMap> allLicenseSubjectAverage(HashMap map);
	List<String> selectRCLicenseTestSubject(String rc_num);
	
}
