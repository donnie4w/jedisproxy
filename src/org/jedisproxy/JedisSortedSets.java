package org.jedisproxy;

import java.util.Set;

/**
 * @author wuxiaodong
 * @function jedis对Sorted-Sets 的操作
 * @time 2012-7-13 下午09:32:35
 */
public class JedisSortedSets extends JedisSource {

	/**
	 * 添加一个分数为score的成员。 如果键不存在，该命令将为该键创建一个新的Sorted-Sets Value 并将score/member对插入其中。 如果该键已经存在，但是与其关联的Value不是Sorted-Sets类型， 相关的错误信息将被返回
	 * 
	 * @param key
	 * @param score
	 * @param member
	 * @return
	 * @throws JedisException
	 */
	public static long zadd(String key, long score, String member) throws JedisException {
		return getJProxy().zadd(key, score, member);
	}

	/**
	 * 获取myzset键中成员的数量
	 * 
	 * @param key
	 * @return
	 * @throws JedisException
	 */
	public static long zcard(String key) throws JedisException {
		return getJProxy().zcard(key);
	}

	/**
	 * 返回 start,end 之间的成员 0表示第一个成员，-1表示最后一个成员。
	 * 
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 * @throws JedisException
	 */
	public static Set<String> zrange(String key, int start, int end) throws JedisException {
		return getJProxy().zrange(key, start, end);
	}

	/**
	 * 返回与myzset关联的Sorted-Set中，分数满足表达式min <= score <= max的成员的数量
	 * 
	 * @param key
	 * @param min
	 * @param max
	 * @return
	 * @throws JedisException
	 */
	public static long zcount(String key, double min, double max) throws JedisException {
		return getJProxy().zcount(key, min, max);
	}

	/**
	 * 返回与myzset关联的Sorted-Set中，分数满足表达式min <= score <= max的成员列表
	 * 
	 * @param key
	 * @param min
	 * @param max
	 * @return
	 * @throws JedisException
	 */
	public static Set<String> zrangeByScore(String key, String min, String max) throws JedisException {
		return getJProxy().zrangeByScore(key, min, max);
	}

	/**
	 * 将成员member的分数增加score，并返回该成员更新后的分数
	 * 
	 * @param key
	 * @param score
	 * @param member
	 * @throws JedisException
	 */
	public static double zincrby(String key, double score, String member) throws JedisException {
		return getJProxy().zincrby(key, score, member);
	}

	/**
	 * 获取成员member在Sorted-Set中的位置索引值。如返回0则表示第一个位置
	 * 
	 * @param key
	 * @param member
	 * @return
	 * @throws JedisException
	 */
	public static long zrank(String key, String member) throws JedisException {
		return getJProxy().zrank(key, member);
	}

	/**
	 * 删除集合中member元素
	 * 
	 * @param key
	 * @param member
	 * @return
	 * @throws JedisException
	 */
	public static long zrem(String key, String member) throws JedisException {
		return getJProxy().zrem(key, member);
	}

	/**
	 * 由于是从高到低的排序，返回成员列表
	 * 
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 * @throws JedisException
	 */
	public static Set<String> zrevrange(String key, int start, int end) throws JedisException {
		return getJProxy().zrevrange(key, start, end);
	}

	/**
	 * 由于是从高到低的排序，返回member的位置
	 * 
	 * @param key
	 * @param member
	 * @throws JedisException
	 */
	public static long zrevrank(String key, String member) throws JedisException {
		return getJProxy().zrevrank(key, member);
	}

	/**
	 * 获取分数满足表达式max >= score >= min的成员，并以相反的顺序输出，即从高到底的顺序
	 * 
	 * @param key
	 * @param max
	 * @param min
	 * @return
	 * @throws JedisException
	 */
	public static Set<String> zrevrangeByScore(String key, String max, String min) throws JedisException {
		return getJProxy().zrevrangeByScore(key, max, min);
	}

	/**
	 * 删除分数满足表达式start <= score <= end的成员，并返回实际删除的数量
	 * 
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 * @throws JedisException
	 */
	public static long zremrangeByScore(String key, double start, double end) throws JedisException {
		return getJProxy().zremrangeByScore(key, start, end);
	}

	/**
	 * 删除位置索引满足表达式start <= rank <= end的成员
	 * 
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 * @throws JedisException
	 */
	public static long zremrangeByRank(String key, int start, int end) throws JedisException {
		return getJProxy().zremrangeByRank(key, start, end);
	}
}
