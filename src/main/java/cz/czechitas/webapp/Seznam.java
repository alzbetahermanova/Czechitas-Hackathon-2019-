
package cz.czechitas.webapp;

import java.util.*;

public class Seznam {
    Long id;
    String nazev;
    List<Vec> obsahSeznamu;

    public Seznam() {
    }

    public Seznam(Long id, String nazev, List<Vec> obsahSeznamu) {
        this.id = id;
        this.nazev = nazev;
        this.obsahSeznamu = obsahSeznamu;
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

    public List<Vec> getObsahSeznamu() {
        return obsahSeznamu;
    }

    public void setObsahSeznamu(List<Vec> newValue) {
        obsahSeznamu = newValue;
    }
}