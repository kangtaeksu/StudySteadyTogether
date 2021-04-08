package org.sst.domain;

import java.io.Serializable;

public class GroupMemberVO implements Serializable {

	private String gm_num;
	private String g_num;
	private String gm_index;
	private String p_grant;
	private String m_id;
	
	public GroupMemberVO() {}
	
	public GroupMemberVO(String gm_num, String g_num, String gm_index, String p_grant, String m_id) {
		super();
		this.gm_num = gm_num;
		this.g_num = g_num;
		this.gm_index = gm_index;
		this.p_grant = p_grant;
		this.m_id = m_id;
	}

	public String getGm_num() {
		return gm_num;
	}

	public void setGm_num(String gm_num) {
		this.gm_num = gm_num;
	}

	public String getG_num() {
		return g_num;
	}

	public void setG_num(String g_num) {
		this.g_num = g_num;
	}

	public String getGm_index() {
		return gm_index;
	}

	public void setGm_index(String gm_index) {
		this.gm_index = gm_index;
	}

	public String getP_grant() {
		return p_grant;
	}

	public void setP_grant(String p_grant) {
		this.p_grant = p_grant;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	
	
}
