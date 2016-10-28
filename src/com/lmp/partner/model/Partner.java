package com.lmp.partner.model;

/**
 * This class represents Partner information.
 */
public class Partner {

    private int id;
    private String companyName;
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private String phone;
    private String email;
    private String URL;
    private String logo;

    public Partner(int id, String companyName, String address, String city, String state, String postalCode, String country, String phone, String email, String URL, String logo) {
        this.id = id;
        this.companyName = companyName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.phone = phone;
        this.email = email;
        this.URL = URL;
        this.logo = logo;
    }

    public Partner(String companyName, String address, String city, String state, String postalCode, String country, String phone, String email, String URL, String logo) {
        this.companyName = companyName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
        this.phone = phone;
        this.email = email;
        this.URL = URL;
        this.logo = logo;
    }

    public int getId() {
        return id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getAddress() {
        return address;
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

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getURL() {
        return URL;
    }

    public String getLogo() {
        return logo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Partner)) return false;

        Partner partner = (Partner) o;

        if (getId() != partner.getId()) return false;
        if (getCompanyName() != null ? !getCompanyName().equals(partner.getCompanyName()) : partner.getCompanyName() != null)
            return false;
        if (getAddress() != null ? !getAddress().equals(partner.getAddress()) : partner.getAddress() != null)
            return false;
        if (getCity() != null ? !getCity().equals(partner.getCity()) : partner.getCity() != null) return false;
        if (getState() != null ? !getState().equals(partner.getState()) : partner.getState() != null) return false;
        if (getPostalCode() != null ? !getPostalCode().equals(partner.getPostalCode()) : partner.getPostalCode() != null)
            return false;
        if (getCountry() != null ? !getCountry().equals(partner.getCountry()) : partner.getCountry() != null)
            return false;
        if (getPhone() != null ? !getPhone().equals(partner.getPhone()) : partner.getPhone() != null) return false;
        if (getEmail() != null ? !getEmail().equals(partner.getEmail()) : partner.getEmail() != null) return false;
        if (getURL() != null ? !getURL().equals(partner.getURL()) : partner.getURL() != null) return false;
        return getLogo() != null ? getLogo().equals(partner.getLogo()) : partner.getLogo() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getCompanyName() != null ? getCompanyName().hashCode() : 0);
        result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + (getState() != null ? getState().hashCode() : 0);
        result = 31 * result + (getPostalCode() != null ? getPostalCode().hashCode() : 0);
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getURL() != null ? getURL().hashCode() : 0);
        result = 31 * result + (getLogo() != null ? getLogo().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Partner{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", URL='" + URL + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }
}
