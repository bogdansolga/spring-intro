package net.safedata.spring.intro.service;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ScheduledTask {

    //@Scheduled(fixedDelay = 5000)
    public void process() {
        System.out.println("do something at " + new Date());
    }
}
