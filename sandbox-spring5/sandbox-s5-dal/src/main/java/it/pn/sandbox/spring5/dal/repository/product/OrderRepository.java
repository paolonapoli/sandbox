/*
 * File OrderRepository.java of project sandbox-s5-dal.
 * File created on 16 ott 2017 at 17:28:35 at PN-HQ.
 */
package it.pn.sandbox.spring5.dal.repository.product;

import java.util.Set;

import org.springframework.data.repository.PagingAndSortingRepository;

import it.pn.sandbox.spring5.model.accounting.User;
import it.pn.sandbox.spring5.model.product.Order;

/**
 * Class OrderRepository representing ...
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {
    /**
     * Method findByUser returns Set<Order>.
     *
     * @param u
     * @return
     */
    public Set<Order> findByUser(User u);
}
