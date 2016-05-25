package org.jedisproxy;

import redis.clients.jedis.Jedis;

/**
 * @author wuxiaodong
 * @function jedis的String 操作
 * @time 2012-7-13 下午06:33:39
 */
public class JedisString extends JedisSource {
	/**
	 * 如果该Key已经存在，APPEND命令将参数Value的数据追加到已存在Value的末尾。 如果该Key不存在，APPEND命令将会创建一个新的Key/Value。
	 * 
	 * @throws JedisException
	 */
	public static long append(String key, String value) throws JedisException {
		return getJProxy().append(key, value);
	}

	/**
	 * 设定该Key持有指定的字符串Value，如果该Key已经存在，则覆盖其原有值
	 * 
	 * @param key
	 * @param value
	 * @throws JedisException
	 */
	public static String set(String key, String value) throws JedisException {
		return getJProxy().set(key, value);
	}

	/**
	 * 设定该Key持有指定的字符串Value，如果该Key已经存在，则不做任何操作
	 * 
	 * @param key
	 * @param value
	 * @throws JedisException
	 */
	public static long setnx(String key, String value) throws JedisException {
		return getJProxy().setnx(key, value);
	}

	/**
	 * 获取指定Key的Value。如果与该Key关联的Value不是string类型，Redis将返回错误信息， 因为GET命令只能用于获取string Value
	 * 
	 * @param key
	 * @return String
	 * @throws JedisException
	 */
	public static String get(String key) throws JedisException {
		return getJProxy().get(key);
	}

	/**
	 * 在获取计数器原有值的同时，并将其设置为新值，这两个操作原子性的同时完成
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @throws JedisException
	 */
	public static String getAndSet(String key, String value) throws JedisException {
		return getJProxy().getSet(key, value);
	}

	/**
	 * 返回指定Key的字符值长度，如果Value不是string类型，Redis将执行失败并给出相关的错误信息
	 * 
	 * @param key
	 * @return long
	 * @throws JedisException
	 */
	public static long strlen(String key) throws JedisException {
		Jedis j = getJedis();
		boolean isException = false;
		try {
			return j.strlen(key);
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
	 * 同时设置该Key在Redis服务器中的存活时间(秒数)。
	 * 
	 * @param key
	 * @param seconds
	 * @param value
	 * @throws JedisException
	 */
	public static String setex(String key, int seconds, String value) throws JedisException {
		return getJProxy().setex(key, seconds, value);
	}

	/**
	 * 将指定Key的Value原子性的递减1。如果该Key不存在，其初始值为0，在decr之后其值为-1。如果Value的值不能转换为整型值， 如Hello，该操作将执行失败并返回相应的错误信息
	 * 
	 * @param key
	 * @throws JedisException
	 */
	public static long decr(String key) throws JedisException {
		return getJProxy().decr(key);
	}

	/**
	 * 将指定Key的Value原子性的递增1。如果该Key不存在，其初始值为0，在incr之后其值为1。如果Value的值不能转换为整型值， 如Hello，该操作将执行失败并返回相应的错误信息
	 * 
	 * @param key
	 * @throws JedisException
	 */
	public static long incr(String key) throws JedisException {
		return getJProxy().incr(key);
	}

	public static void main(String[] args) {
		// String ret = JedisString.get("abc");
		// if (ret == null) {
		// System.out.println("ret is null");
		// }
		// if ("".equals(ret)) {
		// System.out.println("ret is empty");
		// }
		// System.out.println(ret);
		try {
			JedisString.set("abc", "wuxiaodongwellwellwell");
			// JedisString.set("json5", "<input id=\"abc\" />");
			System.out.println(JedisString.get("abc"));
		} catch (JedisException e) {
			e.printStackTrace();
		}

	}
}
