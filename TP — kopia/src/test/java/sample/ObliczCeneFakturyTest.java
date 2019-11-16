package sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ObliczCeneFakturyTest {
    private Faktura faktura;
    private ObliczCeneFaktury obliczCeneFaktury;
    @Before
    public void setUp() {
        Usluga usluga = new Usluga("usluga",50.0, 6, 20.0);
        Klient klient = new Klient("sklep", "grunwaldzka", "123");
        faktura = new Faktura();
        faktura.dodajUsluge(usluga);
        faktura.ustawKlienta(klient);

        obliczCeneFaktury = new ObliczCeneFaktury();
    }

    @After
    public void tearDown() {
        faktura.clear();
        obliczCeneFaktury = null;
    }

    @Test
    public void policzCene() {
        assert(obliczCeneFaktury.policzCene(faktura) == (50.0*6)*(1.2));
    }
}