package cn.ipangbo.controller;

import cn.ipangbo.entity.User;
import cn.ipangbo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {
    @Resource
    UserService userService;

    @GetMapping("user/{uid}")
    public User findUserById(@PathVariable("uid") int uid) {
        return userService.getUserById(uid);
    }
}
