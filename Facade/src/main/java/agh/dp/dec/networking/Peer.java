package agh.dp.dec.networking;

import agh.dp.dec.IFacade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

public class Peer implements IFacade {
    private String name;
    private ServerThread server = null;

    @Override
    public void init(String[] values) {
//        ServerThread server = null;
        try {
            name = values[0];
            server = new ServerThread(values[1]);
        } catch (IOException e) {
            System.out.println("Invalid entry");
        }
        server.start();
    }

    public boolean isAddressAvailable(int port) throws IllegalStateException {
        try (Socket ignored = new Socket("localhost", port)) {
            return false;
        } catch (ConnectException e) {
            return true;
        } catch (IOException e) {
            throw new IllegalStateException("Error while trying to check open port", e);
        }
    }

    @Override
    public void addNodes (String[] nodes) throws IOException {

        for (String node : nodes) {
//            String[] address = listener.split(":");
            Socket socket = null;
            try {
                if (!validatePeer(node)) {
                    socket = new Socket(InetAddress.getByName("localhost"), Integer.parseInt(node));
                    PeerThread peerThread = new PeerThread(socket);
                    peerThread.start();
                }
            } catch (Exception e) {
                if (socket != null) socket.close();
                else System.out.println("Invalid input");
            }
        }

    }


    private boolean validatePeer(String input) {
        boolean flag = false;
        Thread[] threads = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threads);
        ArrayList<String> peers = new ArrayList<>();

        for (Thread thread : threads) {
            if (thread instanceof PeerThread && !peers.contains(((PeerThread)thread).toString())) {
                peers.add(((PeerThread)thread).toString());
            }
            else if  (thread instanceof ServerThread && !peers.contains(((ServerThread)thread).toString())) {
                peers.add(((ServerThread)thread).toString());
            }
        }
        if (peers.contains(input)) flag = true;
        return flag;
    }

    @Override
    public void connectionsList() {
        Thread[] threads = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threads);
        ArrayList<PeerThread> peerThreads = new ArrayList<>();
        ArrayList<PeerServerThread> peerServerThreads = new ArrayList<>();
        ArrayList<ServerThread> serverThreads = new ArrayList<>();

        for (Thread thread : threads) {
            if (thread instanceof PeerThread) peerThreads.add((PeerThread) thread);
            else if (thread instanceof PeerServerThread) peerServerThreads.add((PeerServerThread) thread);
            else if (thread instanceof ServerThread) serverThreads.add((ServerThread) thread);
        }

        if (!peerThreads.isEmpty()) {
            System.out.println("Peer threads connected to ServerThread\n" +
                    "----------------------------------------------------");
            peerThreads.forEach(t -> System.out.println("PeerThread" + " | " + t.toString()));
        }
        else {
            System.out.println("This peer does not listen to any other peer");
        }

        if (!peerServerThreads.isEmpty()) {
            System.out.println("PeerServerThreads connected to PeerThreads" +
                    "----------------------------------------------------");
            peerServerThreads.forEach(t -> System.out.println("ServerThread" + " | " + t.toString()));
        }
        else {
            System.out.println("No other peer listens to messages from this peer");
        }
    }

    @Override
    public void sendBroadcastMessage(String message){
        server.SendMessage(name + ": " + message);
    }
}
