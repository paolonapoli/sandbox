/*
 * File UserRespository.java of project sandbox-s5-dal.
 * File created on 16 ott 2017 at 14:59:59 at PN-HQ.
 */
package it.pn.sandbox.spring5.dal.sql.accounting;

import org.springframework.data.repository.PagingAndSortingRepository;

import it.pn.sandbox.spring5.model.sql.accounting.User;

/**
 * Class UserRespository representing ...
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
public interface UserRespository extends PagingAndSortingRepository<User, Long> {
    /**
     * Method findByUsernameIgnoreCase returns User.
     *
     * @param username
     * @return
     */
    User findByUsernameIgnoreCase(String username);
}
