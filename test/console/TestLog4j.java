package console;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class TestLog4j {
    @Test
    public void log(){
        Log log = LogFactory.getLog(getClass());
        try {
            int a=0;
            int b=11/a;
        } catch (Exception ex) {
            log.debug("社会主义好宝宝");
            log.error(ex.getMessage());
            log.info(ex.getMessage());
            log.warn(ex.getMessage());
            log.fatal(ex.getMessage());
            ex.printStackTrace();
        }

    }
}
