import dictor.Dictor;
import dictor.query.QueryResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

public class Main{
    private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args){
        Dictor dictor = Dictor.getInstance();
        Scanner input = new Scanner(System.in);

        while(true) {
            String query = input.nextLine();

            QueryResult result = dictor.executeQuery(query);

            LOG.info("Query resulted with {} ({}ms), result is: {}", result.getStatus(), result.getExecutionTime()/1000, result.getResult());
        }
    }
}