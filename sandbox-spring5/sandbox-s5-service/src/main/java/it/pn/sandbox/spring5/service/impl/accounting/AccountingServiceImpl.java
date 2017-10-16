/*
 * File AccountingServiceImpl.java of project sandbox-s5-service.
 * File created on 16 ott 2017 at 22:45:52 at PN-HQ.
 */
package it.pn.sandbox.spring5.service.impl.accounting;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import it.pn.sandbox.spring5.dal.repository.accounting.GroupRepository;
import it.pn.sandbox.spring5.dal.repository.accounting.UserRespository;
import it.pn.sandbox.spring5.model.accounting.Group;
import it.pn.sandbox.spring5.model.accounting.User;
import it.pn.sandbox.spring5.service.accounting.AccountingService;
import it.pn.sandbox.spring5.service.accounting.exception.AlreadyExistentGroupException;
import it.pn.sandbox.spring5.service.accounting.exception.AlreadyExistentUserException;
import it.pn.sandbox.spring5.service.accounting.exception.InvalidGroupException;

/**
 * Class AccountingServiceImpl representing ...
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
@Service
public class AccountingServiceImpl implements AccountingService {
    @Autowired
    private UserRespository userRespository;

    @Autowired
    private GroupRepository groupRepository;

    /*
     * (non-Javadoc)
     * @see it.pn.sandbox.spring5.service.accounting.AccountService#createUser(it.pn.sandbox.spring5.model.accounting.User)
     */
    @Override
    public void createUser(User user) throws AlreadyExistentUserException {
	Assert.notNull(user, "NULL user supplied");
	Assert.hasText(user.getUsername(), "NULL user's username supplied");

	User userTest = this.userRespository.findByUsernameIgnoreCase(user.getUsername());
	if (userTest != null) {
	    throw new AlreadyExistentUserException(String.format("User with username '%s' already exists.", user.getUsername()));
	}

	this.userRespository.save(user);
    }

    /*
     * (non-Javadoc)
     * @see it.pn.sandbox.spring5.service.accounting.AccountService#createUser(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Set)
     */
    @Override
    public void createUser(String username, String password, String email, String telephone, Set<String> groupAliases) throws InvalidGroupException, AlreadyExistentUserException {
	User user = new User();
	user.setUsername(username);
	user.setPassword(password);
	user.setEmail(email);
	user.setTelephone(telephone);

	if (groupAliases != null) {
	    Set<Group> userGroups = new HashSet<>();
	    for (String alias : groupAliases) {
		Group group = this.groupRepository.findByAliasIgnoreCase(alias);

		if (group == null) {
		    throw new InvalidGroupException(String.format("Group alias '%s' is not valid.", alias));
		}

		userGroups.add(group);
	    } // for
	    user.setGroups(userGroups);
	}

	createUser(user);
    }

    /*
     * (non-Javadoc)
     * @see it.pn.sandbox.spring5.service.accounting.AccountService#createGroup(it.pn.sandbox.spring5.model.accounting.Group)
     */
    @Override
    public void createGroup(Group group) throws AlreadyExistentGroupException {
	Assert.notNull(group, "NULL group supplied");
	Assert.hasText(group.getAlias(), "NULL group alias supplied");

	Group groupTest = this.groupRepository.findByAliasIgnoreCase(group.getAlias());
	if (groupTest != null) {
	    throw new AlreadyExistentGroupException(String.format("Group alias '%s' already exists.", group.getAlias()));
	}

	this.groupRepository.save(group);
    }

    /*
     * (non-Javadoc)
     * @see it.pn.sandbox.spring5.service.accounting.AccountService#createGroup(java.lang.String, java.lang.String)
     */
    @Override
    public void createGroup(String name, String alias) throws AlreadyExistentGroupException {
	Group g = new Group();
	g.setName(name);
	g.setAlias(alias);

	createGroup(g);
    }
}
