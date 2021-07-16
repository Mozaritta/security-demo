package com.security.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Table(name = "AUTH_AUTHORITY")
@Entity
public class Authority implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "ROLE_CODE")
    private String roleCode;

    @Column(name = "ROLE_DESCRIPTION")
    private String roleDescription;

    @Override
    public String getAuthority() {
        return roleCode;
    }

    public long getId() {
        return id;
    }
}
