package com.example.books.model.test.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum DenunciaAssunto {
    COMPORTAMENTAIS_DISCRIMINATORIAS("Comportamentais e discriminatórias", "Comportamentais e discriminatórias"),
    CONFLITOS_DE_INTERESSE("Conflitos de interesse", "Conflitos de interesse"),
    BRINDES_PRESENTES_ENTRETENIMENTO("Brindes, presentes e entretenimento", "Brindes, presentes e entretenimento"),
    SAUDE_SEGURANÇA_DO_TRABALHO("Saúde e segurança do trabalho", "Saúde e segurança do trabalho"),
    FURTOS_ROUBOS("Furtos e roubos", "Furtos e roubos"),
    FRAUDE_ENVOLVENDO_FORNECEDORES_CLIENTES("Fraude envolvendo fornecedores e clientes",
            "Fraude envolvendo fornecedores e clientes"),
    LAVAGEM_DE_DINHEIRO("Lavagem de dinheiro", "Lavagem de dinheiro"),
    FRAUDES_FINANCEIRAS("Fraudes financeiras", "Fraudes financeiras"), ANTITRUST("Antitrust", "Antitrust"),
    DIVULGAR_INFORMACOES_CONFIDENCIAIS("Divulgar informações confidenciais", "Divulgar informações confidenciais"),
    CORRUPCAO_ATIVA_PASSIVA("Corrupção ativa e passiva", "Corrupção ativa e passiva"),
    FRAUDE_LICITACAO("Fraude em licitação", "Fraude em licitação"),
    VIOLACOES_LEIS_AMBIENTAIS("Violações às leis ambientais", "Violações às leis ambientais");

    private String value;
    private String label;

    DenunciaAssunto(String value, String label) {
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
