package com.lmp.view;

import com.lmp.dao.PartnerDao;
import com.lmp.model.Partner;
import com.lmp.service.PartnerService;

import java.math.BigDecimal;

public class TestClient4Partner {

    public static void main(String[] args) throws Exception {
        
        System.out.println("THIS IS PARTNER SERVICE TEST");
        PartnerService partnerService = new PartnerService(new PartnerDao());
        System.out.println("getPartner(1): " + partnerService.getPartner(1));
        System.out.println("listPartners: " + partnerService.listPartners());

        Partner partner1 = new Partner("Myco", "6331 N Kenmore Ave", "Chicago", "IL", "60660", "USA", "800-556-8876", "abc@xyz.com", "http://www.xyz.com", "", "", "", "", true);
        partnerService.addPartner(partner1);
        System.out.println("listPartners - after new partner add: " + partnerService.listPartners());

        Partner partner2 = new Partner(1, "Myorg", "6332 N Kenmore Ave", "Chicago", "IL", "60660", "USA", "800-666-7776", "abc@abc.com", "http://www.abc.com", "", "", "", "", true);
        partnerService.updatePartner(partner2);
        System.out.println("listPartners - after update: " + partnerService.listPartners());

        partnerService.deletePartner(1);
        System.out.println("listPartners - after delete: " + partnerService.listPartners());
    }
}
