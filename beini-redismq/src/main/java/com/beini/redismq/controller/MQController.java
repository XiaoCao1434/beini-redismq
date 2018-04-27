package com.beini.redismq.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.beini.redismq.thread.SendThread;

@RestController
public class MQController {
	@Autowired
	private SendThread sendThread;

	@GetMapping("/mqs")
	public String mqs() {
		long begin = 0, end = 0;
		begin = new Date().getTime();
		for (int i = 1; i <= 600; i++) {
			sendThread.execute(i+"  ");
		}
		end = new Date().getTime();
		System.out.println((end - begin) + "---------------------------------------------------------------- s");
		return "success";
	}
}
