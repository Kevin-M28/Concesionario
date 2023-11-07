package Models;

import jakarta.persistence.*;

@Entity(name = "User")
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 50)
    private String username;
    @Column(length = 50)
    private String password;
    @Column(length = 50)
    private String e_mail;
    @Enumerated(EnumType.STRING)
    private Role role;

    public User() {
        String username = "";
        String password = "";
        String e_mail = "";
        Role role = Role.ADMIN;
    }

    public User(String username, String password, String e_mail, Role role) {
        this.username = username;
        this.password = password;
        this.e_mail = e_mail;
        this.role = role;
    }

    public int getId() {
        return id;
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

    public String getE_mail() {
        return e_mail;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
