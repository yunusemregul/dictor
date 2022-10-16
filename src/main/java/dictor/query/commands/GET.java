package dictor.query.commands;

public class GET extends Command{
    private final static int MINIMUM_NUMBER_OF_ARGUMENTS = 2;

    @Override
    public void execute(String[] args) {
        if (args.length < MINIMUM_NUMBER_OF_ARGUMENTS) {
            throw new IllegalArgumentException("Minimum number of " + MINIMUM_NUMBER_OF_ARGUMENTS + " arguments needed!");
        }

    }
}
