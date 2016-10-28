package com.lmp.order.model;

import java.math.BigDecimal;
import java.sql.Timestamp;


/**
 * Class represents a more detailed customer order, like what they would see on order confirmation screen.
 */
public class CustomerOrderComplete {

    private int id;
    private BigDecimal orderTotal;
    private String orderStatus;
    private String trackingId;
    private int customerId;
    private int billingInfoId;
    private int shippingInfoId;
    private Timestamp createdOn;
    private Timestamp updatedOn;

    private String billingAddressLine1;
    private String billingAddressLine2;
    private String billingCity;
    private String billingState;
    private String billingPostalCode;
    private String billingCountry;

    private String shippingAddressLine1;
    private String shippingAddressLine2;
    private String shippingCity;
    private String shippingState;
    private String shippingPostalCode;
    private String shippingCountry;

    public CustomerOrderComplete(int id, BigDecimal orderTotal, String orderStatus, String trackingId, int customerId, int billingInfoId, int shippingInfoId, Timestamp createdOn, Timestamp updatedOn, String billingAddressLine1, String billingAddressLine2, String billingCity, String billingState, String billingPostalCode, String billingCountry, String shippingAddressLine1, String shippingAddressLine2, String shippingCity, String shippingState, String shippingPostalCode, String shippingCountry) {
        this.id = id;
        this.orderTotal = orderTotal;
        this.orderStatus = orderStatus;
        this.trackingId = trackingId;
        this.customerId = customerId;
        this.billingInfoId = billingInfoId;
        this.shippingInfoId = shippingInfoId;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.billingAddressLine1 = billingAddressLine1;
        this.billingAddressLine2 = billingAddressLine2;
        this.billingCity = billingCity;
        this.billingState = billingState;
        this.billingPostalCode = billingPostalCode;
        this.billingCountry = billingCountry;
        this.shippingAddressLine1 = shippingAddressLine1;
        this.shippingAddressLine2 = shippingAddressLine2;
        this.shippingCity = shippingCity;
        this.shippingState = shippingState;
        this.shippingPostalCode = shippingPostalCode;
        this.shippingCountry = shippingCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerOrderComplete)) return false;

        CustomerOrderComplete that = (CustomerOrderComplete) o;

        if (id != that.id) return false;
        if (customerId != that.customerId) return false;
        if (billingInfoId != that.billingInfoId) return false;
        if (shippingInfoId != that.shippingInfoId) return false;
        if (orderTotal != null ? !orderTotal.equals(that.orderTotal) : that.orderTotal != null) return false;
        if (orderStatus != null ? !orderStatus.equals(that.orderStatus) : that.orderStatus != null) return false;
        if (trackingId != null ? !trackingId.equals(that.trackingId) : that.trackingId != null) return false;
        if (createdOn != null ? !createdOn.equals(that.createdOn) : that.createdOn != null) return false;
        if (updatedOn != null ? !updatedOn.equals(that.updatedOn) : that.updatedOn != null) return false;
        if (billingAddressLine1 != null ? !billingAddressLine1.equals(that.billingAddressLine1) : that.billingAddressLine1 != null)
            return false;
        if (billingAddressLine2 != null ? !billingAddressLine2.equals(that.billingAddressLine2) : that.billingAddressLine2 != null)
            return false;
        if (billingCity != null ? !billingCity.equals(that.billingCity) : that.billingCity != null) return false;
        if (billingState != null ? !billingState.equals(that.billingState) : that.billingState != null) return false;
        if (billingPostalCode != null ? !billingPostalCode.equals(that.billingPostalCode) : that.billingPostalCode != null)
            return false;
        if (billingCountry != null ? !billingCountry.equals(that.billingCountry) : that.billingCountry != null)
            return false;
        if (shippingAddressLine1 != null ? !shippingAddressLine1.equals(that.shippingAddressLine1) : that.shippingAddressLine1 != null)
            return false;
        if (shippingAddressLine2 != null ? !shippingAddressLine2.equals(that.shippingAddressLine2) : that.shippingAddressLine2 != null)
            return false;
        if (shippingCity != null ? !shippingCity.equals(that.shippingCity) : that.shippingCity != null) return false;
        if (shippingState != null ? !shippingState.equals(that.shippingState) : that.shippingState != null)
            return false;
        if (shippingPostalCode != null ? !shippingPostalCode.equals(that.shippingPostalCode) : that.shippingPostalCode != null)
            return false;
        return shippingCountry != null ? shippingCountry.equals(that.shippingCountry) : that.shippingCountry == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (orderTotal != null ? orderTotal.hashCode() : 0);
        result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
        result = 31 * result + (trackingId != null ? trackingId.hashCode() : 0);
        result = 31 * result + customerId;
        result = 31 * result + billingInfoId;
        result = 31 * result + shippingInfoId;
        result = 31 * result + (createdOn != null ? createdOn.hashCode() : 0);
        result = 31 * result + (updatedOn != null ? updatedOn.hashCode() : 0);
        result = 31 * result + (billingAddressLine1 != null ? billingAddressLine1.hashCode() : 0);
        result = 31 * result + (billingAddressLine2 != null ? billingAddressLine2.hashCode() : 0);
        result = 31 * result + (billingCity != null ? billingCity.hashCode() : 0);
        result = 31 * result + (billingState != null ? billingState.hashCode() : 0);
        result = 31 * result + (billingPostalCode != null ? billingPostalCode.hashCode() : 0);
        result = 31 * result + (billingCountry != null ? billingCountry.hashCode() : 0);
        result = 31 * result + (shippingAddressLine1 != null ? shippingAddressLine1.hashCode() : 0);
        result = 31 * result + (shippingAddressLine2 != null ? shippingAddressLine2.hashCode() : 0);
        result = 31 * result + (shippingCity != null ? shippingCity.hashCode() : 0);
        result = 31 * result + (shippingState != null ? shippingState.hashCode() : 0);
        result = 31 * result + (shippingPostalCode != null ? shippingPostalCode.hashCode() : 0);
        result = 31 * result + (shippingCountry != null ? shippingCountry.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CustomerOrderComplete{" +
                "id=" + id +
                ", orderTotal=" + orderTotal +
                ", orderStatus='" + orderStatus + '\'' +
                ", trackingId='" + trackingId + '\'' +
                ", customerId=" + customerId +
                ", billingInfoId=" + billingInfoId +
                ", shippingInfoId=" + shippingInfoId +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                ", billingAddressLine1='" + billingAddressLine1 + '\'' +
                ", billingAddressLine2='" + billingAddressLine2 + '\'' +
                ", billingCity='" + billingCity + '\'' +
                ", billingState='" + billingState + '\'' +
                ", billingPostalCode='" + billingPostalCode + '\'' +
                ", billingCountry='" + billingCountry + '\'' +
                ", shippingAddressLine1='" + shippingAddressLine1 + '\'' +
                ", shippingAddressLine2='" + shippingAddressLine2 + '\'' +
                ", shippingCity='" + shippingCity + '\'' +
                ", shippingState='" + shippingState + '\'' +
                ", shippingPostalCode='" + shippingPostalCode + '\'' +
                ", shippingCountry='" + shippingCountry + '\'' +
                '}';
    }
}
