package com.cj.springbootforum.dao;

import com.cj.springbootforum.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    String TABLE_NAME = "user";
    String INSERT_FILDS = "name,password,tel,encipheredMessage,headLink";

    @Select("select * from"+TABLE_NAME+"where tel=#{tel}")
    User getUserById();

    @Insert("insert into"+TABLE_NAME+"("+INSERT_FILDS+") values (#{name},#{password},#{tel},#{encipheredMessage},#{headLink})")
    void addUser(User user);
}
