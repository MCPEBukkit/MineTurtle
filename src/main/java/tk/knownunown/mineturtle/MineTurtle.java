package tk.knownunown.mineturtle;

import java.net.*;
/**
 * Created by andrew on 2/2/14.
 */
public class MineTurtle implements Runnable {

    public static void main(String args[]){
        (new Thread(new MineTurtle())).start();
    }

    public void run() {
        try{
        start();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void start() throws Exception{
        System.out.println("merp herp schmerp, mineturtle starting, blahblah");
        byte[] recvD = new byte[1024];
        byte[] sndD = new byte[1024];
            DatagramSocket socket = new DatagramSocket(19132);
            while(true){
                DatagramPacket recvPacket = new DatagramPacket(recvD, recvD.length);
                socket.receive(recvPacket);
                String data = new String(recvPacket.getData());
                InetAddress ip = recvPacket.getAddress();
                System.out.println("Recieved packet data " + data + " from IP Address " + ip.toString() + " with a length of " + recvPacket.getLength());
            }
    }

}

