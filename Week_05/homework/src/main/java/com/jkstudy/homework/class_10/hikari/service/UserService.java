package com.jkstudy.homework.class_10.hikari.service;

import com.jkstudy.homework.class_10.hikari.dao.UserDao;
import com.jkstudy.homework.class_10.hikari.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ：huabin
 * @date ：Created in 2020/11/16 0:20
 * @description：JPAService
 * @modified By：
 * @version: 1.0.0$
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    public User saveOrUpdate(User user){
        return userDao.save(user);
    }

    public User getOne(Long id){
       return userDao.getOne(id);
    }

    public void delete(User user){
        userDao.delete(user);
    }

}
