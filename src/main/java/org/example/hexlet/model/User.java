package org.example.hexlet.model;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {
    private Integer id;
    private String name;
    private String surname;
    private String email;

    public User(String name, String surname, String email){
        this.name = name;
        this.surname = surname;
        this.email = email;
    }
}
