package com.shardingjdbc.controller;

import com.shardingjdbc.entity.Attendance;
import com.shardingjdbc.service.AttendanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.Random;

@RestController
@RequestMapping("/attendance")
@Slf4j
public class AttendanceController {

    @Resource
    private AttendanceService attendanceService;

    @GetMapping("/list")
    public Object list() {
        return attendanceService.list();
    }

    @GetMapping("/add")
    public Object addOrders() {
        Random random = new Random();
        for (int i = 1; i <= 10; i++) {
            Attendance attendance = new Attendance();
            attendance.setUserId(random.nextInt(100));
            attendance.setSiteName(i + "-厦门市思明区万象城");
            attendance.setAccessDate(new Date());
            attendance.setInsertTime(new Date());
            attendanceService.save(attendance);
        }
        return "finish";
    }
}
