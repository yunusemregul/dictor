package dictor;

import dictor.query.CommandManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Objects;

public class Dictor{
    private final Logger LOG = LogManager.getLogger(Dictor.class);

    private static Dictor instance;

    private final CommandManager commandManager;

    private final HashMap<String, String> storage;

    public Dictor(){
        storage = new HashMap<>();
        commandManager = new CommandManager();

        LOG.info("Dictor initialized successfully!");
    }

    public static Dictor getInstance(){
        if (Objects.isNull(instance)) {
            instance = new Dictor();
        }

        return instance;
    }

    public static void setInstance(Dictor instance){
        Dictor.instance = instance;
    }

    public void executeQuery(String query) {
        commandManager.execute(query);
    }

    public String getValue(String key) {
        return storage.get(key);
    }

    public void putValue(String key, String value) {
        this.storage.put(key, value);
    }
}
