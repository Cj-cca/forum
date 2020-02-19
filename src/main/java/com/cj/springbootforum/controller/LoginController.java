package com.cj.springbootforum.controller;

import com.cj.springbootforum.service.UserService;
import com.cj.springbootforum.util.ForumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public String register(@RequestParam("tel") String tel, @RequestParam("password") String password, HttpServletResponse httpServletResponse){
        try {
            Map<String,Object> map = userService.register(tel,password);
            if(map.get("token") != null){
                Cookie cookie = new Cookie("token",map.get("token").toString());
                cookie.setMaxAge(60 * 24 * 12);
                cookie.setPath("/");
                httpServletResponse.addCookie(cookie);
                return ForumUtil.toJSONString(200,map);
            }else {
                return ForumUtil.toJSONString(500,map);
            }
        }catch (Exception e){
            return ForumUtil.toJSONString(500,"注册失败");
        }
    }
}
