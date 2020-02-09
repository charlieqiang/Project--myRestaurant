/**
 * @Description rsgl
 * @author Charlie
 * @date 2020-02-08 14:01
 */
package com.mhl.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.mhl.model.EmpModel;
import com.mhl.tools.MyTools;

public class EmpInfo extends JPanel{

	//define
	JPanel p1,p2,p3,p4,p5;
	JLabel p1_lab1,p3_lab1;
	JTextField p1_jtf1;
	JButton p1_jb1,p4_jb1,p4_jb2,p4_jb3,p4_jb4;
	//rs Msg
	JTable jtable;
	//
	JScrollPane jsp;
	public EmpInfo() {
		// TODO Auto-generated constructor stub
		//create
		p1=new JPanel(new FlowLayout(FlowLayout.CENTER));
		p1_lab1=new JLabel("请输入姓名（员工号或职位）");
		p1_lab1.setFont(MyTools.f2);
		p1_jtf1=new JTextField(20);
		p1_jb1=new JButton("查询");
		p1_jb1.setFont(MyTools.f2);
		
		p1.add(p1_lab1);
		p1.add(p1_jtf1);
		p1.add(p1_jb1);		
		//middle
		EmpModel em=new EmpModel();
		String []paras= {"1"};
		em.query("select empid,empname,sex,zhiwei from rszl where 1=?", paras);
		jtable=new JTable(em);
		p2=new JPanel(new BorderLayout());
		jsp=new JScrollPane(jtable);
		p2.add(jsp);
		
		//south
		p3=new JPanel(new FlowLayout(FlowLayout.LEFT));
		p3_lab1=new JLabel("总记录数是**条");
		p3_lab1.setFont(MyTools.f3);
		
		p3.add(p3_lab1);
		p4=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		

		p4_jb1=new JButton("详细信息");
		p4_jb2=new JButton("添加");
		p4_jb3=new JButton("修改");
		p4_jb4=new JButton("删除");
		p4_jb1.setFont(MyTools.f3);
		p4_jb2.setFont(MyTools.f3);
		p4_jb3.setFont(MyTools.f3);
		p4_jb4.setFont(MyTools.f3);
		
		p4.add(p4_jb1);
		p4.add(p4_jb2);
		p4.add(p4_jb3);
		p4.add(p4_jb4);
		p5=new JPanel(new BorderLayout());
		p5.add(p3,"West");
		p5.add(p4,"East");
		
		//set to border
		this.setLayout(new BorderLayout());
		
		this.add(p1,"North");
		this.add(p2,"Center");
		this.add(p5,"South");
		
		this.setVisible(true);
	}
	
}
