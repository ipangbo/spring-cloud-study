package cn.ipangbo.mapper;

import cn.ipangbo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM DB_USER WHERE UID = #{UID}")
    User getUserById(int uid);
}
