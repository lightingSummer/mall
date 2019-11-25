package club.lightingsummer.mall.service.util;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author light
 * @date 2019/11/25 0025 21:52
 */
@Component
public class JedisUtil implements InitializingBean {
    private static final Logger logger = LoggerFactory.getLogger(JedisUtil.class);

    @Value("${spring.redis.host:disabled}")
    private String host;
    @Value("${spring.redis.port:0}")
    private int port;
    @Value("${spring.redis.password:0}")
    private String password;
    @Value("${spring.redis.timeout:0}")
    private int timeout;
    @Value("${spring.redis.database:0}")
    private int database;

    private JedisPool jedisPool = null;

    @Override
    public void afterPropertiesSet() throws Exception {
        try {
            jedisPool = new JedisPool(new GenericObjectPoolConfig(), host, port, timeout, password, database, (String) null);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Create JedisPool failed :" + e.getMessage());
        }
    }

    public Jedis getJedis() {
        return jedisPool.getResource();
    }
}
