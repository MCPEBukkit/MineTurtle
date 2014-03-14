package com.payton;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by the MineTurtle crew on 3/14/14.
 */
public class NetworkHandler extends Thread {

    private static DatagramSocket socket = null;

    public NetworkHandler(){
        try {
            this.socket = new DatagramSocket(19132);
        }catch (SocketException e){
            Loggy.error("aww, we were unable to create the socket :(");
            e.printStackTrace();
        }
        Loggy.info("MineTurtle networking initalized.");
    }

    public void run(){
        while (Main.isStarted){
            byte buffer[] = new byte[1024];
            DatagramPacket p = new DatagramPacket(buffer, buffer.length);
            try {
                socket.receive(p);
            }catch (IOException e){
                Loggy.error("aww, bad luck. IOException?!");
                e.printStackTrace();
            }finally {
                String hexs = Integer.toHexString(0xFF & p.getData()[0]);
                int type = (int) Long.parseLong(hexs, 16);
                Loggy.info("yayz, received packet " + type + "with length of " + p.getLength());
                handlePacket(p, type);
            }
        }
    }

    private void handlePacket(DatagramPacket packet, int type) {
        switch (type){
            case PacketTypes.UNCONNECTED_PING:
            case PacketTypes.UNCONNECTED_PING_OPEN_CONNECTIONS:
                break;
        }
    }
}
