package com.lmp.model;

import java.sql.Timestamp;

/**
 * Class represents a customer with additional address information.
 */
public class Customer {

    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private boolean active;
    private Timestamp createdOn;
    private Timestamp updatedOn;

    /**
     * Constructor used for INSERTS.
     *
     * @param firstName
     * @param lastName
     * @param phone
     * @param active
     */
    public Customer(String firstName, String lastName, String phone, boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.active = active;
    }

    /**
     * Constructor used for UPDATES.
     *
     * @param id
     * @param firstName
     * @param lastName
     * @param phone
     * @param active
     */
    public Customer(int id, String firstName, String lastName, String phone, boolean active) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.active = active;
    }

    /**
     * Constructor used for SELECTS.
     *
     * @param id
     * @param firstName
     * @param lastName
     * @param phone
     * @param active
     * @param createdOn
     * @param updatedOn
     */
    public Customer(int id, String firstName, String lastName, String phone, boolean active, Timestamp createdOn, Timestamp updatedOn) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.active = active;
        this.createdOn = createdOn;
        this.updatedOn = updatedOn;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
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
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", active=" + active +
                ", createdOn=" + createdOn +
                ", updatedOn=" + updatedOn +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;

        if (getId() != customer.getId()) return false;
        if (isActive() != customer.isActive()) return false;
        if (getFirstName() != null ? !getFirstName().equals(customer.getFirstName()) : customer.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(customer.getLastName()) : customer.getLastName() != null)
            return false;
        if (getPhone() != null ? !getPhone().equals(customer.getPhone()) : customer.getPhone() != null) return false;
        if (getCreatedOn() != null ? !getCreatedOn().equals(customer.getCreatedOn()) : customer.getCreatedOn() != null)
            return false;
        return getUpdatedOn() != null ? getUpdatedOn().equals(customer.getUpdatedOn()) : customer.getUpdatedOn() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        result = 31 * result + (getCreatedOn() != null ? getCreatedOn().hashCode() : 0);
        result = 31 * result + (getUpdatedOn() != null ? getUpdatedOn().hashCode() : 0);
        return result;
    }
}
