package dictor.query.commands;

import dictor.query.QueryResult;
import dictor.query.QueryResultStatus;

public class PING extends Command{
    @Override
    public QueryResult execute(String[] args) {
        return new QueryResult("PONG").withStatus(QueryResultStatus.OK);
    }
}
