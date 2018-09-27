package be.voedsaam.frontend.controller;

import be.voedsaam.frontend.NameAgeLayout;
import be.voedsaam.service.dto.PersonDTO;
import be.voedsaam.service.manager.PersonManager;
import com.vaadin.ui.Button;

public class OKListener implements Button.ClickListener {

    private final NameAgeLayout gui;
    private final PersonManager pm;

    public OKListener(NameAgeLayout gui, PersonManager pm) {
        this.gui = gui;
        this.pm = pm;
    }

    @Override
    public void buttonClick(Button.ClickEvent clickEvent) {
        String name = gui.getNameField().getValue();
        String age = gui.getAgeField().getValue();

        PersonDTO dto = new PersonDTO();
        dto.setName(name);
        dto.setAge(age);

        pm.sayHello(dto);

    }
}
