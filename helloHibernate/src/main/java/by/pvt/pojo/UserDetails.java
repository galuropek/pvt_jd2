package by.pvt.pojo;

import java.sql.Timestamp;

public class UserDetails {

    private long id;
    private String password;
    private Timestamp expiratedDate;
    private int loginAttempts;

    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getExpiratedDate() {
        return expiratedDate;
    }

    public void setExpiratedDate(Timestamp expiratedDate) {
        this.expiratedDate = expiratedDate;
    }

    public int getLoginAttempts() {
        return loginAttempts;
    }

    public void setLoginAttempts(int loginAttempts) {
        this.loginAttempts = loginAttempts;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
