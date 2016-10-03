package com.lmp.model;

import java.sql.Timestamp;

/**
 * This class represents Partner information.
 */

public class Partner {

    private int id;
    private String company_name;
    private String adress;
    private String city;
    private String state;
    private String postal_code;
    private String country;
    private String phone;
    private String URL;
    private String payment_methods;
    private String type;
    private String current_order;
    private String logo;
    private boolean active;
    private Timestamp createdOn;
    private Timestamp updatedOn;

    public Partner(String company_name, String adress, String city, String state, String postal_code, String country, String phone, String URL, String payment_methods, String type, String current_order, String logo, boolean active) {
        this.company_name = company_name;
        this.adress = adress;
        this.city = city;
        this.state = state;
        this.postal_code = postal_code;
        this.country = country;
        this.phone = phone;
    	this.URL = URL;
    	this.payment_methods = payment_methods;
    	this.type = type;
    	this.current_order = current_order;
    	this.logo = logo;
        this.active = active;
    }

    public Partner(int id, String company_name, String adress, String city, String state, String postal_code, String country, String phone, String URL, String payment_methods, String type, String current_order, String logo, boolean active) {
        this.id = id;
        this.company_name = company_name;
        this.adress = adress;
        this.city = city;
        this.state = state;
        this.postal_code = postal_code;
        this.country = country;
        this.phone = phone;
    	this.URL = URL;
    	this.payment_methods = payment_methods;
    	this.type = type;
    	this.current_order = current_order;
    	this.logo = logo;
        this.active = active;
    }

    public Partner(int id, String company_name, String adress, String city, String state, String postal_code, String country, String phone, String URL, String payment_methods, String type, String current_order, String logo, boolean active, Timestamp createdOn, Timestamp updatedOn) {
        this.id = id;
        this.company_name = company_name;
        this.adress = adress;
        this.city = city;
        this.state = state;
        this.postal_code = postal_code;
        this.country = country;
        this.phone = phone;
    	this.URL = URL;
    	this.payment_methods = payment_methods;
    	this.type = type;
    	this.current_order = current_order;
    	this.logo = logo;
        this.active = active;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public int getId() {
        return Id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public String getAdress() {
        return adress;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public String getCountry() {
        return country;

    public String getPhone() {
        return phone;
    }

    public String getURL() {
        return URL;
    }

    public String getPayment_methods() {
        return payment_methods;
    }
    public String getType() {
        return type;
    }
    public String getCurrent_order() {
        return current_order;
    }
    public String getLogo() {
        return logo;
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
        if (getCompany_name() != null ? !getCompany_name().equals(partner.getCompany_name()) : partner.getCompany_name() != null) return false;
        if (getAdress() != null ? !getAdress().equals(partner.getAdress()) : partner.getAdress() != null) return false;
        if (getCity() != null ? !getCity().equals(partner.getCity()) : partner.getCity() != null) return false;
        if (getState() != null ? !getState().equals(partner.getState()) : partner.getState() != null) return false;
        if (getPostal_code() != null ? !getPostal_code().equals(partner.getPostal_code()) : partner.getPostal_code() != null) return false;
        if (getCountry() != null ? !getCountry().equals(partner.getCountry()) : partner.getCountry() != null) return false;
        if (getPhone() != null ? !getPhone().equals(partner.getPhone()) : partner.getPhone() != null) return false;
        if (getURL() != null ? !getURL().equals(partner.getURL()) : partner.getURL() != null) return false;
        if (getPayment_methods() != null ? !getPayment_methods().equals(partner.getPayment_methods()) : partner.getPayment_methods() != null) return false;
        if (getType() != null ? !getType().equals(partner.getType()) : partner.getType() != null) return false;
        if (getCurrent_order() != null ? !getCurrent_order().equals(partner.getCurrent_order()) : partner.getCurrent_order() != null) return false;
        if (getLogo() != null ? !getLogo().equals(partner.getLogo()) : partner.getLogo() != null) return false;
        if (getCreatedOn() != null ? !getCreatedOn().equals(partner.getCreatedOn()) : partner.getCreatedOn() != null) return false;
        return getUpdatedOn() != null ? getUpdatedOn().equals(partner.getUpdatedOn()) : partner.getUpdatedOn() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getCompany_name() != null ? getCompany_name().hashCode() : 0);
        result = 31 * result + (getAdress() != null ? getAdress().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + (getState() != null ? getState().hashCode() : 0);
        result = 31 * result + (getPostal_code() != null ? getPostal_code().hashCode() : 0);
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        result = 31 * result + (getURL() != null ? getURL().hashCode() : 0);
        result = 31 * result + (getPayment_methods() != null ? getPayment_methods().hashCode() : 0);
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getCurrent_order() != null ? getCurrent_order().hashCode() : 0);
        result = 31 * result + (getLogo() != null ? getLogo().hashCode() : 0);
        result = 31 * result + (isActive() ? 1 : 0);
        result = 31 * result + (getCreatedOn() != null ? getCreatedOn().hashCode() : 0);
        result = 31 * result + (getUpdatedOn() != null ? getUpdatedOn().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Partner{" +
                "id=" + id +
                ", company_name='" + company_name + '\'' +
                ", adress='" + adress + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postal_code='" + postal_-code + '\'' +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                ", URL='" + URL + '\'' +
                ", payment_methods='" + payment_methods + '\'' +
                ", type='" + type + '\'' +
                ", current_order='" + current_order + '\'' +
                ", logo='" + logo + '\'' +
                ", active=" + active +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}
