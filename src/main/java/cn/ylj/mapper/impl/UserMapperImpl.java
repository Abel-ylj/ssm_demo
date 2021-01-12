package cn.ylj.mapper.impl;

import cn.ylj.mapper.UserMapper;
import cn.ylj.entity.UserEntity;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author : yanglujian
 * create at:  2021/1/12  12:38 下午
 */
public class UserMapperImpl implements UserMapper {

    public List<UserEntity> selectAll() {
        //获取核心配置文件
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作
        List<UserEntity> users = sqlSession.selectList("userMapper.selectAll");
        //关闭
        sqlSession.close();
        return users;
    }

    public void insert(UserEntity user) {
        //获取核心配置文件
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取session工厂对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        //获取session
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行操作
        sqlSession.insert("cn.ylj.dao.UserMapper.insert",user);
        //mybatis默认不自动提交事务
        sqlSession.commit();
        //关闭
        sqlSession.close();
    }

    public UserEntity selectOneWithOrderByUid(Long id) {
        return null;
    }

}