package com.cy.store.mapper;

import com.cy.store.entity.Address;
import com.cy.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//标注当前类是一个测试类，不会随同项目一起打包
@SpringBootTest
//启动这个单元测试类
@RunWith(SpringRunner.class)
public class AddressMapperTests {
    @Autowired
    private AddressMapper addressMapper;

    @Test
    public void testinsert() {

        Address address = new Address();
        address.setAddress("这是地址");
        address.setName("侯继国");
        address.setPhone("1918182291");
        address.setZip("23442");
        addressMapper.insertAddress(address);

    }


}
