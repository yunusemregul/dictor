package dictor.query.commands;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class CommandFactory{
    private static HashMap<String, Command> commands;

    public CommandFactory(){
        commands = new HashMap<>();

        try{
            addCommand(Get.class);
            addCommand(Put.class);
        } catch(Exception e) {

        }
    }

    private void addCommand(Class command) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException{
        commands.put(command.getName(), (Command) command.getDeclaredConstructor().newInstance());
    }
}
