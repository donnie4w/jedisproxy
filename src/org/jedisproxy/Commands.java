/**
 * Project Name:jedisproxy
 * File Name:Commands.java
 * Package Name:org.jedisproxy
 * Date:2016年7月11日上午1:09:06
 * Copyright (c) 2016, donnie4w@gmail.com All Rights Reserved.
 *
 */

package org.jedisproxy;

import redis.clients.jedis.AdvancedBinaryJedisCommands;
import redis.clients.jedis.BasicCommands;
import redis.clients.jedis.BinaryJedisCommands;
import redis.clients.jedis.BinaryScriptingCommands;
import redis.clients.jedis.JedisCommands;
import redis.clients.jedis.MultiKeyBinaryCommands;

/**
 * ClassName:Commands <br/>
 * Date: 2016年7月11日 上午1:09:06 <br/>
 * 
 * @author dong
 * @version
 * @since JDK 1.7
 * @desc
 */
public interface Commands extends JedisCommands, BasicCommands, BinaryJedisCommands, MultiKeyBinaryCommands, AdvancedBinaryJedisCommands, BinaryScriptingCommands {

}
