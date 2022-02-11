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
     *
     * @param uid
     * @param oldPassword
     * @param newPassword
     * @param newPasswordAgain
     * @return
     */
    void changePassword(Integer uid, String oldPassword, String newPassword, String newPasswordAgain);


    /**
     * 根据uid查询user
     *
     * @param uid
     * @return
     */
    User findUserByUid(Integer uid);

    /**
     * 更新用户信息
     *
     * @param user 需要更新的用户信息
     */
    void updateUserInfo(User user);

    /**
     * 保存用户头像
     *
     * @param avatar 头像的地址
     */
    void saveAvatar(Integer uid, String avatar);
}
