package pl.kalisz.akdemia.pup.apkadamian30685;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class Uczelnia extends AppCompatActivity {

    final StrukturaUczelni strukturaUczelni = new StrukturaUczelni();
    private Spinner wydzial;
    private TextView kierunek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uczelnia);
        wydzial = findViewById(R.id.spinner);
        kierunek = findViewById(R.id.textView);
    }

    public void wyswKierunki(View view) {
        List<String> listaKierunkow = strukturaUczelni.getKierunki(String.valueOf(wydzial.getSelectedItem()));
        StringBuilder stringBuilder = new StringBuilder();
        for (String zm: listaKierunkow) {
            stringBuilder.append(zm).append('\n');
        }
        kierunek.setText(stringBuilder);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        List<String> listaKierunkow = strukturaUczelni.getKierunki(String.valueOf(wydzial.getSelectedItem()));
        StringBuilder stringBuilder = new StringBuilder();
        for (String zm: listaKierunkow) {
            stringBuilder.append(zm).append('\n');
        }
        kierunek.setText(stringBuilder);
    }
}