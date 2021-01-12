import cn.ylj.entity.OrderEntity;
import cn.ylj.mapper.OrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Mybatis多表操作
 * @author : yanglujian
 * create at:  2021/1/12  6:44 下午
 */
public class MybatisMutiTest {

    /**
     * 1:1 1个订单对象包含1个用户
     */
    @Test
    public void oneToOneTest() throws IOException {
        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取代理对象(产生sqlSession的代理对象，用来代理UserMapper接口中的所有方法)
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        OrderEntity order = orderMapper.selectOneByOid(1L);
        System.out.println(order);
        //关闭
        sqlSession.close();
    }
}