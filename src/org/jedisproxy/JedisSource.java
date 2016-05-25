package org.jedisproxy;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCommands;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Pipeline;

/**
 * @author wuxiaodong
 * @function jedis资源初始化
 * @time 2012-7-13 下午06:33:57
 */
public class JedisSource {

	public static JedisPool pool;

	/**
	 * @author dong
	 * @methedDesc 方法描述：初始化
	 * @param jpc
	 * @param ip
	 * @param port
	 * @param timeout
	 * @param pwd
	 */
	public static void init(JedisPoolConfig jpc, String ip, int port, int timeout, String pwd) {
		pool = new JedisPool(jpc, ip, port, timeout, pwd);
	}

	/**
	 * @author dong
	 * @methedDesc 方法描述：初始化
	 * @param ip
	 * @param port
	 * @param timeout
	 * @param pwd
	 */
	public static void init(String ip, int port, int timeout, String pwd) {
		JedisPoolConfig jpc = newJedisPoolConfig(100, 10, 10000);
		pool = new JedisPool(jpc, ip, port, timeout, pwd);
	}

	/**
	 * @author dong
	 * @methedDesc 方法描述：创建 JedisPoolConfig 对象
	 * @param maxActive最大对象数
	 * @param MinIdle保留最小对象数
	 * @param maxwait最长闲时毫秒
	 * @return
	 */
	public static JedisPoolConfig newJedisPoolConfig(int maxActive, int MinIdle, int maxwait) {
		JedisPoolConfig jpc = new JedisPoolConfig();
		jpc.setMaxActive(100);
		jpc.setMinIdle(10);
		jpc.setMaxWait(10000);
		return jpc;
	}

	public static Jedis getJedis() {
		return pool.getResource();
	}

	public static JedisCommands getJProxy() {
		return ((JedisCommands) JedisProxy.newInstance().bind((Jedis) getJedis()));
	}

	public static Pipeline getPipeline() {
		return pool.getResource().pipelined();
	}

	public static void returnResource(Jedis jedis) {
		pool.returnResource(jedis);
	}

	public static void returnBrokenResource(Jedis jedis) {
		pool.returnBrokenResource(jedis);
	}
}
