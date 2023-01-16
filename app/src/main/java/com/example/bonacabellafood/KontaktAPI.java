package com.example.bonacabellafood;

import java.util.LinkedList;

public class KontaktAPI {
    public static LinkedList<Kontakt> getMyContacts (){
        LinkedList<Kontakt> lista = new LinkedList<>();


        lista.add(new Kontakt("Direktor", "aleksa.grbic@gmail.com", Kontakt.TipKontakta.EMAIL));
        lista.add(new Kontakt("Menadžer", "teodor.aleksic@gmail.com", Kontakt.TipKontakta.EMAIL));
        lista.add(new Kontakt("Poslovođa", "ana.aleksic@gmail.com", Kontakt.TipKontakta.EMAIL));


        return lista;

    }
}
