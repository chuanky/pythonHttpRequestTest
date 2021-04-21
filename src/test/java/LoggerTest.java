import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {
    @Test
    public void loggerInit() {
        Logger logger = LoggerFactory.getLogger("Test");
        logger.debug("Hello");
        logger.error("This is an error");
    }
}
