package cn.ipangbo.service;

import cn.ipangbo.entity.UserBorrowDetailVO;

public interface BorrowService {

    UserBorrowDetailVO getUserBorrowDetailByUid(int uid);
}
