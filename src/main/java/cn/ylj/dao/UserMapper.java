package cn.ylj.dao;

import cn.ylj.entity.UserEntity;

import java.util.List;

public interface UserMapper {

    List<UserEntity> selectAll();

    void insert(UserEntity user);
}
