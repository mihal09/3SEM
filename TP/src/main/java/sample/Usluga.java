package sample;

public class Usluga {

    private String nazwaUslugi;
    private Double cenaUslugi;
    private Integer iloscUslug;
    private Double procentPodatku;


    public Usluga(String nazwaUslugi, Double cenaUslugi, Integer iloscUslug, Double procentPodatku){
        this.nazwaUslugi = nazwaUslugi;
        this.cenaUslugi = cenaUslugi;
        this.iloscUslug = iloscUslug;
        this.procentPodatku = procentPodatku;
    }

    public String getNazwaUslugi() {
        return nazwaUslugi;
    }

    public Double getCenaUslugi() {
        return cenaUslugi;
    }

    public Integer getIloscUslug() {
        return iloscUslug;
    }

    public Double getProcentPodatku() {
        return procentPodatku;
    }

    public double getKwotaNetto(){
        return cenaUslugi * iloscUslug;
    }

    public double getKwotaVAT(){
        return getKwotaNetto() * procentPodatku / 100.0;
    }

    public double getKwotaBrutto(){
        return getKwotaNetto() + getKwotaVAT();
    }

   }