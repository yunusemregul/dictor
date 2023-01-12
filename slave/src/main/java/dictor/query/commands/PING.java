package dictor.query.commands;

import dictor.query.Command;
import dictor.query.ResponseType;

public class PING extends Command {
    @Override
    public String execute(String[] args) {
        return ResponseType.TEXT + "PONG";
    }
}
