package Sweeper.Graphics;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;

import javax.swing.JPanel;

import Sweeper.Logic.EventHelper;

//import GamePanel.AL;

  
@SuppressWarnings("serial")
public class Panel extends JPanel {
	
	public static int arrayWidh = 30;
	public static int arrayHeight = 25;
	public static int numberOfMines = 150;
	public static boolean started;

	public static Field[][] fields = new Field[arrayWidh+1][arrayHeight+1];
	public static Score score;
	

		
	public Panel () {
		
		super();
		this.setPreferredSize(new Dimension(15+arrayWidh*25,40+arrayHeight*25)); // field has size of 15 and 2.5 space on each side
		this.setBackground(Color.BLACK);
		this.setVisible(true);
		this.setLayout(null);
		this.setFocusable(true);
		EventHelper eh = new EventHelper();
		this.addKeyListener(
			new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					eh.castSolver(e);
				}
			}
		);
		
		started = false;
		
		score = new Score();
		this.add(score);
		createFields();
	}
	
	public void createFields() {
		
		for (int a = 0; a < arrayWidh; a++) {			
			for (int b = 0; b < arrayHeight; b++) {				
				fields[a][b] = new Field((10+a*25),(35+b*25),a,b);
				this.add(fields[a][b]);
			}			
		}
	}
}
