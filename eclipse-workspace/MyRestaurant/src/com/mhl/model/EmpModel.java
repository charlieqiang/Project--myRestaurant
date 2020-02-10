/**
 * @Description rs model
 * @author Charlie
 * @date 2020-02-08 14:01
 */
package com.mhl.model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.mhl.db.SqlHelper;

public class EmpModel extends AbstractTableModel{

	Vector<String> colums;
	Vector<Vector> rows;
	
	//cru
	public boolean delEmpById(String empId) {
		boolean b=true;
		
		String sql="delete from rszl where empid=?";
		String []paras= {empId};
		SqlHelper sh=new SqlHelper();
		
		try {
			b=sh.exeUpdate(sql, paras);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			sh.close();
		}
		return b;
		
	}
	//optimize
	public void query(String sql, String paras[]) {
		//init
		this.rows=new Vector<Vector>();
		this.colums=new Vector<String>();
		
		//create a sqlH
		SqlHelper sh=new SqlHelper();
		ResultSet rs=sh.query(sql, paras);
		//get a rs metadata
		try {
			ResultSetMetaData rsmt=rs.getMetaData();
			for (int i = 0; i < rsmt.getColumnCount(); i++) {
				this.colums.add(rsmt.getColumnName(i+1));
				
			}
			while (rs.next()) {
				Vector<String> temp=new Vector<String>();
//					temp.add(rs.getString(1));
//					temp.add(rs.getString(2));
//					temp.add(rs.getString(3));
//					temp.add(rs.getString(4));
				for (int i = 0; i < rsmt.getColumnCount(); i++) {
					temp.add(rs.getString(i+1));
				}
				rows.add(temp);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			sh.close();
			
		}
		
//		this.colums.add("员工号");
//		this.colums.add("姓名");
//		this.colums.add("性别");
//		this.colums.add("职位");
		
		//push into rows

	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.colums.size();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rows.size();
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return ((Vector)rows.get(arg0)).get(arg1);
	}
	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return this.colums.get(column).toString();
	}

}
