package com.lmp.model;

import java.sql.Timestamp;

/**
 * This class represents Partner information.
 */

public class Partner {

    private int Id;
    private String PartnerName;
    private String email;
    private boolean active;
    private Timestamp createdOn;
    private Timestamp updatedOn;

    public Partner(String PartnerName, String email, boolean active) {
        this.PartnerName = PartnerName;
        this.email = email;
        this.active = active;
    }

    public Partner(int Id, String PartnerName, String email, boolean active) {
        this.Id = Id;
        this.PartnerName = PartnerName;
        this.email = email;
        this.active = active;
    }

    public Partner(int Id, String PartnerName, String email, boolean active, Timestamp createdOn, Timestamp updatedOn) {
        this.Id = Id;
        this.PartnerName = PartnerName;
        this.email = email;
        this.active = active;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public int getId() {
        return id;
    }

    public String getPartnerName() {
        return PartnerName;
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
        if (getPartnerName() != null ? !getPartnerName().equals(partner.getPartnerName()) : partner.getPartnerName() != null)
            return false;
        if (getEmail() != null ? !getEmail().equals(partner.getEmail()) : partner.getEmail() != null) return false;
        if (getCreatedOn() != null ? !getCreatedOn().equals(partner.getCreatedOn()) : partner.getCreatedOn() != null)
            return false;
        return getUpdatedOn() != null ? getUpdatedOn().equals(partner.getUpdatedOn()) : partner.getUpdatedOn() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getPartnerName() != null ? getPartnerName().hashCode() : 0);
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
                ", email='" + email + '\'' +
                ", active=" + active +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }
}