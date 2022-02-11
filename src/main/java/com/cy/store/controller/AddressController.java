package com.cy.store.controller;

import com.cy.store.entity.Address;
import com.cy.store.entity.JsonResult;
import com.cy.store.services.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @author jimmy
 */
@RestController
@RequestMapping("addresses")
public class AddressController extends BaseController {
    @Autowired
    private IAddressService addressService;

    @RequestMapping("insertAddress")
    public JsonResult insertAddress(HttpSession session, Address address) {
        Integer uid = getUidFromSession(session);
        address.setUid(uid);
        addressService.insertAddress(address);
        return new JsonResult().success();
    }

}
