package Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "wlg", catalog = "")
public class UserEnity {
    private String username;
    private String password;

    @Id
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEnity userEnity = (UserEnity) o;
        return Objects.equals(username, userEnity.username) &&
                Objects.equals(password, userEnity.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password);
    }
}
