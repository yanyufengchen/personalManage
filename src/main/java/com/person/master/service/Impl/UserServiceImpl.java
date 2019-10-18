package com.person.master.service.Impl;

import com.person.master.dao.UserDao;
import com.person.master.dto.UserDto;
import com.person.master.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    /**
     * 根据account查询用户是否存在
     * @param account
     * @return
     */
    @Override
    public UserDto searchUser(String account){
        return userDao.queryUserByAccount(account);
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @Override
    public  UserDto selectUserById(int id){
        return userDao.selectUserById(id);
    }
}
