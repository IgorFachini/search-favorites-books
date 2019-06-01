package com.example.books.model.test.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum EnvolvidoTipo {
    CITADO("Citado", "Citado"), 
    DENUNCIADO("Denunciado", "Denunciado"), 
    TESTEMUNHA("Testemunha", "Testemunha");

    private String value;
    private String label;

    EnvolvidoTipo(String value, String label) {
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
