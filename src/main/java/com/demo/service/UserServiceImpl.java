package com.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.demo.entity.User;
import com.demo.mapper.UserMapper;

import org.springframework.stereotype.Service;




@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {


}



