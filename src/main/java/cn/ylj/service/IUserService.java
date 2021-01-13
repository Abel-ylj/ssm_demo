package cn.ylj.service;

import cn.ylj.entity.UserEntity;

import java.util.List;

public interface IUserService {

    List<UserEntity> list();

    void save();
}
