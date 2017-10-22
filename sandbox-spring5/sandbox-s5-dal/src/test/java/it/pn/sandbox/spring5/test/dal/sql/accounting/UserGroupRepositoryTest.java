/*
 * File UserRepositoryTest.java of project sandbox-s5-dal.
 * File created on 16 ott 2017 at 15:05:40 at PN-HQ.
 */
package it.pn.sandbox.spring5.test.dal.sql.accounting;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import it.pn.sandbox.spring5.dal.conf.SandboxOracleConfig;
import it.pn.sandbox.spring5.dal.sql.accounting.GroupRepository;
import it.pn.sandbox.spring5.dal.sql.accounting.UserRespository;
import it.pn.sandbox.spring5.model.sql.accounting.Group;
import it.pn.sandbox.spring5.model.sql.accounting.User;

/**
 * Class UserRepositoryTest representing ...
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SandboxOracleConfig.class })
@Transactional
// @Commit // does the COMMIT at the end
public class UserGroupRepositoryTest {
    @Autowired
    private UserRespository userRepository;

    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private EntityManager em;

    // @Before
    public void init() {
	this.userRepository.deleteAll();
	this.em.flush();
	this.groupRepository.deleteAll();
	this.em.flush();
    }

    @Test
    public void pupulateUsers() {
	init();

	System.out.println("************ Adding Users ********************");
	//@formatter:off
	String[] allGroups = new String[]{"USER", "CONS", "PROD", "ADMIN"};
	String[] users = new String[]{"user", "admin", "cons", "prod"};
	String[] passwords = new String[]{"user", "admin", "cons", "prod"};
	String[] emails = new String[]{"user@gas.it", "admin@gas.it", "cons@gas.it", "prod@gas.it"};
	String[] phones = new String[]{"123456", "124567", "125678", "126789"};
	String[][] groups = new String[][]{
	    	{"USER"}
	    	, {"USER", "CONS", "PROD", "ADMIN"}
	    	, {"USER", "CONS"}
	    	, {"USER", "PROD"}
	};
	//@formatter:on

	// save all groups
	for (String group : allGroups) {
	    Group g = new Group();
	    g.setName(StringUtils.capitalize(group.toLowerCase()));
	    g.setAlias(StringUtils.upperCase(group.toLowerCase()));
	    this.groupRepository.save(g);
	}

	for (int i = 0; i < users.length; i++) {
	    User u = new User();
	    u.setUsername(users[i]);
	    u.setPassword(passwords[i]);
	    u.setEmail(emails[i]);
	    u.setTelephone(phones[i]);

	    Set<Group> userGroups = new HashSet<>();
	    for (String group : groups[i]) {
		Group g = this.groupRepository.findByAliasIgnoreCase(group);
		userGroups.add(g);
	    }
	    u.setGroups(userGroups);

	    // saves user and association
	    this.userRepository.save(u);
	}
    }

    @Test
    public void findUserAdmin() {
	System.out.println("************ Find user ADMIN lazy ********************");
	User admin = this.userRepository.findByUsernameIgnoreCase("aDmIN");
	System.out.println(admin);
    }

    @Test
    public void findUserAdminLazyLoadGroups() {
	System.out.println("************ Adding user ADMIN lazy with load ********************");
	User admin = this.userRepository.findByUsernameIgnoreCase("aDmIN");
	String adminString = ToStringBuilder.reflectionToString(admin, ToStringStyle.MULTI_LINE_STYLE);
	System.out.println(adminString);
    }

    @Test
    public void findGroupUsers() {
	System.out.println("************ Find group USER lazy ********************");
	Group group = this.groupRepository.findByAliasIgnoreCase("UseR");
	System.out.println(group);
    }

    @Test
    public void findGroupUsersLazyLoadUsers() {
	System.out.println("************ Find group USER lazy with load ********************");
	Group group = this.groupRepository.findByAliasIgnoreCase("UseR");
	String string = ToStringBuilder.reflectionToString(group, ToStringStyle.MULTI_LINE_STYLE);
	System.out.println(string);
    }

    @Test
    public void pupulateUserException() {
	System.out.println("************ Adding User ********************");
	// save user
	User u = new User();
	u.setUsername("myuser");
	u.setPassword("mypassword");
	u.setEmail("myemail@test.com");
	u.setTelephone("1234567890");
	this.userRepository.save(u);

	throw new RuntimeException("volontary");
    }
}
