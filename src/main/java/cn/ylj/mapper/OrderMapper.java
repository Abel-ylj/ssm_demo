package cn.ylj.mapper;

import cn.ylj.entity.OrderEntity;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {

    OrderEntity selectOneByOid(@Param("id") Long id);
}
