/*
 * File Order.java of project sandbox-s5-model.
 * File created on 16 ott 2017 at 16:51:07 at PN-HQ.
 */
package it.pn.sandbox.spring5.model.sql.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import it.pn.sandbox.spring5.model.base.seq.SequenceBaseEntityAudit;
import it.pn.sandbox.spring5.model.sql.accounting.User;

/**
 * Class Order representing ...
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
@Entity
@Table(name = "SBX_ORDER")
@SequenceGenerator(sequenceName = "SBX_SEQ_ORDER", name = "generator", initialValue = 1, allocationSize = 1 /* TODO: tune allocation size */)
public class Order extends SequenceBaseEntityAudit {

    /**
     * Field serialVersionUID:long representing ...
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "ADDRESS", nullable = false, length = 100)
    protected String address;

    @Lob
    @Column(name = "NOTE")
    protected String note;

    @OneToOne
    @JoinColumn(columnDefinition = "USER_ID", nullable = false, referencedColumnName = "ID")
    protected User user;

    /**
     * Getter for the field address:String.
     *
     * @return the address
     */
    public String getAddress() {
	return this.address;
    }

    /**
     * Setter for the field address.
     *
     * @param address
     *            the address to set
     */
    public void setAddress(String address) {
	this.address = address;
    }

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
     * Getter for the field user:User.
     *
     * @return the user
     */
    public User getUser() {
	return this.user;
    }

    /**
     * Setter for the field user.
     *
     * @param user
     *            the user to set
     */
    public void setUser(User user) {
	this.user = user;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Order [id=");
	builder.append(this.id);
	builder.append(", address=");
	builder.append(this.address);
	builder.append(", note=");
	builder.append(this.note);
	// builder.append(", username=");
	// builder.append(username);
	builder.append("]");
	return builder.toString();
    }
}
