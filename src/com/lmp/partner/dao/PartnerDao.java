package com.lmp.partner.dao;

import com.lmp.partner.model.Partner;
import com.lmp.util.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO for interacting with Partner table.
 */
public class PartnerDao {
    private static final String SELECT_PARTNER = "SELECT id, company_name, adress, city, state, postal_code, country, phone, email, URL, logo from partner where id = ?";
    private static final String SELECT_ALL_PARTNERS = "SELECT id, company_name, adress, city, state, postal_code, country, phone, email, URL, logo from partner";
    private static final String INSERT_PARTNER = "INSERT into partner (company_name, adress, city, state, postal_code, country, phone, email, URL, logo) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE_PARTNER = "UPDATE partner set company_name = ?, adress = ?, city= ?, state= ?, postal_code= ?, country= ?, phone= ?, email= ?, URL= ?, logo = ? where id = ?";

    /**
     * @param id
     * @return
     */
    public Partner selectPartner(int id) throws SQLException {
        Partner partner = null;

        try {

            Connection conn = DBHelper.getconnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_PARTNER, id);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                partner = new Partner(resultSet.getInt("id"), resultSet.getString("company_name"), resultSet.getString("adress"), resultSet.getString("city"), resultSet.getString("state"), resultSet.getString("postal_code"), resultSet.getString("country"), resultSet.getString("phone"), resultSet.getString("email"), resultSet.getString("URL"), resultSet.getString("logo"));
            }

        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }

        return partner;

    }


    /**
     * @return
     */
    public List<Partner> selectAllPartners() throws SQLException {

        List<Partner> partnerList = new ArrayList<>();

        try {

            Connection conn = DBHelper.getconnection();
            PreparedStatement ps = conn.prepareStatement(SELECT_ALL_PARTNERS);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()) {
                partnerList.add(new Partner(resultSet.getInt("id"), resultSet.getString("company_name"), resultSet.getString("adress"), resultSet.getString("city"), resultSet.getString("state"), resultSet.getString("postal_code"), resultSet.getString("country"), resultSet.getString("phone"), resultSet.getString("email"), resultSet.getString("URL"), resultSet.getString("logo")));
            }

        } catch (SQLException e) {
            System.out.println("SQLException: " + e);
        }

        return partnerList;
    }


    /**
     * @param partner
     * @throws Exception
     */
    public void createPartner(Partner partner) throws Exception {

        if (partner != null) {

            try {

                Connection conn = DBHelper.getconnection();

                PreparedStatement ps = conn.prepareStatement(INSERT_PARTNER, Statement.RETURN_GENERATED_KEYS);

                ps.setString(1, partner.getCompanyName());
                ps.setString(2, partner.getAddress());
                ps.setString(3, partner.getCity());
                ps.setString(4, partner.getState());
                ps.setString(5, partner.getPostalCode());
                ps.setString(6, partner.getCountry());
                ps.setString(7, partner.getPhone());
                ps.setString(8, partner.getEmail());
                ps.setString(9, partner.getURL());
                ps.setString(10, partner.getLogo());

                int result = ps.executeUpdate();

                if (result == 0) {
                    throw new SQLException("Creating Partner failed. No rows affected.");
                }

                try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        System.out.println("GeneratedKey: " + generatedKeys.getInt(1));
                    } else {
                        throw new SQLException("Creating Partner failed. No ID obtained.");
                    }
                }
            } catch (SQLException e) {
                System.out.println("SQLException: " + e);
            }

        } else {
            throw new Exception("Cannot insert null partner object");
        }
    }


    public void updatePartner(Partner partner) {

        try {
            Connection conn = DBHelper.getconnection();
            PreparedStatement ps = conn.prepareStatement(UPDATE_PARTNER);
            ps.setString(1, partner.getCompanyName());
            ps.setString(2, partner.getAddress());
            ps.setString(3, partner.getCity());
            ps.setString(4, partner.getState());
            ps.setString(5, partner.getPostalCode());
            ps.setString(6, partner.getCountry());
            ps.setString(7, partner.getPhone());
            ps.setString(8, partner.getEmail());
            ps.setString(9, partner.getURL());
            ps.setString(10, partner.getLogo());
            ps.setInt(11, partner.getId());

            int result = ps.executeUpdate();

            if (result == 0) {
                System.out.println("No partner found for partner id: " + partner.getId());
            }

        } catch (SQLException e) {
            System.out.println("SQLException: " + e);

        }
    }
}
