package cn.ylj.dao.impl;

import cn.ylj.dao.IAccountDao;
import cn.ylj.entity.AccountEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : yanglujian
 * create at:  2021/1/8  5:57 下午
 */
@Repository
public class AccountDaoImpl implements IAccountDao {

//    @Resource
//    private JdbcTemplate jdbcTemplate;

    public void in(String inMan, int inMoney) {
//        String sql = "update account set money = money + ? where user = ?";
//        jdbcTemplate.update(sql, inMoney, inMan);
    }

    public void out(String outMan, int outMoney) {
//        String sql = "update account set money = money - ? where user = ?";
//        jdbcTemplate.update(sql, outMoney, outMan);
    }

    public List<AccountEntity> selectAll() {
//        String sql = "select * from account";
//        List<AccountEntity> lst = jdbcTemplate.query(sql, new BeanPropertyRowMapper<AccountEntity>(AccountEntity.class));
//        return lst;
        return null;
    }
}