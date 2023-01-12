package dictor;

import dictor.query.ResponseType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DictorTest {
    final Dictor instance = Dictor.getInstance();

    @Test
    void executeQuery() {
        Assertions.assertEquals(instance.executeQuery("ping"), ResponseType.TEXT + "PONG");
    }


    @Test
    void putGetValue() {
        final String name = "yunemregul";
        instance.executeQuery("set name " + name);
        Assertions.assertEquals(ResponseType.TEXT + name, instance.executeQuery("get name"));
    }
}