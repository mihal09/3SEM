package sample;

import java.util.ArrayList;

public class FakturyStorage {
    private ArrayList<Faktura> faktury;


    public FakturyStorage() {
        faktury = new ArrayList<Faktura>();
    }

    public void dodajFakture(Faktura faktura){
        faktury.add(faktura);
    }

    public void ustawFaktury(ArrayList<Faktura> faktury){
        this.faktury = faktury;
    }

    public ArrayList<Faktura> zwrocFaktury(){
        return faktury;
    }

    public ArrayList<Faktura>  znajdzFaktury(Klient klient){
        ArrayList<Faktura> fakturyKlienta = new ArrayList<Faktura>();
        for (Faktura faktura : faktury) {
            if(faktura.zwrocKlienta().equals(klient))
                fakturyKlienta.add(faktura);
        }
        return fakturyKlienta;
    }
}
