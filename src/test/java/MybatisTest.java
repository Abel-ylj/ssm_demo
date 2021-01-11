import cn.ylj.entity.UserEntity;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author : yanglujian
 * create at:  2021/1/11  4:24 下午
 */
public class MybatisTest {

    /**
     * 删除
     */
    @Test
    public void delete() throws IOException {
        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作
        sqlSession.delete("userMapper.delete",4);
        //mybatis默认不自动提交事务
        sqlSession.commit();
        //关闭
        sqlSession.close();
    }

    /**
     * 修改
     */
    @Test
    public void update() throws IOException {
        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作
        UserEntity user = new UserEntity();
        user.setId(5);
        user.setUsername("杨养眼");
        user.setAddress("皇后大道");
        sqlSession.update("userMapper.update", user);
        //mybatis默认不自动提交事务
        sqlSession.commit();
        //关闭
        sqlSession.close();
    }

    /**
     * 插入
     * @throws IOException
     */
    @Test
    public void insertTest() throws IOException {
        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作
        UserEntity user = new UserEntity();
        user.setUsername("ceshi");
        user.setPassword("ceshi");
        user.setGender("男");
        user.setAge(19);
        user.setAddress("测试地址");
        user.setQq("123456");
        user.setEmail("123456@qq.com");
        sqlSession.insert("userMapper.insert",user);
        //mybatis默认不自动提交事务
        sqlSession.commit();
        //关闭
        sqlSession.close();
    }

    /**
     * 查询
     * @throws IOException
     */
    @Test
    public void test1() throws IOException {
        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作
        List<UserEntity> users = sqlSession.selectList("userMapper.selectAll");
        for (UserEntity user : users) {
            System.out.println(user);
        }
        //关闭
        sqlSession.close();
    }
}