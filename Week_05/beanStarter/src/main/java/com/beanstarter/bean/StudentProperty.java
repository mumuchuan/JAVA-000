package com.beanstarter.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author ：huabin
 * @date ：Created in 2020/11/15 20:36
 * @description：Student实体类
 * @modified By：
 * @version: 1.0.0$
 */
@ConfigurationProperties(prefix = "beanstarter.student") // 自动获取配置文件中的属性，把值传入对象参数
public class StudentProperty {

    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
