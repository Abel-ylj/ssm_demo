package cn.ylj.proxy;

import cn.ylj.dao.IUserDao;
import cn.ylj.dao.impl.UserDaoImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Spring 实现的aop demo
 */
public class SpringOperation {

    public static void main(String[] args) {
        //通知
        final Advice advice = new Advice();

        //目标对象
        final UserDaoImpl userDao = new UserDaoImpl();

        //继承目标类的子class
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserDaoImpl.class);

        //设置回调，功能同jdk动态代理中传入InvocationHandler对象的invoke方法，反射唤起目标对象的目标方法，
        enhancer.setCallback(new MethodInterceptor() {
            public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                advice.preMethod();
                userDao.save();
                advice.postMethod();
                return null;
            }
        });

        //由上面的代码构成的class对象，创建出代理对象并获取
        UserDaoImpl ud_proxy = (UserDaoImpl)enhancer.create();
        ud_proxy.save();

    }


    public void jdkProxy(){
        //目标对象 会被动态代理对象持有，所以这里修饰为final
        final IUserDao userDao = new UserDaoImpl();
        //通知方法
        final Advice advice = new Advice();

        //创建代理对象，Spring底层实现会帮我们实现这个过程，我们只需要将通知，目标对象，增强方式告诉Spring就行
        IUserDao ud_proxy = (IUserDao) Proxy.newProxyInstance(IUserDao.class.getClassLoader(), UserDaoImpl.class.getInterfaces(), new InvocationHandler() {
            /**
             * @param proxy  代理对象的引用地址
             * @param method 代理对象执行时传入的method对象，通过method对象和持有的目标对象，用反射调用
             * @param args   代理对象执行方法时传入的参数
             * @return
             * @throws Throwable
             */
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                advice.preMethod();//前置增强
                //代理对象执行接口规范的方法时，本质上就是调用这个invoke()方法
                method.invoke(userDao, args);
                advice.postMethod();//后置增强
                return null;
            }
        });

        //代理对象执行方法
        ud_proxy.save();
    }
}