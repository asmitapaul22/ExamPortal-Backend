package com.exam.entity;

import javax.persistence.*;

@Entity
public class UserRole {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private Long userRoleId;

//many UserRole can be assoiciated with one User
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    //many UserRole can be assoiciated with one Role
    @ManyToOne
    private Role role;

    public UserRole() {
    }

    public Long getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Long userRoleId) {
        this.userRoleId = userRoleId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
