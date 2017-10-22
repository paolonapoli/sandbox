/*
 * File SequenceBaseEntity.java of project sandbox-s5-model.
 * File created on 22 ott 2017 at PN-HQ.
 */
package it.pn.sandbox.spring5.model.base.seq;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import it.pn.sandbox.spring5.model.base.VersionBaseEntity;

/**
 * Class SequenceBaseEntity.
 * TO DO://complete doc
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
@MappedSuperclass
public abstract class SequenceBaseEntity extends VersionBaseEntity {
    /**
     * Field serialVersionUID:long
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
    @Basic(optional = false)
    @Column(name = "ID", nullable = false)
    protected Long id;

    /*
     * (non-Javadoc)
     * @see it.pn.sandbox.spring5.model.base.VersionBaseEntity#getId()
     */
    @Override
    public Long getId() {
	return this.id;
    }
}
