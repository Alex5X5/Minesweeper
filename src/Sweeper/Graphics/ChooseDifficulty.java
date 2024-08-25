package Sweeper.Graphics;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class ChooseDifficulty extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;

	public int difficulty = 1;
	static JRadioButton b1 = new JRadioButton("bt1");
	static JRadioButton b2 = new JRadioButton("bt2");
	static JRadioButton b3 = new JRadioButton("bt3");

	
	ButtonGroup gr = new ButtonGroup();
	
	public ChooseDifficulty() {
		
		this.setLayout(new FlowLayout());
		gr.add(b1);
		gr.add(b2);
		gr.add(b3);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		this.setTitle("bla");
		this.setResizable(false);
		this.setBackground(new Color(0,0,0));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.add(b1);
		this.add(b2);
		this.add(b3);
		
//		b1.addActionListener(this);

		
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		
	}
	
	void showDialog() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==b1) {
			System.out.println("test?");
		}
		if (e.getSource()==b2) {
			System.out.println("test?");
		}
		if (e.getSource()==b3) {
			System.out.println("test?");
		}
	}
}
