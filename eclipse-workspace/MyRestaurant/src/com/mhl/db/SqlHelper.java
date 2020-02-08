/**
 * @Description crud
 * @author Charlie
 * @date 2020-02-08 14:01
 */
package com.mhl.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SqlHelper {
	
	//define
	PreparedStatement ps=null;
	ResultSet rs=null;
	Connection ct=null;
	String driverName="com.microsoft.jdbc.sqlserver.SQLServerDriver";
	String url="jdbc:microsoft:sqlserver://127.0.0.1:1433;databaseName=restaurant";
	String user="sa";
	String passwd="123456";
	
	public SqlHelper() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName(driverName);
			
			ct=DriverManager.getConnection(url,user,passwd);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	}
	public ResultSet query(String sql, String []paras) {
		try {
			ps=ct.prepareStatement(sql);
			//add
			for(int i=0;i<paras.length;i++) {
				ps.setString(i+1, paras[i]);
				
			}
			
			rs=ps.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return rs;
	}
	
	public void close() {
		try {
			if(rs!=null) rs.close();
			if(ps!=null) ps.close();
			if(ct!=null) ct.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
