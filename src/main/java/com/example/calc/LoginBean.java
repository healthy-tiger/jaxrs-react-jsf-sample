package com.example.calc;

import java.util.Date;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;

import javax.servlet.http.HttpSession;
import javax.faces.context.FacesContext;

@Named
@SessionScoped
public class LoginBean implements Serializable {
    String userName = null;
    Date loginTime = null;

    Integer a = null;
    Integer b = null;

    @PostConstruct
    public void init() {
        userName = null;
        loginTime = new Date();
        a = Integer.valueOf((int)(100 * Math.random()));
        b = Integer.valueOf((int)(100 * Math.random()));
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public String login() {
        return "calc?faces-redirect=true";
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index?faces-redirect=true";
    }

    public Integer getA() {
        return a;
    }

    public Integer getB() {
        return b;
    }

    public String getSessionId() {
        return FacesContext.getCurrentInstance().getExternalContext().getSessionId(false);
    }
}

