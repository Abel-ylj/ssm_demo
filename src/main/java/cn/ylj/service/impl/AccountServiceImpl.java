package cn.ylj.service.impl;

import cn.ylj.mapper.IAccountDao;
import cn.ylj.entity.AccountEntity;
import cn.ylj.service.IAccountService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : yanglujian
 * create at:  2021/1/8  6:03 下午
 */
@Service
public class AccountServiceImpl implements IAccountService {

    @Resource
    private IAccountDao accountDao;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.REPEATABLE_READ, timeout = 100, rollbackFor = Exception.class)
    public void transfer(String outMan, String inMan, int money) {
        accountDao.out(outMan, money);
        int i = 1/0;
        accountDao.in(inMan, money);
    }

    public List selectAll() {
        List<AccountEntity> lst = accountDao.selectAll();
        accountDao.out("tom", 1);
        return lst;
    }
}