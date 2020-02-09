/**
 * @Description main view just for bosses
 * up to down ,left to right
 * @author Charlie
 * @date 2020-02-08 14:01
 */
package com.mhl.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.Timer;

import com.mhl.tools.ImagePanel;
import com.mhl.tools.MyTools;

public class Window1 extends JFrame implements ActionListener{

	//define img icon
	Image titleIcon,timeGg;
	JMenuBar jmb;
	//first
	JMenu jm1,jm2,jm3,jm4,jm5,jm6;
	//second
	JMenuItem jmm1,jmm2,jmm3,jmm4,jmm5;
	//icon
	ImageIcon jmm1_icon1,jmm1_icon2,jmm1_icon3,jmm1_icon4,jmm1_icon5;
	//button tool
	JToolBar jtb;
	JButton jb1,jb2,jb3,jb4,jb5,jb6,jb7,jb8,jb9,jb10;
	//define jpanel
	JPanel p1,p2,p3,p4,p5;
	//show the time
	JLabel timeNow;
	//import a timer
	Timer t;
	//img tool
	JLabel p1_lab1,p1_lab2,p1_lab3,p1_lab4,p1_lab5,p1_lab6,p1_lab7,p1_lab8;
	ImagePanel p1_imgPanel;
	//two jlable for p2
	JLabel p2_lab1,p2_lab2;
	//
	JSplitPane jsp1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Window1();
	}

	public Window1() {
		// TODO Auto-generated constructor stub
		//create
		try {
			titleIcon=ImageIO.read(new File("image/main/title/cup.gif"));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//create icon
		jmm1_icon1 = new ImageIcon("image/main/menu/user.jpg");
		jmm1_icon2 = new ImageIcon("image/main/menu/sell.jpg");
		jmm1_icon3 = new ImageIcon("image/main/menu/login.jpg");
		jmm1_icon4 = new ImageIcon("image/main/menu/wnl.jpg");
		jmm1_icon5 = new ImageIcon("image/main/menu/exit.jpg");
		//create jm1 first
		jm1=new JMenu("系统管理");
		jm1.setFont(MyTools.f1);
		//create second
		jmm1 = new JMenuItem("切换用户",jmm1_icon1);
		jmm1.setFont(MyTools.f2);
		jmm2 = new JMenuItem("切换到收款界面",jmm1_icon2);
		jmm2.setFont(MyTools.f2);
		jmm3 = new JMenuItem("登录管理",jmm1_icon3);
		jmm3.setFont(MyTools.f2);
		jmm4 = new JMenuItem("万年历",jmm1_icon4);
		jmm4.setFont(MyTools.f2);
		jmm5 = new JMenuItem("退出",jmm1_icon5);
		jmm5.setFont(MyTools.f2);
		//add second
		jm1.add(jmm1);
		jm1.add(jmm2);
		jm1.add(jmm3);
		jm1.add(jmm4);
		jm1.add(jmm5);
		
		jm2=new JMenu("人事管理");
		jm2.setFont(MyTools.f1);
		jm3=new JMenu("菜单服务");
		jm3.setFont(MyTools.f1);
		jm4=new JMenu("报表统计");
		jm4.setFont(MyTools.f1);
		jm5=new JMenu("成本及库房");
		jm5.setFont(MyTools.f1);
		jm6=new JMenu("帮助");
		jm6.setFont(MyTools.f1);
		
		jmb=new JMenuBar();
		jmb.add(jm1);
		jmb.add(jm2);
		jmb.add(jm3);
		jmb.add(jm4);
		jmb.add(jm5);
		jmb.add(jm6);
		
		//add jmb to jframe
		this.setJMenuBar(jmb);
		
		//toolbar
		jtb=new JToolBar();
		//set not move
		jtb.setFloatable(false);
		jb1=new JButton(new ImageIcon("image/main/toolbar/sell.jpg"));
		jb2=new JButton(new ImageIcon("image/main/toolbar/user.jpg"));
		jb3=new JButton(new ImageIcon("image/main/toolbar/login.jpg"));
		jb4=new JButton(new ImageIcon("image/main/toolbar/earth.jpg"));
		jb5=new JButton(new ImageIcon("image/main/toolbar/uDisk.jpg"));
		jb6=new JButton(new ImageIcon("image/main/toolbar/fish.jpg"));
		jb7=new JButton(new ImageIcon("image/main/toolbar/cuke.jpg"));
		jb8=new JButton(new ImageIcon("image/main/toolbar/butterfly.jpg"));
		jb9=new JButton(new ImageIcon("image/main/toolbar/robot.jpg"));
		jb10=new JButton(new ImageIcon("image/main/toolbar/exit.jpg"));
		//add bt to jtb
		jtb.add(jb1);
		jtb.add(jb2);
		jtb.add(jb3);
		jtb.add(jb4);
		jtb.add(jb5);
		jtb.add(jb6);
		jtb.add(jb7);
		jtb.add(jb8);
		jtb.add(jb9);
		jtb.add(jb10);
		
		//panel 1
		p1=new JPanel(new BorderLayout()); 
		Image p1_bg=null;
		try {
			p1_bg = ImageIO.read(new File("image/main/windows1/jp1_bg.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.p1_imgPanel=new ImagePanel(p1_bg);
		this.p1_imgPanel.setLayout(new GridLayout(8,1));
		//p1_lab1
		p1_lab1=new JLabel(new ImageIcon("image/main/windows1/label_1.gif"));
		p1_imgPanel.add(p1_lab1);
		//p1_lab2
		p1_lab2=new JLabel("人 事 管 理",new ImageIcon("image/main/windows1/label_2.jpg"),0);
		p1_imgPanel.add(p1_lab2);
		//p1_lab3
		p1_lab3=new JLabel("登 录 管 理",new ImageIcon("image/main/windows1/label_3.jpg"),0);
		p1_imgPanel.add(p1_lab3);
		//p1_lab4
		p1_lab4=new JLabel("菜 谱 价 格",new ImageIcon("image/main/windows1/label_4.jpg"),0);
		p1_imgPanel.add(p1_lab4);
		//p1_lab5
		p1_lab5=new JLabel("报 表 统 计",new ImageIcon("image/main/windows1/label_5.jpg"),0);
		p1_imgPanel.add(p1_lab5);
		//p1_lab6
		p1_lab6=new JLabel("成 本 及 库 房",new ImageIcon("image/main/windows1/label_6.jpg"),0);
		p1_imgPanel.add(p1_lab6);
		//p1_lab7
		p1_lab7=new JLabel("系 统 设 置",new ImageIcon("image/main/windows1/label_7.jpg"),0);
		p1_imgPanel.add(p1_lab7);
		//p1_lab8
		p1_lab8=new JLabel("动 画 帮 助",new ImageIcon("image/main/windows1/label_8.jpg"),0);
		p1_imgPanel.add(p1_lab8);
		//add into p1
		p1.add(this.p1_imgPanel);
		//p2 p3 p4
		p4=new JPanel(new BorderLayout());
		p3=new JPanel(new CardLayout());
		p2=new JPanel(new CardLayout());
		p2_lab1=new JLabel(new ImageIcon("image/main/windows1/jp2_left.jpg"));
		p2_lab2=new JLabel(new ImageIcon("image/main/windows1/jp2_right.jpg"));
		//add into p2
		p2.add(p2_lab1,"0");
		p2.add(p2_lab2,"1");
		//add main to p3
		Image zhu_image=null;
		try {
			zhu_image=ImageIO.read(new File("image/main/windows1/jp3_bg.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ImagePanel ip=new ImagePanel(zhu_image);
		p3.add(ip,"0");
		
		//!!做一个拆分窗口，放p1和p4
		jsp1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,p1,p4);
		//how large left
		jsp1.setDividerLocation(120);
		//cancle boder
		jsp1.setDividerSize(0);
		//add into p4
		p4.add(p2,"West");
		p4.add(p3,"Center");
		
		//panel 5
		p5=new JPanel(new BorderLayout());
		//trigger
		t=new Timer(1000, this);
		t.start();
		timeNow=new JLabel(Calendar.getInstance().getTime().toLocaleString()+"   ");
		timeNow.setFont(MyTools.f1);
		try {
			timeGg=ImageIO.read(new File("image/main/statebar/time_bg.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ImagePanel ip1=new ImagePanel(timeGg);
		ip1.setLayout(new BorderLayout());
		ip1.add(timeNow,"East");
		p5.add(ip1);
		
		//old method
		Container ct=this.getContentPane();
		ct.add(jtb,"North");
		ct.add(jsp1,"Center");
		ct.add(p5,"South");
		//size
		//pos
		int w=Toolkit.getDefaultToolkit().getScreenSize().width;
		int h=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(titleIcon);
		this.setTitle("满汉楼餐饮管理");
		this.setSize(w,h-30);
		this.setVisible(true);
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.timeNow.setText("当前时间："+Calendar.getInstance().getTime().toLocaleString()+"   ");
	}
}
