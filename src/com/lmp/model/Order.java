package com.lmp.model;

import java.util.Date;

/**
 * This class represents order information.
 */
public class Order {

	private int customerID;
     private int paymentID;
	private int orderID;
	private int orderStatus;
	private String trackingNumber;
     private Date datePurchased;
	private Date dateRefunded;


    /**
     * Constructor used for INSERTS.
     *
     * @param customerID
     * @param paymentID
     * @param orderID
     * @param orderStatus
	* @param trackingNumber
     */
    public Order(int customerID, int paymentID, int orderID, int orderStatus, String trackingNumber) {
        this.customerID = customerID;
        this.paymentID = paymentID;
        this.orderID = orderID;
        this.orderStatus = orderStatus;
        this.trackingNumber = trackingNumber;
    }

    /**
     * Constructor used for UPDATES.
     *
     * @param customerID
     * @param paymentID
     * @param phone
     * @param orderID
     * @param orderStatus
	* @param trackingNumber
     */
    public Order(int customerID, int paymentID, int orderID, int orderStatus, String trackingNumber) {
        this.customerID = customerID;
        this.paymentID = paymentID;
        this.orderID = orderID;
        this.orderStatus = orderStatus;
        this.trackingNumber = trackingNumber;
    }

    /**
     * Constructor used for SELECTS.
     *
     * @param customerID
     * @param paymentID
     * @param phone
     * @param orderID
     * @param orderStatus
	* @param trackingNumber
     * @param datePurchased
     * @param dateRefunded
     */
    public Order(int customerID, int paymentID, int orderID, int orderStatus, String trackingNumber, Date datePurchased, Date dateRefunded) {
        this.customerID = customerID;
        this.paymentID = paymentID;
        this.orderID = orderID;
        this.orderStatus = orderStatus;
        this.trackingNumber = trackingNumber;
        this.datePurchased = datePurchased;
        this.updatedOn = updatedOn;
    }

    public Date getDatePurchased() {
		return datePurchased;
	}
	public void setDatePurchased(Date datePurchased) {
		this.datePurchased = datePurchased;
	}
	public Date getDateRefunded() {
		return dateRefunded;
	}
	public void setDateRefunded(Date dateRefunded) {
		this.dateRefunded = dateRefunded;
	}
	public int getCustomerID() {
		return customerID;
	}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public int getOrderStatusCode() {
		return orderStatusCode;
	}
	public void setOrderStatusCode(int orderStatusCode) {
		this.orderStatusCode = orderStatusCode;
	}
	public int getPaymentID() {
		return paymentID;
	}
	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}
	public String getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}	
}

    
