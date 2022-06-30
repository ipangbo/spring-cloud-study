package cn.ipangbo.mapper;

import cn.ipangbo.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BookMapper {

    @Select("SELECT * FROM DB_BOOK WHERE BID=#{BID}")
    Book getBookById(int bid);
}
