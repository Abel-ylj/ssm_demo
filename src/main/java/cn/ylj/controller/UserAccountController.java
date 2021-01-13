package cn.ylj.controller;

import cn.ylj.entity.UserEntity;
import cn.ylj.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : yanglujian
 * create at:  2021/1/13  10:56 上午
 */
@Controller
@RequestMapping("/user")
public class UserAccountController {

    /**
     * Spring是父容器，SpringMVC是子容器
     * 子容器中持有父容器
     * 父容器看不到子容器，跟继承关系类似
     */
    @Resource
    private IUserService userService;

    @RequestMapping("/list")
    public ModelAndView users(){
        List<UserEntity> list = userService.list();
        ModelAndView mv = new ModelAndView();
        mv.addObject("users",list);
        mv.setViewName("user-list");
        return mv;
    }
}