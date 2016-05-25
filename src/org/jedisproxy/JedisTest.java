/**
 * Project Name:jedisproxy
 * File Name:JedisTest.java
 * Package Name:org.jedisproxy
 * Date:2016年5月26日上午12:36:57
 * Copyright (c) 2016, donnie4w@gmail.com All Rights Reserved.
 *
 */

package org.jedisproxy;

import redis.clients.jedis.JedisPoolConfig;

/**
 * ClassName:JedisTest <br/>
 * 
 * @version
 * @since JDK 1.7
 * @desc
 */
public class JedisTest {
	public static void main(String[] args) throws Exception {
		JedisPoolConfig jpc = new JedisPoolConfig();
		jpc.setMaxActive(100);
		jpc.setMaxIdle(50);
		jpc.setMaxWait(1000l);
		jpc.setTestOnBorrow(false);
		JedisSource.init(jpc, "127.0.0.1", 6379, 2000, "aaaaaaaaaa");
		JedisString.set("test", "123456");
		System.out.println(JedisString.get("test"));
	}
}
