package com.lmp.customer.model;

import java.sql.Timestamp;

/**
 * Class to represent a customer billing information (credit card + expiration date)
 */
public class CustomerBillingInfo {

    private int id;
    private String creditCardNumber;
    private String creditCardExpiration; // mmyy
    private boolean active;
    private Timestamp createdOn;
    private Timestamp updatedOn;
    private int customerId;

    public CustomerBillingInfo(int id, String creditCardNumber, String creditCardExpiration, boolean active) {
        this.id = id;
        this.creditCardNumber = creditCardNumber;
        this.creditCardExpiration = creditCardExpiration;
        this.active = active;
    }

    public CustomerBillingInfo(String creditCardNumber, String creditCardExpiration, boolean active, int customerId) {
        this.creditCardNumber = creditCardNumber;
        this.creditCardExpiration = creditCardExpiration;
        this.active = active;
        this.customerId = customerId;
    }

    public CustomerBillingInfo(int id, String creditCardNumber, String creditCardExpiration, boolean active, Timestamp createdOn, Timestamp updatedOn, int customerId) {
        this.id = id;
        this.creditCardNumber = creditCardNumber;
        this.creditCardExpiration = creditCardExpiration;
        this.active = active;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
        this.customerId = customerId;
    }

    public int getId() {
        return id;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public String getCreditCardExpiration() {
        return creditCardExpiration;
    }

    public boolean isActive() {
        return active;
    }

    public int getCustomerId() {
        return customerId;
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
        if (!(o instanceof CustomerBillingInfo)) return false;

        CustomerBillingInfo that = (CustomerBillingInfo) o;

        if (getId() != that.getId()) return false;
        if (isActive() != that.isActive()) return false;
        if (getCustomerId() != that.getCustomerId()) return false;
        if (getCreditCardNumber() != null ? !getCreditCardNumber().equals(that.getCreditCardNumber()) : that.getCreditCardNumber() != null)
            return false;
        if (getCreditCardExpiration() != null ? !getCreditCardExpiration().equals(that.getCreditCardExpiration()) : that.getCreditCardExpiration() != null)
            return false;
        if (getCreatedOn() != null ? !getCreatedOn().equals(that.getCreatedOn()) : that.getCreatedOn() != null)
            return false;
        return getUpdatedOn() != null ? getUpdatedOn().equals(that.getUpdatedOn()) : that.getUpdatedOn() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getCreditCardNumber() != null ? getCreditCardNumber().hashCode() : 0);
        result = 31 * result + (getCreditCardExpiration() != null ? getCreditCardExpiration().hashCode() : 0);
        result = 31 * result + (isActive() ? 1 : 0);
        result = 31 * result + getCustomerId();
        result = 31 * result + (getCreatedOn() != null ? getCreatedOn().hashCode() : 0);
        result = 31 * result + (getUpdatedOn() != null ? getUpdatedOn().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CustomerBillingInfo{" +
                "id=" + id +
                ", creditCardNumber='" + creditCardNumber + '\'' +
                ", creditCardExpiration='" + creditCardExpiration + '\'' +
                ", active=" + active +
                ", customerId=" + customerId +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
