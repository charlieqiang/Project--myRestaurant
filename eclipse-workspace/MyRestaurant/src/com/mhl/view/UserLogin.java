package com.mhl.view;

import com.mhl.model.UserModel;
import com.mhl.tools.*;
import com.mhl.tools.*;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class UserLogin extends JDialog implements ActionListener{
	
	//define con
	JLabel jl1,jl2,jl3;
	JTextField jName;
	JPasswordField jPasswd;
	JButton jCon, jCancel;
	
	//for test
//	public static void main(String[] args) {
//		//TODO Auto-generated method stub
//		new UserLogin();
//	}
	
	public UserLogin() {
		// TODO Auto-generated constructor stub
		//init
		//Layout
		this.setLayout(null);
//		new method
//		this.add(bi);
//		old
//		Container ct = this.getContentPane();
//		ct.add(bi);
		Container ct = this.getContentPane();
		
//		jl1
		jl1=new JLabel("请输入用户名");
		jl1.setFont(MyTools.f1);
		jl1.setBounds(60,190,150,30);
		
//		jname
		jName =new JTextField(20);
		jName.setFont(MyTools.f1);
		jName.setBounds(180, 190, 120, 30);
		//effect
		jName.setBorder(BorderFactory.createLoweredBevelBorder());
		
//		jl2
		jl2=new JLabel("（员工号）");
		jl2.setFont(MyTools.f2);
		jl2.setForeground(Color.red);
		jl2.setBounds(100, 210, 100, 30 );

//		jl3
		jl3=new JLabel("请输入密码");
		jl3.setFont(MyTools.f1);
		jl3.setBounds(60, 240, 150, 30);
		
//		jpsw
		jPasswd = new JPasswordField();
		jPasswd.setBounds(180, 240, 120, 30);
		
//		jcon
		jCon=new JButton("确定");
		jCon.setFont(MyTools.f1);
		jCon.setBounds(110, 300, 70, 30);
		jCon.addActionListener(this);
		
//		jcancle
		jCancel = new JButton("取消");
		jCancel.setFont(MyTools.f1);
		jCancel.setBounds(220, 300, 70, 30);
		jCancel.addActionListener(this);
		
		//add
		ct.add(jName);
		ct.add(jl1);
		ct.add(jl2);
		ct.add(jl3);
		ct.add(jPasswd);
		ct.add(jCon);
		ct.add(jCancel);
		//create backImage
		BackImage bi = new BackImage();
		
		//setpos
		bi.setBounds(0,0,360,360);
		ct.add(bi);
		
		//not use default
		this.setUndecorated(true);
		this.setSize(360, 360);
		
		//pos
		int width=Toolkit.getDefaultToolkit().getScreenSize().width;
		int height=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation(width/2-200,height/2-150);
		this.setVisible(true);
		
	}
	
	//inside class
	class BackImage extends JPanel{
		Image im = null;
		public BackImage() {
			// TODO Auto-generated constructor stub
			try {
				im = ImageIO.read(new File("image/login/login.gif"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		//draw the image
		public void paintComponent(Graphics g) {
			g.drawImage(im, 0, 0, 360, 360, this);
		}	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jCon) {
			//trim() for the unvaluable space
			String u=this.jName.getText().trim();
			String p=new String(this.jPasswd.getPassword());
//			System.out.println(u+" "+p);
			UserModel um=new UserModel();
			String res=um.checkUser(u, p).trim();
			System.out.println(res);
			if(res.equals("经理")||res.equals("主管")||res.equals("管理员")) {
				new Window1();
				this.dispose();
			}
		}else if(e.getSource()==jCancel) {
			//you should add a tips!
			this.dispose();
			
		}
	}
}
