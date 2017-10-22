/*
 * File ProductOrder.java of project sandbox-s5-model.
 * File created on 16 ott 2017 at 17:19:27 at PN-HQ.
 */
package it.pn.sandbox.spring5.model.sql.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import it.pn.sandbox.spring5.model.base.seq.SequenceBaseEntity;

/**
 * Class ProductOrder representing ...
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
@Entity
@Table(name = "SBX_PRODUCT_ORDER", uniqueConstraints = { @UniqueConstraint(columnNames = { "ORDER_ID", "PRODUCT_ID" }) })
@SequenceGenerator(sequenceName = "SBX_SEQ_PRODUCT_ORDER", name = "generator", initialValue = 1, allocationSize = 1 /* TODO: tune allocation size */)
public class ProductOrder extends SequenceBaseEntity {
    /**
     * Field serialVersionUID:long representing ...
     */
    private static final long serialVersionUID = 1L;

    @OneToOne
    @JoinColumn(columnDefinition = "ORDER_ID", nullable = false)
    protected Order order;

    @OneToOne
    @JoinColumn(columnDefinition = "PRODUCT_ID", nullable = false)
    protected Product product;

    @Column(name = "qty", nullable = false)
    protected Long quantity;

    /**
     * Getter for the field order:Order.
     *
     * @return the order
     */
    public Order getOrder() {
	return this.order;
    }

    /**
     * Setter for the field order.
     *
     * @param order
     *            the order to set
     */
    public void setOrder(Order order) {
	this.order = order;
    }

    /**
     * Getter for the field product:Product.
     *
     * @return the product
     */
    public Product getProduct() {
	return this.product;
    }

    /**
     * Setter for the field product.
     *
     * @param product
     *            the product to set
     */
    public void setProduct(Product product) {
	this.product = product;
    }

    /**
     * Getter for the field quantity:Long.
     *
     * @return the quantity
     */
    public Long getQuantity() {
	return this.quantity;
    }

    /**
     * Setter for the field quantity.
     *
     * @param quantity
     *            the quantity to set
     */
    public void setQuantity(Long quantity) {
	this.quantity = quantity;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("ProductOrder [id=");
	builder.append(this.id);
	builder.append(", order=");
	builder.append(this.order);
	builder.append(", product=");
	builder.append(this.product);
	builder.append(", quantity=");
	builder.append(this.quantity);
	builder.append("]");
	return builder.toString();
    }
}
