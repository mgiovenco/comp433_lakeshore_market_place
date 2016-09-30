package com.lmp.service;

import com.lmp.dao.CustomerDao;
import com.lmp.model.Customer;
import com.lmp.model.CustomerAddress;
import com.lmp.model.CustomerBillingInfo;

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

    public Customer getCustomer(int id) throws SQLException {
        return customerDao.selectCustomer(id);
    }

    public List<Customer> listCustomers() throws SQLException {
        return customerDao.selectAllCustomers();
    }

    public void addCustomer(Customer customer) throws Exception {
        customerDao.createCustomer(customer);
    }

    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }

    public void deleteCustomer(int id) {
        // Soft delete customer
        customerDao.updateCustomerActiveStatus(id, false);
    }

    public CustomerAddress getCustomerAddress(int id) throws SQLException {
        return customerDao.selectCustomerAddress(id);
    }

    public List<CustomerAddress> getCustomerAddressesByCustId(int id) throws SQLException {
        return customerDao.selectCustomerAddressesByCustId(id);
    }

    public void addCustomerAddress(CustomerAddress customerAddress) throws Exception {
        customerDao.createCustomerAddress(customerAddress);
    }

    public void updateCustomerAddress(CustomerAddress customerAddress) {
        customerDao.updateCustomerAddress(customerAddress);
    }

    public void deleteCustomerAddress(int id) {
        // Soft delete customer address
        customerDao.updateCustomerAddressActiveStatus(id, false);
    }

    public CustomerBillingInfo getCustomerBillingInfo(int id) throws SQLException {
        return customerDao.selectCustomerBillingInfo(id);
    }

    public List<CustomerBillingInfo> getCustomerBillingInfoByCustId(int id) throws SQLException {
        return customerDao.selectCustomerBillingInfoByCustId(id);
    }

    public void addCustomerBillingInfo(CustomerBillingInfo customerBillingInfo) throws Exception {
        customerDao.createCustomerBillingInfo(customerBillingInfo);
    }

    public void updateCustomerBillingInfo(CustomerBillingInfo customerBillingInfo) {
        customerDao.updateCustomerBillingInfo(customerBillingInfo);
    }
}
