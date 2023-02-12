package ru.skypro.homework.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "comment")
public class Comment {
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User user;
    private String createdAt;
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pk;
    private String text;

    @ManyToOne
    @JoinColumn(name = "ad_pk")
    private Ad ad;


}
