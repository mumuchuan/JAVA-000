package com.jkstudy.homework;

import com.beanstarter.bean.Student;
import com.jkstudy.homework.class_10.hikari.entity.User;
import com.jkstudy.homework.class_10.hikari.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class HomeworkApplication implements CommandLineRunner {

    @Resource
    Student student;
    @Resource
    UserService userService;


    public static void main(String[] args) {
        SpringApplication.run(HomeworkApplication.class, args);
    }


//    /**
//     * 第十课作业：测试Student自动装配
//     * @param args
//     * @throws Exception
//     */
//    @Override
//    public void run(String... args) throws Exception {
//        System.out.println(student.toString());
//    }

    /**
     * 第十课作业：测试JPA操作DB
     * @param args
     * @throws Exception
     */
    public void run(String... args) throws Exception{

        //todo 使用CommandLineRunner有坑

//        //新增/修改
//        User user = new User();
//        user.setId(8L);
//        user.setName("Jordan");
//        user.setAge(57);
//        userService.saveOrUpdate(user);
//
//        //删除
//        User deleteUser = new User();
//        deleteUser.setId(4L);
//        userService.delete(deleteUser);

        //查询单条记录
        User tmpUser = userService.getOne(8L);
        System.out.println(tmpUser);
    }
}
