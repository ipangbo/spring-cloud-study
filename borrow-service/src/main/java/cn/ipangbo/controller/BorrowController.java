package cn.ipangbo.controller;

import cn.ipangbo.entity.UserBorrowDetailVO;
import cn.ipangbo.service.BorrowService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;

@RestController
@Slf4j
public class BorrowController {
    @Resource
    BorrowService borrowService;

    @HystrixCommand(fallbackMethod = "onError")
    @GetMapping("/borrow/{uid}")
    UserBorrowDetailVO findUserBorrows(@PathVariable int uid) {
        return borrowService.getUserBorrowDetailByUid(uid);
    }

    UserBorrowDetailVO onError(int uid) {
        // 原先的500错误页面现在变成了服务降级的数据
        log.info("服务熔断，执行了补救措施");
        return new UserBorrowDetailVO(null, Collections.emptyList());
    }

}
