package sample;

import java.util.ArrayList;

class ObliczCeneFaktury {

    public ObliczCeneFaktury(){}

    public double policzCene(Faktura faktura){
        double cena = 0;
        ArrayList<Usluga> uslugaArrayList = faktura.zwrocUslugi();
        for(Usluga usluga: uslugaArrayList){
            cena += ObliczCeneUslugi.getKwotaBrutto(usluga);
        }

        return cena;
    }
}