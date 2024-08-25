package Sweeper.Logic;

import java.util.ArrayList;

import SimpleLogging.Logging.*;
import Sweeper.Graphics.Field;
import Sweeper.Graphics.Panel;

public class FieldGetter {
	
	private static LoggingLevel mLvl = new LoggingLevel("FieldGetter");
	
	public FieldGetter() {}
	
	public ArrayList<Field> getAllFields() {
		Logging.buildDebugMessage(mLvl, new ActionMessage("getting all fields"));
		ArrayList<Field> f = new ArrayList<>();
		for (int a = 0; a < Panel.arrayWidh; a++) {
			for (int b = 0; b < Panel.arrayHeight; b++) {
				f.add(Panel.fields[a][b]);
			}			
		}
		return f;		
	}

	public ArrayList<Field> getNearbyMines(Field f) {
		Logging.buildDebugMessage(mLvl, new ActionMessage("getting nearby mines"));
			ArrayList<Field> fields = getNearbyFields(f);
			ArrayList<Field> back = new ArrayList<Field>();
			for(int i=0; i<fields.size(); i++) {			
				if(fields.get(i).flag) {
					back.add(fields.get(i));
				}
			}
			return back;
		}
		
	public ArrayList<Field> getNearbyMarkers(Field f) {
		Logging.buildDebugMessage(mLvl, new ActionMessage("getting nearby markers"));
		ArrayList<Field> fields = getNearbyFields(f);
		ArrayList<Field> back = new ArrayList<Field>();
		for(int i=0; i<fields.size(); i++) {
			if(fields.get(i).marked) {
				back.add(fields.get(i));
			}
		}
		return back;
	}
	
	public ArrayList<Field> getNearbyClosed(Field f){
		Logging.buildDebugMessage(mLvl, new ActionMessage("getting nearby closed fields"));
		ArrayList<Field> fields = getNearbyFields(f);
		ArrayList<Field> back = new ArrayList<Field>();
		for(int i=0; i<fields.size(); i++) {
			if(!fields.get(i).open) {
				back.add(fields.get(i));
			}
		}
		return back;
	}
	
	public ArrayList<Field> getNearbyOpen(Field f){
		Logging.buildDebugMessage(mLvl, new ActionMessage("getting nearrby open fields"));
		ArrayList<Field> fields = getNearbyFields(f);
		ArrayList<Field> back = new ArrayList<Field>();
		for(int i=0; i<fields.size(); i++) {
			if(!fields.get(i).open) {
				back.add(fields.get(i));
			}
		}
		return back;
	}
	
	public ArrayList<Field> getNearbyFields(Field f) {
		//detects whether fields around a given field are outside the play field matrix
		//returns a list with the fields that are not outside the play field
		
		@SuppressWarnings("serial")
		ArrayList<Field> nearby = new ArrayList<Field>() {};
		
		if(f.arrayA != 0 && f.arrayB != 0) {
			nearby.add(Panel.fields[f.arrayA-1][f.arrayB-1]); //top left Field
//			System.out.println("top left can be tested");
		}
		if(f.arrayB != 0) {
			nearby.add(Panel.fields[f.arrayA][f.arrayB-1]); //top middle Field
//			System.out.println("top middle can be tested");
		}
		if(f.arrayA != Panel.arrayWidh-1 && f.arrayB != 0) {
			nearby.add(Panel.fields[f.arrayA+1][f.arrayB-1]); // top right Field
//			System.out.println("top right can be tested");
		}
		if(f.arrayA != 0) {
			nearby.add(Panel.fields[f.arrayA-1][f.arrayB]); // middle left Field
//			System.out.println("middle left can be tested");
		}
		if(f.arrayA != Panel.arrayWidh-1 ) {
			nearby.add(Panel.fields[f.arrayA+1][f.arrayB]); // middle right Field
//			System.out.println("middle right can be tested");
		}
		if(f.arrayA != 0 && f.arrayB != Panel.arrayHeight-1) {
			nearby.add(Panel.fields[f.arrayA-1][f.arrayB+1]); //bottom left Field
//			System.out.println("bottom left can be tested");
		}
		if(f.arrayB != Panel.arrayHeight-1) {
			nearby.add(Panel.fields[f.arrayA][f.arrayB+1]); //bottom middle Field
//			System.out.println("bottom middle can be tested");
		}
		if(f.arrayA != Panel.arrayWidh-1 && f.arrayB != Panel.arrayHeight-1) {
			nearby.add(Panel.fields[f.arrayA+1][f.arrayB+1]); // bottom right Field
//			System.out.println("bottom right can be tested");
		}
//		System.out.println("returned List");
		return nearby;
	}
	
}
