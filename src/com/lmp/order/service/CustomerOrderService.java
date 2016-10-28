package com.lmp.order.service;

import com.lmp.order.dao.CustomerOrderDao;
import com.lmp.order.model.CustomerOrder;
import com.lmp.order.model.CustomerOrderDetail;
import com.lmp.order.model.CustomerOrderComplete;
import com.lmp.order.model.Payment;

import java.sql.SQLException;
import java.util.List;

/**
 * Service for interacting with order and payment entities.
 */
public class CustomerOrderService {

    private CustomerOrderDao customerOrderDao;

    public CustomerOrderService(CustomerOrderDao customerOrderDao) {
        this.customerOrderDao = customerOrderDao;
    }

    /**
     * Get customer order by id.
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public CustomerOrder getCustomerOrder(int id) throws SQLException {
        return customerOrderDao.selectCustomerOrder(id);
    }

    /**
     * Get all customer orders by customer id.
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public List<CustomerOrder> getAllCustomerOrdersByCustId(int id) throws SQLException {
        return customerOrderDao.selectAllCustomerOrdersByCustId(id);
    }

    /**
     * Get detailed customer order by id.
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public CustomerOrderComplete getDetailedCustomerOrder(int id) throws SQLException {
        return customerOrderDao.selectDetailedCustomerOrder(id);
    }

    /**
     * Add single customer order.
     *
     * @param customerOrder
     * @throws Exception
     */
    public void addCustomerOrder(CustomerOrder customerOrder) throws Exception {
        customerOrderDao.createCustomerOrder(customerOrder);
    }

    /**
     * Get customer order status by id.
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public String getCustomerOrderStatus(int id) throws SQLException {
        return customerOrderDao.selectCustomerOrderStatus(id);
    }

    /**
     * Updates single customer order.
     *
     * @param customerOrder
     */
    public void updateCustomerOrder(CustomerOrder customerOrder) {
        customerOrderDao.updateCustomerOrder(customerOrder);
    }

    /**
     * ADd single payment.
     *
     * @param payment
     */
    public void addPayment(Payment payment) throws Exception {
        customerOrderDao.createPayment(payment);
    }

    /**
     * Get payment by id.
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public Payment getPayment(int id) throws SQLException {
        return customerOrderDao.selectPayment(id);
    }

    /**
     * Update a single payment.
     *
     * @param id
     * @param status
     */
    public void updatePayment(int id, String status) {
        customerOrderDao.updatePayment(id, status);
    }

    /**
     * Get all payments by customer order id.
     *
     * @param id
     * @return
     */
    public List<Payment> getPaymentsByOrderId(int id) {
        return customerOrderDao.selectPaymentsByOrderId(id);
    }

    /**
     * Create single customer order detail.
     *
     * @param customerOrderDetail
     */
    public void addCustomerOrderDetail(CustomerOrderDetail customerOrderDetail) throws Exception {
        customerOrderDao.createCustomerOrderDetail(customerOrderDetail);
    }

    /**
     * Select customer order detail.
     *
     * @param id
     * @return
     */
    public CustomerOrderDetail getCustomerOrderDetail(int id) {
        return customerOrderDao.selectCustomerOrderDetail(id);
    }

    /**
     * Select all customer order details by order id.
     *
     * @param id
     * @return
     */
    public List<CustomerOrderDetail> getCustomerOrderDetailsByOrderId(int id) {
        return customerOrderDao.selectCustomerOrderDetailsByOrderId(id);
    }
}
