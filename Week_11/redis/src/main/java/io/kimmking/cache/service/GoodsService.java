package io.kimmking.cache.service;

/**
 * @author ：huabin
 * @date ：Created in 2021/1/6 21:59
 * @description：
 * @modified By：
 * @version: $
 */
public interface GoodsService {

    /**
     * 购买
     * @param gooksId
     * @return
     */
    Integer buy(Integer gooksId);

    /**
     * 查看库存
     * @param gooksId
     * @return
     */
    Integer stock(Integer gooksId);

}
