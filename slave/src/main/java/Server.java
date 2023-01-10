import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
    private static final Logger LOG = LogManager.getLogger(Server.class);
    public final int port;
    private final ClientHandler[] clients;

    public Server(int maxClients, int port) {
        this.port = port;
        clients = new ClientHandler[maxClients];
    }


    @Override
    public void run() {
        ServerSocket serverSocket;

        try {
            serverSocket = new ServerSocket(port);

            while (true) {
                Socket socket = serverSocket.accept();
                boolean hasCreatedThread = false;

                for (int i = 0; i < this.clients.length; i++) {
                    if (clients[i] == null || !clients[i].isAlive()) {
                        clients[i] = new ClientHandler(socket);
                        clients[i].start();
                        hasCreatedThread = true;
                        break;
                    }
                }

                if (!hasCreatedThread) {
                    socket.close();
                }
            }
        } catch (IOException e) {
            LOG.error(e);
        }
    }
}
