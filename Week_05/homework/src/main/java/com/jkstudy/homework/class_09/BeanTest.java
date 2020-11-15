package com.jkstudy.homework.class_09;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author ：huabin
 * @date ：Created in 2020/11/15 19:28
 * @description：测试bean
 * @modified By：
 * @version: 1.0.0$
 */
@Component
public class BeanTest {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        BeanDemo01 beanDemo01 = (BeanDemo01)context.getBean("beanDemo01");
        System.out.println("-----------注解方式构造bean打印---"+beanDemo01.toString());


        BeanDemo02 beanDemo02 = (BeanDemo02)context.getBean("beanDemo02");
        System.out.println("-----------xml方式构造bean打印---"+beanDemo02.toString());

    }

}
