package com.example.books.model.test;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.example.books.model.test.enums.EnvolvidoCategoria;
import com.example.books.model.test.enums.EnvolvidoTipo;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
public class Envolvido {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private String area;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private EnvolvidoTipo type;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private EnvolvidoCategoria category;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Incidente> incident = new HashSet<>();
}