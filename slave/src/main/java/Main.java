import dictor.Dictor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import slave.Server;
import slave.ShutdownHandler;

public class Main {
    private static final Logger LOG = LogManager.getLogger(Main.class);
    public static final int MAX_CLIENTS = 1;
    public static final int PORT = 4141;

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new ShutdownHandler());
        Dictor.createInstance();

        Server server = new Server(MAX_CLIENTS, PORT);
        server.start();
    }
}