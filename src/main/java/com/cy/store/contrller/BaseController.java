package com.cy.store.contrller;

import com.cy.store.entity.JsonResult;
import com.cy.store.services.ex.InsertException;
import com.cy.store.services.ex.ServiceException;
import com.cy.store.services.ex.UserNameDuplicatedException;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * controller基类
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
    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handlerException(Throwable e) {
        JsonResult<Void> jsonResult = new JsonResult<Void>(e);
        if (e instanceof UserNameDuplicatedException) {
            jsonResult.setState(100);
        } else if (e instanceof InsertException) {
            jsonResult.setState(300);
        } else {
            jsonResult.setState(900);
        }
        return jsonResult;

    }

}
