package dictor.query;

import dictor.query.commands.Command;
import dictor.query.commands.GET;
import dictor.query.commands.PUT;
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
            addCommand(PUT.class);
        } catch(Exception e){
            LOG.error("Exception creating default commands, exception is: ", e);
        }
    }

    private void addCommand(final Class<?> command) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException{
        commands.put(command.getSimpleName(), (Command) command.getDeclaredConstructor().newInstance());
    }

    public QueryResult execute(String query) {
        if (StringUtils.isBlank(query)) {
            throw new IllegalArgumentException("Query is empty!");
        }

        final String[] queryArgs = query.split(" ");
        final String commandName = StringUtils.upperCase(queryArgs[0]);
        final Command command = commands.get(commandName);

        if (Objects.nonNull(command)) {
            LOG.info("Command {} called with args: {}", commandName, queryArgs);
            try {
                return command.execute(queryArgs);
            } catch (Exception e) {
                return new QueryResult<>(e).withStatus(QueryResultStatus.NOK).withMessage(e.getMessage());
            }
        } else {
            LOG.error("No command found with name: {}", commandName);
        }

        return null;
    }
}
