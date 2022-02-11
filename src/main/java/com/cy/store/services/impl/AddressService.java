package com.cy.store.services.impl;

import com.cy.store.entity.Address;
import com.cy.store.mapper.AddressMapper;
import com.cy.store.services.IAddressService;
import com.cy.store.services.ex.AddressMaxException;
import com.cy.store.services.ex.UpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author jimmy
 */
@Service
public class AddressService implements IAddressService {

    @Value("${address.max_count}")
    int MAX_ADDRESS;

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public void insertAddress(Address address) {
        Integer uid = address.getUid();
        int count = findCountByUid(uid);
        if (count > MAX_ADDRESS) {
            throw new AddressMaxException();
        }

        //如果只有一条数据，则自动设置为默认
        address.setIsDefault(count == 0 ? 1 : 0);

        Integer integer = addressMapper.insertAddress(address);
        if (integer != 1) {
            throw new UpdateException();
        }
    }

    @Override
    public int findCountByUid(Integer uid) {
        int count = addressMapper.findCountByUid(uid);
        return count;
    }
}
