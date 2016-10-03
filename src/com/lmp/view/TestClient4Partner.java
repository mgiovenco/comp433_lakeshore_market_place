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

        Partner partner1 = new Partner("MYCO", "6331 N Kenmore Ave", "Chicago", "IL", “60660”, “USA”, ”abc@xyz.com”, ”xyz.com”, ”Check”, true);
        partnerService.addPartner(partner1);
        System.out.println("listPartners - after new partner add: " + partnerService.listPartners());

        Partner partner2 = new Partner(1, “MYCOM", "6332 N Kenmore Ave", "Chicago", "IL", “60660”, “USA”, ”xyz@xyz.com”, ”xyz.com”, ”Cash”, true);
        partnerService.updatePartner(partner2);
        System.out.println("listPartners - after update: " + partnerService.listPartners());

        partnerService.deletePartner(1);
        System.out.println("listPartners - after delete: " + partnerService.listPartners());
    }
}
