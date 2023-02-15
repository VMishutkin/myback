package ru.skypro.homework.model.entity;

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
    private String image;
    @OneToMany(mappedBy = "ad")
    private List<Comment> comments;



    public void addComment(Comment comment){
        comments.add(comment);
    }
    public User getAuthor(){
        return author;
    }


    public void setAuthor(User author) {
        this.author = author;
    }

    public Integer getPk() {
        return pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
