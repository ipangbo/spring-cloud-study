package cn.ipangbo.controller;

import cn.ipangbo.entity.Book;
import cn.ipangbo.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BookController {
    @Resource
    BookService bookService;

    @GetMapping("/book/{bid}")
    Book findBookById(@PathVariable int bid) {
        return bookService.getBookById(bid);
    }
}
