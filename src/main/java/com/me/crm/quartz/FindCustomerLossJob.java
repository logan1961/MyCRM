package com.me.crm.quartz;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FindCustomerLossJob {
	
	//0/30 * * * * ? 每隔30秒触发
	//0 0 1 1 * ?
	@Scheduled(cron="0/30 * * * * ?")//每月1号凌晨
	public void work() {
		System.err.println("FindCustomerLossJob.work()");
		
	}
}
