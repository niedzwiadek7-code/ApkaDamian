package pl.kalisz.akdemia.pup.apkadamian30685;

public class Obiekt {
    String nazwa;
    String opis;
    int fotoId;

    public static final Obiekt[] obiekty = {
            new Obiekt("Rektorat", "Nowy Świat 4", R.drawable.crektorat),
            new Obiekt("Collegium Novum", "Nowy Świat 4a", R.drawable.cnovum),
            new Obiekt("Collegium Ocecologicum", "Poznanska 201-205", R.drawable.coecologicum),
            new Obiekt("Collegium Medicum", "Kaszubska 13", R.drawable.cmedicum),
            new Obiekt("Collegium Mechanicum", "Poznanska 201-205", R.drawable.cmechanicum)
    };

    public Obiekt (String nazwa, String opis, int fotoId) {
        this.nazwa = nazwa;
        this.opis = opis;
        this.fotoId = fotoId;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getFotoId() {
        return fotoId;
    }

    public String getOpis() {
        return opis;
    }
}
