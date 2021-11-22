package com.grow.medicines.models;

import org.springframework.data.annotation.Id;

public class Medicine {
    @Id
    private String id;
    private String name;
    private Integer amount;
    private String recommendations;

    public Medicine(String id, String name, Integer amount, String recommendations) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.recommendations = recommendations;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }
}
