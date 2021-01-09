//package cn.ylj;
//
//import cn.ylj.config.SpringConfig;
//import com.alibaba.druid.pool.DruidDataSource;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.sql.SQLException;
//
///**
// * @author : yanglujian
// * create at:  2021/1/6  10:33 下午
// */
//public class application {
//    public static void main(String[] args) throws IllegalAccessException, InstantiationException, SQLException {
//
////        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
//        DruidDataSource ds = (DruidDataSource) ctx.getBean("ds");
//        System.out.println(ds.getConnection());
//    }
//}