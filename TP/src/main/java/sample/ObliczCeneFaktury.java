package sample;

import java.util.ArrayList;

public class ObliczCeneFaktury {

    private ArrayList<Usluga> uslugaArrayList;

    public ObliczCeneFaktury(){}

    public double policzCene(Faktura faktura){
        double cena = 0;
        uslugaArrayList = faktura.zwrocUslugi();
        for(Usluga usluga:uslugaArrayList){
            cena += usluga.getKwotaBrutto();
        }

        return cena;
    }
}