package com.openbootcamp.demospringrest.services;

import com.openbootcamp.demospringrest.models.Bootcamper;
import com.openbootcamp.demospringrest.models.User;
import org.jvnet.hk2.annotations.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BootcamperService {

    private final List<Bootcamper> bootcampers = new ArrayList<>() {
    };


    public List<Bootcamper> getAll() {
        return bootcampers;
    }

    public void add (Bootcamper bootcamper){
        bootcampers.add(bootcamper);
    }


    public Bootcamper get(String nombre) {
        for (Bootcamper bootcamper : bootcampers) {
            if (bootcamper.getNombre().equalsIgnoreCase(nombre)) {
                return bootcamper;
            }
        }
        return null;
    }

    public void deleteByName(String nombre) {
        Bootcamper bootcamperToRemove = null;
        for (Bootcamper bootcamper : bootcampers) {
            if (bootcamper.getNombre().equals(nombre)) {
                bootcamperToRemove = bootcamper;
                break;
            }
        }
        if (bootcamperToRemove != null) {
            bootcampers.remove(bootcamperToRemove);
        }
    }

    public void deleateAll(){
        bootcampers.clear();
    }
}
