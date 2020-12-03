package com.week07.datasource02.dao;

import com.week07.datasource02.entity.CustomerInf;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 用户信息表(CustomerInf)表数据库访问层
 *
 * @author makejava
 * @since 2020-12-02 20:45:11
 */
@Mapper
//@Repository("customerInfDao")
public interface CustomerInfDao {

    /**
     * 通过ID查询单条数据
     *
     * @param customerInfId 主键
     * @return 实例对象
     */
    CustomerInf queryById(Object customerInfId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<CustomerInf> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param customerInf 实例对象
     * @return 对象列表
     */
    List<CustomerInf> queryAll(CustomerInf customerInf);

    /**
     * 新增数据
     *
     * @param customerInf 实例对象
     * @return 影响行数
     */
    int insert(CustomerInf customerInf);

    /**
     * 修改数据
     *
     * @param customerInf 实例对象
     * @return 影响行数
     */
    int update(CustomerInf customerInf);

    /**
     * 通过主键删除数据
     *
     * @param customerInfId 主键
     * @return 影响行数
     */
    int deleteById(Object customerInfId);

}