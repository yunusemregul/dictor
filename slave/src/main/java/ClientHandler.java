import dictor.Dictor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.Socket;

public class ClientHandler extends Thread {
    private static final Logger LOG = LogManager.getLogger(ClientHandler.class);
    private final Socket socket;
    private final Dictor dictor;

    public ClientHandler(Socket socket) {
        this.socket = socket;
        this.dictor = Dictor.getInstance();
    }

    public void run() {
        LOG.info("Thread with id {} started!", this.getId());

        InputStream inputStream;
        BufferedReader reader;
        DataOutputStream outputStream;

        try {
            inputStream = socket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream));
            outputStream = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            return;
        }

        String line;

        while (true) {
            try {
                line = reader.readLine();

                if ((line == null) || line.equalsIgnoreCase("QUIT")) {
                    socket.close();
                    break;
                } else {
                    outputStream.writeBytes(dictor.executeQuery(line) + "\n\r");
                    outputStream.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }

        LOG.info("Thread with id {} died!", this.getId());
    }
}
