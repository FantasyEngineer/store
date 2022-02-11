package com.cy.store.controller;

import com.cy.store.controller.ex.FileEmptyException;
import com.cy.store.controller.ex.FileOutOfSizeException;
import com.cy.store.controller.ex.FileTypeException;
import com.cy.store.controller.ex.FileUploadException;
import com.cy.store.entity.JsonResult;
import com.cy.store.services.ex.InsertException;
import com.cy.store.services.ex.ServiceException;
import com.cy.store.services.ex.UserNameDuplicatedException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/**
 * controller基类
 *
 * @author jimmy
 */
public class BaseController {
    public static final int OK = 200;

    /**
     * 全局抓取当前类和子类中的所有异常，有异常时执行此块代码。
     *
     * @param e
     * @return
     */
    @ExceptionHandler({ServiceException.class, FileUploadException.class})
    public JsonResult<Void> handlerException(Throwable e) {
        JsonResult<Void> jsonResult = new JsonResult<Void>(e);
        if (e instanceof UserNameDuplicatedException) {
            jsonResult.setState(100);
        } else if (e instanceof InsertException) {
            jsonResult.setState(300);
        } else if (e instanceof FileEmptyException) {
            jsonResult.setState(5000);
        } else if (e instanceof FileTypeException) {
            jsonResult.setState(5001);
        } else if (e instanceof FileOutOfSizeException) {
            jsonResult.setState(5002);
        } else {
            jsonResult.setState(900);
        }
        return jsonResult;

    }

    /**
     * 从HttpSession对象中获取uid
     *
     * @param session HttpSession对象
     * @return 当前登录的用户的id
     */
    protected final Integer getUidFromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    /**
     * 从HttpSession对象中获取用户名
     *
     * @param session HttpSession对象
     * @return 当前登录的用户名
     */
    protected final String getUsernameFromSession(HttpSession session) {
        return session.getAttribute("username").toString();
    }


}
