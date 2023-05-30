package pl.kalisz.akdemia.pup.apkadamian30685;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class OrganizacjaSQLiteOpenHelper extends SQLiteOpenHelper
{
    private static final String DB_NAME = "PWSZ";
    private static final int DB_VERSION = 1;

    OrganizacjaSQLiteOpenHelper (Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        updateMyDatabase(db, 0, DB_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateMyDatabase(db, oldVersion, newVersion);
    }

    private static void wstawOrganizacja (SQLiteDatabase db, String nazwa, String rodzaj) {
        ContentValues obiektValue = new ContentValues();
        obiektValue.put("NAZWA", nazwa);
        obiektValue.put("RODZAJ", rodzaj);
        db.insert("ORGANIZACJA", null, obiektValue);
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 1) {
            db.execSQL("CREATE TABLE ORGANIZACJA (_id INTEGER PRIMARY KEY AUTOINCREMENT, NAZWA TEXT, RODZAJ TEXT); ");
            wstawOrganizacja(db, "Koło naukowe informatyki", "koło naukowe");
            wstawOrganizacja(db, "Akademicki Zespół Sportowy", "sport");
            wstawOrganizacja(db, "Bulionik", "akademik");
            wstawOrganizacja(db, "Katedra Informatyki", "katedra");
            wstawOrganizacja(db, "Sieć uczelniana", "administrator");
        }
    }
}
