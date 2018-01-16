package com.devopsbuddy.devopsbuddy.web.controller.domain.frontend;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import sun.java2d.pipe.SpanShapeRenderer;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@Entity
public class User implements UserDetails{

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private long user_id;

@Column(name = "name")
private String userName;

@Column(name = "lastname")
private String user_lastname;

@Column(name = "email")
private String user_email;

@Column(name = "password")
private String user_password;

@Column(name = "account_expired")
private String accountExpired;

    public String getAccountExpired() {
        return accountExpired;
    }

    public void setAccountExpired(String accountExpired) {
        this.accountExpired = accountExpired;
    }
    @OneToMany(mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
private Set<PasswordResetToken> passwordResetTokens = new HashSet<>();


@JoinTable(
         name = "user_roles",
         joinColumns = @JoinColumn(name = "user_id"),
         inverseJoinColumns = @JoinColumn(name = "role_id"))
@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
private Set<Role> roles;

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return userName;
    }

    public void setUser_name(String user_name) {
        this.userName = user_name;
    }

    public String getUser_lastname() {
        return user_lastname;
    }

    public void setUser_lastname(String user_lastname) {
        this.user_lastname = user_lastname;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public Set<PasswordResetToken> getPasswordResetTokens() {
        return passwordResetTokens;
    }

    public void setPasswordResetTokens(Set<PasswordResetToken> passwordResetTokens) {
        this.passwordResetTokens = passwordResetTokens;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    User()
{

}

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<GrantedAuthority> authorities = new HashSet<>();
       roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRoleName())));
       return authorities;


    }

    @Override
    public String getPassword() {
        return user_password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
      return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
