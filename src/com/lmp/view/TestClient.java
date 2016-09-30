package com.lmp.view;

import com.lmp.dao.CustomerDao;
import com.lmp.model.Customer;
import com.lmp.model.CustomerAddress;
import com.lmp.model.CustomerBillingInfo;
import com.lmp.service.CustomerService;

public class TestClient {

    public static void main(String[] args) throws Exception {

        System.out.println("###CustomerService Test###");
        CustomerService customerService = new CustomerService(new CustomerDao());
        System.out.println("getCustomer(1): " + customerService.getCustomer(1));
        System.out.println("listCustomers: " + customerService.listCustomers());

        Customer customer1 = new Customer("Dan", "Danson", "847-123-4567", true);
        customerService.addCustomer(customer1);
        System.out.println("listCustomers - after new customer add: " + customerService.listCustomers());

        Customer customer2 = new Customer(1, "Edward", "Edwardson", "444-555-6666", true);
        customerService.updateCustomer(customer2);
        System.out.println("listCustomers - after update: " + customerService.listCustomers());

        customerService.deleteCustomer(1);
        System.out.println("listCustomers - after delete: " + customerService.listCustomers());

        CustomerAddress customerAddress1 = new CustomerAddress("456 fake ln", "unit 402", "Chicago", "IL", "60642", "USA", true, true, true, 1);
        customerService.addCustomerAddress(customerAddress1);

        System.out.println("getCustomerAddress(1): " + customerService.getCustomerAddress(1));
        System.out.println("listCustomerAddressesByCustId(1): " + customerService.getCustomerAddressesByCustId(1));

        CustomerAddress customerAddress2 = new CustomerAddress(1, "555 super fake ln", "unit 555", "Chicago", "IL", "123456", "USA", true, false, true, 1);
        customerService.updateCustomerAddress(customerAddress2);

        System.out.println("listCustomerAddressesByCustId(1) - after update: " + customerService.getCustomerAddressesByCustId(1));

        customerService.deleteCustomerAddress(1);
        System.out.println("getCustomerAddress(1) - after 1: " + customerService.getCustomerAddress(1));

        System.out.println("getCustomerBillingInfo(1): " + customerService.getCustomerBillingInfo(1));

        CustomerBillingInfo customerBillingInfo1 = new CustomerBillingInfo("4444444444444444444", "1117", true, 1);
        customerService.addCustomerBillingInfo(customerBillingInfo1);

        CustomerBillingInfo customerBillingInfo2 = new CustomerBillingInfo(1, "5555555555555555555", "1218", false);
        customerService.updateCustomerBillingInfo(customerBillingInfo2);

        System.out.println("getCustomerBillingInfoByCustId(1): " + customerService.getCustomerBillingInfoByCustId(1));

    }
}
