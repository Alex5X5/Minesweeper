package Sweeper.Logic;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import Sweeper.Ai.PuzzleSolver;
import Sweeper.Graphics.Field;
//import Graphics.Frame;
//import Sweeper.Graphics.Panel;

public class FieldLogic {
	
	EventHelper eh = new EventHelper();
	FieldGetter fg = new FieldGetter();

	public void controllFieldEvent(Field f, MouseEvent e) {
		
		eh.checkForEvents(f);
		
		if (f.open && e.getButton() == 1 && fg.getNearbyMarkers(f).size()==fg.getNearbyMines(f).size()) {
			softOpenNearby(f);	
		}
		
		//checking whether the field is marked
		if (!f.open && !f.marked && e.getButton() == 3) {
			f.open("",new Color(200,200,0));
			f.marked = true;
		}
		else {
			if (!f.open && f.marked && e.getButton() == 3) {
				f.open("",new Color(150,90,50));
				f.marked = false;
			}			
		}
		
		//checking whether the field is a flag
		if (!f.open && f.flag && !f.marked && e.getButton() == 1) {
			f.open("B",new Color(255,0,0));
			f.open = true;
		}
		
		if (!f.open && !f.flag && !f.marked && e.getButton() == 1) {
			if (fg.getNearbyMines(f).size()==0) {
				softOpenNearby(f);
			}
			else {
				printMines(f);
			}
		}
		
		if (e.getButton() == 2) {
			PuzzleSolver ps = new PuzzleSolver();
			ps.runSolver();
			ps = null; 
		}
		
		eh.checkForEvents(f);
		
	}
	
	public void printMines(Field f) {
		if (fg.getNearbyMines(f).size()!=0) {
			f.open(String.valueOf(fg.getNearbyMines(f).size()),Color.white);
			f.open=true;
		}
		else {
			f.open("",Color.white);
			f.open=true;
		}
	}

	public void softOpenNearby(Field f) {
		f.open = true;
		ArrayList<Field> fields = fg.getNearbyFields(f);
		for(int i=0; i<fg.getNearbyFields(f).size(); i++) {
			// passes if the field isn't opened already
			if(!fields.get(i).open) {
				// passes if the field marked
				if (!fields.get(i).marked) {
					//the field is a mine
					if(fields.get(i).flag) {
						fields.get(i).open("B",new Color(255,0,0));
						fields.get(i).open = true;
					}
					//the field isn't a mine
					if(!fields.get(i).flag && fg.getNearbyMines(fields.get(i)).size()>0) {
						printMines(fields.get(i));
					}
					if(!fields.get(i).flag && fg.getNearbyMines(fields.get(i)).size()==0) {
						softOpenNearby(fields.get(i));
					}
				}
			}
		}
		printMines(f);
	}
}
