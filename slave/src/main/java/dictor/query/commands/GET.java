package dictor.query.commands;

import dictor.Dictor;
import dictor.query.Command;
import dictor.query.ResponseType;

import java.util.Objects;

public class GET extends Command {
    private final static int MINIMUM_NUMBER_OF_ARGUMENTS = 2;

    @Override
    public String execute(String[] args) {
        if (args.length < MINIMUM_NUMBER_OF_ARGUMENTS) {
            return ResponseType.ERROR + "Minimum number of " + MINIMUM_NUMBER_OF_ARGUMENTS + " arguments needed!";
        }

        String key = args[1];
        String result = Dictor.getInstance().getValue(key);

        if (Objects.isNull(result)) {
            return ResponseType.ERROR + String.format("No value found with key %s", key);
        }

        return ResponseType.TEXT + result;
    }
}
