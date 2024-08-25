package Sweeper.Logic;

import java.util.ArrayList;
import java.util.Random;

import Sweeper.Graphics.Field;
import Sweeper.Graphics.Panel;

public class Randomizer {
	
	static Random random = new Random();
	static FieldGetter fg = new FieldGetter();
	
	public void randomizeBombs(Field f) {
		int i = 0;
		while(i <= Panel.numberOfMines) {			
			int a = random.nextInt(0, Panel.arrayWidh);
			int b = random.nextInt(0, Panel.arrayHeight);
			if (ensureNotNearby(f,Panel.fields[a][b]) && f!=Panel.fields[a][b]){
				Panel.fields[a][b].flag = true;
				i++;
			}
		}
		System.out.println("Randomizer finished");
	}
	
	public boolean ensureNotNearby(Field source, Field check) {
		boolean back = true;
		ArrayList<Field> fields = fg.getNearbyFields(source);
		
		if(fields.contains(check)) {
			back = false;
		}
		return back;
	}
}
