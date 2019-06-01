package com.example.books.model.test;

import javax.persistence.*;

import lombok.Data;

@Data
@Entity
public class Arquivo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private byte[] file;

    @ManyToOne(fetch = FetchType.EAGER)
    private Incidente incident;
   
}