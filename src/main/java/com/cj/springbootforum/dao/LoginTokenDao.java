package com.cj.springbootforum.dao;

import com.cj.springbootforum.entity.LoginToken;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginTokenDao {

    String TABLE_NAME = "loginToken";
    String INSERT_FILDS = "tel,token,status,indate";

    @Select("select * from"+TABLE_NAME+"where tel=#{tel}")
    LoginToken getLoginTokenById();

    @Insert("insert into"+TABLE_NAME+"("+INSERT_FILDS+") values (#{tel},#{token},#{status},#{indate})")
    void addLoginToken(LoginToken loginToken);
}
