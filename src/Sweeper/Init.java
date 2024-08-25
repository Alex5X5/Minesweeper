package Sweeper;

//import Sweeper.Graphics.ChooseDifficulty;
import Sweeper.Graphics.Frame;
import SimpleLogging.Logging.*;

public class Init {
	public static void main(String[] args) {
		Logging.setStartTime();
		@SuppressWarnings("unused")
		Frame f = new Frame();
		Logging.disableDebug();
		Logging.buildLogMessage(new LoggingLevel("Init"), new ActionMessage("starting"));
	}
}
