package Sweeper.Ai;
import java.awt.Color;
import java.util.ArrayList;

import Sweeper.Graphics.*;
import Sweeper.Logic.*;

public class PuzzleSolver {
	
	static FieldGetter fg = new FieldGetter();
	static FieldLogic fl = new FieldLogic();
	static EventHelper eh = new EventHelper();
	
	public PuzzleSolver() {}
	
	public void runSolver() {
			for(int i=0 ; i<20; i++) {
			markFields();
			openFields();
		}
	}
	
	public void markFields () {
		ArrayList<Field> fields = fg.getAllFields();
		for(int i=0 ; i<fields.size(); i++) {
			mark1(fields.get(i));
		}
	}
	
	public void openFields () {
		ArrayList<Field> fields = fg.getAllFields();
		for(int i=0 ; i<fields.size(); i++) {
			open1(fields.get(i));
			eh.checkForEvents(null);
		}
	}
	
	public void mark1 (Field f) {
		ArrayList<Field> nearby = fg.getNearbyClosed(f);
		
		if((nearby.size())==fg.getNearbyMines(f).size() && f.open) {
			for(int i=0 ; i<nearby.size(); i++) {
//				System.out.println(nearby.size()+fg.getNearbyMarkers(f).size() + " " + i);
				if(!nearby.get(i).open && !nearby.get(i).marked) {
					nearby.get(i).open("",new Color(200,200,0));
					nearby.get(i).marked = true;

				}	
			}
		}
	}
	
	public void open1 (Field f) {
//		System.out.println("opening");
//		ArrayList<Field> closed = fg.getNearbyClosed(f);
		if(fg.getNearbyMarkers(f).size()==fg.getNearbyMines(f).size() && f.open) {
//			for(int i=0 ; i<closed.size(); i++) {
//				fl.printMines(closed.get(i));
//			}
			fl.softOpenNearby(f);
		}
	}
}
