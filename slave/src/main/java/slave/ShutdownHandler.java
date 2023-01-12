package slave;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShutdownHandler extends Thread {
    private static final Logger LOG = LogManager.getLogger(ShutdownHandler.class);

    public void run() {
        LOG.info("Server is shutting down!");
    }
}
