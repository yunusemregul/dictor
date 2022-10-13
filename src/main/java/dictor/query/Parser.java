package dictor.query;

import org.apache.commons.lang3.StringUtils;

public class Parser{

    public Parser(){
    }

    public void parse(String query) {
        if (StringUtils.isBlank(query)) {
            throw new IllegalArgumentException("Query is empty!");
        }

        final String[] queryArgs = query.split(" ");
    }
}
