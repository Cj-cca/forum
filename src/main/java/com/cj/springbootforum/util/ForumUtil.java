package com.cj.springbootforum.util;


import com.alibaba.fastjson.JSONObject;

import java.util.Map;
import java.util.UUID;

public class ForumUtil {

    public static String toJSONString(Integer code){
        JSONObject root = new JSONObject();
        root.put("code",code);
        return root.toJSONString();

    }

    public static String toJSONString(Integer code, String message){
        JSONObject root = new JSONObject();
        root.put("code",code);
        root.put("message",message);
        return root.toJSONString();

    }

    public static String toJSONString(Integer code, Map<String,Object> map){
        JSONObject root = new JSONObject();
        root.put("code",code);
        for (Map.Entry<String,Object> entry : map.entrySet()) {
            root.put(entry.getKey(),entry.getValue());
        }
        return root.toJSONString();
    }

    public static String getRandomUUID() {
        return UUID.randomUUID().toString().replace("_","");
    }

    public static String MD5(byte[] byteArray) {

        // 首先初始化一个字符数组，用来存放每个16进制字符
        char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'A','B','C','D','E','F' };
        // new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））
        char[] resultCharArray =new char[byteArray.length * 2];
        // 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
        int index = 0;
        for (byte b : byteArray) {
            resultCharArray[index++] = hexDigits[b>>> 4 & 0xf];
            resultCharArray[index++] = hexDigits[b& 0xf];
        }
        // 字符数组组合成字符串返回
        return new String(resultCharArray);
    }
}
