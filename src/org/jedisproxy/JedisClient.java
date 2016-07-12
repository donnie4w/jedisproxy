/**
 * Project Name:jedisproxy
 * File Name:JedisClient.java
 * Package Name:org.jedisproxy
 * Date:2016年7月11日上午12:43:04
 * Copyright (c) 2016, donnie4w@gmail.com All Rights Reserved.
 *
 */

package org.jedisproxy;

import redis.clients.jedis.Jedis;

/**
 * ClassName:JedisClient <br/>
 * Date: 2016年7月11日 上午12:43:04 <br/>
 * 
 * @author dong
 * @version
 * @since JDK 1.7
 * @desc
 */
public class JedisClient extends Jedis implements Commands {
	Jedis j;

	public JedisClient(Jedis j) {
		this.j = j;
	}

	public Jedis getJedis() {
		return j;
	}
}
