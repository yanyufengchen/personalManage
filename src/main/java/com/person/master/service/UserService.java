package com.person.master.service;

import com.person.master.dto.UserDto;

/**
 * 用户接口
 *
 * @author jjma
 * 2019/09/06
 */
public interface UserService {

    /**
     * 查询用户
     * @param account
     * @return
     */
    UserDto searchUser(String account);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    UserDto selectUserById(int id);
}
