package team.redrock.shorturl1.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import team.redrock.shorturl1.entity.IdToUrl;

public interface UrlMapper {

    @Select("select * from id_url where id=#{id}")
    IdToUrl selectById(String id);


    @Insert("insert into id_url (id,url,password) values(#{id},#{url},#{password})")
    int insertOne(IdToUrl idToUrl);


}
