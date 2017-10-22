/*
 * File User.java of project sandbox-s5-model.
 * File created on 16 ott 2017 at 14:38:11 at PN-HQ.
 */
package it.pn.sandbox.spring5.model.sql.accounting;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import it.pn.sandbox.spring5.model.base.seq.SequenceBaseEntityAudit;

/**
 * Class User representing ...
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
@Entity
@Table(name = "SBX_USER", uniqueConstraints = { @UniqueConstraint(columnNames = "USERNAME"), @UniqueConstraint(columnNames = "EMAIL") })
@SequenceGenerator(sequenceName = "SBX_SEQ_USER", name = "generator", initialValue = 1, allocationSize = 1 /* TODO: tune allocation size */)
public class User extends SequenceBaseEntityAudit {
    /**
     * Field serialVersionUID:long representing ...
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "USERNAME")
    protected String username;

    @Column(name = "PASSWORD", nullable = false)
    protected String password;

    @Column(name = "ENABLED", nullable = false)
    protected Boolean enabled = true; // default

    @Column(name = "EMAIL", nullable = false)
    protected String email;

    @Column(name = "TELEPHONE")
    protected String telephone;

    // @formatter:off
    // TODO: add JSON ignore if null
    @ManyToMany
    @JoinTable(name = "SBX_USER_GROUP"
    	, joinColumns = { @JoinColumn(name = "USER_ID", referencedColumnName = "ID") }
    	, inverseJoinColumns = {@JoinColumn(name = "GROUP_ID", referencedColumnName = "ID") }
    )
    // @formatter:on
    protected Set<Group> groups;

    /**
     * Getter for the field username:String.
     *
     * @return the username
     */
    public String getUsername() {
	return this.username;
    }

    /**
     * Setter for the field username.
     *
     * @param username
     *            the username to set
     */
    public void setUsername(String username) {
	this.username = username;
    }

    /**
     * Getter for the field password:String.
     *
     * @return the password
     */
    public String getPassword() {
	return this.password;
    }

    /**
     * Setter for the field password.
     *
     * @param password
     *            the password to set
     */
    public void setPassword(String password) {
	this.password = password;
    }

    /**
     * Getter for the field enabled:Boolean.
     *
     * @return the enabled
     */
    public Boolean getEnabled() {
	return this.enabled;
    }

    /**
     * Setter for the field enabled.
     *
     * @param enabled
     *            the enabled to set
     */
    public void setEnabled(Boolean enabled) {
	this.enabled = enabled;
    }

    /**
     * Getter for the field email:String.
     *
     * @return the email
     */
    public String getEmail() {
	return this.email;
    }

    /**
     * Setter for the field email.
     *
     * @param email
     *            the email to set
     */
    public void setEmail(String email) {
	this.email = email;
    }

    /**
     * Getter for the field telephone:String.
     *
     * @return the telephone
     */
    public String getTelephone() {
	return this.telephone;
    }

    /**
     * Setter for the field telephone.
     *
     * @param telephone
     *            the telephone to set
     */
    public void setTelephone(String telephone) {
	this.telephone = telephone;
    }

    /**
     * Getter for the field groups:Set<Group>.
     *
     * @return the groups
     */
    public Set<Group> getGroups() {
	return this.groups;
    }

    /**
     * Setter for the field groups.
     *
     * @param groups
     *            the groups to set
     */
    public void setGroups(Set<Group> groups) {
	this.groups = groups;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("User [id=");
	builder.append(this.id);
	builder.append(", username=");
	builder.append(this.username);
	builder.append(", password=");
	builder.append(this.password);
	builder.append(", enabled=");
	builder.append(this.enabled);
	builder.append(", email=");
	builder.append(this.email);
	builder.append(", telephone=");
	builder.append(this.telephone);
	// builder.append(", groups=");
	// builder.append(this.groups);
	builder.append("]");
	return builder.toString();
    }
}
