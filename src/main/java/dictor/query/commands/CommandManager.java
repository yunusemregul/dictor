package dictor.query.commands;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

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

    private void addCommand(Class command) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException{
        commands.put(command.getSimpleName(), (Command) command.getDeclaredConstructor().newInstance());
    }
}
