package cn.ipangbo.mapper;

import cn.ipangbo.entity.Borrow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BorrowMapper {

    @Select("SELECT * FROM DB_BORROW WHERE UID=#{UID}")
    List<Borrow> getBorrowsByUid(int uid);

    @Select("SELECT * FROM DB_BORROW WHERE BID=#{BID}")
    List<Borrow> getBorrowByBid(int bid);

    @Select("SELECT * FROM DB_BORROW WHERE UID=#{UID} AND BID=#{BID}")
    Borrow getBorrow(int uid, int bid);
}
