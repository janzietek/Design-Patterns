package agh.dp.dec;

import agh.dp.dec.networking.Peer;
import agh.dp.dec.networking.PeerThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class CmdChat {
    public static void main(String[] args) throws IOException {
        IFacade networking = new Peer();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("> Enter your <nick> and <port>");
        String[] values = reader.readLine().split(" ");
        networking.init(values);

        boolean flag = true;
        boolean menu = true;
        while (flag) {
            if (menu) {
                System.out.println("> You can now communicate, a:dd nodes, l:ist connections, e:xit");
                menu = false;
            }
            String command = reader.readLine();
            if (!command.equals(""))menu = true;
            switch (command) {
                case "a" -> {
                    System.out.println("> Enter ports of peers to listen messages from, s:kip");
                    String input = reader.readLine();
                    String[] nodes = input.split(" ");

                    if (!input.equals("s")) {
                        networking.addNodes(nodes);
                    }
                }
                case "l" -> networking.connectionsList();
                case "e" -> flag = false;
                default -> networking.sendBroadcastMessage(command);
            }
        }
        System.exit(0);
    }
}
