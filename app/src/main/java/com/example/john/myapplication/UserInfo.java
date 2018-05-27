package com.example.john.myapplication;

/**
 * Created by john on 2018/4/1.
 */

public class UserInfo {

    /**
     * user_type_id : 2
     * mobile : 17858939031
     * password : 123456
     * device_id : 2
     * version_number : 1.1.9
     */

    private int user_type_id;
    private String mobile;
    private String password;
    private int device_id;
    private String version_number;

    public int getUser_type_id() {
        return user_type_id;
    }

    public void setUser_type_id(int user_type_id) {
        this.user_type_id = user_type_id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDevice_id() {
        return device_id;
    }

    public void setDevice_id(int device_id) {
        this.device_id = device_id;
    }

    public String getVersion_number() {
        return version_number;
    }

    public void setVersion_number(String version_number) {
        this.version_number = version_number;
    }
}
