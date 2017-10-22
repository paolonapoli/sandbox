/*
 * File Group.java of project sandbox-s5-model.
 * File created on 16 ott 2017 at 14:41:56 at PN-HQ.
 */
package it.pn.sandbox.spring5.model.sql.accounting;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import it.pn.sandbox.spring5.model.base.seq.SequenceBaseEntityAudit;

/**
 * Class Group representing ...
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
@Entity
@Table(name = "SBX_GROUP", uniqueConstraints = { @UniqueConstraint(columnNames = { "GID_ALIAS" }) })
@SequenceGenerator(sequenceName = "SBX_SEQ_GROUP", name = "generator", initialValue = 1, allocationSize = 1 /* TODO: tune allocation size */)
public class Group extends SequenceBaseEntityAudit {

    /**
     * Field serialVersionUID:long representing ...
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "NAME", nullable = false)
    protected String name;

    @Column(name = "GID_ALIAS", nullable = false)
    protected String alias;

    @ManyToMany(mappedBy = "groups")
    protected Set<User> users;

    /**
     * Getter for the field name:String.
     *
     * @return the name
     */
    public String getName() {
	return this.name;
    }

    /**
     * Setter for the field name.
     *
     * @param name
     *            the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * Getter for the field alias:String.
     *
     * @return the alias
     */
    public String getAlias() {
	return this.alias;
    }

    /**
     * Setter for the field alias.
     *
     * @param alias
     *            the alias to set
     */
    public void setAlias(String alias) {
	this.alias = alias;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Group [id=");
	builder.append(this.id);
	builder.append(", name=");
	builder.append(this.name);
	builder.append(", alias=");
	builder.append(this.alias);
	// builder.append(", users=");
	// builder.append(users);
	builder.append("]");
	return builder.toString();
    }
}
