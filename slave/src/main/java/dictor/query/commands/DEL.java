package dictor.query.commands;

import dictor.Dictor;
import dictor.query.Command;
import dictor.query.ResponseType;

public class DEL extends Command {
    private final static int MINIMUM_NUMBER_OF_ARGUMENTS = 2;

    @Override
    public String execute(String[] args) {
        if (args.length < MINIMUM_NUMBER_OF_ARGUMENTS) {
            return ResponseType.ERROR + "Minimum number of " + MINIMUM_NUMBER_OF_ARGUMENTS + " arguments needed!";
        }

        int deletedCount = 0;

        for (int i = 1; i < args.length; i++) {
            if (Dictor.getInstance().delete(args[1]) != null) {
                deletedCount += 1;
            }
        }

        return ResponseType.INTEGER.toString() + deletedCount;
    }
}
