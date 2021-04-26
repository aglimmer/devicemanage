package com.testcase.user;

import java.sql.Timestamp;
import java.util.Date;

public class UserTest {
    private Long id;
    private String nickname;
    private String username;
    private String password;
    private String mailbox;
    private String phone;
    private Timestamp createTime;
    private String avatarUrl;
    private Date birth;
    private String sex;
    private String state;
    private String salt;
    private Integer level;
    private boolean deleted;

	@Override
	public String toString() {
		return "UserTest{" +
				"id=" + id +
				", nickname='" + nickname + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", mailbox='" + mailbox + '\'' +
				", phone='" + phone + '\'' +
				", createTime=" + createTime +
				", avatarUrl='" + avatarUrl + '\'' +
				", birth=" + birth +
				", sex='" + sex + '\'' +
				", state='" + state + '\'' +
				", salt='" + salt + '\'' +
				", level=" + level +
				", deleted=" + deleted +
				'}';
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
