package com.lmp.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Class represents a customer order.
 */
public class CustomerOrder {

    private int id;
    private BigDecimal orderTotal;
    private String orderStatus;
    private String trackingId;
    private int customerId;
    private int billingInfoId;
    private int shippingInfoId;
    private Timestamp createdOn;
    private Timestamp updatedOn;

    public CustomerOrder(int id, BigDecimal orderTotal, String orderStatus, String trackingId, int customerId, int billingInfoId, int shippingInfoId, Timestamp createdOn, Timestamp updatedOn) {
        this.id = id;
        this.orderTotal = orderTotal;
        this.orderStatus = orderStatus;
        this.trackingId = trackingId;
        this.customerId = customerId;
        this.billingInfoId = billingInfoId;
        this.shippingInfoId = shippingInfoId;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public CustomerOrder(BigDecimal orderTotal, String orderStatus, String trackingId, int customerId, int billingInfoId, int shippingInfoId) {
        this.orderTotal = orderTotal;
        this.orderStatus = orderStatus;
        this.trackingId = trackingId;
        this.customerId = customerId;
        this.billingInfoId = billingInfoId;
        this.shippingInfoId = shippingInfoId;
    }

    public CustomerOrder(int id, BigDecimal orderTotal, String orderStatus, String trackingId, int customerId, int billingInfoId, int shippingInfoId) {
        this.id = id;
        this.orderTotal = orderTotal;
        this.orderStatus = orderStatus;
        this.trackingId = trackingId;
        this.customerId = customerId;
        this.billingInfoId = billingInfoId;
        this.shippingInfoId = shippingInfoId;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getBillingInfoId() {
        return billingInfoId;
    }

    public int getShippingInfoId() {
        return shippingInfoId;
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
        if (!(o instanceof CustomerOrder)) return false;

        CustomerOrder that = (CustomerOrder) o;

        if (getId() != that.getId()) return false;
        if (getCustomerId() != that.getCustomerId()) return false;
        if (getBillingInfoId() != that.getBillingInfoId()) return false;
        if (getShippingInfoId() != that.getShippingInfoId()) return false;
        if (getOrderTotal() != null ? !getOrderTotal().equals(that.getOrderTotal()) : that.getOrderTotal() != null)
            return false;
        if (getOrderStatus() != null ? !getOrderStatus().equals(that.getOrderStatus()) : that.getOrderStatus() != null)
            return false;
        if (getTrackingId() != null ? !getTrackingId().equals(that.getTrackingId()) : that.getTrackingId() != null)
            return false;
        if (getCreatedOn() != null ? !getCreatedOn().equals(that.getCreatedOn()) : that.getCreatedOn() != null)
            return false;
        return getUpdatedOn() != null ? getUpdatedOn().equals(that.getUpdatedOn()) : that.getUpdatedOn() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getOrderTotal() != null ? getOrderTotal().hashCode() : 0);
        result = 31 * result + (getOrderStatus() != null ? getOrderStatus().hashCode() : 0);
        result = 31 * result + (getTrackingId() != null ? getTrackingId().hashCode() : 0);
        result = 31 * result + getCustomerId();
        result = 31 * result + getBillingInfoId();
        result = 31 * result + getShippingInfoId();
        result = 31 * result + (getCreatedOn() != null ? getCreatedOn().hashCode() : 0);
        result = 31 * result + (getUpdatedOn() != null ? getUpdatedOn().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CustomerOrder{" +
                "id=" + id +
                ", orderTotal=" + orderTotal +
                ", orderStatus='" + orderStatus + '\'' +
                ", trackingId='" + trackingId + '\'' +
                ", customerId=" + customerId +
                ", billingInfoId=" + billingInfoId +
                ", shippingInfoId=" + shippingInfoId +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
