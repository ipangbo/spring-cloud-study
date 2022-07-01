package cn.ipangbo.service.client;

import cn.ipangbo.entity.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("bookservice")
public interface BookClient {

    @GetMapping("/book/{bid}")
    Book findBookById(@PathVariable int bid);
}
