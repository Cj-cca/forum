package com.cj.springbootforum;

import com.cj.springbootforum.util.ForumUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootForumApplicationTests {

    @Test
    void contextLoads() {
        String str = "zhangsan";
        ForumUtil.MD5(str.getBytes());
        System.out.println(ForumUtil.MD5(str.getBytes()));
    }

}
