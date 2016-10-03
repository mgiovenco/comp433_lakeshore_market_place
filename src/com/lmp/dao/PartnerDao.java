package com.lmp.dao;

import com.lmp.model.Partner;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.sql.Timestamp;

import java.util.ArrayList;

import java.util.List;


/**

* DAO for interacting with Partner tables.

*/

public class PartnerDao {

private static final String SELECT_PARTNER = "SELECT id, company_name, adress, city, state, postal_code, country, phone, URL, payment_methods, type, current_order, logo, active, created_on, updated_on from partner where id = ?";

private static final String SELECT_ALL_PARTNERS = "SELECT id, company_name, adress, city, state, postal_code, country, phone, URL, payment_methods, type, current_order, logo, active, created_on, updated_on from partner";

private static final String INSERT_PARTNER = "INSERT into partner (company_name, adress, city, state, postal_code, country, phone, URL, payment_methods, type, current_order, logo, active, created_on) values (?, ?, ?, ?, ?, ?)";

private static final String UPDATE_PARTNER = "UPDATE partner set company_name = ?, adress = ?, city= ?, state= ?, postal_code= ?, country= ?, phone= ?, URL= ?, payment_methods= ?, type= ?, current_order= ?, logo, = ?, email = ?, active = ?, updated_on = ? where id = ?";

private static final String INACTIVATE_PARTNER = "UPDATE partner set active = ?, updated_on = ? where id = ?";





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

partner = new Partner(resultSet.getInt("id"), resultSet.getString("company_name"), resultSet.getString("adress"), resultSet.getString("city"), resultSet.getString("state"), resultSet.getString("postal_code"), resultSet.getString("country"), resultSet.getString("phone"), resultSet.getString("URL"), resultSet.getString("payment_methods"), resultSet.getString("type"), resultSet.getString("current_order"), resultSet.getString("logo"), resultSet.getBoolean("active"), resultSet.getTimestamp("created_on"), resultSet.getTimestamp("updated_on"));

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

partnerList.add(new Partner(resultSet.getInt("id"), resultSet.getString("company_name"), resultSet.getString("adress"), resultSet.getString("city"), resultSet.getString("state"), resultSet.getString("postal_code"), resultSet.getString("country"), resultSet.getString("phone"), resultSet.getString("URL"), resultSet.getString("payment_methods"), resultSet.getString("type"), resultSet.getString("current_order"), resultSet.getString("logo"), resultSet.getBoolean("active"), resultSet.getTimestamp("created_on"), resultSet.getTimestamp("updated_on")));

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

ps.setString(1, partner. getCompany_name());
ps.setString(2, partner.getAdress());
ps.setString(3, partner.getCity ));
ps.setString(4, partner.getState ));
ps.setString(5, partner.getPostal_code());
ps.setString(6, partner.getCountry());
ps.setString(7, partner.getPhone());
ps.setString(8, partner.getURL());
ps.setString(9, partner.getPayment_methods());
ps.setString(10, partner.getType());
ps.setString(11, partner.getCurrent_order());
ps.setString(12, partner.getLogo());
ps.setBoolean(13, partner.isActive());
ps.setTimestamp(14, new Timestamp(new java.util.Date().getTime()));

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



public void updateCustomer(Partner partner) {

try {

Connection conn = DBHelper.getconnection();

PreparedStatement ps = conn.prepareStatement(UPDATE_PARTNER);

ps.setString(1, partner. getCompany_name());
ps.setString(2, partner.getAdress());
ps.setString(3, partner.getCity ));
ps.setString(4, partner.getState ));
ps.setString(5, partner.getPostal_code());
ps.setString(6, partner.getCountry());
ps.setString(7, partner.getPhone());
ps.setString(8, partner.getURL());
ps.setString(9, partner.getPayment_methods());
ps.setString(10, partner.getType());
ps.setString(11, partner.getCurrent_order());
ps.setString(12, partner.getLogo());
ps.setBoolean(13, partner.isActive());
ps.setTimestamp(14, new Timestamp(new java.util.Date().getTime()));
ps.setInt(15, partner.getId());

int result = ps.executeUpdate();



if (result == 0) {

System.out.println("No partner found for partner id: " + partner.getId());

}

} catch (SQLException e) {

System.out.println("SQLException: " + e);

}

}



public void updatePartnerActiveStatus(int id, boolean status) {

try {

Connection conn = DBHelper.getconnection();

PreparedStatement ps = conn.prepareStatement(INACTIVATE_PARTNER);



ps.setBoolean(1, status);

ps.setTimestamp(2, new Timestamp(new java.util.Date().getTime()));

ps.setInt(3, id);



int result = ps.executeUpdate();



if (result == 0) {

System.out.println("No partner found for partner id: " + id);

}

} catch (SQLException e) {

System.out.println("SQLException: " + e);

}

}