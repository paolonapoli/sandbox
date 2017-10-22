/*
 * File Invoice.java of project sandbox-s5-model.
 * File created on 22 ott 2017 at PN-HQ.
 */
package it.pn.sandbox.spring5.model.mysql.invoice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

import it.pn.sandbox.spring5.model.base.auto.AutoBaseEntityAudit;

/**
 * Class Invoice.
 * TO DO://complete doc
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
@Entity
@Table(name = "SBX_INVOICE")
public class Invoice extends AutoBaseEntityAudit {

    /**
     * Field serialVersionUID:long
     */
    private static final long serialVersionUID = 1L;

    @Lob
    @Column(name = "NOTE")
    protected String note;

    @Column(name = "ORDER_ID")
    protected Long orderId;

    @Column(name = "USER_ID")
    protected Long userId;

    /**
     * Getter for the field note:String.
     *
     * @return the note
     */
    public String getNote() {
	return this.note;
    }

    /**
     * Setter for the field note.
     *
     * @param note
     *            the note to set
     */
    public void setNote(String note) {
	this.note = note;
    }

    /**
     * Getter for the field orderId:Long.
     *
     * @return the orderId
     */
    public Long getOrderId() {
	return this.orderId;
    }

    /**
     * Setter for the field orderId.
     *
     * @param orderId
     *            the orderId to set
     */
    public void setOrderId(Long orderId) {
	this.orderId = orderId;
    }

    /**
     * Getter for the field userId:Long.
     *
     * @return the userId
     */
    public Long getUserId() {
	return this.userId;
    }

    /**
     * Setter for the field userId.
     *
     * @param userId
     *            the userId to set
     */
    public void setUserId(Long userId) {
	this.userId = userId;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Invoice [id=");
	builder.append(this.id);
	builder.append(", note=");
	builder.append(this.note);
	builder.append(", orderId=");
	builder.append(this.orderId);
	builder.append(", userId=");
	builder.append(this.userId);
	builder.append("]");
	return builder.toString();
    }
}
