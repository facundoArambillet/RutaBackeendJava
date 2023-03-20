package com.platzimarket.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Purchase {
    private int idPurchase;
    private String idClient;
    private LocalDateTime date;
    private String paymentMethod;
    private String comment;
    private String state;

    private List<PurchaseItem> items;

    public int getIdPurcharse() {
        return idPurchase;
    }

    public void setIdPurcharse(int idPurcharse) {
        this.idPurchase = idPurcharse;
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<PurchaseItem> getItems() {
        return items;
    }

    public void setItems(List<PurchaseItem> items) {
        this.items = items;
    }
}
