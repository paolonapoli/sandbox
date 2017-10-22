/*
 * File VersionBaseEntity.java of project sandbox-s5-model.
 * File created on 22 ott 2017 at PN-HQ.
 */
package it.pn.sandbox.spring5.model.base;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import it.pn.sandbox.spring5.model.base.simple.BaseEntity;

/**
 * Class VersionBaseEntity.
 * TO DO://complete doc
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
@MappedSuperclass
public abstract class VersionBaseEntity implements Serializable {

    /**
     * Field serialVersionUID:long
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "VERSION")
    @Version
    private Long version;

    public abstract Long getId();

    public Long getVersion() {
	return this.version;
    }

    @Override
    public int hashCode() {
	int hash = 0;
	hash += (this.getId() != null ? this.getId().hashCode() : 0);

	return hash;
    }

    @Override
    public boolean equals(Object object) {
	if (this == object) {
	    return true;
	}
	if (object == null) {
	    return false;
	}
	if (getClass() != object.getClass()) {
	    return false;
	}

	BaseEntity other = (BaseEntity) object;
	if ((this.getId() != other.getId()) && ((this.getId() == null) || !this.getId().equals(other.getId()))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return this.getClass().getName() + " [ID=" + this.getId() + "]";
    }
}
