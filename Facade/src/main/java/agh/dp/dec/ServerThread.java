package agh.dp.dec;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.HashSet;
import java.util.Set;

public class ServerThread extends Thread{
    private String port = null;
    private ServerSocket serverSocket = null;
    private String hostName = null;
    private Set<PeerServerThread> peersServerThreads = new HashSet<>();

    public ServerThread(String port) throws IOException {
        this.port = port;
        this.serverSocket = new ServerSocket(Integer.parseInt(port));
        this.hostName = InetAddress.getLocalHost().getHostName();
    }

    public void run() {
        try {
            while (true) {
                PeerServerThread peerServerThread = new PeerServerThread(serverSocket.accept(), this);
                peersServerThreads.add(peerServerThread);
                peerServerThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
            peersServerThreads.forEach(Thread::stop);
        }
    }

    public void SendMessage(String message) {
        try {
            peersServerThreads.forEach(t -> t.getWriter().println(message));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Set<PeerServerThread> getPeersServerThreads() {
        return peersServerThreads;
    }

    public String toString() {
        return hostName + ":" + port;
    }
}
