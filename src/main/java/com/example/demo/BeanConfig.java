package com.example.demo;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dao.BookDao;
import dao.RentDao;
import dao.UserDao;
import service.BookService;
import service.RentService;
import service.UserService;
@Configuration
public class BeanConfig {
     @Bean(destroyMethod = "close")
      public DataSource dataSource() {
           DataSource ds = new DataSource();
           ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
    ds.setUrl("jdbc:mysql://localhost/spring5fs?characterEncoding=utf8&serverTimezone=UTC");
           ds.setUsername("spring5");
           ds.setPassword("spring5");
           ds.setInitialSize(2);
           ds.setMaxActive(10);
           ds.setTestWhileIdle(true);
           ds.setMinEvictableIdleTimeMillis(60000 * 3);
           ds.setTimeBetweenEvictionRunsMillis(10 * 1000);
           return ds;
     }
     
     @Bean
     public UserDao userDao() {
    	 return new UserDao(dataSource());
     }
     @Bean BookDao bookDao() {
    	 return new BookDao(dataSource());
     }
     @Bean BookService bookSvc() {
    	 return new BookService(bookDao());
     }
     @Bean UserService userSvc() {
    	 return new UserService(userDao());
     }
     @Bean RentDao rentDao() {
    	 return new RentDao(dataSource());
     }
     @Bean RentService rentSvc() {
    	 return new RentService(rentDao());
     }
} 