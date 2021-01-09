package cn.ylj.model;

import cn.ylj.entity.UserEntity;

import java.util.List;

/**
 * @author : yanglujian
 * create at:  2021/1/9  8:06 下午
 */
public class UserVO {
    List<UserEntity> users;

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}