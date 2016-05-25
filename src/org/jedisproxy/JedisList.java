package org.jedisproxy;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.BinaryClient.LIST_POSITION;

/**
 * @author wuxiaodong
 * @function jedis List操作
 * @time 2012-7-13 下午06:32:46
 */
public class JedisList extends JedisSource {

	/**
	 * 往集合key中加入成员value,插入在链表头部,如果key不存在，则新建key
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @throws JedisException
	 */
	public static long lpush(String key, String value) throws JedisException {
		return getJProxy().lpush(key, value);
	}

	/**
	 * 往集合key中加入成员value,插入在链表尾部，如果key不存在，则新建key
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @throws JedisException
	 */
	public static long rpush(String key, String value) throws JedisException {
		return getJProxy().rpush(key, value);
	}

	/**
	 * 往集合key中加入成员value,插入在链表头部,如果key不存在，则不做任何操作
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @throws JedisException
	 */
	public static long lpushx(String key, String value) throws JedisException {
		return getJProxy().lpushx(key, value);
	}

	/**
	 * 往集合key中加入成员value,插入在链表尾部,如果key不存在，则不做任何操作
	 * 
	 * @param key
	 * @param value
	 * @return
	 * @throws JedisException
	 */
	public static long rpushx(String key, String value) throws JedisException {
		return getJProxy().rpushx(key, value);
	}

	/**
	 * 获取key集合中第一个元素
	 * 
	 * @param key
	 * @return
	 * @throws JedisException
	 */
	public static String lpop(String key) throws JedisException {
		return getJProxy().lpop(key);
	}

	/**
	 * 获取key 集合中最后一个元素
	 * 
	 * @param key
	 * @return
	 * @throws JedisException
	 */
	public static String rpop(String key) throws JedisException {
		return getJProxy().rpop(key);
	}

	/**
	 * 返回指定范围内元素的列表 参数start和end都是0-based。即0表示链表头部(leftmost)的第一个元素。其中start的值也可以为负值，-1将表示链表中的最后一个元素，即尾部元素，-2表示倒数第二个并以此类推
	 * 
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 * @throws JedisException
	 */
	public static List<String> lrange(String key, int start, int end) throws JedisException {
		return getJProxy().lrange(key, start, end);
	}

	/***
	 * 统计key集合个数
	 * 
	 * @param key
	 * @return
	 * @throws JedisException
	 */
	public static long llen(String key) throws JedisException {
		return getJProxy().llen(key);
	}

	/**
	 * 从头部(left)向尾部(right)变量链表，删除count个值等于value的元素，返回值为实际删除的数量
	 * 
	 * @param key
	 * @param count
	 * @param value
	 * @return
	 * @throws JedisException
	 */
	public static long lrem(String key, long count, String value) throws JedisException {
		return getJProxy().lrem(key, count, value);
	}

	/**
	 * 将key集合index位置的值修改为value，如果成功则返回“OK”
	 * 
	 * @param key
	 * @param index
	 * @param value
	 * @throws JedisException
	 */
	public static String lset(String key, long index, String value) throws JedisException {
		return getJProxy().lset(key, index, value);
	}

	/**
	 * 返回key集合index位置的元素
	 * 
	 * @param key
	 * @param index
	 * @return
	 * @throws JedisException
	 */
	public static String lindex(String key, long index) throws JedisException {
		return getJProxy().lindex(key, index);
	}

	/**
	 * 集合key中,在pivot元素后插入value元素
	 * 
	 * @param key
	 * @param pivot
	 * @param value
	 * @throws JedisException
	 */
	public static long linsert4after(String key, String pivot, String value) throws JedisException {
		return getJProxy().linsert(key, LIST_POSITION.AFTER, pivot, value);
	}

	/**
	 * 集合key中,在pivot元素前插入value元素
	 * 
	 * @param key
	 * @param pivot
	 * @param value
	 * @throws JedisException
	 */
	public static long linsert4before(String key, String pivot, String value) throws JedisException {
		return getJProxy().linsert(key, LIST_POSITION.BEFORE, pivot, value);
	}

	/**
	 * 原子性的从与source键关联的链表尾部弹出一个元素，同时再将弹出的元素插入到与destination键关联的链表的头部。 如果source键不存在，该命令将返回nil，同时不再做任何其它的操作了。
	 * 如果source和destination是同一个键，则相当于原子性的将其关联链表中的尾部元素移到该链表的头部。 如果srckey与dstkey为同一个值，则集合尾部元素移到头部
	 * 
	 * @param srckey
	 * @param dstkey
	 * @return
	 * @throws JedisException
	 */
	public static String rpoplpush(String srckey, String dstkey) throws JedisException {
		Jedis j = getJedis();
		boolean isException = false;
		try {
			return j.rpoplpush(srckey, dstkey);
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
