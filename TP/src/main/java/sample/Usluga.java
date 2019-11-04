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

    public double getKwotaNetto(){
        return cenaUslugi * iloscUslug;
    }
    public double getKwotaVAT(){
        return getKwotaNetto() * procentPodatku / 100.0;
    }
    public double getKwotaBrutto(){
        return getKwotaNetto() + getKwotaVAT();
    }

    public String getNazwaUslugi() {
        return nazwaUslugi;
    }

    public void setNazwaUslugi(String nazwaUslugi) {
        this.nazwaUslugi = nazwaUslugi;
    }

    public Double getCenaUslugi() {
        return cenaUslugi;
    }

    public void setCenaUslugi(Double cenaUslugi) {
        this.cenaUslugi = cenaUslugi;
    }

    public Integer getIloscUslug() {
        return iloscUslug;
    }

    public void setIloscUslug(Integer iloscUslug) {
        this.iloscUslug = iloscUslug;
    }

    public Double getProcentPodatku() {
        return procentPodatku;
    }

    public void setProcentPodatku(Double procentPodatku) {
        this.procentPodatku = procentPodatku;
    }
}