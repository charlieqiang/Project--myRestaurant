package com.mhl.tools;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class ImagePanel extends JPanel{
	Image im;
	public ImagePanel(Image im) {
		// TODO Auto-generated constructor stub
		//adaption
		this.im=im;
		int w=Toolkit.getDefaultToolkit().getScreenSize().width;
		int h=Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setSize(w,h);
		
	}
	
	public void paintComponent(Graphics g) {
		//clear
		super.paintComponents(g);
		g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), this);
	
	}
}
