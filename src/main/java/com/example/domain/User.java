package com.example.domain;


import org.hibernate.validator.constraints.NotEmpty;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table( name="users" )
public class User {

    @Id @GeneratedValue
    private Long id;

    @NotEmpty(message = "Podaj imie")
    private String name;

    @NotEmpty(message = "Podaj nazwisko")
    private String surname;

    @NotEmpty( message = "Pole Login nie moze byc puste")
    @Size(min = 5, max = 15, message = "pole Login musi zawierac od 5 do 15 znaków")
    @Column(unique = true, nullable = false)
    private String login;

    @NotEmpty(message = "Pole Hasło nie może być puste")
    @Column( nullable = false)
    private String password;

    @NotEmpty(message = "Pole EMAIL nie może byc puste")
    @Column( nullable = false)
    private String email;

    @ManyToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> roles = new HashSet<Role>();


    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                '}';
    }
}
