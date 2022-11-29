package agh.dp.dec.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class PeerThread extends Thread {
    private BufferedReader reader;
    private int port;
    private int localPort;
    private String localHostAddress = null;
    private String hostAddress = null;

    public PeerThread(Socket socket) throws IOException {
        this.localHostAddress = socket.getLocalAddress().getHostName();
        this.localPort = socket.getLocalPort();
        this.port = socket.getPort();
        this.hostAddress = socket.getInetAddress().getHostName();
        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public void run() {
        boolean flag = true;
        while (flag) {
            try {
                String message = this.reader.readLine();
                System.out.println(message);
            } catch (IOException e) {
                e.printStackTrace();
                flag = false;
                interrupt();
            }
        }
    }

    public int getPort() {
        return port;
    }

    public String getHostAddress() {
        return hostAddress;
    }

    @Override
    public String toString() {
        return this.localHostAddress + ":" + this.localPort;
    }
}
