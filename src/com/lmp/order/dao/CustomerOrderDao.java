package com.lmp.order.dao;

import com.lmp.order.model.CustomerOrder;
import com.lmp.order.model.CustomerOrderComplete;
import com.lmp.order.model.CustomerOrderDetail;
import com.lmp.order.model.Payment;
import com.lmp.util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object for interacting with the customer_order and payment tables.
 */
public class CustomerOrderDao {

    private static final String SELECT_CUSTOMER_ORDER = "SELECT id, order_total, order_status, tracking_id, customer_id, billing_info_id, shipping_info_id, created_on, updated_on from customer_order where id = ?";
    private static final String SELECT_ALL_CUSTOMER_ORDERS_BY_CUSTID = "SELECT id, order_total, order_status, tracking_id, customer_id, billing_info_id, shipping_info_id, created_on, updated_on from customer_order where customer_id = ?";
    private static final String INSERT_CUSTOMER_ORDER = "INSERT into customer_order (order_total, order_status, tracking_id, customer_id, billing_info_id, shipping_info_id, created_on) values (?, ?, ?, ?, ?, ?, ?)";

    private static final String SELECT_DETAILED_CUSTOMER_ORDER = "SELECT co.id, co.order_total, co.order_status, co.tracking_id, co.customer_id, co.billing_info_id, co.shipping_info_id, co.created_on, co.updated_on, cab.address_line_1, cab.address_line_2, cab.city, cab.state, cab.postal_code, cab.country,cas.address_line_1, cas.address_line_2, cas.city, cas.state, cas.postal_code, cas.country from customer_order co join customer c on (co.customer_id = c.id)join customer_address cab on (co.billing_info_id = cab.id) join customer_address cas on (co.shipping_info_id = cas.id) where co.id = ?";
    private static final String SELECT_CUSTOMER_ORDER_STATUS = "SELECT order_status from customer_order where id = ?";

    private static final String UPDATE_CUSTOMER_ORDER = "UPDATE customer_order set order_total = ?, order_status = ?, tracking_id = ?, customer_id = ?, billing_info_id = ?, shipping_info_id = ?, updated_on = ? where id = ?";

    private static final String SELECT_PAYMENT = "SELECT id, customer_order_id, type, status, created_on, updated_on from payment where id = ?";
    private static final String SELECT_ALL_PAYMENTS_BY_ORDERID = "SELECT id, customer_order_id, type, status, created_on, updated_on from payment where customer_order_id = ?";
    private static final String INSERT_PAYMENT = "INSERT into payment (customer_order_id, type, status, created_on) values (?, ?, ?, ?)";
    private static final String UPDATE_PAYMENT = "UPDATE payment set status = ?, updated_on = ? where id = ?";

    private static final String SELECT_CUSTOMER_ORDER_DETAIL = "SELECT id, customer_order_id, product_id, created_on, updated_on from customer_order_detail where id = ?";
    private static final String INSERT_CUSTOMER_ORDER_DETAIL = "INSERT INTO customer_order_detail (customer_order_id, product_id, created_on) values (?, ?, ?)";
    private static final String SELECT_CUSTOMER_ORDER_DETAILS_BY_ORDER_ID = "select cod.id, cod.customer_order_id, cod.product_id, cod.created_on, cod.updated_on from customer_order_detail cod join customer_order co on (cod.customer_order_id = co.id) where co.id = ?";

    /**
     * Select single customer order by id
     *
     * @param id
     * @return
     */
    public CustomerOrder selectCustomerOrder(int id) throws SQLException {

        CustomerOrder customerOrder = null;

        try {
            Connection conn = DBHelper.getconnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_CUSTOMER_ORDER, id);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                customerOrder = new CustomerOrder(resultSet.getInt("id"), resultSet.getBigDecimal("order_total"), resultSet.getString("order_status"), resultSet.getString("tracking_id"), resultSet.getInt("customer_id"), resultSet.getInt("billing_info_id"), resultSet.getInt("shipping_info_id"), resultSet.getTimestamp("created_on"), resultSet.getTimestamp("updated_on"));
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }

