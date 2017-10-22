/*
 * File ProductOrderRepository.java of project sandbox-s5-dal.
 * File created on 16 ott 2017 at 17:29:00 at PN-HQ.
 */
package it.pn.sandbox.spring5.dal.sql.product;

import org.springframework.data.repository.PagingAndSortingRepository;

import it.pn.sandbox.spring5.model.sql.product.ProductOrder;

/**
 * Class ProductOrderRepository representing ...
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
public interface ProductOrderRepository extends PagingAndSortingRepository<ProductOrder, Long> {

}
