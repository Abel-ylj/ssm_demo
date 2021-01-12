package cn.ylj.proxy;

import cn.ylj.mapper.IUserDao;
import cn.ylj.mapper.impl.UserDaoImpl;

/**
 * 静态代理
 */
public class UserDaoProxy implements IUserDao{

    //持有被代理对象
    private IUserDao userDao;

    //持有通知类方法
    private Advice advice;

    //手写了一个带参构造后，默认无参构造会被屏蔽
    public UserDaoProxy(IUserDao userDao, Advice advice){
        this.userDao = userDao;
        this.advice = advice;
    }

    /****
     * 增强目标方法
     */
    public void save() {
        advice.preMethod();
        userDao.save();
        advice.postMethod();
    }

    public void hello() {

    }

    public void selectOne(int id) {

    }

    public static void main(String[] args) {
        UserDaoProxy userDaoProxy = new UserDaoProxy(new UserDaoImpl(), new Advice());
        userDaoProxy.save();
    }
}