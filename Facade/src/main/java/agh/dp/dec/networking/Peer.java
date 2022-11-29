package agh.dp.dec.networking;

import agh.dp.dec.IFacade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.util.ArrayList;

public class Peer implements IFacade {
    public static void main(String[] args) {
        boolean wait = true;
        Peer peer = new Peer();
        while (wait) {
            try {
                peer.handleInput();
                wait = false;
            } catch (IOException e) {
                System.out.println("Invalid entry");
            }
        }
    }

    private void handleInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("> Enter your <nick> and <port>");
        String[] values = reader.readLine().split(" ");
        ServerThread server = new ServerThread(values[1]);
        server.start();
        //new Peer().addListeners(reader, values[0], server);
    }

    private void addListeners (BufferedReader bufferedReader, String nick, ServerThread serverThread) throws IOException {
        System.out.println("> Enter computername:port peers to exchange messages from, s:kip");
        String input = bufferedReader.readLine();

        String[] values = input.split(" ");
        if (!input.equals("s")) {
            for (String peer : values) {
                String[] address = input.split(":");
                Socket socket = null;
                try {
                    if (!validatePeer(peer)) {
                        socket = new Socket(InetAddress.getByName(address[0]), Integer.parseInt(address[1]));
                        PeerThread peerThread = new PeerThread(socket);
                        peerThread.start();
                    }
                } catch (Exception e) {
                    if (socket != null) socket.close();
                    else System.out.println("Invalid input");
                }
            }
        }
        //StartChat(bufferedReader, nick, serverThread);
    }

    private void StartChat(BufferedReader bufferedReader, String nick, ServerThread serverThread) {
        try {
            System.out.println("> You can now communicate, a:dd listener, l:ist connections, e:xit");
            boolean flag = true;
            while (flag) {
                String command = bufferedReader.readLine();
                switch (command) {
                    case "a" -> addListeners(bufferedReader, nick, serverThread);
                    case "l" -> list();
                    case "e" -> flag = false;
                    default -> serverThread.SendMessage(command);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    private boolean validatePeer(String input) {
        boolean flag = false;
        Thread[] threads = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threads);
        ArrayList<String> peers = new ArrayList<>();

        for (Thread thread : threads) {
            if (thread instanceof PeerThread && !peers.contains(((PeerThread)thread).toString())) {
                peers.add(((PeerThread)thread).getHostAddress() + ":" + ((PeerThread)thread).getPort());
            }
            else if  (thread instanceof ServerThread && !peers.contains(((ServerThread)thread).toString())) {
                peers.add(((ServerThread)thread).toString());
            }
        }
        if (peers.contains(input)) flag = true;
        return flag;
    }

    private void list() {
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
}
