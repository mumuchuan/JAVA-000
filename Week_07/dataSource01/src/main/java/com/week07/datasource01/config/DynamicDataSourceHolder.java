package com.week07.datasource01.config;

/**
 * @author ：huabin
 * @date ：Created in 2020/12/2 17:11
 * @description：使用ThreadLocal技术来记录当前线程中的数据源的key
 * @modified By：
 * @version: 1.0.0$
 */
public class DynamicDataSourceHolder {

    //写库对应的数据源key
    public static final String MASTER = "master";

    //读库对应的数据源key
    public static final String SLAVE = "slave";

    //使用ThreadLocal记录当前线程的数据源key
    private static final ThreadLocal<String> holder = new ThreadLocal<String>();

    /**
     * 设置数据源key
     * @param key
     */
    public static void putDataSourceKey(String key) {
        holder.set(key);
    }

    /**
     * 获取数据源key
     * @return
     */
    public static String getDataSourceKey() {
        return holder.get();
    }

    /**
     * 标记写库
     */
    public static void markMaster(){
        putDataSourceKey(MASTER);
    }

    /**
     * 标记读库
     */
    public static void markSlave(){
        putDataSourceKey(SLAVE);
    }

    /**
     * 判断是否是主库
     * @return
     */
    public static boolean isMaster() {
        boolean result = false;
        if(null != holder.get() && holder.get().equals(MASTER)){
            result = true;
        }
        return result;
    }
}
