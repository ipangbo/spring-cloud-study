package cn.ipangbo.service.impl;

import cn.ipangbo.entity.Book;
import cn.ipangbo.mapper.BookMapper;
import cn.ipangbo.service.BookService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookServiceImpl implements BookService {
    @Resource
    BookMapper bookMapper;

    @Override
    public Book getBookById(int bid) {
        return bookMapper.getBookById(bid);
    }
}
