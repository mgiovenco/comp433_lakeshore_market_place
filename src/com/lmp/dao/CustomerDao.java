package com.lmp.dao;

import com.lmp.model.Customer;
import com.lmp.model.CustomerAddress;
import com.lmp.model.CustomerBillingInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object for interacting with the customer and customer_address tables.
 */
public class CustomerDao {

    private static final String SELECT_CUSTOMER = "SELECT id, first_name, last_name, phone, email, active, created_on, updated_on from customer where id = ?";
    private static final String SELECT_ALL_CUSTOMERS = "SELECT id, first_name, last_name, phone, email, active, created_on, updated_on from customer";
    private static final String INSERT_CUSTOMER = "INSERT into customer (first_name, last_name, phone, email, active, created_on) values (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_CUSTOMER = "UPDATE customer set first_name = ?, last_name = ?, phone = ?, email = ?, active = ?, updated_on = ? where id = ?";
    private static final String INACTIVATE_CUSTOMER = "UPDATE customer set active = ?, updated_on = ? where id = ?";

    private static final String SELECT_CUSTOMER_ADDRESS = "SELECT id, address_line_1, address_line_2, city, state, postal_code, country, billing_address, shipping_address, active, created_on, updated_on, customer_id from customer_address where id = ?";
    private static final String SELECT_CUSTOMER_ADDRESS_BY_CUSTID = "SELECT id, address_line_1, address_line_2, city, state, postal_code, country, billing_address, shipping_address, active, created_on, updated_on, customer_id from customer_address where customer_id = ?";
    private static final String INSERT_CUSTOMER_ADDRESS = "INSERT into customer_address (address_line_1, address_line_2, city, state, postal_code, country, billing_address, shipping_address, active, created_on, customer_id) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_CUSTOMER_ADDRESS = "UPDATE customer_address set address_line_1 = ?, address_line_2 = ?, city = ?, state = ?, postal_code = ?, country = ?, billing_address = ?, shipping_address = ?, active = ?, updated_on = ? where id = ?";
    private static final String INACTIVATE_CUSTOMER_ADDRESS = "UPDATE customer_address set active = ?, updated_on = ? where id = ?";

    private static final String SELECT_CUSTOMER_BILLING_INFO = "SELECT id, credit_card_number, credit_card_expiration, active, created_on, updated_on, customer_id from customer_billing_info where id = ?";
    private static final String SELECT_CUSTOMER_BILLING_INFO_BY_CUSTID = "SELECT id, credit_card_number, credit_card_expiration, active, created_on, updated_on, customer_id from customer_billing_info where customer_id = ?";
    private static final String INSERT_CUSTOMER_BILLING_INFO = "INSERT into customer_billing_info (credit_card_number, credit_card_expiration, active, created_on, customer_id) values (?, ?, ?, ?, ?)";
    private static final String UPDATE_CUSTOMER_BILLING_INFO = "UPDATE customer_billing_info set credit_card_number = ?, credit_card_expiration = ?, active = ?, updated_on = ? where id = ?";

    /**
     * Select single customer by id
     *
     * @param id
     * @return
     */
    public Customer selectCustomer(int id) throws SQLException {

        Customer customer = null;

        try {
            Connection conn = DBHelper.getconnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_CUSTOMER, id);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                customer = new Customer(resultSet.getInt("id"), resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("phone"), resultSet.getString("email"), resultSet.getBoolean("active"), resultSet.getTimestamp("created_on"), resultSet.getTimestamp("updated_on"));
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }

