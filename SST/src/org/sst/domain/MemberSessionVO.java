package org.sst.domain;

public class MemberSessionVO {
	private String id;
	private String name;
	
	public MemberSessionVO() {
	}

	public MemberSessionVO(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setEmail(String name) {
		this.name = name;
	}
	
}
