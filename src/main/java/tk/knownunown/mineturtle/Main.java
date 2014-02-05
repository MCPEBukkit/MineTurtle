package tk.knownunown.mineturtle;

import java.util.logging.*;

/**
 * Created by andrew on 2/3/14.
 */
public class Main implements Runnable {

    public static void main(String args[]){
        (new Thread(new Main())).start();
    }

    public void run(){
        System.out.println("MineTurtle starting.");

    }
}
