package com.testcase.user01;

/**
 * @Author WangZeng
 * @Date 2021-04-25 21:31
 */
public class UserEntity {
    private String userId;
    private String userPasswd;
    private String userName;
    private String userType;
    private String userAcademy;
    private String userEmail;
    private String userPhone;
    public UserEntity() {
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId='" + userId + '\'' +
                ", userPasswd='" + userPasswd + '\'' +
                ", userName='" + userName + '\'' +
                ", userType='" + userType + '\'' +
                ", userAcademy='" + userAcademy + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userPhone='" + userPhone + '\'' +
                '}';
    }

    /**
     * 后面的setter与getter都是通过快捷键生成
     **/
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPasswd() {
        return userPasswd;
    }

    public void setUserPasswd(String userPasswd) {
        this.userPasswd = userPasswd;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserAcademy() {
        return userAcademy;
    }

    public void setUserAcademy(String userAcademy) {
        this.userAcademy = userAcademy;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}
