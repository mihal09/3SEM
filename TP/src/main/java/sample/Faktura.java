package sample;

import java.util.ArrayList;

public class Faktura {
    private Klient klient;
    private ArrayList<Usluga> uslugi;


    public Faktura() {
        uslugi = new ArrayList<Usluga>();
    }
    public Faktura(Klient klient) {
        ustawKlienta(klient);
        uslugi = new ArrayList<Usluga>();
    }

    public Faktura(Faktura tworzonaFaktura) {
        this.uslugi = new ArrayList<Usluga>(tworzonaFaktura.uslugi);
    }


    public void dodajUsluge(Usluga usluga){
        uslugi.add(usluga);
    }
    public void clear(){klient = null; uslugi.clear();}
    public ArrayList<Usluga> zwrocUslugi(){
        return uslugi;
    }
    public Klient zwrocKlienta(){ return klient; }
    public void ustawKlienta(Klient klient) {this.klient = klient; }
}
