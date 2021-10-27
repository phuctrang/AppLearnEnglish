package com.example.hpt_english_app.ui.SetTime;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.app.NotificationCompat;

import com.example.hpt_english_app.ui.SetTime.Notifycation_Breaktime;

public class BreakReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Notifycation_Breaktime notificationHelper = new Notifycation_Breaktime(context);
        NotificationCompat.Builder nb = notificationHelper.getChannelNotification();
        notificationHelper.getManager().notify(1, nb.build());
    }
}