package dictor.query.commands;

import dictor.Dictor;
import dictor.query.CommandManager;
import dictor.query.QueryResult;
import dictor.query.QueryResultStatus;
import dictor.validator.MinimumNumberOfArgsValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PUT extends Command{
    private static final Logger LOG = LogManager.getLogger(PUT.class);
    private final static int MINIMUM_NUMBER_OF_ARGUMENTS = 3;

    @Override
    public QueryResult execute(String[] args) {
        MinimumNumberOfArgsValidator.validate(args, MINIMUM_NUMBER_OF_ARGUMENTS);

        String key = args[1];
        String value = args[2];
        try {
            Dictor.getInstance().putValue(key, value);
            return new QueryResult<>(null).withStatus(QueryResultStatus.OK);
        } catch (Exception e) {
            LOG.error(e);
        }

        return new QueryResult<>(null).withStatus(QueryResultStatus.NOK);
    }
}
