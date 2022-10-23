package dictor.query.commands;

import dictor.Dictor;
import dictor.query.QueryResult;
import dictor.query.QueryResultStatus;
import dictor.validator.MinimumNumberOfArgsValidator;

import java.util.Objects;

public class GET extends Command{
    private final static int MINIMUM_NUMBER_OF_ARGUMENTS = 2;

    @Override
    public QueryResult execute(String[] args) {
        MinimumNumberOfArgsValidator.validate(args, MINIMUM_NUMBER_OF_ARGUMENTS);

        String key = args[1];
        String result = Dictor.getInstance().getValue(key);

        if (Objects.isNull(result)) {
            return new QueryResult<>(null).withStatus(QueryResultStatus.OK).withMessage(String.format("No value found with key %s", key));
        }

        return new QueryResult<>(result).withStatus(QueryResultStatus.OK);
    }
}
