package cn.ylj.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author : yanglujian
 * create at:  2021/1/13  11:50 上午
 */
public class MybatisSessionFactoryUtils {

    static{
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取session工厂对象
        MybatisSessionFactoryUtils.sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
    }

    private static SqlSessionFactory sqlSessionFactory;

    public static void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        MybatisSessionFactoryUtils.sqlSessionFactory = sqlSessionFactory;
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        if (sqlSessionFactory != null){
            return sqlSessionFactory;
        }
        return null;
    }

    public static <T> T getMapper(Class<T> clz){
        //创建该mapper的代理对象
        T mapper = sqlSessionFactory.openSession().getMapper(clz);
        return mapper;
    }
}