package cz.czechitas.webapp;

import java.util.*;
import java.util.concurrent.atomic.*;

public class Vec {

    private static AtomicLong getIdPosloupnost() {
        return idPosloupnost;
    }

    public static void setIdPosloupnost(AtomicLong newValue) {
        idPosloupnost = newValue;
    }

    public static AtomicLong idPosloupnost = new AtomicLong(100L);

    private Long id;
    private String nazev;
    
    public static List<Vec> statickeVeci = initStatickeVeci();

    public Vec() {
        this.id = idPosloupnost.getAndIncrement();
    }

    public Vec(String nazev) {
        this.nazev = nazev;
    }

    public Vec(Long id, String nazev) {
        this.id = idPosloupnost.getAndIncrement();
        this.nazev = nazev;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long newValue) {
        id = newValue;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String newValue) {
        nazev = newValue;
    }

    private static List<Vec> initStatickeVeci() {
        List<Vec> list = new ArrayList<>();
        list.add(new Vec(0L, "plavky"));
        list.add(new Vec(1L, "ručník"));
        list.add(new Vec(2L, "krém"));
        list.add(new Vec(3L, "hůlky"));
        list.add(new Vec(4L, "lyže"));
        list.add(new Vec(5L, "lyžáky"));
        list.add(new Vec(6L, "notebook"));
        list.add(new Vec(7L, "trafo"));
        list.add(new Vec(8L, "myš"));

        return list;
    }


}

