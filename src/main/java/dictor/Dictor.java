package dictor;

import dictor.query.Parser;
import dictor.query.commands.CommandManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Dictor{
    private final Logger LOG = LogManager.getLogger(Dictor.class);

    private static Dictor instance;

    private final CommandManager commandManager;
    private final Parser queryParser;

    public Dictor(){
        queryParser = new Parser();
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
        queryParser.parse(query);
    }
}
