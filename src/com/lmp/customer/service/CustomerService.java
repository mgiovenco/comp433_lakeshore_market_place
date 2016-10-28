package com.lmp.customer.service;

import com.lmp.customer.dao.CustomerDao;
import com.lmp.customer.model.Customer;
import com.lmp.customer.model.CustomerAddress;
import com.lmp.customer.model.CustomerBillingInfo;

import java.sql.SQLException;
import java.util.List;

/**
 * Service for interacting with customer entities.
 */
public class CustomerService {

    private CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    /**
     * Get customer by id.
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public Customer getCustomer(int id) throws SQLException {
        return customerDao.selectCustomer(id);
    }

    /**
     * List all customers.
     *
     * @return
     * @throws SQLException
     */
    public List<Customer> listCustomers() throws SQLException {
        return customerDao.selectAllCustomers();
    }

    /**
     * Add single customer.
     *
     * @param customer
     * @throws Exception
     */
    public void addCustomer(Customer customer) throws Exception {
        customerDao.createCustomer(customer);
    }

    /**
     * Update single customer.
     *
     * @param customer
     */
    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }

    /**
     * Soft delete single customer.
     *
     * @param id
     */
    public void deleteCustomer(int id) {
        customerDao.updateCustomerActiveStatus(id, false);
    }

    /**
     * Get single customer address.
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public CustomerAddress getCustomerAddress(int id) throws SQLException {
        return customerDao.selectCustomerAddress(id);
    }

    /**
     * Get all customer addresses by custId.
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public List<CustomerAddress> getCustomerAddressesByCustId(int id) throws SQLException {
        return customerDao.selectCustomerAddressesByCustId(id);
    }

    /**
     * Add single customer address.
     *
     * @param customerAddress
     * @throws Exception
     */
    public void addCustomerAddress(CustomerAddress customerAddress) throws Exception {
        customerDao.createCustomerAddress(customerAddress);
    }

    /**
     * Update single customer address.
     *
     * @param customerAddress
     */
    public void updateCustomerAddress(CustomerAddress customerAddress) {
        customerDao.updateCustomerAddress(customerAddress);
    }

    /**
     * Soft delete customer address.
     *
     * @param id
     */
    public void deleteCustomerAddress(int id) {
        // Soft delete customer address
        customerDao.updateCustomerAddressActiveStatus(id, false);
    }

    /**
     * Get single customer billing info.
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public CustomerBillingInfo getCustomerBillingInfo(int id) throws SQLException {
        return customerDao.selectCustomerBillingInfo(id);
    }

    /**
     * Get all customer billing info for cust id.
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public List<CustomerBillingInfo> getCustomerBillingInfoByCustId(int id) throws SQLException {
        return customerDao.selectCustomerBillingInfoByCustId(id);
    }

    /**
     * Add single customer billing info.
     *
     * @param customerBillingInfo
     * @throws Exception
     */
    public void addCustomerBillingInfo(CustomerBillingInfo customerBillingInfo) throws Exception {
        customerDao.createCustomerBillingInfo(customerBillingInfo);
    }

    /**
     * Update single customer billing info.
     *
     * @param customerBillingInfo
     */
    public void updateCustomerBillingInfo(CustomerBillingInfo customerBillingInfo) {
        customerDao.updateCustomerBillingInfo(customerBillingInfo);
    }
}