        return customerOrder;
    }

    /**
     * Select all customer orders by cust id
     *
     * @param id
     * @return
     */
    public List<CustomerOrder> selectAllCustomerOrdersByCustId(int id) throws SQLException {

        List<CustomerOrder> customerOrderList = new ArrayList<>();

        try {
            Connection conn = DBHelper.getconnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_ALL_CUSTOMER_ORDERS_BY_CUSTID, id);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                customerOrderList.add(new CustomerOrder(resultSet.getInt("id"), resultSet.getBigDecimal("order_total"), resultSet.getString("order_status"), resultSet.getString("tracking_id"), resultSet.getInt("customer_id"), resultSet.getInt("billing_info_id"), resultSet.getInt("shipping_info_id"), resultSet.getTimestamp("created_on"), resultSet.getTimestamp("updated_on")));
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }

        return customerOrderList;
    }

    /**
     * Select detailed customer order by id.
     *
     * @param id
     * @return
     */
    public CustomerOrderComplete selectDetailedCustomerOrder(int id) throws SQLException {

        CustomerOrderComplete customerOrderDetailed = null;

        try {
            Connection conn = DBHelper.getconnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_DETAILED_CUSTOMER_ORDER, id);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                customerOrderDetailed = new CustomerOrderComplete(
                        resultSet.getInt("co.id"), resultSet.getBigDecimal("co.order_total"), resultSet.getString("co.order_status"), resultSet.getString("co.tracking_id"), resultSet.getInt("co.customer_id"), resultSet.getInt("co.billing_info_id"), resultSet.getInt("co.shipping_info_id"), resultSet.getTimestamp("co.created_on"), resultSet.getTimestamp("co.updated_on"),
                        resultSet.getString("cab.address_line_1"), resultSet.getString("cab.address_line_2"), resultSet.getString("cab.city"), resultSet.getString("cab.state"), resultSet.getString("cab.postal_code"), resultSet.getString("cab.country"),
                        resultSet.getString("cas.address_line_1"), resultSet.getString("cas.address_line_2"), resultSet.getString("cas.city"), resultSet.getString("cas.state"), resultSet.getString("cas.postal_code"), resultSet.getString("cas.country"));
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }

        return customerOrderDetailed;
    }

    /**
     * Create customer order object.
     *
     * @param customerOrder
     * @throws Exception
     */
    public void createCustomerOrder(CustomerOrder customerOrder) throws Exception {
        if (customerOrder != null) {
            try {
                Connection conn = DBHelper.getconnection();
                PreparedStatement ps = conn.prepareStatement(INSERT_CUSTOMER_ORDER, Statement.RETURN_GENERATED_KEYS);
                ps.setBigDecimal(1, customerOrder.getOrderTotal());
                ps.setString(2, customerOrder.getOrderStatus());
                ps.setString(3, customerOrder.getTrackingId());
                ps.setInt(4, customerOrder.getCustomerId());
                ps.setInt(5, customerOrder.getBillingInfoId());
                ps.setInt(6, customerOrder.getShippingInfoId());
                ps.setTimestamp(7, new Timestamp(new java.util.Date().getTime()));

                int result = ps.executeUpdate();

                if (result == 0) {
                    throw new SQLException("Creating customer order failed, no rows affected.");
                }

                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        System.out.println("GeneratedKey: " + generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Creating customer order failed, no ID obtained.");
                    }
                }

            } catch (SQLException e) {
                System.out.println("SQLException: " + e);
            }
        } else {
            throw new Exception("Cannot insert null customer order object");
        }
    }

    /**
     * Select single customer order status by id
     *
     * @param id
     * @return
     */
    public String selectCustomerOrderStatus(int id) throws SQLException {

        String status = null;

        try {
            Connection conn = DBHelper.getconnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_CUSTOMER_ORDER_STATUS, id);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                status = resultSet.getString("order_status");
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }

        return status;
    }

    /**
     * Updates the customer order object.
     *
     * @param customerOrder
     */
    public void updateCustomerOrder(CustomerOrder customerOrder) {
        try {
            Connection conn = DBHelper.getconnection();
            PreparedStatement ps = conn.prepareStatement(UPDATE_CUSTOMER_ORDER);

            ps.setBigDecimal(1, customerOrder.getOrderTotal());
            ps.setString(2, customerOrder.getOrderStatus());
            ps.setString(3, customerOrder.getTrackingId());
            ps.setInt(4, customerOrder.getCustomerId());
            ps.setInt(5, customerOrder.getBillingInfoId());
            ps.setInt(6, customerOrder.getShippingInfoId());
            ps.setTimestamp(7, new Timestamp(new java.util.Date().getTime()));
            ps.setInt(8, customerOrder.getId());

            int result = ps.executeUpdate();

            if (result == 0) {
                System.out.println("No customer order found for customer order id: " + customerOrder.getId());
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
    }

    /**
     * Create a customer payment.
     *
     * @param payment
     */
    public void createPayment(Payment payment) throws Exception {

        if (payment != null) {
            try {
                Connection conn = DBHelper.getconnection();
                PreparedStatement ps = conn.prepareStatement(INSERT_PAYMENT, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, payment.getCustomerOrderId());
                ps.setString(2, payment.getType());
                ps.setString(3, payment.getStatus());
                ps.setTimestamp(4, new Timestamp(new java.util.Date().getTime()));

                int result = ps.executeUpdate();

                if (result == 0) {
                    throw new SQLException("Creating payment failed, no rows affected.");
                }

                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        System.out.println("GeneratedKey: " + generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Creating payment failed, no ID obtained.");
                    }
                }

            } catch (SQLException e) {
                System.out.println("SQLException: " + e);
            }
        } else {
            throw new Exception("Cannot insert null payment object");
        }
    }

    /**
     * Returns a single payment.
     *
     * @param id
     * @return
     */
    public Payment selectPayment(int id) {

        Payment payment = null;

        try {
            Connection conn = DBHelper.getconnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_PAYMENT, id);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                payment = new Payment(resultSet.getInt("id"), resultSet.getInt("customer_order_id"), resultSet.getString("type"), resultSet.getString("status"), resultSet.getTimestamp("created_on"), resultSet.getTimestamp("updated_on"));
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }

        return payment;
    }

    /**
     * Used for updating a payment status (whether refund, processing, etc).
     *
     * @param id
     */
    public void updatePayment(int id, String status) {
        try {
            Connection conn = DBHelper.getconnection();
            PreparedStatement ps = conn.prepareStatement(UPDATE_PAYMENT);

            ps.setString(1, status);
            ps.setTimestamp(2, new Timestamp(new java.util.Date().getTime()));
            ps.setInt(3, id);

            int result = ps.executeUpdate();

            if (result == 0) {
                System.out.println("No payment found for customer order id: " + id);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
    }

    public List<Payment> selectPaymentsByOrderId(int id) {
        List<Payment> paymentList = new ArrayList<>();

        try {
            Connection conn = DBHelper.getconnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_ALL_PAYMENTS_BY_ORDERID, id);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                paymentList.add(new Payment(resultSet.getInt("id"), resultSet.getInt("customer_order_id"), resultSet.getString("type"), resultSet.getString("status"), resultSet.getTimestamp("created_on"), resultSet.getTimestamp("updated_on")));
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }

        return paymentList;
    }

    /**
     * Create customer order detail.
     *
     * @param customerOrderDetail
     */
    public void createCustomerOrderDetail(CustomerOrderDetail customerOrderDetail) throws Exception {
        if (customerOrderDetail != null) {
            try {
                Connection conn = DBHelper.getconnection();
                PreparedStatement ps = conn.prepareStatement(INSERT_CUSTOMER_ORDER_DETAIL, Statement.RETURN_GENERATED_KEYS);
                ps.setInt(1, customerOrderDetail.getCustomerOrderId());
                ps.setInt(2, customerOrderDetail.getProductId());
                ps.setTimestamp(3, new Timestamp(new java.util.Date().getTime()));

                int result = ps.executeUpdate();

                if (result == 0) {
                    throw new SQLException("Creating customer order detail failed, no rows affected.");
                }

                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        System.out.println("GeneratedKey: " + generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Creating customer order detail failed, no ID obtained.");
                    }
                }

            } catch (SQLException e) {
                System.out.println("SQLException: " + e);
            }
        } else {
            throw new Exception("Cannot insert null customer order detail object");
        }
    }

    /**
     * Get single customer order detail.
     *
     * @param id
     * @return
     */
    public CustomerOrderDetail selectCustomerOrderDetail(int id) {
        CustomerOrderDetail customerOrderDetail = null;

        try {
            Connection conn = DBHelper.getconnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_CUSTOMER_ORDER_DETAIL, id);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                customerOrderDetail = new CustomerOrderDetail(resultSet.getInt("id"), resultSet.getInt("customer_order_id"), resultSet.getInt("product_id"), resultSet.getTimestamp("created_on"), resultSet.getTimestamp("updated_on"));
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }

        return customerOrderDetail;
    }

    /**
     * Get all customer order detail records for particular order id.
     *
     * @param id
     * @return
     */
    public List<CustomerOrderDetail> selectCustomerOrderDetailsByOrderId(int id) {
        List<CustomerOrderDetail> customerOrderDetailList = new ArrayList<>();

        try {
            Connection conn = DBHelper.getconnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_CUSTOMER_ORDER_DETAILS_BY_ORDER_ID, id);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                customerOrderDetailList.add(new CustomerOrderDetail(resultSet.getInt("id"), resultSet.getInt("customer_order_id"), resultSet.getInt("product_id"), resultSet.getTimestamp("created_on"), resultSet.getTimestamp("updated_on")));
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }

        return customerOrderDetailList;
    }
}
