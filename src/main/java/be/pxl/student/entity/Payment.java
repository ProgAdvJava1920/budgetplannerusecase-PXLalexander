package be.pxl.student.entity;

import java.util.Date;
import java.util.Objects;

public class Payment {

    private String iban;
    private Date date;
    private float amount;
    private String currency;
    private String detail;

    public Payment(String iban, Date date, float amount, String currency, String detail) {
        this.iban = iban;
        this.date = date;
        this.amount = amount;
        this.currency = currency;
        this.detail = detail;
    }

    public Date getDate() {
        return date;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban){
        this.iban = iban;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "{" +
                "IBAN=" + iban +
                ", date=" + date +
                ", amount=" + amount +
                ", currency='" + currency + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Float.compare(payment.amount, amount) == 0 &&
                iban.equals(payment.iban) &&
                date.equals(payment.date) &&
                currency.equals(payment.currency) &&
                Objects.equals(detail, payment.detail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, date, amount, currency, detail);
    }
}
