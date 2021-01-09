package cn.ylj.service.impl;

import cn.ylj.dao.IUserDao;
import cn.ylj.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : yanglujian
 * create at:  2021/1/6  10:32 下午
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao dao;
    private int age;
    private String name;

    private List<String> stus;
    public List<String> getStus() {
        return stus;
    }
    public void setStus(List<String> stus) {
        this.stus = stus;
    }

    public void setDao(IUserDao userDao){
        this.dao = userDao;
    }

    public int getAge(){
        return this.age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public UserServiceImpl(){
        super();
        System.out.println("UserService被初始化了");
    }

    public void init(){
        System.out.println("初始化方法");
    }

    public void destory(){
        System.out.println("销毁方法");
    }

    public void save() {
        dao.save();
    }
}