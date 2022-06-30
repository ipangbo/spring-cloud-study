package cn.ipangbo.service.impl;

import cn.ipangbo.entity.Book;
import cn.ipangbo.entity.Borrow;
import cn.ipangbo.entity.User;
import cn.ipangbo.entity.UserBorrowDetailVO;
import cn.ipangbo.mapper.BorrowMapper;
import cn.ipangbo.service.BorrowService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowServiceImpl implements BorrowService {
    @Resource
    BorrowMapper borrowMapper;

    @Override
    public UserBorrowDetailVO getUserBorrowDetailByUid(int uid) {
        List<Borrow> borrows = borrowMapper.getBorrowsByUid(uid);

        RestTemplate template = new RestTemplate();
        User user = template.getForObject("http://localhost:8101/user/" + uid, User.class);

        List<Book> bookList = borrows
                .stream()
                .map(borrow -> template.getForObject("http://localhost:8201/book/"+borrow.getBid(), Book.class))
                .collect(Collectors.toList());

        return new UserBorrowDetailVO(user, bookList);
    }
}
