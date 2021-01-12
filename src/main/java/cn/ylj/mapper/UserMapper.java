package cn.ylj.mapper;

import cn.ylj.entity.UserEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<UserEntity> selectAll();

    void insert(UserEntity user);

    UserEntity selectOneWithOrderByUid(@Param("id") Long id);
}
