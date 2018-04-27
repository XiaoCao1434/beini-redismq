package com.beini.redismq.thread;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.beini.redismq.util.RedisClusterUtil;
@Component
public class SendThread {
	/*@Resource(name = "beiniRedisUtil")
	private BeiniAllRedisUtil redisUtil;*/
	@Autowired
	private RedisClusterUtil redisClasterUtil;
	public void execute(String id) {
		new Worker(id).start();
	}
	
	 // 线程内部类，Thread或者Runnable均可
    private class Worker extends Thread {
    	private String id="1";
    	public Worker(String id) {
    		this.id = id;
    	}
        @Override
        public void run() {
        	for (int i = 1; i <= 250; i++) {
        		redisClasterUtil.set(id+"  "+i, "" + (i + 300000));
    		}
        }
    }
    
}
