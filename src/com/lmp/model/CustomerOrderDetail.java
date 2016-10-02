package com.lmp.model;

import java.sql.Timestamp;

/**
 * Class represents a customer order detail.
 */
public class CustomerOrderDetail {

    private int id;
    private int customerOrderId;
    private int productId;
    private Timestamp createdOn;
    private Timestamp updatedOn;

    public CustomerOrderDetail(int id, int customerOrderId, int productId, Timestamp createdOn, Timestamp updatedOn) {
        this.id = id;
        this.customerOrderId = customerOrderId;
        this.productId = productId;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public CustomerOrderDetail(int customerOrderId, int productId) {
        this.customerOrderId = customerOrderId;
        this.productId = productId;
    }

    public int getId() {
        return id;
    }

    public int getCustomerOrderId() {
        return customerOrderId;
    }

    public int getProductId() {
        return productId;
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
        if (!(o instanceof CustomerOrderDetail)) return false;

        CustomerOrderDetail that = (CustomerOrderDetail) o;

        if (getId() != that.getId()) return false;
        if (getCustomerOrderId() != that.getCustomerOrderId()) return false;
        if (getProductId() != that.getProductId()) return false;
        if (getCreatedOn() != null ? !getCreatedOn().equals(that.getCreatedOn()) : that.getCreatedOn() != null)
            return false;
        return getUpdatedOn() != null ? getUpdatedOn().equals(that.getUpdatedOn()) : that.getUpdatedOn() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getCustomerOrderId();
        result = 31 * result + getProductId();
        result = 31 * result + (getCreatedOn() != null ? getCreatedOn().hashCode() : 0);
        result = 31 * result + (getUpdatedOn() != null ? getUpdatedOn().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CustomerOrderDetail{" +
                "id=" + id +
                ", customerOrderId=" + customerOrderId +
                ", productId=" + productId +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
