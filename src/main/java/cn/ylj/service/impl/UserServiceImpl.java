package cn.ylj.service.impl;

import cn.ylj.entity.UserEntity;
import cn.ylj.mapper.IUserDao;
import cn.ylj.mapper.UserMapper;
import cn.ylj.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : yanglujian
 * create at:  2021/1/6  10:32 下午
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    //使用spring封装的jdbcTemplate访问数据库
    @Resource(name = "IUserDao")
    private IUserDao dao;

    @Resource
    private UserMapper userMapper;

    public void setDao(IUserDao userDao){
        this.dao = userDao;
    }

    public void init(){
        System.out.println("初始化方法");
    }

    public void destory(){
        System.out.println("销毁方法");
    }

    /**
     * 使用Mybatis框架访问数据库(主流)
     * 1.构建SessionFactory工厂类，
     * 2.通过工厂类获取sqlSession对象
     * 3.通过SqlSession给其sql指令(namespace.method)访问---不推荐
     * 4.通过SqlSession内置方法，给它接口类型(按照规范根据接口全限定名可以找到namespace 接口中的方法和配置的方法一一对应)，创建动态代理对象
     * 动态代理对象的方法就是全部的操作方法了
     * @return
     */
    public List<UserEntity> list() {
//        //获取核心配置文件
//        InputStream resourceAsStream = null;
//        try {
//            resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        //获取session工厂对象
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
//        //获取sqlSession
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        //获取代理对象(产生sqlSession的代理对象，用来代理UserMapper接口中的所有方法)
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //创建了单例的工具类，实际上这个过程可以自动化，
        //改进：启动时扫描mapper接口，自动创建mapper代理对象到IoC容器中，哪里需要注哪里
//        UserMapper userMapper = MybatisSessionFactoryUtils.getMapper(UserMapper.class);
//        List<UserEntity> userEntities = userMapper.selectAll();


        //Spring继承Mybatis后，在IoC容器初始化时，就按照配置完成了mapper代理对象(目标对象是sqlSession)的实例化，要用时注入就行
        List<UserEntity> userEntities = userMapper.selectAll();
        return userEntities;
    }


    //transaction示例,可以用注解，也可以使用配置xml
//    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void save(UserEntity user) {
        userMapper.insert(user);
        int i = 1/0;
        userMapper.insert(user);
    }
}