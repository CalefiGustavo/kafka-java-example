package br.com.paygo.kafka.models;

import java.math.BigDecimal;
import java.util.List;

public class Order {

    private String documentNumber;

    private Boolean active;

    private List<Partner> partners;

    public Order(String userId, Boolean active, List<Partner> partners) {
        this.documentNumber = userId;
        this.active = active;
        this.partners = partners;
    }

}
