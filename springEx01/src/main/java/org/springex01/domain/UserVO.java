package org.springex01.domain;

public class UserVO {
	private String uid;
	private String upw;
	private String uname;
	private int upoint;
	
	public UserVO() {
		super();
	}

	public UserVO(String uid, String upw, String uname, int upoint) {
		super();
		this.uid = uid;
		this.upw = upw;
		this.uname = uname;
		this.upoint = upoint;
	}
	
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUpw() {
		return upw;
	}
	public void setUpw(String upw) {
		this.upw = upw;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getUpoint() {
		return upoint;
	}
	public void setUpoint(int upoint) {
		this.upoint = upoint;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserVO [uid=");
		builder.append(uid);
		builder.append(", upw=");
		builder.append(upw);
		builder.append(", uname=");
		builder.append(uname);
		builder.append(", upoint=");
		builder.append(upoint);
		builder.append("]");
		return builder.toString();
	}
}
