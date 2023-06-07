package pl.kalisz.akdemia.pup.apkadamian30685;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import java.util.Random;

/**
 * Implementation of App Widget functionality.
 */
public class Widget30685 extends AppWidgetProvider {
    static Obiekt[] obiekty = Obiekt.obiekty;

    static void updateAppWidget(
            Context context,
            AppWidgetManager appWidgetManager,
            int appWidgetId
    ) {
        Random rand = new Random();
        int nr_obiektu = rand.nextInt(5);
        System.out.println(nr_obiektu);
        System.out.println(obiekty[nr_obiektu].toString());
        Intent intent = new Intent(context, ObiektyUczelni.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget30685);
        views.setImageViewResource(R.id.appwidget_obrazek, obiekty[nr_obiektu].getFotoId());
        views.setOnClickPendingIntent(R.id.appwidget_przycisk, pendingIntent);
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}