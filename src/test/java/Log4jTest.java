import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author : yanglujian
 * create at:  2021/1/13  2:52 下午
 */
public class Log4jTest {

    private static Logger logger = Logger.getLogger(Log4jTest.class);

    @Test
    public void logTest(){
        logger.info("测试日志");
    }
}