        return customer;
    }

    /**
     * Select all customers
     *
     * @return
     */
    public List<Customer> selectAllCustomers() throws SQLException {

        List<Customer> customerList = new ArrayList<>();

        try {
            Connection conn = DBHelper.getconnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_ALL_CUSTOMERS);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                customerList.add(new Customer(resultSet.getInt("id"), resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getString("phone"), resultSet.getString("email"), resultSet.getBoolean("active"), resultSet.getTimestamp("created_on"), resultSet.getTimestamp("updated_on")));
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }

        return customerList;
    }

    /**
     * Create customer object.
     *
     * @param customer
     * @throws Exception
     */
    public void createCustomer(Customer customer) throws Exception {
        if (customer != null) {
            try {
                Connection conn = DBHelper.getconnection();
                PreparedStatement ps = conn.prepareStatement(INSERT_CUSTOMER, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, customer.getFirstName());
                ps.setString(2, customer.getLastName());
                ps.setString(3, customer.getPhone());
                ps.setString(4, customer.getEmail());
                ps.setBoolean(5, customer.isActive());
                ps.setTimestamp(6, new Timestamp(new java.util.Date().getTime()));

                int result = ps.executeUpdate();

                if (result == 0) {
                    throw new SQLException("Creating customer failed, no rows affected.");
                }

                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        System.out.println("GeneratedKey: " + generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Creating customer failed, no ID obtained.");
                    }
                }

            } catch (SQLException e) {
                System.out.println("SQLException: " + e);
            }
        } else {
            throw new Exception("Cannot insert null customer object");
        }
    }

    public void updateCustomer(Customer customer) {
        try {
            Connection conn = DBHelper.getconnection();
            PreparedStatement ps = conn.prepareStatement(UPDATE_CUSTOMER);

            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getPhone());
            ps.setString(4, customer.getEmail());
            ps.setBoolean(5, customer.isActive());
            ps.setTimestamp(6, new Timestamp(new java.util.Date().getTime()));
            ps.setInt(7, customer.getId());

            int result = ps.executeUpdate();

            if (result == 0) {
                System.out.println("No customer found for customer id: " + customer.getId());
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
    }

    public void updateCustomerActiveStatus(int id, boolean status) {
        try {
            Connection conn = DBHelper.getconnection();
            PreparedStatement ps = conn.prepareStatement(INACTIVATE_CUSTOMER);

            ps.setBoolean(1, status);
            ps.setTimestamp(2, new Timestamp(new java.util.Date().getTime()));
            ps.setInt(3, id);

            int result = ps.executeUpdate();

            if (result == 0) {
                System.out.println("No customer found for customer id: " + id);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
    }

    public CustomerAddress selectCustomerAddress(int id) throws SQLException {

        CustomerAddress customerAddress = null;

        try {
            Connection conn = DBHelper.getconnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_CUSTOMER_ADDRESS, id);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                customerAddress = new CustomerAddress(resultSet.getInt("id"), resultSet.getString("address_line_1"), resultSet.getString("address_line_2"), resultSet.getString("city"), resultSet.getString("state"), resultSet.getString("postal_code"), resultSet.getString("country"), resultSet.getBoolean("billing_address"), resultSet.getBoolean("shipping_address"), resultSet.getBoolean("active"), resultSet.getInt("customer_id"), resultSet.getTimestamp("created_on"), resultSet.getTimestamp("updated_on"));
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }

        return customerAddress;
    }

    public List<CustomerAddress> selectCustomerAddressesByCustId(int id) throws SQLException {

        List<CustomerAddress> customerAddressList = new ArrayList<>();

        try {
            Connection conn = DBHelper.getconnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_CUSTOMER_ADDRESS_BY_CUSTID, id);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                customerAddressList.add(new CustomerAddress(resultSet.getInt("id"), resultSet.getString("address_line_1"), resultSet.getString("address_line_2"), resultSet.getString("city"), resultSet.getString("state"), resultSet.getString("postal_code"), resultSet.getString("country"), resultSet.getBoolean("billing_address"), resultSet.getBoolean("shipping_address"), resultSet.getBoolean("active"), resultSet.getInt("customer_id"), resultSet.getTimestamp("created_on"), resultSet.getTimestamp("updated_on")));
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }

        return customerAddressList;
    }

    public void createCustomerAddress(CustomerAddress customerAddress) throws Exception {
        if (customerAddress != null) {
            try {
                Connection conn = DBHelper.getconnection();
                PreparedStatement ps = conn.prepareStatement(INSERT_CUSTOMER_ADDRESS, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, customerAddress.getAddressLine1());
                ps.setString(2, customerAddress.getAddressLine2());
                ps.setString(3, customerAddress.getCity());
                ps.setString(4, customerAddress.getState());
                ps.setString(5, customerAddress.getPostalCode());
                ps.setString(6, customerAddress.getCountry());
                ps.setBoolean(7, customerAddress.isBillingAddress());
                ps.setBoolean(8, customerAddress.isShippingAddress());
                ps.setBoolean(9, customerAddress.isActive());
                ps.setTimestamp(10, new Timestamp(new java.util.Date().getTime()));
                ps.setInt(11, customerAddress.getCustomerId());


                int result = ps.executeUpdate();

                if (result == 0) {
                    throw new SQLException("Creating customer address failed, no rows affected.");
                }

                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        System.out.println("GeneratedKey: " + generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Creating customer address failed, no ID obtained.");
                    }
                }

            } catch (SQLException e) {
                System.out.println("SQLException: " + e);
            }
        } else {
            throw new Exception("Cannot insert null customer address object");
        }
    }

    public void updateCustomerAddress(CustomerAddress customerAddress) {
        try {
            Connection conn = DBHelper.getconnection();
            PreparedStatement ps = conn.prepareStatement(UPDATE_CUSTOMER_ADDRESS);

            ps.setString(1, customerAddress.getAddressLine1());
            ps.setString(2, customerAddress.getAddressLine2());
            ps.setString(3, customerAddress.getCity());
            ps.setString(4, customerAddress.getState());
            ps.setString(5, customerAddress.getPostalCode());
            ps.setString(6, customerAddress.getCountry());
            ps.setBoolean(7, customerAddress.isBillingAddress());
            ps.setBoolean(8, customerAddress.isShippingAddress());
            ps.setBoolean(9, customerAddress.isActive());
            ps.setTimestamp(10, new Timestamp(new java.util.Date().getTime()));
            ps.setInt(11, customerAddress.getId());

            int result = ps.executeUpdate();

            if (result == 0) {
                System.out.println("No customer address found for customer address id: " + customerAddress.getId());
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
    }

    public void updateCustomerAddressActiveStatus(int id, boolean status) {
        try {
            Connection conn = DBHelper.getconnection();
            PreparedStatement ps = conn.prepareStatement(INACTIVATE_CUSTOMER_ADDRESS);

            ps.setBoolean(1, status);
            ps.setTimestamp(2, new Timestamp(new java.util.Date().getTime()));
            ps.setInt(3, id);

            int result = ps.executeUpdate();

            if (result == 0) {
                System.out.println("No customer address found for customer address id: " + id);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
    }

    public void createCustomerBillingInfo(CustomerBillingInfo customerBillingInfo) throws Exception {
        if (customerBillingInfo != null) {
            try {
                Connection conn = DBHelper.getconnection();
                PreparedStatement ps = conn.prepareStatement(INSERT_CUSTOMER_BILLING_INFO, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, customerBillingInfo.getCreditCardNumber());
                ps.setString(2, customerBillingInfo.getCreditCardExpiration());
                ps.setBoolean(3, customerBillingInfo.isActive());
                ps.setTimestamp(4, new Timestamp(new java.util.Date().getTime()));
                ps.setInt(5, customerBillingInfo.getCustomerId());

                int result = ps.executeUpdate();

                if (result == 0) {
                    throw new SQLException("Creating customer billing info failed, no rows affected.");
                }

                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        System.out.println("GeneratedKey: " + generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Creating customer billing info failed, no ID obtained.");
                    }
                }

            } catch (SQLException e) {
                System.out.println("SQLException: " + e);
            }
        } else {
            throw new Exception("Cannot insert null customer billing info object");
        }
    }

    public void updateCustomerBillingInfo(CustomerBillingInfo customerBillingInfo) {
        try {
            Connection conn = DBHelper.getconnection();
            PreparedStatement ps = conn.prepareStatement(UPDATE_CUSTOMER_BILLING_INFO);

            ps.setString(1, customerBillingInfo.getCreditCardNumber());
            ps.setString(2, customerBillingInfo.getCreditCardExpiration());
            ps.setBoolean(3, customerBillingInfo.isActive());
            ps.setTimestamp(4, new Timestamp(new java.util.Date().getTime()));
            ps.setInt(5, customerBillingInfo.getId());

            int result = ps.executeUpdate();

            if (result == 0) {
                System.out.println("No customer billing info found for customer billing info id: " + customerBillingInfo.getId());
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
    }

    public CustomerBillingInfo selectCustomerBillingInfo(int id) throws SQLException {

        CustomerBillingInfo customerBillingInfo = null;

        try {
            Connection conn = DBHelper.getconnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_CUSTOMER_BILLING_INFO, id);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                customerBillingInfo = new CustomerBillingInfo(resultSet.getInt("id"), resultSet.getString("credit_card_number"), resultSet.getString("credit_card_expiration"), resultSet.getBoolean("active"), resultSet.getTimestamp("created_on"), resultSet.getTimestamp("updated_on"), resultSet.getInt("customer_id"));
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }

        return customerBillingInfo;
    }

    public List<CustomerBillingInfo> selectCustomerBillingInfoByCustId(int id) throws SQLException {

        List<CustomerBillingInfo> customerBillingInfoList = new ArrayList<>();

        try {
            Connection conn = DBHelper.getconnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_CUSTOMER_BILLING_INFO_BY_CUSTID, id);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                customerBillingInfoList.add(new CustomerBillingInfo(resultSet.getInt("id"), resultSet.getString("credit_card_number"), resultSet.getString("credit_card_expiration"), resultSet.getBoolean("active"), resultSet.getTimestamp("created_on"), resultSet.getTimestamp("updated_on"), resultSet.getInt("customer_id")));
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }

        return customerBillingInfoList;
    }
}
