package org.jedisproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import redis.clients.jedis.Jedis;

public class JedisProxy extends JedisSource implements InvocationHandler {
	private Object target;

	public static JedisProxy newInstance() {
		return new JedisProxy();
	}

	public Object bind(Object target) {
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		boolean isException = false;
		try {
			if (target instanceof JedisClient) {
				result = method.invoke(((JedisClient) target).getJedis(), args);
			} else {
				result = method.invoke(target, args);
			}
		} catch (Exception e) {
			isException = true;
			if (target instanceof JedisClient) {
				returnBrokenResource(((JedisClient) target).getJedis());
			} else if (target instanceof Jedis) {
				returnBrokenResource(((Jedis) target));
			}
			throw new JedisException(e);
		} finally {
			if (!isException) {
				if (target instanceof JedisClient) {
					returnResource(((JedisClient) target).getJedis());
				} else if (target instanceof Jedis) {
					returnResource((Jedis) target);
				}
			}
		}
		return result;
	}
}
