package com.week07.datasource02;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.shardingsphere.driver.api.ShardingSphereDataSourceFactory;
import org.apache.shardingsphere.infra.config.algorithm.ShardingSphereAlgorithmConfiguration;
import org.apache.shardingsphere.replicaquery.api.config.ReplicaQueryRuleConfiguration;
import org.apache.shardingsphere.replicaquery.api.config.rule.ReplicaQueryDataSourceRuleConfiguration;
import org.apache.shardingsphere.sharding.api.config.ShardingRuleConfiguration;
import org.apache.shardingsphere.sharding.api.config.rule.ShardingTableRuleConfiguration;
import org.apache.shardingsphere.sharding.api.config.strategy.sharding.StandardShardingStrategyConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;

@SpringBootApplication
public class Datasource02Application {

    public static void main(String[] args) {
        SpringApplication.run(Datasource02Application.class, args);
    }

//    @Bean
//    public DataSource dataSource() {
//        // 配置真实数据源
//        Map<String, DataSource> dataSourceMap = new HashMap<>();
//
//        // 配置第 1 个数据源
//        BasicDataSource dataSource1 = new BasicDataSource();
//        dataSource1.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource1.setUrl("jdbc:mysql://127.0.0.1:3306/mall_system?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&serverTimezone=UTC");
//        dataSource1.setUsername("root");
//        dataSource1.setPassword("hb135119");
//        dataSourceMap.put("ds0", dataSource1);
//
//        // 配置第 2 个数据源
//        BasicDataSource dataSource2 = new BasicDataSource();
//        dataSource2.setDriverClassName("com.mysql.jdbc.Driver");
//        dataSource2.setUrl("jdbc:mysql://127.0.0.1:3306/mall_system?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&serverTimezone=UTC");
//        dataSource2.setUsername("root");
//        dataSource2.setPassword("hb135119");
//        dataSourceMap.put("ds1", dataSource2);
//
//        // 配置 t_order 表规则
//        ShardingTableRuleConfiguration orderTableRuleConfig = new ShardingTableRuleConfiguration("t_test", "ds${0..1}.t_test_${0..1}");
//
//        // 配置分库策略
//        orderTableRuleConfig.setDatabaseShardingStrategy(new StandardShardingStrategyConfiguration("column_id", "dbShardingAlgorithm"));
//
//        // 配置分表策略
//        orderTableRuleConfig.setTableShardingStrategy(new StandardShardingStrategyConfiguration("title_id", "tableShardingAlgorithm"));
//
//        // 省略配置 t_order_item 表规则...
//        // ...
//
//        // 配置分片规则
//        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
//        shardingRuleConfig.getTables().add(orderTableRuleConfig);
//
//        // 配置分库算法
//        Properties dbShardingAlgorithmrProps = new Properties();
//        dbShardingAlgorithmrProps.setProperty("algorithm-expression", "ds${column_id % 2}");
//        shardingRuleConfig.getShardingAlgorithms().put("dbShardingAlgorithm", new ShardingSphereAlgorithmConfiguration("INLINE", dbShardingAlgorithmrProps));
//
//        // 配置分表算法
//        Properties tableShardingAlgorithmrProps = new Properties();
//        tableShardingAlgorithmrProps.setProperty("algorithm-expression", "t_test_${title_id % 2}");
//        shardingRuleConfig.getShardingAlgorithms().put("tableShardingAlgorithm", new ShardingSphereAlgorithmConfiguration("INLINE", tableShardingAlgorithmrProps));
//
//        DataSource dataSource = null;
//        try {
//            dataSource = ShardingSphereDataSourceFactory.createDataSource(dataSourceMap, Collections.singleton(shardingRuleConfig), new Properties());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        //logger.info("datasource : {}", dataSource);
//        return dataSource;
//    }

    @Bean
    public DataSource dataSource() throws SQLException {
        //数据源Map
        Map<String, DataSource> dsMap = new HashMap<>();
        //配置主库
        HikariDataSource masterDs = new HikariDataSource();
        masterDs.setDriverClassName("com.mysql.cj.jdbc.Driver");
        masterDs.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/mall_system?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true");
        masterDs.setMinimumIdle(4);
        masterDs.setMaximumPoolSize(8);
        masterDs.setConnectionInitSql("SET NAMES utf8mb4");
        masterDs.setUsername("root");
        masterDs.setPassword("hb135119");
        dsMap.put("master_ds", masterDs);
        //配置读库1
        HikariDataSource replicaDs1 = new HikariDataSource();
        replicaDs1.setDriverClassName("com.mysql.cj.jdbc.Driver");
        replicaDs1.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/mall_system_02?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true");
        replicaDs1.setMinimumIdle(4);
        replicaDs1.setMaximumPoolSize(8);
        replicaDs1.setConnectionInitSql("SET NAMES utf8mb4");
        replicaDs1.setUsername("root");
        replicaDs1.setPassword("hb135119");
        dsMap.put("replica_ds_1", replicaDs1);
        //配置读库2
        HikariDataSource replicaDs2 = new HikariDataSource();
        replicaDs2.setDriverClassName("com.mysql.cj.jdbc.Driver");
        replicaDs2.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/mall_system_03?characterEncoding=utf8&useSSL=false&serverTimezone=Asia/Shanghai&rewriteBatchedStatements=true");
        replicaDs2.setMinimumIdle(4);
        replicaDs2.setMaximumPoolSize(8);
        replicaDs2.setConnectionInitSql("SET NAMES utf8mb4");
        replicaDs2.setUsername("root");
        replicaDs2.setPassword("hb135119");
        dsMap.put("replica_ds_2", replicaDs2);
        //配置读写分离规则
        List<ReplicaQueryDataSourceRuleConfiguration> configurations = new ArrayList<>();
        configurations.add(new ReplicaQueryDataSourceRuleConfiguration("ds", "master_ds", Arrays.asList("replica_ds_1", "replica_ds_2"), "load_balancer"));
        Map<String, ShardingSphereAlgorithmConfiguration> loadBalancers = new HashMap<>();
        loadBalancers.put("load_balancer", new ShardingSphereAlgorithmConfiguration("ROUND_ROBIN", new Properties()));
        ReplicaQueryRuleConfiguration ruleConfiguration = new ReplicaQueryRuleConfiguration(configurations, loadBalancers);
        //创建DS
        return ShardingSphereDataSourceFactory.createDataSource(dsMap, Arrays.asList(ruleConfiguration), new Properties());
    }


}
