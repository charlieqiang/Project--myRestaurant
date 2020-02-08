/**
 * @Description user data modol 32:38
 * @author Charlie
 * @date 2020-02-08 14:01
 */
package com.mhl.model;

import java.sql.ResultSet;

import com.mhl.db.SqlHelper;

public class UserModel {
	
	
	/**
	 * @param uid userid
	 * @param p passwd
	 * @return clerk position if not return false
	 */
	public boolean checkUser(String uid, String p) {
		
		String position="";
		
		try {
			String sql="select ? from login,lszl where login.empid = rszl.empid and login.empid=? and login.passwd=?";
			String paras[]= {uid,p};
			SqlHelper sp=new SqlHelper();
			ResultSet rs=sp.query(sql, paras);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return false;
		
	}
	
}
