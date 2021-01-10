package cn.ylj.controller;

import cn.ylj.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : yanglujian
 * create at:  2021/1/10  4:56 下午
 */
@Controller
public class ExceptionController {

    @RequestMapping("/myExceptionMethod")
    public void myExceptionMethod() throws MyException {
        System.out.println("自定义异常方法");
        throw new MyException();
    }

    @RequestMapping("/classCastMethod")
    public void classCastExceptionMethod(){
        System.out.println("类型转换异常");
        Object str = "nihao";
        Integer i = (Integer)str;
    }

    @RequestMapping("/default")
    public void defaultMethod(){
        int i = 1/0;
    }

}