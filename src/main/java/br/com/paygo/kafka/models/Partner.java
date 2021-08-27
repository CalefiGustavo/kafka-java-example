package br.com.paygo.kafka.models;

import java.math.BigDecimal;

public class Partner {

    private String documentNumber;

    private String type;

    private String status;

    private String name;

    public Partner(String  documentNumber, String name, String type, String status) {
        this.documentNumber = documentNumber;
        this.name = name;
        this.type = type;
        this.status = status;
    }

}
