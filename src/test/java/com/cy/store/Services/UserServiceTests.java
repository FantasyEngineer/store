package com.cy.store.Services;

import com.cy.store.entity.JsonResult;
import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.services.impl.UserService;
import javafx.animation.ScaleTransition;
import org.junit.Test;
import org.junit.platform.commons.function.Try;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//标注当前类是一个测试类，不会随同项目一起打包
@SpringBootTest
//启动这个单元测试类
@RunWith(SpringRunner.class)
public class UserServiceTests {
    @Autowired
    private UserService userService;

    @Test
    public void login() {
        User user = new User();
        user.setUsername("test01");
        user.setPassword("123");
        JsonResult<User> result = userService.login(user);
        System.out.println(result);
    }

    @Test
    public void reg() {
        try {
            User user = new User();
            user.setUsername("张伟2");
            user.setPassword("123");
            userService.reg(user);
            System.out.println("ok");
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }

    }
}
