package com.lmp.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * This class represents order information.
 */
public class Order {

    private int id;
    private BigDecimal orderTotal;
    private String status;
    private Timestamp createdOn;
    private Timestamp updatedOn;
    private int billingInfoId;
    private int shippingInfoId;

    public int getId() {
        return id;
    }

    public BigDecimal getOrderTotal() {
        return orderTotal;
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

    public int getBillingInfoId() {
        return billingInfoId;
    }

    public int getShippingInfoId() {
        return shippingInfoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (getId() != order.getId()) return false;
        if (getBillingInfoId() != order.getBillingInfoId()) return false;
        if (getShippingInfoId() != order.getShippingInfoId()) return false;
        if (getOrderTotal() != null ? !getOrderTotal().equals(order.getOrderTotal()) : order.getOrderTotal() != null)
            return false;
        if (getStatus() != null ? !getStatus().equals(order.getStatus()) : order.getStatus() != null) return false;
        if (getCreatedOn() != null ? !getCreatedOn().equals(order.getCreatedOn()) : order.getCreatedOn() != null)
            return false;
        return getUpdatedOn() != null ? getUpdatedOn().equals(order.getUpdatedOn()) : order.getUpdatedOn() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getOrderTotal() != null ? getOrderTotal().hashCode() : 0);
        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
        result = 31 * result + (getCreatedOn() != null ? getCreatedOn().hashCode() : 0);
        result = 31 * result + (getUpdatedOn() != null ? getUpdatedOn().hashCode() : 0);
        result = 31 * result + getBillingInfoId();
        result = 31 * result + getShippingInfoId();
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderTotal=" + orderTotal +
                ", status='" + status + '\'' +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                ", billingInfoId=" + billingInfoId +
                ", shippingInfoId=" + shippingInfoId +
                '}';
    }
}
