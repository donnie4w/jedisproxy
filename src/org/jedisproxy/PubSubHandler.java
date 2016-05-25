package org.jedisproxy;

import redis.clients.jedis.Client;
import redis.clients.jedis.JedisPubSub;

public class PubSubHandler extends JedisPubSub {

	@Override
	public void unsubscribe() {
		super.unsubscribe();
	}

	@Override
	public void unsubscribe(String... channels) {
		super.unsubscribe(channels);
	}

	@Override
	public void subscribe(String... channels) {
		super.subscribe(channels);
	}

	@Override
	public void psubscribe(String... patterns) {
		super.psubscribe(patterns);
	}

	@Override
	public void punsubscribe() {
		super.punsubscribe();
	}

	@Override
	public void punsubscribe(String... patterns) {
		super.punsubscribe(patterns);
	}

	@Override
	public boolean isSubscribed() {
		return super.isSubscribed();
	}

	@Override
	public void proceedWithPatterns(Client client, String... patterns) {
		super.proceedWithPatterns(client, patterns);
	}

	@Override
	public void proceed(Client client, String... channels) {
		super.proceed(client, channels);
	}

	@Override
	public int getSubscribedChannels() {
		return super.getSubscribedChannels();
	}

	@Override
	public void onMessage(String channel, String message) {
		System.out.println(channel + " -->1 " + message);
	}

	@Override
	public void onPMessage(String pattern, String channel, String message) {
		System.out.println(channel + " -->2 " + message);
	}

	@Override
	public void onSubscribe(String channel, int subscribedChannels) {
		System.out.println(channel + " -->3 " + subscribedChannels);
	}

	@Override
	public void onUnsubscribe(String channel, int subscribedChannels) {
	}

	@Override
	public void onPUnsubscribe(String pattern, int subscribedChannels) {
	}

	@Override
	public void onPSubscribe(String pattern, int subscribedChannels) {
	}

	public static void main(String[] args) throws Exception {
		// PubSubHandler jedisPubSub = new PubSubHandler();
		// PubSub.subscribe(jedisPubSub, "news.test2");
		PubSub.publish("news.test2", "wuxiaodong2");
	}
}