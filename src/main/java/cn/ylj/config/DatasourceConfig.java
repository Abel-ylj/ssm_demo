package cn.ylj.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author : yanglujian
 * create at:  2021/1/7  3:04 下午
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
public class DatasourceConfig {

    @Value("${jdbc.driverClassName}")
    String jdbcClassName;
    @Value("${jdbc.url}")
    String jdbcUrl;
    @Value("${jdbc.username}")
    String jdbcUsername;
    @Value("${jdbc.password}")
    String jdbcPassword;

    @Bean("ds")
    DruidDataSource getDruidDataSource(){
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName(this.jdbcClassName);
        ds.setUrl(this.jdbcUrl);
        ds.setUsername(this.jdbcUsername);
        ds.setPassword(this.jdbcPassword);
        return ds;
    }

}