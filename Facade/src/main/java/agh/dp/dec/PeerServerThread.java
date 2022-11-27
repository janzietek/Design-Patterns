package agh.dp.dec;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class PeerServerThread extends Thread{
    private ServerThread serverThread;
    private Socket socket;
    private PrintWriter writer;

    public PeerServerThread(Socket socket, ServerThread serverThread) {
        this.serverThread = serverThread;
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            this.writer = new PrintWriter(socket.getOutputStream(), true);
            while (true) {
                serverThread.SendMessage(reader.readLine());
            }
        } catch (IOException e) {
            serverThread.getPeersServerThreads().remove(this);
        }
    }

    public PrintWriter getWriter() {
        return writer;
    }

    public String toString() {
        return socket.getInetAddress().getHostName() + ":" + socket.getPort();
    }
}
