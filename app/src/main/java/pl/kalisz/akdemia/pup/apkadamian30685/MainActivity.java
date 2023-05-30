package pl.kalisz.akdemia.pup.apkadamian30685;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ShareActionProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.core.view.MenuItemCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity
        extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ShareActionProvider shareActionProvider;
    private Snackbar snackbar;
    private CharSequence komunikat;
    private int czas = Snackbar.LENGTH_LONG;

    private String backgroundColor = "#FFFF00";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView upper = (TextView) findViewById(R.id.snackbar);
        upper.setText(getAndroidVersion());

        TextView down = (TextView) findViewById(R.id.down);
        down.setText("Autorem programu jest Damian");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawer, toolbar, R.string.nav_open_drawer, R.string.nav_close_drawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView)  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void setShareActionIntent (String text) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, text);
        shareActionProvider.setShareIntent(intent);
    }

    public String getAndroidVersion () {
        String release = Build.VERSION.RELEASE;
        int sdkVersion = Build.VERSION.SDK_INT;
        return "Android SDK: " + sdkVersion + " (" + release + ")";
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem = menu.findItem(R.id.share);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(menuItem);
        setShareActionIntent("Zapraszamy na stronę główną uczelni");
        return super.onCreateOptionsMenu(menu);
     }

     public boolean onOptionsItemSelected (MenuItem item) {
        switch (item.getItemId()) {
            case R.id.send:
                Toast.makeText(this, "Wyślij", Toast.LENGTH_LONG).show();
                TextView upper = (TextView) findViewById(R.id.snackbar);
                upper.setBackgroundColor(Color.parseColor("#FFFF00"));
                return true;
            case R.id.share:
                Toast.makeText(this, "Udostępnij", Toast.LENGTH_LONG).show();
                return true;
            case R.id.version:
                Toast.makeText(this, getAndroidVersion(), Toast.LENGTH_LONG).show();
                return true;
            case R.id.about:
                String komunikat = "Autorem programu jest Damian";
                snackbar = Snackbar.make(findViewById(R.id.snackbar), komunikat, czas);
                snackbar.setAction("wersja API", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, getAndroidVersion(), Toast.LENGTH_LONG).show();
                    }
                });
                snackbar.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
     }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_16:
                Intent intent_16 = new Intent(this, Czujniki.class);
                startActivity(intent_16);
                break;
            case R.id.nav_16_b:
                Intent nav_16_b = new Intent(this, Uczelnia.class);
                startActivity(nav_16_b);
                break;
            case R.id.nav_17:
                Intent nav_17 = new Intent(this, Konfiguracja.class);
                startActivity(nav_17);
                break;
            case R.id.nav_18:
                Intent nav_18 = new Intent(this, ObiektyUczelni.class);
                startActivity(nav_18);
                break;
            case R.id.nav_19:
                komunikat = "Lab 9.";
                Toast.makeText(this, komunikat, Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_110:
                komunikat = "Lab 10.";
                Toast.makeText(this, komunikat, Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_111:
                komunikat = "Lab 11.";
                Toast.makeText(this, komunikat, Toast.LENGTH_LONG).show();
                break;
            case R.id.nav_112:
                komunikat = "Lab 12.";
                Toast.makeText(this, komunikat, Toast.LENGTH_LONG).show();
                break;
            case R.id.temat:
                komunikat =  "Tematem projektu jest aplikacja wycieczkowa";;
                snackbar =  Snackbar.make(findViewById(R.id.snackbar), komunikat, czas);
                snackbar.show();
                break;
            case  R.id.ikona:
                komunikat = "A tu wyświetla się ikona projektu";
                snackbar = Snackbar.make(findViewById(R.id.snackbar), komunikat, czas);
                snackbar.show();
                break;
            default:
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString("backgroundColor", backgroundColor);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedState) {
        super.onRestoreInstanceState(savedState);
        backgroundColor=savedState.getString("backgroundColor");
        TextView sdkVersionTextView = findViewById(R.id.snackbar);
        sdkVersionTextView.setBackgroundColor(Color.parseColor("#FFFF00"));
    }
}