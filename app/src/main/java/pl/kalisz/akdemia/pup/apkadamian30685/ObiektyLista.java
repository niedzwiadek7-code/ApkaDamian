package pl.kalisz.akdemia.pup.apkadamian30685;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class ObiektyLista extends AppCompatActivity
    implements ObiektyListaFragment.Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obiekty_lista);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    public void itemClicked(long id) {
        Intent intent = new Intent(this, ObiektyInfo.class);
        intent.putExtra(ObiektyInfo.EXTRA_OBIEKT_ID, (int) id);
        startActivity(intent);
    }
}