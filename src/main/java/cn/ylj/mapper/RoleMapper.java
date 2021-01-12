package cn.ylj.mapper;

import cn.ylj.entity.RoleEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {

    List<RoleEntity> selectOneWithUsersById(@Param("rid") Long rid);

}
