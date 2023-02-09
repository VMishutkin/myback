package ru.skypro.homework.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ads")
public class Ads {

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    @Id
    @GeneratedValue
    private Integer pk;
    private int price;
    private String title;
    @Lob
    private byte[] image;

}
