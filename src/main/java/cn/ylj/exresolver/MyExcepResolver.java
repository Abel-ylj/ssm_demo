package cn.ylj.exresolver;

import cn.ylj.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

/**
 * 自定义异常处理器
 * @author : yanglujian
 * create at:  2021/1/10  5:20 下午
 */
public class MyExcepResolver implements HandlerExceptionResolver {
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("customizeException");
        HashMap<String, String> map = new HashMap<String, String>();
        if (ex instanceof MyException){
            System.out.println("发生自定义类型异常");
            map.put("type", "自定义异常");
            map.put("message", "抛出自定义异常啦。。。");
            mv.addObject("error",map);
        } else if (ex instanceof ClassCastException){
            System.out.println("发生类型转换异常");
            map.put("type", "类型转换异常");
            map.put("message", "抛出类型转换异常啦。。。");
            mv.addObject("error",map);
        } else {
            map.put("type", "默认异常");
            map.put("message", "抛出异常啦。。。");
            mv.addObject("error",map);
            System.out.println("发生异常");
        }
        return mv;
    }
}