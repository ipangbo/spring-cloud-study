package cn.ipangbo.service.client;

import cn.ipangbo.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserFallbackClient implements UserClient {
    @Override
    public User findUserById(int uid) {
        log.info("执行了补救措施");
        User user = new User();
        user.setName("补救措施");
        return user;
    }
}
