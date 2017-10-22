/*
 * File InvoiceRepository.java of project sandbox-s5-dal.
 * File created on 22 ott 2017 at PN-HQ.
 */
package it.pn.sandbox.spring5.dal.mysql.invoice;

import java.util.Set;

import org.springframework.data.repository.PagingAndSortingRepository;

import it.pn.sandbox.spring5.model.mysql.invoice.Invoice;

/**
 * Class InvoiceRepository.
 * TO DO://complete doc
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
public interface InvoiceRepository extends PagingAndSortingRepository<Invoice, Long> {
    /**
     * Method findByOrderId returns Set<Invoice>.
     *
     * @param orderId
     * @return
     */
    Set<Invoice> findByOrderId(Long orderId);

    /**
     * Method findByUserId returns Set<Invoice>.
     *
     * @param userId
     * @return
     */
    Set<Invoice> findByUserId(Long userId);
}
