package com.cy.store.services;

import com.cy.store.entity.Address;
import com.cy.store.entity.User;

/**
 * @author jimmy
 */

public interface IAddressService {


    /**
     * 新增地址
     *
     * @param address 地址实体类
     */
    void insertAddress(Address address);

    /**
     * 查找uid下有多少个地址
     *
     * @param uid
     */
    int findCountByUid(Integer uid);

}
