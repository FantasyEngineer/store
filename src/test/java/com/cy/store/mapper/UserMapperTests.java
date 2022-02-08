package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//标注当前类是一个测试类，不会随同项目一起打包
@SpringBootTest
//启动这个单元测试类
@RunWith(SpringRunner.class)
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testinsert() {
        User user = new User();
        user.setUsername("jimmy2");
        user.setPassword("12313");
        Integer row = userMapper.insert(user);
        System.out.println(row);
    }
}
