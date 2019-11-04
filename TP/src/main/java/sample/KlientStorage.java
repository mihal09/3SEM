package sample;

import java.util.ArrayList;

public class KlientStorage {
    private ArrayList<Klient> klienci;


    public KlientStorage() {
        klienci = new ArrayList<Klient>();
    }

    public void dodajKlienta(Klient klient){
        klienci.add(klient);
    }

    public void ustawKlientow(ArrayList<Klient> klienci){
        this.klienci = klienci;
    }

    public ArrayList<Klient> zwrocKlientow(){
        return klienci;
    }

    public Klient znajdzKlientaNIP(String nip){
        for (Klient klient : klienci) {
            if(klient.getNip().equals(nip))
                return klient;
        }
        return null;
    }

    public Klient znajdzKlientaNazwa(String nazwa){
        for (Klient klient : klienci) {
            if(klient.getNazwa().equals(nazwa))
                return klient;
        }
        return null;
    }
}
