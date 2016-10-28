package com.lmp.product.dao;

import com.lmp.product.model.Product;
import com.lmp.util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Hattan
 */
public class ProductDao {

    private static final String SELECT_PRODUCT = "SELECT id, vendor_product_id, name, description, product_available, picture, category_id, partner_id from product where id = ?";
    private static final String SELECT_ALL_PPRODUCT = "SELECT id, vendor_product_id, name, description, product_available, picture, category_id, partner_id from product";
    private static final String INSERT_PRODUCT = "INSERT into product (vendor_product_id, name, description, product_available, picture, category_id, partner_id) values (?, ?, ?, ?, ?, ?,?)";
    private static final String UPDATE_PRODUCT = "UPDATE product set vendor_product_id = ?, name = ?, description = ?, product_available = ?, picture = ?, category_id = ?, partner_id = ? where id = ?";
    private static final String UNAVILABLE_PRODUCT = "UPDATE product set product_available = ? where id = ?";

    private static final String SELECT_PRODUCT_BY_CATEGORY = "SELECT id, vendor_product_id, name, description, product_available, picture, category_id, partner_id from product where category_id = ?";

    /**
     * Select one product by id
     *
     * @param id
     * @return
     */
    public Product selectProduct(int id) throws SQLException {
        Product product = null;
        try {
            Connection conn = DBHelper.getconnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_PRODUCT, id);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                product = new Product(resultSet.getInt("id"), resultSet.getString("vendor_product_id"),
                        resultSet.getString("name"), resultSet.getString("description"),
                        resultSet.getBoolean("product_available"), resultSet.getInt("category_id"),
                        resultSet.getInt("partner_id"), resultSet.getString("picture"));
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }

        return product;
    }

    /**
     * Select SELECT_ALL_PPRODUCT
     *
     * @return
     */
    public List<Product> selectAllProducts() throws SQLException {

        List<Product> productList = new ArrayList<>();

        try {
            Connection conn = DBHelper.getconnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_ALL_PPRODUCT);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                productList.add(new Product(resultSet.getInt("id"), resultSet.getString("vendor_product_id"),
                        resultSet.getString("name"), resultSet.getString("description"),
                        resultSet.getBoolean("product_available"), resultSet.getInt("category_id"),
                        resultSet.getInt("partner_id"), resultSet.getString("picture")));
            }
        } catch (SQLException e) {
            System.out.println("SQLException:" + e);
        }

        return productList;
    }

    /**
     * Create new product.
     */
    public void createProduct(Product product) throws Exception {
        if (product != null) {
            try {
                Connection conn = DBHelper.getconnection();
                PreparedStatement ps = conn.prepareStatement(INSERT_PRODUCT, Statement.RETURN_GENERATED_KEYS);
                ps.setString(1, product.getVendor_product_id());
                ps.setString(2, product.getName());
                ps.setString(3, product.getDescription());
                ps.setBoolean(4, product.isProduct_available());
                ps.setString(5, product.getPicture());
                ps.setInt(6, product.getCategory_id());
                ps.setInt(7, product.getPartner_id());

                int result = ps.executeUpdate();

                if (result == 0) {
                    throw new SQLException("Creating a new product failed, no rows affected.");
                }

                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        System.out.println("GeneratedKey: " + generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Creating new product failed, no ID obtained.");
                    }
                }

            } catch (SQLException e) {
                System.out.println("SQLException: " + e);
            }
        } else {
            throw new Exception("Cannot insert null product object");
        }
    }

    /**
     * UPDATE_PRODUCT.
     */
    public void updateProduct(Product product) {
        try {
            Connection conn = DBHelper.getconnection();
            PreparedStatement ps = conn.prepareStatement(UPDATE_PRODUCT);

            ps.setString(1, product.getVendor_product_id());
            ps.setString(2, product.getName());
            ps.setString(3, product.getDescription());
            ps.setBoolean(4, product.isProduct_available());
            ps.setString(5, product.getPicture());
            ps.setInt(6, product.getCategory_id());
            ps.setInt(7, product.getPartner_id());
            ps.setInt(8, product.getId());

            int result = ps.executeUpdate();

            if (result == 0) {
                System.out.println("No product found for product id: " + product.getId());
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
    }

    /**
     * update Product Availability.
     */
    public void updateProductAvailability(int id, boolean status) {
        try {
            Connection conn = DBHelper.getconnection();
            PreparedStatement ps = conn.prepareStatement(UNAVILABLE_PRODUCT);

            ps.setBoolean(1, status);
            ps.setInt(2, id);

            int result = ps.executeUpdate();

            if (result == 0) {
                System.out.println("No Product found for id: " + id);
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }
    }

    /**
     * SELECT_PRODUCT_BY_CATEGORY
     */
    public List<Product> selectProductsByCategoryId(int id) throws SQLException {

        List<Product> productByCategoryList = new ArrayList<>();

        try {
            Connection conn = DBHelper.getconnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_PRODUCT_BY_CATEGORY, id);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                productByCategoryList.add(new Product(resultSet.getInt("id"), resultSet.getString("vendor_product_id"),
                        resultSet.getString("name"), resultSet.getString("description"),
                        resultSet.getBoolean("product_available"), resultSet.getInt("category_id"),
                        resultSet.getInt("partner_id"), resultSet.getString("picture")));
            }
        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }

        return productByCategoryList;
    }

}
