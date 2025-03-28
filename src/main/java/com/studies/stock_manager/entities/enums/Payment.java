package com.studies.stock_manager.entities.enums;

public enum Payment {
    BANK_SLIP("Bank Slip"),
    CREDIT_CARD("Credit Card"),
    DEBIT_CARD("Debit Card");

    private String payment;

    Payment(String payment) {
        this.payment = payment;
    }

    public String getPayment() {
        return payment;
    }
}
