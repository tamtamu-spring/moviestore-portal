package com.devopsbuddy.devopsbuddy.web.controller.domain.frontend;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long role_id;

    @Column
    private String roleName;

    Role()
    {

    }

    public long getRole_id() {
        return role_id;
    }

    public void setRole_id(long role_id) {
        this.role_id = role_id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }






}
