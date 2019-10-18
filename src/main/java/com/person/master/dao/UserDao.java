package com.person.master.dao;

import com.person.master.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserDao {

    /**
     * 查询用户
     * @param account
     * @return
     */
    @Select("select * from user where account = #{account}")
    UserDto queryUserByAccount(@Param("account") String account);

    /**
     * 根据id查询用户
     */
    @Select("select * from user where id = #{id}")
    UserDto selectUserById(@Param("id") int id);
}
