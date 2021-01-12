import cn.ylj.dao.UserMapper;
import cn.ylj.dao.impl.UserMapperImpl;
import cn.ylj.entity.UserEntity;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author : yanglujian
 * create at:  2021/1/11  4:24 下午
 */
public class MybatisTest {

    @Test
    public void pageHelperTest(){
        //获取核心配置文件
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        PageHelper.startPage(2, 5);
        List<UserEntity> users = userMapper.selectAll();
        for (UserEntity user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void TypeHandlerInsertTest(){
        //获取核心配置文件
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取代理对象(产生sqlSession的代理对象，用来代理UserMapper接口中的所有方法)
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        UserEntity user = new UserEntity();
//        user.setUsername("ceshi100");
//        user.setAddress("ceshi100");
//        user.setCreateAt(new Date());
        Date now = new Date();
        for (int i = 0; i < 100; i++) {
            user.setUsername("ceshi100" + i);
            user.setAddress("ceshi100" + i);
            user.setCreateAt(now);
            userMapper.insert(user);
        }
        //关闭
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void typeHandlerInsertTest1(){
        UserMapper userMapper = new UserMapperImpl();
        UserEntity user = new UserEntity();
        user.setUsername("ceshi999");
        user.setAddress("ceshi999");
        user.setCreateAt(new Date());
        userMapper.insert(user);
    }

    /**
     * 查询（代理）
     * @throws IOException
     */
    @Test
    public void findAll() throws IOException {
        //获取核心配置文件
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取代理对象(产生sqlSession的代理对象，用来代理UserMapper接口中的所有方法)
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<UserEntity> users = userMapper.selectAll();
        for (UserEntity user : users) {
            System.out.println(user);
        }
        //关闭
        sqlSession.close();
    }


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
        sqlSession.delete("userMapper.delete",1);
        //mybatis默认不自动提交事务
        sqlSession.commit();
        //回滚
        //sqlSession.rollback();
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
        sqlSession.insert("cn.ylj.dao.UserMapper.insert",user);
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