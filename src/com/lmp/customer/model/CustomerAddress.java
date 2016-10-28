package com.lmp.customer.model;

import java.sql.Timestamp;

/**
 * Class to represent either a customer billing address and/or shipping address.
 */
public class CustomerAddress {
    private int id;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private boolean billingAddress;
    private boolean shippingAddress;
    private boolean active;
    private int customerId;
    private Timestamp createdOn;
    private Timestamp updatedOn;

    public CustomerAddress(String addressLine1, String addressLine2, String city, String state, String postalCode, String country, boolean billingAddress, boolean shippingAddress, boolean active, int customerId) {
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.active = active;
        this.customerId = customerId;
    }

    public CustomerAddress(int id, String addressLine1, String addressLine2, String city, String state, String postalCode, String country, boolean billingAddress, boolean shippingAddress, boolean active, int customerId) {
        this.id = id;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.active = active;
        this.customerId = customerId;
    }

    public CustomerAddress(int id, String addressLine1, String addressLine2, String city, String state, String postalCode, String country, boolean billingAddress, boolean shippingAddress, boolean active, int customerId, Timestamp createdOn, Timestamp updatedOn) {
        this.id = id;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.active = active;
        this.customerId = customerId;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public int getId() {
        return id;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCountry() {
        return country;
    }

    public boolean isBillingAddress() {
        return billingAddress;
    }

    public boolean isShippingAddress() {
        return shippingAddress;
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
        if (!(o instanceof CustomerAddress)) return false;

        CustomerAddress that = (CustomerAddress) o;

        if (getId() != that.getId()) return false;
        if (isBillingAddress() != that.isBillingAddress()) return false;
        if (isShippingAddress() != that.isShippingAddress()) return false;
        if (isActive() != that.isActive()) return false;
        if (getCustomerId() != that.getCustomerId()) return false;
        if (getAddressLine1() != null ? !getAddressLine1().equals(that.getAddressLine1()) : that.getAddressLine1() != null)
            return false;
        if (getAddressLine2() != null ? !getAddressLine2().equals(that.getAddressLine2()) : that.getAddressLine2() != null)
            return false;
        if (getCity() != null ? !getCity().equals(that.getCity()) : that.getCity() != null) return false;
        if (getState() != null ? !getState().equals(that.getState()) : that.getState() != null) return false;
        if (getPostalCode() != null ? !getPostalCode().equals(that.getPostalCode()) : that.getPostalCode() != null)
            return false;
        if (getCountry() != null ? !getCountry().equals(that.getCountry()) : that.getCountry() != null) return false;
        if (getCreatedOn() != null ? !getCreatedOn().equals(that.getCreatedOn()) : that.getCreatedOn() != null)
            return false;
        return getUpdatedOn() != null ? getUpdatedOn().equals(that.getUpdatedOn()) : that.getUpdatedOn() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getAddressLine1() != null ? getAddressLine1().hashCode() : 0);
        result = 31 * result + (getAddressLine2() != null ? getAddressLine2().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + (getState() != null ? getState().hashCode() : 0);
        result = 31 * result + (getPostalCode() != null ? getPostalCode().hashCode() : 0);
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        result = 31 * result + (isBillingAddress() ? 1 : 0);
        result = 31 * result + (isShippingAddress() ? 1 : 0);
        result = 31 * result + (isActive() ? 1 : 0);
        result = 31 * result + getCustomerId();
        result = 31 * result + (getCreatedOn() != null ? getCreatedOn().hashCode() : 0);
        result = 31 * result + (getUpdatedOn() != null ? getUpdatedOn().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CustomerAddress{" +
                "id=" + id +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", billingAddress=" + billingAddress +
                ", shippingAddress=" + shippingAddress +
                ", active=" + active +
                ", customerId=" + customerId +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
