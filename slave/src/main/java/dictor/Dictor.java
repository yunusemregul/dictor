package dictor;

import dictor.query.CommandManager;
import dictor.store.DictorMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Dictor{
    private final Logger LOG = LogManager.getLogger(Dictor.class);

    private static Dictor instance;

    private final CommandManager commandManager;

    private final DictorMap storage;

    public Dictor(){
        storage = new DictorMap();
        commandManager = new CommandManager();

        LOG.info("Dictor initialized successfully!");
    }

    public static Dictor getInstance(){
        createInstance();

        return instance;
    }

    public static void createInstance() {
        if (instance == null) {
            instance = new Dictor();
        }
    }

    public String executeQuery(String query) {
        return commandManager.execute(query);
    }

    public String getValue(String key) {
        return storage.get(key);
    }

    public void putValue(String key, String value) {
        this.storage.put(key, value);
    }

    public boolean contains(String key) {
        return storage.containsKey(key);
    }

    public String delete(String key) {
        return storage.remove(key);
    }
}
