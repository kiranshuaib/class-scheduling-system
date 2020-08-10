package io.pragra.learning.classscheduling.entity;

import javax.persistence.*;

@Entity
@Table
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String title;
    private String imageUrl;

    public Instructor(String name, String title, String imageUrl) {
        this.name = name;
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public Instructor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
