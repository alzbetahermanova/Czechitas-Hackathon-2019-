package cz.czechitas.webapp;

import java.util.*;

public class PametovaRepository {

    List<Seznam> seznamSeznamu = new ArrayList<>();

    public PametovaRepository() {
        List<Vec> vecikMori = new ArrayList<>();
        vecikMori.add(Vec.statickeVeci.get(0));
        vecikMori.add(Vec.statickeVeci.get(1));
        vecikMori.add(Vec.statickeVeci.get(2));

        List<Vec> veciNaLyze = new ArrayList<>();
        veciNaLyze.add(Vec.statickeVeci.get(3));
        veciNaLyze.add(Vec.statickeVeci.get(4));
        veciNaLyze.add(Vec.statickeVeci.get(5));

        List<Vec> veciNaKonferenci = new ArrayList<>();
        veciNaKonferenci.add(Vec.statickeVeci.get(6));
        veciNaKonferenci.add(Vec.statickeVeci.get(7));
        veciNaKonferenci.add(Vec.statickeVeci.get(8));

        seznamSeznamu.add(new Seznam(0L, "more", vecikMori));
        seznamSeznamu.add(new Seznam(1L, "hory", veciNaLyze));
        seznamSeznamu.add(new Seznam(2L, "konference", veciNaKonferenci));

    }

    public synchronized List<Seznam> findAll() {
        List<Seznam> veci = new ArrayList<>(seznamSeznamu.size());
        for (Seznam seznamVeci : seznamSeznamu) {
            veci.add(seznamVeci);
        }
        return veci;
    }

    public synchronized Seznam findById(Long id) {
        Seznam seznam = najdiSeznamPodleId(id);
        return clone(seznam);
    }
    
    private Seznam clone(Seznam puvodni) {
        if (puvodni == null) {
            return null;
        }
        return new Seznam(puvodni.getId(), puvodni.getNazev(), puvodni.getObsahSeznamu());
    }

    private Seznam najdiSeznamPodleId(Long id) {
        for (Seznam seznam : seznamSeznamu) {
            if (seznam.getId().equals(id)) {
                return seznam;
            }
        }
        return null;
    }

    public synchronized Seznam findByName(String nazev) {
        for (Seznam seznam : seznamSeznamu) {
            if (seznam.getNazev().equals(nazev)) {
                return clone(seznam);
            }
        }
        return null;
    }
    public synchronized Seznam save(Seznam zaznamKUlozeni) {
        if (zaznamKUlozeni.getId() == null) {
            throw new NullPointerException("Kontakt.ID nesmi byt null");
        }
        int index = najdiIndexZaznamu(zaznamKUlozeni.getId());
        if (index == -1) {
            return pridej(zaznamKUlozeni);
        }
        return updatuj(zaznamKUlozeni, index);
    }
    
    private Seznam pridej(Seznam zaznamKPridani) {
       Seznam seznam = clone(zaznamKPridani);
        seznamSeznamu.add(seznam);
        return clone(seznam);
    }

    private int najdiIndexZaznamu(Long id) {
        if (id == null) {
            throw new NullPointerException("Clanek.ID nesmi byt null");
        }
        for (int i = 0; i < seznamSeznamu.size(); i++) {
            Seznam seznam = seznamSeznamu.get(i);
            if (seznam.getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    private Seznam updatuj(Seznam zaznamKUlozeni, int index) {
        Seznam seznam = clone(zaznamKUlozeni);
        seznamSeznamu.set(index, seznam);
        return clone(seznam);
    }
}