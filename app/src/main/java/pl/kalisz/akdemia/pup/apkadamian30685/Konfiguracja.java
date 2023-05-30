package pl.kalisz.akdemia.pup.apkadamian30685;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.List;

public class Konfiguracja extends AppCompatActivity {

    EditText poleNick;
    Spinner poleWydzial;
    AutoCompleteTextView poleKierunek;
    DatePicker poleData;
    RadioGroup polePlec;
    EditText poleEmail;
    ToggleButton wlacz;
    CheckBox poleInfoAkademik;
    CheckBox poleInfoUczelnia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_konfiguracja);

        poleNick = (EditText) findViewById(R.id.nick);
        poleWydzial = (Spinner) findViewById(R.id.wydzial);
        poleKierunek = (AutoCompleteTextView) findViewById(R.id.kierunek);
        poleData = (DatePicker) findViewById(R.id.data);
        polePlec = (RadioGroup) findViewById(R.id.plec);
        poleEmail = (EditText) findViewById(R.id.email);
        wlacz = (ToggleButton) findViewById(R.id.wlacz);
        poleInfoAkademik = (CheckBox) findViewById(R.id.info_akademik);
        poleInfoUczelnia = (CheckBox) findViewById(R.id.info_uczelnia);

        Konfiguracja konf = this;

        poleWydzial.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                StrukturaUczelni strukturaUczelni = new StrukturaUczelni();
                String[] items = strukturaUczelni.getKierunkiById(position).toArray(new String[0]);

                ArrayAdapter<String> adapter = new ArrayAdapter<>(konf, android.R.layout.simple_dropdown_item_1line, items);
                poleKierunek.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                System.out.println("onNothingSelected");
            }
        });
    }

    private int getCheckedPolePlecId () {
        int radioButtonId = polePlec.getCheckedRadioButtonId();
        View radioButton = polePlec.findViewById(radioButtonId);
        return polePlec.indexOfChild(radioButton);
    }

    private String getDaneStudentaString () {
        int day = poleData.getDayOfMonth();
        int month = poleData.getMonth();
        int year = poleData.getYear();

        String date = day + "."  + month + "." + year;

        DaneStudenta daneStudenta = new DaneStudenta(
                poleNick.getText().toString(),
                String.valueOf(poleWydzial.getSelectedItem()),
                poleKierunek.getText().toString(),
                date,
                getCheckedPolePlecId(),
                poleEmail.getText().toString(),
                wlacz.isChecked(),
                poleInfoAkademik.isChecked(),
                poleInfoUczelnia.isChecked()
        );

        return daneStudenta.toString();
    }

    public void wyslijDane(View view) {
        Toast.makeText(this, getDaneStudentaString(), Toast.LENGTH_LONG).show();
    }

    public void wyslijDaneSMSManager(View view) {
        try {
            String phoneNumber = "30685";
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, "random", null, null);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    public void wyslijDaneSMS (View view) {
        try {
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:30685"));
            intent.putExtra("sms_body", getDaneStudentaString());
            startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}