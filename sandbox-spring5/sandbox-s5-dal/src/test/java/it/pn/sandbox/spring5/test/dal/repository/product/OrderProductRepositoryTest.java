/*
 * File OrderProductRepositoryTest.java of project sandbox-s5-dal.
 * File created on 16 ott 2017 at 17:27:16 at PN-HQ.
 */
package it.pn.sandbox.spring5.test.dal.repository.product;

import java.util.Set;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import it.pn.sandbox.spring5.dal.conf.SandboxDalConfig;
import it.pn.sandbox.spring5.dal.repository.accounting.UserRespository;
import it.pn.sandbox.spring5.dal.repository.product.OrderRepository;
import it.pn.sandbox.spring5.dal.repository.product.ProductOrderRepository;
import it.pn.sandbox.spring5.dal.repository.product.ProductRepository;
import it.pn.sandbox.spring5.model.accounting.User;
import it.pn.sandbox.spring5.model.product.Order;
import it.pn.sandbox.spring5.model.product.Product;
import it.pn.sandbox.spring5.model.product.ProductOrder;

/**
 * Class OrderProductRepositoryTest representing ...
 *
 * @author Paolo Napoli <paolonapoli.dev@gmail.com>
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SandboxDalConfig.class })
@Transactional
@Commit // does the COMMIT at the end
public class OrderProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductOrderRepository productOrderRepository;

    @Autowired
    private UserRespository userRespository;

    @Autowired
    private EntityManager em;

    public void init() {
	this.productOrderRepository.deleteAll();
	this.em.flush();
	this.productRepository.deleteAll();
	this.em.flush();
	this.orderRepository.deleteAll();
	this.em.flush();
    }

    @Test
    public void pupulateProductOrder() {
	init();

	System.out.println("************ Saving Product/Order ********************");
	User admin = this.userRespository.findByUsernameIgnoreCase("admin");

	Product p = new Product();
	p.setName("Product A");
	p.setDescription("Product A");
	this.productRepository.save(p);

	Order o = new Order();
	o.setAddress("Fantasy street, 76 CALIFORNIA (US)");
	o.setNote("NO note provided");
	o.setUser(admin);
	this.orderRepository.save(o);

	ProductOrder po = new ProductOrder();
	po.setOrder(o);
	po.setProduct(p);
	po.setQuantity(7L);
	this.productOrderRepository.save(po);
    }

    @Test
    public void getOrderByUser() {
	System.out.println("************ Finding Product/Order ********************");
	User admin = this.userRespository.findByUsernameIgnoreCase("admin");

	Set<Order> byUser = this.orderRepository.findByUser(admin);
	for (Order order : byUser) {
	    String string = ToStringBuilder.reflectionToString(order, ToStringStyle.MULTI_LINE_STYLE);
	    System.out.println(string);
	}
    }
}