package com.payton;

public class Main implements Runnable {

    public static boolean isStarted = false;
    public static final Loggy loggy = new Loggy();

    public static void main(String[] args) {
        (new Thread(new Main())).start();
        loggy.start();
    }

    public void run(){
        this.isStarted = true;
        loggy.info("Starting MineTurtle.");
        (new NetworkHandler()).start();
    }
}
