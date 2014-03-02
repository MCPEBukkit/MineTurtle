package tk.knownunown.mineturtle;
import tk.knownunown.mineturtle.networking.NetworkHandler;
/**
 * Created by andrew on 3/1/14.
 */
public class MineTurtle implements Runnable {

    public static boolean isStarted = false;
    public static final Loggy loggy = new Loggy();

    public static void main(String args[]){
        (new Thread(new MineTurtle())).start();
        loggy.start();
    }

    public void run(){
        this.isStarted = true;
        loggy.info("Starting MineTurtle.");
        (new NetworkHandler()).start();
    }
}
