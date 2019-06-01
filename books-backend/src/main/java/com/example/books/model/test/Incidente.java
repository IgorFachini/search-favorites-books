package com.example.books.model.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Size;

import com.example.books.model.test.enums.DenunciaAssunto;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Entity
public class Incidente {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private DenunciaAssunto complaintSubject;
    private Boolean notify;

    @Column(length = 4000)
    @Size(max = 4000)
    private String complaint;
   
    @OneToMany(fetch = FetchType.LAZY)
    private List<Arquivo> attachments;

    @ManyToOne(fetch = FetchType.EAGER)
    private Empresa company;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Envolvido> involved = new HashSet<>();


}