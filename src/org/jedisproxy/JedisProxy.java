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
			result = method.invoke(target, args);
		} catch (Exception e) {
			isException = true;
			returnBrokenResource((Jedis) target);
			throw new JedisException(e);
		} finally {
			if (!isException) {
				returnResource((Jedis) target);
			}
		}
		return result;
	}
}
