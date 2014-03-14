package com.payton;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by the MineTurtle crew on 3/14/14.
 */
public class Loggy extends Thread {

    private static final Logger logger = Logger.getLogger("MineTurtle");

    public Loggy(){

    }

    public void run(){
        info("helloooo, world!");
    }

    public static void info(String message) {
        logger.info("[MineTurtle|INFO] " + message);
    }

    public static void debug(String message){
        logger.fine("[MineTurtle|DEBUG] " + message);
    }

    public static void error(String message){
        logger.log(Level.SEVERE, "[MineTurtle|ERROR] " + message);
    }
}
