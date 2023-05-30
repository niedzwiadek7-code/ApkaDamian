package pl.kalisz.akdemia.pup.apkadamian30685;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import pl.kalisz.akdemia.pup.apkadamian30685.databinding.ActivityBazaDanychBinding;

public class BazaDanych extends AppCompatActivity {

    private SQLiteOpenHelper organizacjaSQLiteOpenHelper;
    private SQLiteDatabase db;
    private Cursor cursor;
    private ListView listViewOrganizacje;

    private AppBarConfiguration appBarConfiguration;
    private ActivityBazaDanychBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baza_danych);

        listViewOrganizacje = (ListView) findViewById(R.id.listViewOrganizacje);
        try {
            organizacjaSQLiteOpenHelper = new OrganizacjaSQLiteOpenHelper(this);
            db = organizacjaSQLiteOpenHelper.getWritableDatabase();
//            organizacjaSQLiteOpenHelper.onCreate(db);
        } catch (SQLException e) {
            Toast toast = Toast.makeText(this, "Baza danych jest niedostępna", Toast.LENGTH_LONG);
            toast.show();
            finish();
        }
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick (AdapterView<?> listViewOrganizacje, View view, int position, long id) {
                        Intent intent = new Intent (BazaDanych.this, BazaDanychAktualizacja.class);
                        intent.putExtra (BazaDanychAktualizacja.EXTRA_ORGANIZACJA_ID, (int) id);
                        startActivity(intent);
                    } };
        listViewOrganizacje.setOnItemClickListener(itemClickListener);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent int1 = new Intent (BazaDanych. this, BazaDanychDopisz.class);
                startActivity(int1);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.listViewOrganizacje);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            cursor = db.query("ORGANIZACJA", new String[] { "_id", "NAZWA", "RODZAJ"}, null, null, null, null, null);
            if (cursor.moveToFirst()) {
                SimpleCursorAdapter listAdapter = new SimpleCursorAdapter(
                        this,
                        android.R.layout.simple_list_item_2,
                        cursor,
                        new String[] {"NAZWA", "RODZAJ"},
                        new int[] { android.R.id.text1, android.R.id.text2 },
                        0
                );
                listViewOrganizacje.setAdapter(listAdapter);
            }
        } catch (SQLException e) {
            Toast toast = Toast.makeText(this, "Baza danych jest niedostępna", Toast.LENGTH_LONG);
            toast.show();
            finish();
        }
    }
}