package com.soen387.a2.dataobject;

import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

/**
 * @author: Jingchao Zhang
 * @createDate: 2019/11/05
 **/

@Entity
@DynamicInsert
public class UserInfo {

    @Id
    private Integer id;

    @Column(length = 64, nullable = false)
    private String username;

    @Column(length = 128, nullable = false)
    private String password;

    @Column()
    private String sessionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
}

