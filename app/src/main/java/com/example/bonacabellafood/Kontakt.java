package com.example.bonacabellafood;

public class Kontakt {

    public enum TipKontakta {EMAIL}

    private String ime, vrednost;
    private TipKontakta tipKontakta;

    public Kontakt(String ime, String vrednost, TipKontakta tipKontakta) {
        this.ime = ime;
        this.vrednost = vrednost;
        this.tipKontakta = tipKontakta;
    }

    public String getIme() {
        return ime;
    }

    public String getVrednost() {
        return vrednost;
    }

    public TipKontakta getTipKontakta() {
        return tipKontakta;
    }
}

