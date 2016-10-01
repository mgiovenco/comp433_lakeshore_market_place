package com.lmp.model;

import java.sql.Timestamp;

/**
 * This class represents a payment on an order.
 */
public class Payment {

    private int id;
    private int customerOrderId;
    private String type;
    private String status;
    private Timestamp createdOn;
    private Timestamp updatedOn;

    public Payment(int id, int customerOrderId, String type, String status, Timestamp createdOn, Timestamp updatedOn) {
        this.id = id;
        this.customerOrderId = customerOrderId;
        this.type = type;
        this.status = status;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public Payment(int customerOrderId, String type, String status) {
        this.customerOrderId = customerOrderId;
        this.type = type;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getCustomerOrderId() {
        return customerOrderId;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public Timestamp getUpdatedOn() {
        return updatedOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;

        Payment payment = (Payment) o;

        if (getId() != payment.getId()) return false;
        if (getCustomerOrderId() != payment.getCustomerOrderId()) return false;
        if (getType() != null ? !getType().equals(payment.getType()) : payment.getType() != null) return false;
        if (getStatus() != null ? !getStatus().equals(payment.getStatus()) : payment.getStatus() != null) return false;
        if (getCreatedOn() != null ? !getCreatedOn().equals(payment.getCreatedOn()) : payment.getCreatedOn() != null)
            return false;
        return getUpdatedOn() != null ? getUpdatedOn().equals(payment.getUpdatedOn()) : payment.getUpdatedOn() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getCustomerOrderId();
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getCreatedOn() != null ? getCreatedOn().hashCode() : 0);
        result = 31 * result + (getUpdatedOn() != null ? getUpdatedOn().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", customerOrderId=" + customerOrderId +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
