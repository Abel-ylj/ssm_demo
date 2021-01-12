package cn.ylj.entity;

import java.util.Date;

/**
 * @author : yanglujian
 * create at:  2021/1/12  6:21 下午
 */
public class OrderEntity {

    private Long id;

    //订购个数
    private Integer total;

    //外键uid
//    private Long uid;
    private UserEntity user;

    private Date ordertime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    @Override
    public String toString() {
        return "OrderEntity{" +
                "id=" + id +
                ", total=" + total +
                ", user=" + user +
                ", ordertime=" + ordertime +
                '}';
    }
}