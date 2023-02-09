
package ru.skypro.homework.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private LocalDate regDate;
    private String city;


    @OneToMany(mappedBy = "user")
    private List<Comment> comments;
    @OneToMany//(mappedBy = "author")
    private List<Ads> ads;
    @Lob
    private byte[] image;

}

