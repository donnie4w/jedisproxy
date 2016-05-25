package org.jedisproxy;

import redis.clients.jedis.BinaryJedisPubSub;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class PubSub extends JedisSource {

	/**
	 * 将信息 message 发送到指定的频道 channel
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @throws JedisException
	 */
	public static long publish(String channel, String message) throws JedisException {
		Jedis j = getJedis();
		boolean isException = false;
		try {
			return j.publish(channel, message);
		} catch (Exception e) {
			returnBrokenResource(j);
			isException = true;
			throw new JedisException(e);
		} finally {
			if (!isException) {
				returnResource(j);
			}

		}
	}

	/**
	 * 订阅给定的一个或多个频道的信息
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @throws JedisException
	 */
	public static void subscribe(JedisPubSub jedisPubSub, String... channels) throws JedisException {
		Jedis j = getJedis();
		boolean isException = false;
		try {
			j.subscribe(jedisPubSub, channels);
		} catch (Exception e) {
			returnBrokenResource(j);
			isException = true;
			throw new JedisException(e);
		} finally {
			if (!isException) {
				returnResource(j);
			}

		}
	}

	/**
	 * 订阅给定的一个或多个频道的信息
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @throws JedisException
	 */
	public static void psubscribe(JedisPubSub jedisPubSub, String... patterns) throws JedisException {
		Jedis j = getJedis();
		boolean isException = false;
		try {
			j.psubscribe(jedisPubSub, patterns);
		} catch (Exception e) {
			returnBrokenResource(j);
			isException = true;
			throw new JedisException(e);
		} finally {
			if (!isException) {
				returnResource(j);
			}

		}
	}

	/**
	 * 订阅给定的一个或多个频道的信息
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @throws JedisException
	 */
	public static void psubscribe(BinaryJedisPubSub jedisPubSub, byte[] patterns) throws JedisException {
		Jedis j = getJedis();
		boolean isException = false;
		try {
			j.psubscribe(jedisPubSub, patterns);
		} catch (Exception e) {
			returnBrokenResource(j);
			isException = true;
			throw new JedisException(e);
		} finally {
			if (!isException) {
				returnResource(j);
			}

		}
	}
}