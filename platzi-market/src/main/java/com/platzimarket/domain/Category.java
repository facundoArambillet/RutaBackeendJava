package com.platzimarket.domain;

public class Category {
    private int idCategory;
    private String description;

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    private boolean active;

    public int getIdCategory() {
        return idCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
