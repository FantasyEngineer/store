package com.cy.store.services;

import com.cy.store.entity.JsonResult;
import com.cy.store.entity.User;

/**
 * @author jimmy
 */
public interface IUserService {

    /**
     * 注册
     *
     * @param user 注册的数据
     */
    void reg(User user);


    /**
     * 登录
     * @param user
     */
    JsonResult<User> login(User user);
}
