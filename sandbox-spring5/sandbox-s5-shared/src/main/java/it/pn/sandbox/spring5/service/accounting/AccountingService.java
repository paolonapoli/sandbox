/*
 * File AccountingService.java of project sandbox-s5-service.
 * File created on 16 ott 2017 at 19:28:44 at PN-HQ.
 */
package it.pn.sandbox.spring5.service.accounting;

import java.util.Set;

import it.pn.sandbox.spring5.model.sql.accounting.Group;
import it.pn.sandbox.spring5.model.sql.accounting.User;
import it.pn.sandbox.spring5.service.accounting.exception.AlreadyExistentGroupException;
import it.pn.sandbox.spring5.service.accounting.exception.AlreadyExistentUserException;
import it.pn.sandbox.spring5.service.accounting.exception.InvalidGroupException;

/**
 * Class AccountingService representing ...
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
public interface AccountingService {
    /**
     * Method createUser returns void.
     *
     * @param user
     * @throws AlreadyExistentUserException
     */
    public void createUser(User user) throws AlreadyExistentUserException;

    /**
     * Method createUser returns void.
     *
     * @param username
     * @param password
     * @param email
     * @param telephone
     * @param groupAliases
     * @throws InvalidGroupException
     * @throws AlreadyExistentUserException
     */
    public void createUser(String username, String password, String email, String telephone, Set<String> groupAliases) throws InvalidGroupException, AlreadyExistentUserException;

    /**
     * Method createGroup returns void.
     *
     * @param group
     * @throws AlreadyExistentGroupException
     */
    public void createGroup(Group group) throws AlreadyExistentGroupException;

    /**
     * Method createGroup returns void.
     *
     * @param name
     * @param alias
     * @throws AlreadyExistentGroupException
     */
    public void createGroup(String name, String alias) throws AlreadyExistentGroupException;
}
