package com.dechichi.spring.web.DAO;

import com.dechichi.spring.web.validations.ValidEmail;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Created by gabriel on 10/03/16.
 */
public class User {

    @NotBlank()
    @Size(min=8, max=15)
    @Pattern(regexp="^\\w{8,}$")
    private String username;

    @NotBlank()
    @Pattern(regexp="^\\S+$")
    @Size(min=8, max=15)
    private String password;

    @NotBlank()
    @Size(min=8, max=60)
    private String name;

    @ValidEmail
    private String email;

    private boolean enabled = false;
    private String authority;
    public User(){

    }

    public User(String username, String password, String name, String email, boolean enabled, String authority) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.enabled = enabled;
        this.authority = authority;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (isEnabled() != user.isEnabled()) return false;
        if (!getUsername().equals(user.getUsername())) return false;
        if (getName() != null ? !getName().equals(user.getName()) : user.getName() != null) return false;
        if (getEmail() != null ? !getEmail().equals(user.getEmail()) : user.getEmail() != null) return false;
        return getAuthority() != null ? getAuthority().equals(user.getAuthority()) : user.getAuthority() == null;

    }

    @Override
    public int hashCode() {
        int result = getUsername().hashCode();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (isEnabled() ? 1 : 0);
        result = 31 * result + (getAuthority() != null ? getAuthority().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                ", authority='" + authority + '\'' +
                '}';
    }
}
