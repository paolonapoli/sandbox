/*
 * File BaseEntity.java of project sandbox-s5-model.
 * File created on 16 ott 2017 at 14:28:49 at PN-HQ.
 */
package it.pn.sandbox.spring5.model.base.simple;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import it.pn.sandbox.spring5.model.base.VersionBaseEntity;

/**
 * Class BaseEntity representing ...
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
@MappedSuperclass
public class BaseEntity extends VersionBaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    protected Long id;

    @Override
    public Long getId() {
	return this.id;
    }

    @Override
    public String toString() {
	return this.getClass().getName() + " [ID=" + this.id + "]";
    }
}
