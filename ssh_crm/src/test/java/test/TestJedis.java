package test;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class TestJedis {

	@Test
	public void fun1() {
		Jedis jedis = new Jedis("localhost", 6379);
		System.out.println(jedis.get("name"));
		jedis.close();
	}

	@Test
	public void fun2() {
		/*
		 * 1、创建池子的配置对象
		 */
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxIdle(30);// 最大闲置个数
		poolConfig.setMinIdle(10);// 最小闲置个数
		poolConfig.setMaxTotal(50);// 最大连接数
		/*
		 * 2、创建一个redis连接池
		 */
		JedisPool pool = new JedisPool(poolConfig, "localhost", 6379);
		/*
		 * 3、从池子中获得redis的连接资源
		 */
		Jedis jedis = pool.getResource();
		/*
		 * 4、进行常规数据存储操作
		 */
		System.out.println(jedis.get("name"));
		/*
		 * 5、关闭资源
		 */
		jedis.close();
		pool.close();
	}

}
