package cn.ylj.dao;

import cn.ylj.entity.AccountEntity;

import java.util.List;

/**
 * @author : yanglujian
 * create at:  2021/1/8  5:55 下午
 */
public interface IAccountDao {

    void in(String inMan, int inMoney);

    void out(String outMan, int outMoney);

    List<AccountEntity> selectAll();
}