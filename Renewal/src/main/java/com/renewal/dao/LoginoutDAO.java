package com.renewal.dao;

import javax.servlet.http.HttpSession;

public interface LoginoutDAO {
	public HttpSession login(String mId, String mPw) throws Exception;
	public void logout(HttpSession mInfo) throws Exception;
}
