package web.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Name should not be empty")
    @Column(name = "surname")
    private String surname;

    @Email
    @NotEmpty(message = "Name should not be empty")
    @Column(name = "email")
    private String email;

    @NotEmpty(message = "Name should not be empty")
    @Column(name = "phoneNumber")
    private String phoneNumber;

    public User(String name, String surname, String email, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        final String pattern = "\\+7\\d{10}";

        if (phoneNumber.matches(pattern)) {
            this.phoneNumber = phoneNumber;
        }
    }
}
