package com.cy.store.mapper;


import com.cy.store.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author jimmy
 * 用户注册的持久层
 */
@Mapper
public interface UserMapper {
    /**
     * 插入用户的数据
     *
     * @param user 用户的数据
     * @return 受影响的行数（增删改都以受影响的行数作为返回值，可以根据返回值来判断是否执行成功）
     */
    @Insert("insert into t_user (username, password , salt, phone, email, gender, avatar, is_delete, created_user, created_time, modified_user, modified_time) values (#{username}, #{password} , #{salt}, #{phone}, #{email}, #{gender}, #{avatar}, #{isDelete}, #{createdUser}, #{createdTime}, #{modifiedUser}, #{modifiedTime})")
    Integer insert(User user);


    /**
     * 根据用户名查询用户的数据
     *
     * @param username 用户名
     * @return 如果找到对应的用户，则返回该用户，如果没有找到，则返回null值
     */
    @Select("select * from t_user where username = #{username}")
    User findByUsername(String username);


    /**
     * 根据uid获取到用户
     *
     * @param uid
     * @return
     */
    @Select("select * from t_user where uid = #{uid}")
    User findByUserUid(Integer uid);

    /**
     * 根据uid进行修改密码
     *
     * @param uid
     * @param password
     * @return
     */
    @Update("update t_user set password=#{password} where uid = #{uid}")
    Integer updatePassword(Integer uid, String password);


    /**
     * 更新用户信息
     *
     * @param user 需要更新的用户信息
     * @return 1 更新成功 ！1 更新失败
     */
    @Update("update t_user set username = #{username} ,phone = #{phone} , email = #{email}, gender = #{gender}, avatar = #{avatar}, is_delete = #{isDelete} where uid =#{uid}")
    Integer updateUserInfo(User user);


    /**
     * 更新头像
     *
     * @param uid
     * @param avatar 头像在服务器上保存的位置
     * @return
     */
    @Update("update t_user set avatar = #{avatar} where uid = #{uid}")
    Integer updateAvatar(Integer uid, String avatar);

}
