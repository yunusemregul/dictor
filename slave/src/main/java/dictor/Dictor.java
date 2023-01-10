package dictor;

import dictor.query.CommandManager;
import dictor.query.QueryResult;
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

    public QueryResult executeQuery(String query) {
        final long start = System.nanoTime();
        final QueryResult result = commandManager.execute(query);
        final long end = System.nanoTime();
        result.setExecutionTime(end-start);
        return result;
    }

    public String getValue(String key) {
        return storage.get(key);
    }

    public void putValue(String key, String value) {
        this.storage.put(key, value);
    }
}
