package pl.kalisz.akdemia.pup.apkadamian30685;

public class DaneStudenta {
    String nick;
    String wydzial;
    String kierunek;
    String data;
    String plec;
    String email;
    String wlacz;
    Boolean infoAkademik;
    Boolean infoUczelnia;

    private String getPlecNazwa(int id) {
        switch (id) {
            case 0:
                return "Mężczyzna";
            case 1:
                return "Kobieta";
            default:
                return String.valueOf(id);
        }
    }

    public DaneStudenta(
        String nick,
        String wydzial,
        String kierunek,
        String data,
        int plec,
        String email,
        Boolean wlacz,
        Boolean infoAkademik,
        Boolean infoUczelnia
    ) {
        this.nick = nick;
        this.wydzial = wydzial;
        this.kierunek = kierunek;
        this.data = data;
        this.plec = getPlecNazwa(plec);
        this.email = email;
        this.wlacz = String.valueOf(wlacz);
        this.infoAkademik = infoAkademik;
        this.infoUczelnia = infoUczelnia;
    }

    @Override
    public String toString() {
        return "DaneStudenta {" +
                "\nnick='" + nick + '\'' +
                "\n, wydzial='" + wydzial + '\'' +
                "\n, kierunek='" + kierunek + '\'' +
                "\n, data='" + data + '\'' +
                "\n, plec='" + plec + '\'' +
                "\n, email='" + email + '\'' +
                "\n, wlacz='" + wlacz + '\'' +
                "\n, infoAkademik=" + infoAkademik +
                "\n, infoUczelnia=" + infoUczelnia +
                "\n }";
    }
}
