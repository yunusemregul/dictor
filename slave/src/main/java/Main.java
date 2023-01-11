import dictor.Dictor;
import slave.Server;

public class Main {
    public static final int MAX_CLIENTS = 1;
    public static final int PORT = 4141;

    public static void main(String[] args) {
        Dictor.createInstance();

        Server server = new Server(MAX_CLIENTS, PORT);
        server.start();
    }
}