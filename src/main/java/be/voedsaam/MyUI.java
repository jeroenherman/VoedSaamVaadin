package be.voedsaam;

import be.voedsaam.frontend.NameAgeLayout;
import be.voedsaam.service.dto.PersonDTO;
import be.voedsaam.service.manager.PersonManager;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

import javax.servlet.annotation.WebServlet;
import java.util.Observable;
import java.util.Observer;

/**
        * This UI is the application entry point. A UI may either represent a browser window
        * (or tab) or some part of an HTML page where a Vaadin application is embedded.
        * <p>
        * The UI is initialized using {import java.util.Observable;
import java.util.Observer;

@link #init(VaadinRequest)}. This method is intended to be
        * overridden to add component to the user interface and initialize non-component functionality.
        */
@Theme("mytheme")
public class MyUI extends UI implements Observer {
    private PersonManager pm;

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = MyUI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {
        pm = new PersonManager();
        pm.addObserver(this); // je voegt jezelf (MyUI) toe aan de lijst van observers van PersonManager pm
        setContent(new NameAgeLayout(pm));
    }

    /**
     * Wanneer personmanager veranderd met setChanged();
     * en daarna alle observers verwittigd met notifyObservers();
     * zal Update uitgevoerd worden bij alle oservers
     */
    @Override
    public void update(Observable o, Object arg) {
        PersonDTO dto = ((PersonManager)o).getCurrent(); // je cast altijd hetgeen wat je terug krijgt van update naar het object dat je wil in dit geval een PersonManager
        Notification.show("Hello, " + dto.getName() + " - " + dto.getAge());
    }
}