package com.jkstudy.homework.class_10.hikari.dao;

import com.jkstudy.homework.class_10.hikari.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ：huabin
 * @date ：Created in 2020/11/16 0:18
 * @description：JPADao
 * @modified By：
 * @version: 1.0.0$
 */
@Repository
public interface UserDao extends JpaRepository<User,Long> {
}
