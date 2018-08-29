package team.redrock.shorturl1.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import team.redrock.shorturl1.entity.User;
import team.redrock.shorturl1.entity.UserToId;

import java.util.List;

public interface UserMapper {

    @Insert("insert into user (username,password,limits) values (#{username},#{password},#{limits})")
    int insertOne(User user);

    @Select("select * from user where username=#{username}")
    User selectOneByUsername(String username);

    @Select("select * from user_id where username=#{username}")
    List<UserToId> selectAmoutOfUrl(String username);

    @Insert("insert into user_id (username,id) values (#{username},#{id})")
    int insertUser_ID(UserToId userToId);

}
