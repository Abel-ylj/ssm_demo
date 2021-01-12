package cn.ylj.entity;

import java.util.List;

/**
 * @author : yanglujian
 * create at:  2021/1/12  7:43 下午
 */
public class RoleEntity {

    private Long id;

    private String rolename;

    private List<UserEntity> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}