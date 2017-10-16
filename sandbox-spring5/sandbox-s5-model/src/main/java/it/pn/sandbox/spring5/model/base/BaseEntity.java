/*
 * File BaseEntity.java of project sandbox-s5-model.
 * File created on 16 ott 2017 at 14:28:49 at PN-HQ.
 */
package it.pn.sandbox.spring5.model.base;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * Class BaseEntity representing ...
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
@MappedSuperclass
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    protected Long id;

    @Column(name = "VERSION")
    @Version
    private Long version;

    public Long getId() {
	return this.id;
    }

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
	if ((this.getId() != other.getId()) && ((this.getId() == null) || !this.id.equals(other.id))) {
	    return false;
	}
	return true;
    }

    @Override
    public String toString() {
	return this.getClass().getName() + " [ID=" + this.id + "]";
    }
}
