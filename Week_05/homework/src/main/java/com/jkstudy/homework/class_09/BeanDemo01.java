package com.jkstudy.homework.class_09;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author ：huabin
 * @date ：Created in 2020/11/15 19:24
 * @description：注解方式构造bean
 * @modified By：
 * @version: 1.0.0$
 */
@Component("beanDemo01")
@Scope("prototype")
public class BeanDemo01 {

    @Value("1")
    private Long uid;

    @Value("张三")
    private String name;

    @Value("23")
    private Integer age;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "BeanDemo01{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
