package com.zhoukun.managementbackground.platform.user.pojo;

/**
 * @description：TODO
 * @author： sc
 * @create： 2024/1/30 17:47
 */
public class UserLoginInfo {

    private String loginType;

    private String account;

    private String password;

    private String telephone;

    private String verificationCode;

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }
}
