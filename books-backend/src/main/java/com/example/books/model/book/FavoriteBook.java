package com.example.books.model.book;

import javax.persistence.*;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class FavoriteBook {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String userId;
    private String googleBookId;
    private String title;
    private String authors;
    private String link;
    private String imgSmallThumbnail;
    private String imgThumbnail;

    @Column(length = 4000)
    @Size(max = 4000)
    private String description;
}