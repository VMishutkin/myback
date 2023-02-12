package ru.skypro.homework.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "ads")
public class Ad {

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
    @OneToMany(mappedBy = "ad")
    private List<Comment> comments;



    public void addComment(Comment comment){
        comments.add(comment);
    }
    public User getAuthor(){
        return author;
    }

}
