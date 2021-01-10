package cn.ylj.controller;

import cn.ylj.entity.UserEntity;
import cn.ylj.model.UserVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author : yanglujian
 * create at:  2021/1/9  1:56 下午
 */
@Controller
public class UserController {

    @RequestMapping("/quick10")
    @ResponseBody
    public void userSave10(@CookieValue(value = "JSESSION") String sessionId)  {
        System.out.println(sessionId);
    }

    @RequestMapping("/quick9")
    @ResponseBody
    public void userSave9(@RequestHeader(value = "user-agent") String headerStr)  {
        System.out.println(headerStr);
    }

    @RequestMapping("/quick8")
    @ResponseBody
    public void userSave8(HttpServletRequest req, HttpServletResponse resp, HttpSession session)  {
        System.out.println(req);
        System.out.println(resp);
        System.out.println(session);
    }

    @RequestMapping("/quick7")
    @ResponseBody
    public void userSave7(@RequestParam(value = "createAt", required = false) Date createAt)  {
        System.out.println(createAt);
    }

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
        return "success";
    }
}