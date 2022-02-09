package com.cy.store.contrller;


import com.cy.store.entity.JsonResult;
import com.cy.store.entity.User;
import com.cy.store.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author jimmy
 */
@RestController
@RequestMapping("/users")
public class UserController extends BaseController {
    @Autowired
    private IUserService iUserService;

    @RequestMapping("reg")
    public JsonResult<Void> reg(User user) {
        iUserService.reg(user);
        return new JsonResult<User>().success(user);
    }

    @RequestMapping("login")
    public JsonResult<User> login(User user, HttpSession session) {
        User user1 = iUserService.login(user);
        //登录之后将部分数据存入到session中。
        session.setAttribute("uid", user1.getUid());
        session.setAttribute("username", user1.getUsername());

        return new JsonResult<User>().success(user1);
    }

    /**
     * 修改密码，根据uid进行修改
     *
     * @param oldPassword      老密码
     * @param newPassword      新密码
     * @param newPasswordAgain 再一次新密码
     * @return 是否成功
     */
    @RequestMapping("change_password")
    public JsonResult<Void> changePassword(HttpSession session, String oldPassword, String newPassword, String newPasswordAgain) {
        Integer uid = getUidFromSession(session);
        iUserService.changePassword(uid, oldPassword, newPassword, newPasswordAgain);
        return new JsonResult<Void>().success();
    }

}
