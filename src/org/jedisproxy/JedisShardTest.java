package org.jedisproxy;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.ShardedJedisPool;

public class JedisShardTest {
	public static List<JedisShardInfo> Shards = new ArrayList<JedisShardInfo>();
	public static JedisShardInfo shard1;
	public static JedisShardInfo shard2;
	public static ShardedJedisPool shardedJedisPool;
	public static Jedis jedis;
	static {
		shard1 = new JedisShardInfo("127.0.0.1", 6379, 2000, 2000, 1);
		shard1.setPassword("aaaaaaaaaa");
		shard2 = new JedisShardInfo("127.0.0.1", 6379, 2000, 2000, 6);
		shard2.setPassword("aaaaaaaaaa");
		Shards.add(shard1);
		Shards.add(shard2);
		createPool();
		jedis = shardedJedisPool.getResource().getShard("");
	}

	public static void createPool() {
		JedisPoolConfig jpc = new JedisPoolConfig();
		jpc.setMaxIdle(50);
		jpc.setTestOnBorrow(false);
		shardedJedisPool = new ShardedJedisPool(jpc, Shards);
	}

	public static Jedis getJedis() {
		return jedis;
	}

	public static Pipeline getPipeline() {
		return getJedis().pipelined();
	}

	public static void main(String[] args) throws Exception {
		JedisShardTest.jedis.set("test", "123456789");
		System.out.println(JedisShardTest.jedis.get("test"));
	}
}