import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final Logger LOG = LogManager.getLogger(Server.class);

    private static final int PORT = 4141;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;

        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            LOG.error(e);
            return;
        }

        while (true) {
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                LOG.error(e);
            }

            new ClientHandler(socket).start();
        }
    }
}