package be.voedsaam.service.manager;

import be.voedsaam.service.dto.PersonDTO;

import java.util.Observable;

public class PersonManager extends Observable {
    private PersonDTO current;

    public void sayHello(PersonDTO dto){
        System.out.println("in manager" + this + " - " + dto);
        this.current = dto;
        setChanged();
        notifyObservers();
    }

    public PersonDTO getCurrent() {
        return current;
    }
}
