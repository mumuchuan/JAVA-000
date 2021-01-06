package io.kimmking.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ：huabin
 * @date ：Created in 2021/1/6 20:23
 * @description：
 * @modified By：
 * @version: $
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = RedisApplication.class)
public class RedisApplicationTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testInsert() {
        redisTemplate.opsForValue().set("mm", "miao");
    }
}
