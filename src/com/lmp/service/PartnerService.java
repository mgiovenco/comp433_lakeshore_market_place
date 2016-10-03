package com.lmp.service;

import com.lmp.dao.PartnerDao;
import com.lmp.model.Partner;
import java.sql.SQLException;
import java.util.List;

/**
 * Service for interacting with partner entities.
 */
public class PartnerService {

    private PartnerDao partnerDao;

    public PartnerService(PartnerDao partnerDao) {
        this.partnerDao = partnerDao;
    }

    /**
     * Get partner by id.
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public Partner getPartner(int id) throws SQLException {
        return partnerDao.selectPartner(id);
    }

    /**
     * List all partners.
     *
     * @return
     * @throws SQLException
     */
    public List<Partner> listPartners() throws SQLException {
        return partnerDao.selectAllPartners();
    }

    /**
     * Add single partner.
     *
     * @param partner
     * @throws Exception
     */
    public void addPartner(Partner partner) throws Exception {
        partnerDao.createPartner(partner);
    }

    /**
     * Update single partner.
     *
     * @param partner
     */
    public void updatePartner(Partner partner) {
        partnerDao.updatePartner(partner);
    }

    /**
     * Soft delete single partner.
     *
     * @param id
     */
    public void deletePartner(int id) {
        partnerDao.updatePartnerActiveStatus(id, false);
    }

}
