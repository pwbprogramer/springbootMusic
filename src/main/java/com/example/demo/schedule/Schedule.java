package com.example.demo.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
//@Component
public class Schedule {

	  public final static long SECOND = 1 * 1000;
	  SimpleDateFormat fdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	 
	 
	  @Scheduled(fixedDelay = SECOND * 2)
	  public void fixedDelayJob() throws InterruptedException {
	    TimeUnit.SECONDS.sleep(2);
	    System.out.println("[FixedDelayJob Execute]"+fdf.format(new Date())+"==========================================================");
	  }
}
