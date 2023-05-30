package pl.kalisz.akdemia.pup.apkadamian30685;

import java.util.ArrayList;
import java.util.List;

public class StrukturaUczelni {

    List<String> getKierunki(String wydzial) {
        List<String> kierunki = new ArrayList<>();
        switch (wydzial) {
            case "Politechniczny":
                kierunki.add("informatyka");
                kierunki.add("budownictwo");
                kierunki.add("mechanika maszyn");
                break;
            case "Lekarski":
                kierunki.add("pielęgniarstwo");
                kierunki.add("położnictwo");
                break;
            case "Nauk o zdrowiu" :
                kierunki.add("fizjoterapia");
                kierunki.add("ratownictwo medyczne");
                break;
            case "Nauk Społecznych":
                kierunki.add("ekonomia menedżerska");
                kierunki.add("bezpieczeństwo");
                kierunki.add("zarządzanie");
                break;
            default:
                kierunki.add("wybierz wydział");
                break;
        }
        return kierunki;
    }

    List<String> getKierunkiById(int id) {
        List<String> kierunki = new ArrayList<>();
        switch (id) {
            case 0:
                kierunki.add("informatyka");
                kierunki.add("budownictwo");
                kierunki.add("mechanika maszyn");
                break;
            case 1:
                kierunki.add("pielęgniarstwo");
                kierunki.add("położnictwo");
                break;
            case 2:
                kierunki.add("fizjoterapia");
                kierunki.add("ratownictwo medyczne");
                break;
            case 3:
                kierunki.add("ekonomia menedżerska");
                kierunki.add("bezpieczeństwo");
                kierunki.add("zarządzanie");
                break;
            default:
                kierunki.add("wybierz wydział");
                break;
        }
        return kierunki;
    }
}
