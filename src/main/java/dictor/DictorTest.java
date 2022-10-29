package dictor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.Assert.assertTrue;

class DictorTest {
    final Dictor instance = Dictor.getInstance();

    @Test
    void executeQuery() {
        Assertions.assertEquals(instance.executeQuery("ping").getResult(), "PONG");
    }


    @Test
    void putGetValue() {
        final String name = "yunemregul";
        instance.executeQuery("set name " + name);
        Assertions.assertEquals(name, instance.executeQuery("get name").getResult());
    }
}