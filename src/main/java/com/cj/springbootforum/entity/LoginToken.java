package com.cj.springbootforum.entity;

import javax.xml.crypto.Data;
import java.util.Date;

public class LoginToken {
    private Integer id;
    private String tel;
    private String token;
    private Integer status;
    private Date indate;  //有效期

    public LoginToken() {
        this.id = 0;
        this.tel = "";
        this.token = "";
        this.status = null;
        this.indate = null;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getIndate() {
        return indate;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }
}
