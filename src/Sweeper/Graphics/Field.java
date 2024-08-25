package Sweeper.Graphics;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import Sweeper.Logic.FieldLogic;
//import Logic.Menu;

@SuppressWarnings("serial")
public class Field extends JButton implements MouseListener{
	

	
	public int arrayA; 
	//how high the the first value of the Field in the panel's Array is
	//i.e. how far right the Field is placed on the screen
	
	public int arrayB;
	//how high the the second value of the Field in the panel's Array is
	//i.e. how far down the Field is placed on the screen
	
	public boolean flag;
	public boolean open;
	public boolean marked;
	public boolean RandomizerSource;
	
	public Field(int newX, int newY, int a, int b) {
		super();
		this.setBorder(BorderFactory.createEmptyBorder());
		this.setBounds(newX, newY, 20, 20);
		this.addMouseListener(this);
		this.setBackground(new Color(150,90,50));
		this.setFocusable(false);
		arrayA = a;
		arrayB = b;
		open = false;
		flag = false;
		marked = false;
	}

	public void open(String s, Color c) {		
		this.setBackground(c);
		this.setText(s);
	}
	
	public void openEmpty() {
		open("B",new Color(255,255,255));
	}
	
	public void openWithNumber() {
		open("B",new Color(255,255,255));
	}
	
	public void openAsBomb() {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		FieldLogic fl = new FieldLogic();
		fl.controllFieldEvent(this, e);
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

}
