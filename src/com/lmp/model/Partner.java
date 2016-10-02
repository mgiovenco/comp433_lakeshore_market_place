package com.lmp.model;

import java.sql.Timestamp;

/**
 * This class represents Partner information.
 */

public class Partner {

    private int Id;
    private String PartnerName;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String phone;
    private String email;
    private boolean active;
    private Timestamp createdOn;
    private Timestamp updatedOn;

    public Partner(String PartnerName, String addressLine1, String addressLine2, String city, String state, String postalCode, String country, String phone, String email, boolean active) {
        this.PartnerName = PartnerName;
this.addressLine1 = addressLine1;
this.addressLine2 = addressLine2;
this.city = city;
this.state = state;
this.postalCode = postalCode;
this.country = country;
this.phone = phone;
        this.email = email;
        this.active = active;
    }

    public Partner(int Id, String PartnerName, String addressLine1, String addressLine2, String city, String state, String postalCode, String country, String phone, String email, boolean active) {
        this.Id = Id;
        this.PartnerName = PartnerName;
this.addressLine1 = addressLine1;
this.addressLine2 = addressLine2;
this.city = city;
this.state = state;
this.postalCode = postalCode;
this.country = country;
this.phone = phone;
        this.email = email;
        this.active = active;
    }

    public Partner(int Id, String PartnerName, String addressLine1, String addressLine2, String city, String state, String postalCode, String country, String phone, String email, boolean active, Timestamp createdOn, Timestamp updatedOn) {
        this.Id = Id;
        this.PartnerName = PartnerName;
this.addressLine1 = addressLine1;
this.addressLine2 = addressLine2;
this.city = city;
this.state = state;
this.postalCode = postalCode;
this.country = country;
this.phone = phone;
        this.email = email;
        this.active = active;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public int getId() {
        return Id;
    }

    public String getPartnerName() {
        return PartnerName;
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

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return active;
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
        if (!(o instanceof Partner)) return false;

        Partner partner = (Partner) o;

        if (getId() != partner.getId()) return false;
        if (isActive() != partner.isActive()) return false;
        if (getPartnerName() != null ? !getPartnerName().equals(partner.getPartnerName()) : partner.getPartnerName() != null) return false;
        if (getAddressLine1() != null ? !getAddressLine1().equals(partner.getAddressLine1()) : partner.getAddressLine1() != null) return false;
        if (getAddressLine2() != null ? !().equals(partner.getAddressLine2()) : partner.getAddressLine2() != null) return false;
        if (getEmail() != null ? !getEmail().equals(partner.getEmail()) : partner.getEmail() != null) return false;
        if (getCity() != null ? !getCity().equals(partner.getCity()) : partner.getCity() != null) return false;
        if (getState() != null ? !getState().equals(partner.getState()) : partner.getState() != null) return false;
        if (getPostalCode() != null ? !getPostalCode().equals(partner.getPostalCode()) : partner.getPostalCode() != null) return false;
        if (getCountry() != null ? !getCountry().equals(partner.getCountry()) : partner.getCountry() != null) return false;
        if (getPhone() != null ? !getPhone().equals(partner.getPhone()) : partner.getPhone() != null) return false;
        if (getCreatedOn() != null ? !getCreatedOn().equals(partner.getCreatedOn()) : partner.getCreatedOn() != null) return false;
        return getUpdatedOn() != null ? getUpdatedOn().equals(partner.getUpdatedOn()) : partner.getUpdatedOn() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getPartnerName() != null ? getPartnerName().hashCode() : 0);
        result = 31 * result + (getAddressLine1() != null ? getAddressLine1().hashCode() : 0);
        result = 31 * result + (getAddressLine2() != null ? getAddressLine2().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + (getState() != null ? getState().hashCode() : 0);
        result = 31 * result + (getPostalCode() != null ? getPostalCode().hashCode() : 0);
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (isActive() ? 1 : 0);
        result = 31 * result + (getCreatedOn() != null ? getCreatedOn().hashCode() : 0);
        result = 31 * result + (getUpdatedOn() != null ? getUpdatedOn().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Partner{" +
                "Id=" + Id +
                ", PartnerName='" + PartnerName + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", active=" + active +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}