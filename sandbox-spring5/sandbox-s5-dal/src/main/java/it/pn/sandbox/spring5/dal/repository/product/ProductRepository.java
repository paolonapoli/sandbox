/*
 * File ProductRepository.java of project sandbox-s5-dal.
 * File created on 16 ott 2017 at 17:27:57 at PN-HQ.
 */
package it.pn.sandbox.spring5.dal.repository.product;

import org.springframework.data.repository.PagingAndSortingRepository;

import it.pn.sandbox.spring5.model.product.Product;

/**
 * Class ProductRepository representing ...
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

}
