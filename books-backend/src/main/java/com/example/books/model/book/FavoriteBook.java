package com.example.books.model.book;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
public class FavoriteBook {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="member_id")
    private Long id;

    @Column(name="first_name")
    @NotEmpty(message="* Please Enter First Name")
    private String userId;

    @Column(name="last_name")
    @NotEmpty(message="* Please Enter Last Name")
    private String googleBookId;

}