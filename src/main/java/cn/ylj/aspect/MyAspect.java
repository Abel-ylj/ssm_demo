package cn.ylj.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 创建切面类： 其实这里只有通知/增强，按spring给的格式走而已
 */
@Component("myAspect")
@Aspect
public class MyAspect {

    @Before("myPointCut()")
    public void before(){
        System.out.println("前置增强。。。。");
    }

    @After("myPointCut()")
    public void after(){
        System.out.println("后置通知。。。。");
    }

    @Around("myPointCut()")
    public void around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("环绕前增强。。。。");
        //切点 目标方法
        pjp.proceed();
        System.out.println("环绕后增强。。。。");
    }

    @AfterThrowing("myPointCut()")
    public void afterThrowing(){
        System.out.println("异常通知。。。");
    }

    /**
     * 切点表达式抽取
     */
    @Pointcut("execution(* cn.ylj.dao.impl.UserDaoImpl.*(..))")
    public void myPointCut(){
    }
}