package pl.kalisz.akdemia.pup.apkadamian30685;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ObiektyInfo extends AppCompatActivity {
    public static final String EXTRA_OBIEKT_ID = "id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obiekty_info);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ObiektyInfoFragment frag = (ObiektyInfoFragment) getSupportFragmentManager().findFragmentById(R.id.info_frag);

        int obiektId = (int) getIntent().getExtras().get(EXTRA_OBIEKT_ID);
        frag.setObiekt(obiektId);
    }
}