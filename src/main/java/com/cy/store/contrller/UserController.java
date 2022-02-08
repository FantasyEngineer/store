package com.cy.store.contrller;


import com.cy.store.entity.JsonResult;
import com.cy.store.entity.User;
import com.cy.store.services.IUserService;
import com.cy.store.services.ex.InsertException;
import com.cy.store.services.ex.UserNameDuplicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public JsonResult<User> login(User user) {
        return iUserService.login(user);
    }
}
