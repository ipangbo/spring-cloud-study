package cn.ipangbo.service.impl;

import cn.ipangbo.entity.User;
import cn.ipangbo.mapper.UserMapper;
import cn.ipangbo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper mapper;

    @Override
    public User getUserById(int uid) {
        return mapper.getUserById(uid);
    }
}
