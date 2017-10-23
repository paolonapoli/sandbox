package it.pn.sandbox.spring5.web.simple;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 *
 */
@Theme("mytheme")
public class MyUI extends UI {

    // private CrudService<Person> service = new CrudService<>();
    // private DataProvider<Person, String> dataProvider = new CallbackDataProvider<>(query -> this.service.findAll().stream(), query -> this.service.findAll().size());

    @Override
    protected void init(VaadinRequest vaadinRequest) {
	final VerticalLayout layout = new VerticalLayout();
	final TextField name = new TextField();
	name.setCaption("Type your name here:");

	final Button button = new Button("Click Me");
	button.addClickListener(e -> {
	    // this.service.save(new Person(name.getValue()));
	    // this.dataProvider.refreshAll();
	    Notification.show("Pushed!");
	});

	// final Grid<Person> grid = new Grid<>();
	// grid.addColumn(Person::getName).setCaption("Name");
	// grid.setDataProvider(this.dataProvider);
	// grid.setSizeFull();

	// This is a component from the myapplication-addon module
	// layout.addComponent(new MyComponent());
	layout.addComponents(name, button/* , grid */);
	layout.setSizeFull();
	// layout.setExpandRatio(grid, 1.0f);

	setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = true)
    public static class MyUIServlet extends VaadinServlet {
    }
}
