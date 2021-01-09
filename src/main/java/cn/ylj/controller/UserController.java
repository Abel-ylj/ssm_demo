package cn.ylj.controller;

import cn.ylj.entity.UserEntity;
import cn.ylj.model.UserVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author : yanglujian
 * create at:  2021/1/9  1:56 下午
 */
@Controller
public class UserController {

    @RequestMapping("/quick6")
    @ResponseBody
    public void userSave6(@RequestBody List<UserEntity> users)  {
        for (Object user : users) {
            System.out.println(user);
        }
    }

    @RequestMapping("/quick5")
    @ResponseBody
    public void userSave3(UserVO vo)  {
        List<UserEntity> users = vo.getUsers();
        for (UserEntity user : users) {
            System.out.println(user);
        }
    }

    @RequestMapping("/quick4")
    @ResponseBody
    public void userSave3(String[] hobby)  {
        for (String s : hobby) {
            System.out.println(s);
        }
    }

    @RequestMapping("/quick3")
    @ResponseBody
    public void userSave3(@RequestBody UserEntity user)  {
        System.out.println(user);
    }

    @RequestMapping("/quick2")
    @ResponseBody
    public void userSave2(UserEntity user)  {
        System.out.println(user);
    }

    @RequestMapping("/quick1")
    @ResponseBody
    public UserEntity userSave1()  {
        UserEntity user = new UserEntity();
        user.setUsername("ylj");
        user.setAge(19);
        return user;
    }

    @RequestMapping("/quick")
    @ResponseBody
    public String userSave(){
        return "success.jsp";
    }
}