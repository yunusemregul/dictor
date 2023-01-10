package dictor.validator;

public class MinimumNumberOfArgsValidator {
    public static void validate(String[] args, int minimumNumberOfArgs) {
        if (args.length < minimumNumberOfArgs) {
            throw new IllegalArgumentException("Minimum number of " + minimumNumberOfArgs + " arguments needed!");
        }
    }
}
