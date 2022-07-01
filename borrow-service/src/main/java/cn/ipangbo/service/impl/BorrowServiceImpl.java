package cn.ipangbo.service.impl;

import cn.ipangbo.entity.Book;
import cn.ipangbo.entity.Borrow;
import cn.ipangbo.entity.User;
import cn.ipangbo.entity.UserBorrowDetailVO;
import cn.ipangbo.mapper.BorrowMapper;
import cn.ipangbo.service.BorrowService;
import cn.ipangbo.service.client.BookClient;
import cn.ipangbo.service.client.UserClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Resource
    BorrowMapper borrowMapper;

    @Resource
    UserClient userClient;

    @Resource
    BookClient bookClient;

    @Override
    public UserBorrowDetailVO getUserBorrowDetailByUid(int uid) {
        List<Borrow> borrows = borrowMapper.getBorrowsByUid(uid);

        User user = userClient.findUserById(uid);

        List<Book> bookList = borrows
                .stream()
                .map(borrow -> bookClient.findBookById(borrow.getBid()))
                .collect(Collectors.toList());

        return new UserBorrowDetailVO(user, bookList);
    }
}
