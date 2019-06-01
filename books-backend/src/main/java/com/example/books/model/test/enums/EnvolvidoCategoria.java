package com.example.books.model.test.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum EnvolvidoCategoria {
    COLABORADOR("Colaborador", "Colaborador"), 
    CLIENTE("Cliente", "Cliente"), 
    FORNECEDOR("Fornecedor", "Fornecedor"), 
    PARCEIRO("Parceiro", "Parceiro");

    private String value;
    private String label;

    EnvolvidoCategoria(String value, String label) {
        this.value = value;
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }
}
