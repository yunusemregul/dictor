package dictor.query;

import dictor.query.commands.Command;
import dictor.query.commands.GET;
import dictor.query.commands.PING;
import dictor.query.commands.SET;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Objects;

public class CommandManager{

    private static final Logger LOG = LogManager.getLogger(CommandManager.class);
    private static HashMap<String, Command> commands;

    public CommandManager(){
        commands = new HashMap<>();

        try{
            addCommand(GET.class);
            addCommand(SET.class);
            addCommand(PING.class);
        } catch(Exception e){
            LOG.error("Exception creating default commands, exception is: ", e);
        }
    }

    private void addCommand(final Class<?> command) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException{
        Command commandInstance = (Command) command.getDeclaredConstructor().newInstance();
        commands.put(StringUtils.lowerCase(command.getSimpleName()), commandInstance);
        commands.put(StringUtils.upperCase(command.getSimpleName()), commandInstance);
    }

    public QueryResult execute(String query) {
        if (query.length() == 0) {
            return new QueryResult<>(null).withStatus(QueryResultStatus.NOK).withMessage("Query is empty!");
        }

        final String[] queryArgs = query.split(" ");
        final String commandName = queryArgs[0];
        final Command command = commands.get(commandName);

        if (Objects.nonNull(command)) {
            LOG.debug("Command {} called with args: {}", commandName, queryArgs);
            try {
                return command.execute(queryArgs);
            } catch (Exception e) {
                return new QueryResult<>(e).withStatus(QueryResultStatus.NOK).withMessage(e.getMessage());
            }
        } else {
            final String message = String.format("No command found with name: %s", commandName);
            LOG.error(message);
            return new QueryResult<>(null).withStatus(QueryResultStatus.NOK).withMessage(message);
        }
    }
}
