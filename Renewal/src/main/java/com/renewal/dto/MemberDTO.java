package com.renewal.dto;

import java.util.Date;

public class MemberDTO {
	private int mNo;
	private String mId;
	private String mPw;
	private String mName;
	private int mAge;
	private Date mregDate;
	
	public MemberDTO() {
		super();
	}

	public MemberDTO(int mNo, String mId, String mPw, String mName, int mAge, Date mregDate) {
		super();
		this.mNo = mNo;
		this.mId = mId;
		this.mPw = mPw;
		this.mName = mName;
		this.mAge = mAge;
		this.mregDate = mregDate;
	}

	public int getmNo() {
		return mNo;
	}

	public void setmNo(int mNo) {
		this.mNo = mNo;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getmPw() {
		return mPw;
	}

	public void setmPw(String mPw) {
		this.mPw = mPw;
	}

	public String getmName() {
		return mName;
	}

	public void setmName(String mName) {
		this.mName = mName;
	}

	public int getmAge() {
		return mAge;
	}

	public void setmAge(int mAge) {
		this.mAge = mAge;
	}

	public Date getMregDate() {
		return mregDate;
	}

	public void setMregDate(Date mregDate) {
		this.mregDate = mregDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("memberDTO [mNo=");
		builder.append(mNo);
		builder.append(", mId=");
		builder.append(mId);
		builder.append(", mPw=");
		builder.append(mPw);
		builder.append(", mName=");
		builder.append(mName);
		builder.append(", mAge=");
		builder.append(mAge);
		builder.append(", mregDate=");
		builder.append(mregDate);
		builder.append("]");
		return builder.toString();
	}
}
