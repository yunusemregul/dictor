package dictor.query.commands;

import dictor.query.QueryResult;

public abstract class Command{
    public abstract QueryResult execute(String[] args);
}
