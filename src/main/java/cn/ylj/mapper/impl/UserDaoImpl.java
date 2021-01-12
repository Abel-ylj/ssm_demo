package cn.ylj.mapper.impl;

import cn.ylj.mapper.IUserDao;
import org.springframework.stereotype.Repository;

/**
 * @author : yanglujian
 * create at:  2021/1/7  12:23 下午
 */
@Repository
public class UserDaoImpl implements IUserDao {
    public void save() {

        System.out.println("dao saving...");
    }

    public void hello() {
        System.out.println("hello hello..");
    }

    public void selectOne(int id) {
        String sql = "select * from user where id = ?";
    }
}