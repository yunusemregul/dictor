package dictor;

import dictor.query.Parser;

import java.util.Objects;

public class Dictor{
    private static Dictor instance;

    private final Parser queryParser;

    public Dictor(){
        queryParser = new Parser();
    }

    public static Dictor getInstance(){
        if (Objects.isNull(instance)) {
            instance = new Dictor();
        }

        return instance;
    }

    public static void setInstance(Dictor instance){
        Dictor.instance = instance;
    }

    public void executeQuery(String query) {
        queryParser.parse(query);
    }
}
