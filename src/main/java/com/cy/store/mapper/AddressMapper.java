package com.cy.store.mapper;


import com.cy.store.entity.Address;
import com.cy.store.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author jimmy
 * 用户地址crud的持久层
 */
@Mapper
public interface AddressMapper {


    /**
     * 添加地址
     *
     * @param address
     * @return
     */
    @Insert("insert into t_address values (null,#{uid},#{provinceName},#{provinceCode},#{cityName},#{cityCode},#{areaName},#{areaCode},#{zip},#{name},#{address},#{phone},#{tel},#{tag},#{isDefault})")
    Integer insertAddress(Address address);


}
