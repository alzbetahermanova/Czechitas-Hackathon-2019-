package cz.czechitas.webapp;

import java.io.*;
import java.util.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

@Controller
public class HlavniController {

    private PametovaRepository dodavatelDat = new PametovaRepository();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView zobrazIndex() throws IOException {
        ModelAndView drzakNaObsah = new ModelAndView("index");
        return drzakNaObsah;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView zpracujDetail(IndexForm vstup) {
        
        Seznam veciKNaDovolenou = dodavatelDat.findByName(vstup.getTyp());

        if(vstup.getNovaVec()!=null) {
           Vec novaVec = new Vec(99L, vstup.getNovaVec());
           veciKNaDovolenou.obsahSeznamu.add(novaVec);

        }
        ModelAndView drzakNaObsah = new ModelAndView("detail");
        
        List<Vec> testlist = veciKNaDovolenou.getObsahSeznamu();
        
        String typ = veciKNaDovolenou.getNazev();
        drzakNaObsah.addObject("nazevSeznamu",typ);
        drzakNaObsah.addObject("veciNaDovolenou", testlist);

        return drzakNaObsah;

    }
}


