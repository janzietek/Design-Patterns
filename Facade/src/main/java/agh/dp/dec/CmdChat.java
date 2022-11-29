package agh.dp.dec;

import agh.dp.dec.networking.Peer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CmdChat {
    public static void main(String[] args) throws IOException {
        IFacade networking = new Peer();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("> Enter your <nick> and <port>");
        String[] values = reader.readLine().split(" ");
        networking.init();

        System.out.println("> You can now communicate, a:dd listener, l:ist connections, e:xit");

        boolean flag = true;
        while (flag) {
            String command = reader.readLine();
            switch (command) {
                case "a" -> addListeners(port);
                case "l" -> list();
                case "e" -> flag = false;
                default -> serverThread.SendMessage(command);
            }
        }
    }
}
