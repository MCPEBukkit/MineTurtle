package tk.knownunown.mineturtle;

import java.util.logging.*;
/**
 * Created by andrew on 3/1/14.
 */
public class Loggy extends Thread {

    private static final Logger logger = Logger.getLogger("MineTurtle");

    public Loggy(){

    }

    public void run(){
        info("helloooo, world!");
    }

    public static void info(String message){
        logger.info("[MineTurtle|INFO] " + message);
    }

    public static void debug(String message){
        logger.fine("[MineTurtle|DEBUG] " + message);
    }

    public static void error(String message){
        logger.log(Level.SEVERE, "[MineTurtle|ERROR] " + message);
    }
}
