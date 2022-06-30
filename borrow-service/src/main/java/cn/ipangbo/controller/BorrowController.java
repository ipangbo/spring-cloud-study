package cn.ipangbo.controller;

import cn.ipangbo.entity.UserBorrowDetailVO;
import cn.ipangbo.service.BorrowService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BorrowController {
    @Resource
    BorrowService borrowService;

    @GetMapping("/borrow/{uid}")
    UserBorrowDetailVO findUserBorrows(@PathVariable int uid) {
        return borrowService.getUserBorrowDetailByUid(uid);
    }

}
