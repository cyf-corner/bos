package top.flyroc.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtils {

	private static JedisPool pool = null;

	static {
		InputStream is = JedisPoolUtils.class.getClassLoader().getResourceAsStream("redis.properties");
		Properties pro = new Properties();
		try {
			pro.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}

		JedisPoolConfig poolConfig = new JedisPoolConfig();
		poolConfig.setMaxIdle(Integer.parseInt(pro.getProperty("redis.maxIdle")));
		poolConfig.setMinIdle(Integer.parseInt(pro.getProperty("redis.minIdle")));
		poolConfig.setMaxTotal(Integer.parseInt(pro.getProperty("redis.maxTotal")));
		pool = new JedisPool(poolConfig, pro.getProperty("redis.url"), Integer.parseInt(pro.getProperty("redis.port")));
	}

	public static Jedis getJedis() {
		return pool.getResource();
	}

	public static void main(String[] args) {
		System.out.println(JedisPoolUtils.getJedis().get("name"));
	}
}
