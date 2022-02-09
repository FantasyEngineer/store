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
     *
     * @param user
     */
    User login(User user);


    /**
     * 修改密码
     * @param uid
     * @param oldPassword
     * @param newPassword
     * @param newPasswordAgain
     * @return
     */
    void changePassword(Integer uid, String oldPassword, String newPassword, String newPasswordAgain);
}
