import cn.ylj.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : yanglujian
 * create at:  2021/1/8  6:04 下午
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AccountTest {

    @Resource
    IAccountService accountService;

    @Test
    public void transferTest(){
        accountService.transfer("tom", "lucy", 10);
    }

    @Test
    public void selectAllTest(){
        List list = accountService.selectAll();
    }
}