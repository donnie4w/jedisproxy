package org.jedisproxy;

import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * @author wuxiaodong
 * @function jedis的set操作
 * @time 2012-7-13 下午06:33:21
 */
public class JedisSet extends JedisSource {

	/**
	 * 往集合key插入value值
	 * 
	 * @param key
	 * @param value
	 * @throws JedisException
	 */
	public static long sadd(String key, String value) throws JedisException {
		return getJProxy().sadd(key, value);
	}

	/**
	 * 获取key集合成员变量的数量
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @throws JedisException
	 */
	public static long scard(String key) throws JedisException {
		return getJProxy().scard(key);
	}

	/**
	 * 判断成员变量是否存在于集合中
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @throws JedisException
	 */
	public static boolean sismember(String key, String value) throws JedisException {
		return getJProxy().sismember(key, value);
	}

	/**
	 * 返回key集合元素
	 * 
	 * @param key
	 * @return
	 * @throws JedisException
	 */
	public static Set<String> smembers(String key) throws JedisException {
		return getJProxy().smembers(key);
	}

	/**
	 * 将成员member 从srckey中移除
	 * 
	 * @param srckey
	 * @param member
	 * @return
	 * @throws JedisException
	 */
	public static long smove(String srckey, String member) throws JedisException {
		Jedis j = getJedis();
		boolean isException = false;
		try {
			return j.smove(srckey, "", member);
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
	 * keys的差集
	 * 
	 * @param keys
	 * @throws JedisException
	 */
	public static Set<String> sdiff(String[] keys) throws JedisException {
		Jedis j = getJedis();
		boolean isException = false;
		try {
			return j.sdiff(keys);
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
	 * keys的差集存放到dstkey中
	 * 
	 * @throws JedisException
	 */
	public static long sdiffstore(String dstkey, String[] keys) throws JedisException {
		Jedis j = getJedis();
		boolean isException = false;
		try {
			return j.sdiffstore(dstkey, keys);
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
	 * keys的交集
	 * 
	 * @param keys
	 * @return
	 * @throws JedisException
	 */
	public static Set<String> sinter(String[] keys) throws JedisException {
		Jedis j = getJedis();
		boolean isException = false;
		try {
			return j.sinter(keys);
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
	 * keys的交集存放到dstkey中
	 * 
	 * @throws JedisException
	 */
	public static long sinterstore(String dstkey, String[] keys) throws JedisException {
		Jedis j = getJedis();
		boolean isException = false;
		try {
			return j.sinterstore(dstkey, keys);
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
	 * keys的并集
	 * 
	 * @param keys
	 * @return
	 * @throws JedisException
	 */
	public static Set<String> sunion(String[] keys) throws JedisException {
		Jedis j = getJedis();
		boolean isException = false;
		try {
			return j.sunion(keys);
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
	 * keys的并集存放到dstkey中
	 * 
	 * @throws JedisException
	 */
	public static long sunionstore(String dstkey, String[] keys) throws JedisException {
		Jedis j = getJedis();
		boolean isException = false;
		try {
			return j.sunionstore(dstkey, keys);
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
