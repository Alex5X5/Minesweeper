package Sweeper.Graphics;

import java.awt.Color;
import java.awt.Label;
//import java.awt.TextField;

import javax.accessibility.Accessible;

@SuppressWarnings( "serial")
public class Score extends Label implements Accessible{
	
	public Score() {
		super("");
		this.setVisible(true);
		this.setBounds((Panel.arrayWidh*25/2-20),15,55,30);
		this.setBackground(Color.white);
//		this.setText("txt");


//		this.setText("aöeflskdhj");
	}
	
	public void setValue(String txt) {
		this.setText(txt);
	}
}
