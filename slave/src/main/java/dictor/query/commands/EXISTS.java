package dictor.query.commands;

import dictor.Dictor;
import dictor.query.Command;
import dictor.query.ResponseType;

public class EXISTS extends Command {
    private final static int MINIMUM_NUMBER_OF_ARGUMENTS = 2;

    @Override
    public String execute(String[] args) {
        if (args.length < MINIMUM_NUMBER_OF_ARGUMENTS) {
            return ResponseType.ERROR + "Minimum number of " + MINIMUM_NUMBER_OF_ARGUMENTS + " arguments needed!";
        }

        return ResponseType.INTEGER + (Dictor.getInstance().contains(args[1]) ? "1" : "0");
    }
}
