package cn.ylj.service;

import java.util.List;

public interface IAccountService {

    void transfer(String outMan,String inMan, int money);

    List selectAll();
}
