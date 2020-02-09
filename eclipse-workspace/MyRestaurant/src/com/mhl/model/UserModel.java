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
	public String checkUser(String uid, String p) {
		
		String position="";
		SqlHelper sp=null;
		try {
			String sql="select rszl.zhiwei from login,rszl where login.empid = rszl.empid and login.empid=? and login.passwd=?";
			String paras[]= {uid,p};
			sp=new SqlHelper();
			ResultSet rs=sp.query(sql, paras);
			if(rs.next()) {
				//get position
				position=rs.getString(1);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			sp.close();
		}
		
		return position;
		
	}
	
}
