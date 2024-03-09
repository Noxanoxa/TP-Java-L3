package tp;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class DemoPanel extends JFrame{
	final int maxcol =15;
	final int maxrow =10;
	final int nodesize =70;
	final int screenWidth = nodesize * maxcol;
	final int screenhight = nodesize * maxrow;
	
	public DemoPanel() {
		this.setPreferredSize(new Dimension(screenWidth,screenhight));
		this.setBackground(Color.black);
		this.setLayout(new GridLayout(maxrow,maxcol));
		
	}

}