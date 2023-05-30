package pl.kalisz.akdemia.pup.apkadamian30685;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class ObiektyInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obiekty_info);

        ObiektyInfoFragment frag = (ObiektyInfoFragment) getSupportFragmentManager().findFragmentById(R.id.info_frag);
    }
}