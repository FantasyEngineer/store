package com.cy.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author jimmy
 * MapperScan用来指定mapper接口路径的位置，在项目启动的时候会自动加载所有的mapper文件
 */
@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }

}
