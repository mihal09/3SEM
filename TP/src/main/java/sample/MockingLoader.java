package sample;

import java.util.ArrayList;

public class MockingLoader implements ILoader {
    public void load() {
        System.out.println("ŁADUJE");
        ArrayList<Klient> klienci = new ArrayList<Klient>();
        Klient k1 = new Klient("a","a","a");
        Klient k2 = new Klient("b","b","b");
        klienci.add(k1);
        klienci.add(k2);

        Usluga u1 = new Usluga("usluga 1", 120.0, 2, 23.0);
        Usluga u2 = new Usluga("usluga 2", 50.0, 1, 23.0);
        Usluga u3 = new Usluga("usluga 3", 60.0, 5, 23.0);
        Usluga u4 = new Usluga("usluga 4", 80.0, 1, 23.0);

        ArrayList<Faktura> faktury = new ArrayList<Faktura>();

        Faktura f1 = new Faktura();
        f1.ustawKlienta(k1);
        f1.dodajUsluge(u1);
        f1.dodajUsluge(u2);

        Faktura f2 = new Faktura();
        f2.ustawKlienta(k1);
        f2.dodajUsluge(u3);
        f2.dodajUsluge(u4);

        Faktura f3 = new Faktura();
        f3.ustawKlienta(k2);
        f3.dodajUsluge(u1);
        f3.dodajUsluge(u3);

        faktury.add(f1);
        faktury.add(f2);
        faktury.add(f3);


        ResourceManager.getInstance().getKlientStorage().ustawKlientow(klienci);
        ResourceManager.getInstance().getFakturyStorage().ustawFaktury(faktury);
    }
}
