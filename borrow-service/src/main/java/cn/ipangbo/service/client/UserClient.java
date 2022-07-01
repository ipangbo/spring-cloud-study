package cn.ipangbo.service.client;

import cn.ipangbo.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "userservice", fallback = UserFallbackClient.class)
public interface UserClient {

    @GetMapping("user/{uid}")
    public User findUserById(@PathVariable("uid") int uid);
}
