package cn.ylj.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

/**
 * @author : yanglujian
 * create at:  2021/1/7  2:46 下午
 */
@Configuration
@ComponentScan("cn.ylj")
@Import(DatasourceConfig.class)
public class SpringConfig {

}