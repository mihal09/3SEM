package sample;

class ObliczCeneUslugi {

    public static double getKwotaNetto(Usluga usluga){
        return usluga.getCenaUslugi() * usluga.getIloscUslug();
    }
    public static  double getKwotaVAT(Usluga usluga){
        return usluga.getKwotaNetto() * usluga.getProcentPodatku() / 100.0;
    }
    public static  double getKwotaBrutto(Usluga usluga){
        return usluga.getKwotaNetto() + usluga.getKwotaVAT();
    }
}

