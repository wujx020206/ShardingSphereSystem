package com.shardingjdbc.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.shardingjdbc.entity.Attendance;
import com.shardingjdbc.mapper.AttendanceMapper;
import com.shardingjdbc.service.AttendanceService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class AttendanceServiceImpl extends ServiceImpl<AttendanceMapper, Attendance> implements AttendanceService {

}
