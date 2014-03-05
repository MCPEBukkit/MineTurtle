package tk.knownunown.mineturtle.networking;

import java.net.*;
import java.io.*;
import tk.knownunown.mineturtle.Loggy;
import tk.knownunown.mineturtle.MineTurtle;
import tk.knownunown.mineturtle.networking.packet.PacketTypes;

/**
 * Created by andrew on 3/1/14.
 */
public class NetworkHandler extends Thread {

    private static DatagramSocket socket = null;

    public NetworkHandler(){
        try{
            this.socket = new DatagramSocket(19132);
        } catch(SocketException e){
            Loggy.error("aww, we were unable to create the socket :(");
            e.printStackTrace();
        }
        Loggy.info("MineTurtle networking initialized.");
    }

    public void run() {
        while(MineTurtle.isStarted){
            byte buffer[] = new byte[1024];
            DatagramPacket p = new DatagramPacket(buffer, buffer.length);
            try {
                socket.receive(p);
            } catch(IOException e){
                Loggy.error("aww, bad luck. IOException?!");
                e.printStackTrace();
            } finally {
                String hexs = Integer.toHexString(0xFF & p.getData()[0]);
                int type = (int) Long.parseLong(hexs, 16);
                Loggy.info("yayz, recieved packet " + type + " with a length of " + p.getLength());
                //TODO: add a switch statement here to parse packets. (whoops fixed with handlePacket)
                handlePacket(p, type);
            }
        }
    }

    public void handlePacket(DatagramPacket packet, int type){
        switch(type){ //hah! Tricked you, IntelliJ!
            case PacketTypes.UNCONNECTED_PING:
            case PacketTypes.UNCONNECTED_PING_OPEN_CONNECTIONS:
                break;
        }
    }
}
