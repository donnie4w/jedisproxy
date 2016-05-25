package org.jedisproxy;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author wuxiaodong
 * @function jedis 中hset操作
 * @time 2012-7-13 下午07:03:59
 */
public class Jedishset extends JedisSource {

	/****
	 * 为指定的Key设定Field/Value对，如果Key不存在，该命令将创建新Key以参数中的Field/Value对， 如果参数中的Field在该Key中已经存在，则用新值覆盖其原有值。
	 * 
	 * @param key
	 * @param field
	 * @param value
	 * @return
	 * @throws JedisException
	 */
	public static long hset(String key, String field, String value) throws JedisException {
		return getJProxy().hset(key, field, value);
	}

	/**
	 * 只有当参数中的Key或Field不存在的情况下，为指定的Key设定Field/Value对，否则该命令不会进行任何操作
	 * 
	 * @param key
	 * @param field
	 * @param value
	 * @return
	 * @throws JedisException
	 */
	public static long hsetnx(String key, String field, String value) throws JedisException {
		return getJProxy().hsetnx(key, field, value);
	}

	/**
	 * 获取key集合field元素的值
	 * 
	 * @param key
	 * @param field
	 * @return
	 * @throws JedisException
	 */
	public static String hget(String key, String field) throws JedisException {
		return getJProxy().hget(key, field);
	}

	/***
	 * 判断key集合field元素是否存在
	 * 
	 * @param key
	 * @param field
	 * @return
	 * @throws JedisException
	 */
	public static boolean hexists(String key, String field) throws JedisException {
		return getJProxy().hexists(key, field);
	}

	/***
	 * 计算key集合filed个数
	 * 
	 * @param key
	 * @return
	 * @throws JedisException
	 */
	public static long hlen(String key) throws JedisException {
		return getJProxy().hlen(key);
	}

	/**
	 * 删除key集合中field元素 如果没filed值返回0。
	 * 
	 * @param key
	 * @param field
	 * @return
	 * @throws JedisException
	 */
	public static long hdel(String key, String field) throws JedisException {
		return getJProxy().hdel(key, field);
	}

	/**
	 * 给key的field字段的值加value，返回加后的结果 如hincrby myhash field -10 给myhash的field字段的值加-10，返回加后的结果
	 * 
	 * @param key
	 * @param field
	 * @param value
	 * @return
	 * @throws JedisException
	 */
	public static long hincrBy(String key, String field, long value) throws JedisException {
		return getJProxy().hincrBy(key, field, value);
	}

	/**
	 * 返回key集合中field的列表集合
	 * 
	 * @param key
	 * @return
	 * @throws JedisException
	 */
	public static Set<String> hkeys(String key) throws JedisException {
		return getJProxy().hkeys(key);
	}

	/**
	 * 获取 key集合中 field/value 的键值对
	 * 
	 * @param key
	 * @return
	 * @throws JedisException
	 */
	public static Map<String, String> hgetall(String key) throws JedisException {
		return getJProxy().hgetAll(key);
	}

	/**
	 * 获取key键的多个字段的值
	 * 
	 * @param key
	 * @param fields
	 * @return
	 * @throws JedisException
	 */
	public static List<String> hmget(String key, String[] fields) throws JedisException {
		return getJProxy().hmget(key, fields);
	}

	/**
	 * 仅获取key键中所有字段的值。
	 * 
	 * @param key
	 * @param field
	 * @throws JedisException
	 */
	public static List<String> hvals(String key, String field) throws JedisException {
		return getJProxy().hvals(key);
	}

	public static void main(String[] args) {
		try {
			Jedishset.hset("2012", "wu", "wuxiaodong");
//			JedisUtil.expire("2012", TimeUnit.toSecond(10, TimeUnit.SECOND));
			System.out.println(Jedishset.hget("2012", "wu"));
		} catch (JedisException e) {
		}
	}
}
