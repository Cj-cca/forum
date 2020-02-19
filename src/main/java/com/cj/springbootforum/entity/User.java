package com.cj.springbootforum.entity;

public class User {
    private Integer id;
    private String name;
    private String tel;
    private String password;
    private String encipheredMessage;  //加密信息
    private String headLink;   //头像

    //这个空构造方法是用来以免存入空的数据在数据库中出现错误
    public User(){
        this.id = 0;
        this.name = "";
        this.tel = "";
        this.password = "";
        this.encipheredMessage = "";
        this.headLink = "";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncipheredMessage() {
        return encipheredMessage;
    }

    public void setEncipheredMessage(String encipheredMessage) {
        this.encipheredMessage = encipheredMessage;
    }

    public String getHeadLink() {
        return headLink;
    }

    public void setHeadLink(String headLink) {
        this.headLink = headLink;
    }
}
