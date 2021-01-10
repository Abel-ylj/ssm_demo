package cn.ylj.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 是SpringMVC中的概念
 * 访问@Controller中的方法时，若匹配拦截表达式(切点表达式)，则动态织入
 * 而Aspect是Spring的基础概念，如事务控制时，对Dao对象的方法进行拦截，动态代理。
 * @author : yanglujian
 * create at:  2021/1/10  3:59 下午
 */
public class MyInterceptor implements HandlerInterceptor {

    //目标方法执行之前执行
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //用户校验，若未登陆则返回用户页面
        String sessionId = request.getParameter("sessionId");
        if (sessionId == null){
            request.getRequestDispatcher("error.jsp").forward(request, response);
        } else {
            //继续走后续的拦截器链
            return true;
        }
        return false;
    }

    //目标方法执行之后执行，ModelAndView对象返回之前,可以对返回的mv对象进行修改,如换视图或改数据
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //修改数据
        Object v = modelAndView.getModel().get("username");
        if (v instanceof String){
            v = String.format("%s,被修改了", v);
        }
        modelAndView.addObject("username", v);
    }

    //目标方法执行之后，ModelAndView对象返回之后,做一些收尾工作,如异常处理等...
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("收尾工作");
    }
}