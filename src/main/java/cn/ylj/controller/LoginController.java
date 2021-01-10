package cn.ylj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author : yanglujian
 * create at:  2021/1/10  3:50 下午
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public ModelAndView loginShow(ModelAndView mv){
        mv.setViewName("index.jsp");
        mv.addObject("username","ylj");
        return mv;
    }
}