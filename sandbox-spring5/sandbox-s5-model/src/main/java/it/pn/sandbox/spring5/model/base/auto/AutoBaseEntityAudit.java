/*
 * File AutoBaseEntityAudit.java of project sandbox-s5-model.
 * File created on 22 ott 2017 at PN-HQ.
 */
package it.pn.sandbox.spring5.model.base.auto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

/**
 * Class AutoBaseEntityAudit.
 * TO DO://complete doc
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
@MappedSuperclass
public abstract class AutoBaseEntityAudit extends AutoBaseEntity {

    /**
     * Field serialVersionUID:long representing ...
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "CREATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Size(max = 20)
    @Column(name = "CREATED_BY", length = 20)
    private String createdBy;

    @Column(name = "UPDATED_AT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Size(max = 20)
    @Column(name = "UPDATED_BY", length = 20)
    private String updatedBy;

    public Date getCreatedAt() {
	return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
    }

    public String getCreatedBy() {
	return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
	this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
	return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
	return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
	this.updatedBy = updatedBy;
    }

    /**
     * Sets createdAt before insert
     */
    @PrePersist
    public void setCreationDate() {
	this.createdAt = new Date();
    }

    /**
     * Sets updatedAt before update
     */
    @PreUpdate
    public void setChangeDate() {
	this.updatedAt = new Date();
    }
}
