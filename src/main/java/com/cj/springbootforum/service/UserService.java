package com.cj.springbootforum.service;

import com.cj.springbootforum.dao.LoginTokenDao;
import com.cj.springbootforum.dao.UserDao;
import com.cj.springbootforum.entity.LoginToken;
import com.cj.springbootforum.entity.User;
import com.cj.springbootforum.util.ForumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    @Autowired
    LoginTokenDao loginTokenDao;

    public Map<String, Object> register(String tel, String password) {
        Map<String,Object> map = new HashMap<>();
        if(tel == null || "".equals(tel)){
            map.put("message","手机号不能为空");
            return map;
        }
        if(tel.length() != 11){
            map.put("message","手机号不正确");
            return map;
        }
        if(password == null || "".equals(password)){
            map.put("message","密码不能为空");
            return map;
        }
        if(password.length()<6){
            map.put("message","密码至少是六位数");
            return map;
        }
        User user = userDao.getUserById();
        if(tel.equals(user.getTel())){
            map.put("message","手机号已注册");
            return map;
        }
        user = new User();
        String encipheredMessage = ForumUtil.getRandomUUID().substring(0,6);
        user.setEncipheredMessage(encipheredMessage);
        user.setTel(tel);
        user.setPassword(ForumUtil.MD5((password+encipheredMessage).getBytes()));
        String token = addToken(tel);
        map.put("token",token);
        return map;
    }

    private String addToken(String tel){
        String token = ForumUtil.getRandomUUID();
        long indate = new Date().getTime() + 1000 * 3600 * 24 * 10;
        LoginToken loginToken = new LoginToken();
        loginToken.setTel(tel);
        loginToken.setToken(token);
        loginToken.setIndate(new Date(indate));
        loginTokenDao.addLoginToken(loginToken);
        return token;
    }
}
