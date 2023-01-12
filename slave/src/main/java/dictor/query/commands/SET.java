package dictor.query.commands;

import dictor.Dictor;
import dictor.query.Command;
import dictor.query.ResponseType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SET extends Command {
    private static final Logger LOG = LogManager.getLogger(SET.class);
    private final static int MINIMUM_NUMBER_OF_ARGUMENTS = 3;

    @Override
    public String execute(String[] args) {
        if (args.length < MINIMUM_NUMBER_OF_ARGUMENTS) {
            return ResponseType.ERROR + "Minimum number of " + MINIMUM_NUMBER_OF_ARGUMENTS + " arguments needed!";
        }

        String key = args[1];
        String value = args[2];

        try {
            Dictor.getInstance().putValue(key, value);
            return ResponseType.TEXT + "OK";
        } catch (Exception e) {
            return ResponseType.ERROR + e.getMessage();
        }
    }
}
