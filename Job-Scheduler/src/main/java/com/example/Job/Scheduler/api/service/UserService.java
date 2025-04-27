package com.example.Job.Scheduler.api.service;


import com.example.Job.Scheduler.api.dao.UserDao;
import com.example.Job.Scheduler.api.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class UserService {

    @Autowired
    private UserDao dao;

    Logger log = LoggerFactory.getLogger(UserService.class);

    //sceduler job add object in db (Every 5 sec)

    @Scheduled(fixedRate = 5000)
    public void add2DBJob() {
        User user = new User();
        user.setName("aman" + new Random().nextInt(374483));
        dao.save(user);
        System.out.println("add service called in " + new Date().toString());
    }

    //eachh 15 second
    @Scheduled(cron = "0/15 * * * * *")
    public void fetchDB() {
        List<User> users = dao.findAll();
        System.out.println("Fetch Servidce Called " + users);
        System.out.println("No of Recores Found" + users.size());
        log.info("users:{}", users);
    }

}
