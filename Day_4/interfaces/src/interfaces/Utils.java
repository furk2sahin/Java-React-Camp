package interfaces;

public class Utils {
	public static void runLoggers(Logger[] loggers ,String message) { // static bellekte newleyip referans verir
		 for(Logger logger : loggers) {
			   logger.log(message);
		 }
	}
}
