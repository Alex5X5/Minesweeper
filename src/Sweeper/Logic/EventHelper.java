package Sweeper.Logic;

import java.awt.event.KeyEvent;

import Sweeper.Ai.PuzzleSolver;
import Sweeper.Graphics.Field;
import Sweeper.Graphics.Panel;
import SimpleLogging.Logging.*;

public class EventHelper {
	
	Randomizer r = new Randomizer();
	FieldGetter fg = new FieldGetter();
	PuzzleSolver ps = new PuzzleSolver();
	LoggingLevel mLvl = new LoggingLevel("EventHelper");
	
	public void checkForEvents(Field f) {
		Logging.buildDebugMessage(mLvl,new ActionMessage("checking for events"));
		refreshScoreValue();
		if(!Panel.started) {
			r.randomizeBombs(f);
			Panel.started = true;
		}
	}
	
	public void refreshScoreValue() {
		int total = Panel.numberOfMines;
		int marked = 0;
		int delta;
		for (int x = 0; x < Panel.arrayHeight; x++) {
			for (int y = 0; y < Panel.arrayHeight; y++) {
				if(Panel.fields[x][y].marked) {
					marked++;
				}
			}
		}
		delta = total - marked;
		Panel.score.setText(String.valueOf(delta));
	}
	
	public void castSolver(KeyEvent e) {
		Logging.buildDebugMessage(mLvl,new ActionMessage("starting solver"));
		if(e.getKeyCode() == KeyEvent.VK_1) {
			ps.markFields();
		}
		if(e.getKeyCode() == KeyEvent.VK_2) {
			ps.openFields();
		}
		if(e.getKeyCode() == KeyEvent.VK_3) {
			ps.runSolver();
		}
	}
}
