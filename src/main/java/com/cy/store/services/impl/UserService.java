package com.cy.store.services.impl;

import com.cy.store.entity.JsonResult;
import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import com.cy.store.services.IUserService;
import com.cy.store.services.ex.InsertException;
import com.cy.store.services.ex.UserNameDuplicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * @author jimmy
 */
@Service
public class UserService implements IUserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public void reg(User user) {
        //通过User参数获取传递过来的username
        String username = user.getUsername();
        //调用findByUsername判断用户是否注册过
        User result = userMapper.findByUsername(username);
        //判断结果集是否为null，不为null则抛出用户名被占用的异常
        if (result != null) {
            throw new UserNameDuplicatedException("用户名被占用");
        }

        //密码的加密处理，MD5的形式
        //串 + password + 串 ---------md5进行加密，连续加载三次
        //盐值 +password + 盐值  ------盐值就是随机的字符串
        String password = user.getPassword();
        //获取盐值(随机生成一个盐值)
        String salt = UUID.randomUUID().toString().toUpperCase();
        //将密码和盐值作为一个整体进行加密处理，忽略了原有密码的强度，提高了数据的安全性
        String md5Password = getMd5Password(password, salt);
        //将新密码设置到user中
        user.setPassword(md5Password);
        //将盐值记录下来
        user.setSalt(salt);

        // 补全数据is_delete设置成0
        user.setIs_delete(0);
        //补全数据：4个创建与修改的数据
        user.setCreatedUser("jimmy");
        user.setModifiedUser("jimmy");
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);

        //为null则进行保存数据库操作
        Integer rows = userMapper.insert(user);
        if (rows != 1) {
            throw new InsertException("在用户注册过程中产生了未知的异常");
        }
    }

    @Override
    public JsonResult<User> login(User user) {
        //获取到用户名
        String username = user.getUsername();
        //根据用户名查询到用户的数据
        User result = userMapper.findByUsername(username);
        //获取加密的随机盐值
        String salt = result.getSalt();
        //获取用户输入的密码
        String password = user.getPassword();
        //加密密码得到新密码
        String md5Password = getMd5Password(password, salt);

        JsonResult<User> userJsonResult = new JsonResult<>();
        //将加密后的密码与查询到的密码进行比较
        if (result.getPassword().equals(md5Password)) {
            userJsonResult.success(result);
        } else {
            userJsonResult.fail();
        }
        return userJsonResult;
    }


    /**
     * 根据密码，盐值，进行md5的加密
     */
    private String getMd5Password(String password, String salt) {
        for (int i = 0; i < 3; i++) {
            //md5加密算法方法的调用
            password = DigestUtils.md5DigestAsHex((salt + password + salt).getBytes()).toUpperCase();
        }
        return password;
    }
}
