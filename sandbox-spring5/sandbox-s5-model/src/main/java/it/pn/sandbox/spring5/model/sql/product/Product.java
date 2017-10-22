/*
 * File Product.java of project sandbox-s5-model.
 * File created on 16 ott 2017 at 16:49:08 at PN-HQ.
 */
package it.pn.sandbox.spring5.model.sql.product;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import it.pn.sandbox.spring5.model.base.seq.SequenceBaseEntityAudit;

/**
 * Class Product representing ...
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
@Entity
@Table(name = "SBX_PRODUCT")
@SequenceGenerator(sequenceName = "SBX_SEQ_PRODUCT", name = "generator", initialValue = 1, allocationSize = 1 /* TODO: tune allocation size */)
public class Product extends SequenceBaseEntityAudit {

    /**
     * Field serialVersionUID:long representing ...
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "NAME", nullable = false)
    protected String name;

    @Lob
    @Column(name = "DESCRIPTION")
    protected String description;

    @Column(name = "PRICE")
    protected BigDecimal price;

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
     * Getter for the field description:String.
     *
     * @return the description
     */
    public String getDescription() {
	return this.description;
    }

    /**
     * Setter for the field description.
     *
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
	this.description = description;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("Product [id=");
	builder.append(this.id);
	builder.append(", name=");
	builder.append(this.name);
	builder.append(", description=");
	builder.append(this.description);
	builder.append(", price=");
	builder.append(this.price);
	builder.append("]");
	return builder.toString();
    }
}
