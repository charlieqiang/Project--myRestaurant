/**
 * @Description rs model
 * @author Charlie
 * @date 2020-02-08 14:01
 */
package com.mhl.model;

import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.mhl.db.SqlHelper;

public class EmpModel extends AbstractTableModel{

	Vector<String> colums;
	Vector<Vector> rows;
	
	//
	public void query(String sql, String paras[]) {
		//init
		this.rows=new Vector<Vector>();
		this.colums=new Vector<String>();
		this.colums.add("员工号");
		this.colums.add("姓名");
		this.colums.add("性别");
		this.colums.add("职位");
		
		//create a sqlH
		SqlHelper sh=new SqlHelper();
		ResultSet rs=sh.query(sql, paras);
		
		//push into rows
		try {
			while (rs.next()) {
				Vector<String> temp=new Vector<String>();
				temp.add(rs.getString(1));
				temp.add(rs.getString(2));
				temp.add(rs.getString(3));
				temp.add(rs.getString(4));
				rows.add(temp);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			sh.close();
			
		}

		
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
