package io.kimmking.cache.service.impl;

import io.kimmking.cache.service.GoodsService;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
 * @author ：huabin
 * @date ：Created in 2021/1/6 22:01
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    /**
     * 购买
     * @param gooksId
     * @return
     */
    @Override
    public Integer buy(Integer gooksId) {
        String key = "goods_" + gooksId;
        Jedis jedis = new Jedis("localhost", 6379);
        System.out.println(jedis.info());
        if(jedis.exists(key)){
            Integer count = Integer.valueOf(jedis.get(key).toString());
            System.out.println("购买之前库存："+count);
            if(count > 0){
                //商品key:goods_1,初始库存100已经设置缓存中，此处只模拟购买时商品减库存，不做db处理
                jedis.decr("goods_1");
                System.out.println("购买之后库存："+jedis.get(key));
            }else {
                System.out.println("商品已卖完");
            }
        }else {
            //商品不存在
            return 0;
        }
        return 1;
    }

    /**
     * 查看库存
     * @param gooksId
     * @return
     */
    @Override
    public Integer stock(Integer gooksId) {
        Integer count = 0;
        String key = "goods_" + gooksId;
        Jedis jedis = new Jedis("localhost", 6379);
        System.out.println(jedis.info());
        if(jedis.exists(key)){
            count = Integer.valueOf(jedis.get(key).toString());
        }
        return count;
    }

}
