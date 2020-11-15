package com.beanstarter.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ：huabin
 * @date ：Created in 2020/11/15 20:59
 * @description：
 * @modified By：
 * @version: $
 */
@Configuration
@ConditionalOnClass(Student.class)
@ConditionalOnProperty(prefix = "beanstarter.student",value = "enable",matchIfMissing = true)
@EnableConfigurationProperties(StudentProperty.class)
public class StudentAutoConfiguration {

    @Autowired
    StudentProperty studentProperty;

    @Bean
    @ConditionalOnMissingBean
    public Student student() {
        Student student = new Student(studentProperty.getId(),studentProperty.getName());
        return student;
    }

}
