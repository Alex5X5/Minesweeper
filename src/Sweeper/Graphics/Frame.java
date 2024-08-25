package Sweeper.Graphics;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Frame extends JFrame {
	
	public Panel panel;

	public Frame() {
		this.setTitle("Mine Sweeper");
		this.setResizable(false);
//		this.setFocusable(true);

//		this.setBackground(Color.black);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(new Panel());
//		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
//		this.setUndecorated(true);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
	}	
}
