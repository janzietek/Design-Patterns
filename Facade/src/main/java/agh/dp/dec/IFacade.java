package agh.dp.dec;

import java.io.IOException;

public interface IFacade {
    public void init(String[] values);
    public void addNodes(String[] nodes) throws IOException;
    public void connectionsList();
    public void sendBroadcastMessage(String message);
}
