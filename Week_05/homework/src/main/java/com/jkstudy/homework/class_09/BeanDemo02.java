package com.jkstudy.homework.class_09;

/**
 * @author ：huabin
 * @date ：Created in 2020/11/15 19:37
 * @description：xml方式构造bean
 * @modified By：
 * @version: 1.0.0$
 */
public class BeanDemo02 {

    private Long uid;

    private String name;

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
        return "BeanDemo02{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
