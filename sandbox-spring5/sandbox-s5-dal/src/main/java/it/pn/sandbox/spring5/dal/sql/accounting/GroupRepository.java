/*
 * File GroupRepository.java of project sandbox-s5-dal.
 * File created on 16 ott 2017 at 15:01:01 at PN-HQ.
 */
package it.pn.sandbox.spring5.dal.sql.accounting;

import org.springframework.data.repository.PagingAndSortingRepository;

import it.pn.sandbox.spring5.model.sql.accounting.Group;

/**
 * Class GroupRepository representing ...
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
public interface GroupRepository extends PagingAndSortingRepository<Group, Long> {
    /**
     * Method findByAliasIgnoreCase returns Group.
     *
     * @param alias
     * @return
     */
    Group findByAliasIgnoreCase(String alias);
}
