package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "MyReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive triggered with action: " + intent.getAction());
        if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())) {
            // Using Settings.Global is a more reliable way to check the current airplane mode state
            boolean isAirplaneModeOn = Settings.Global.getInt(
                    context.getContentResolver(), 
                    Settings.Global.AIRPLANE_MODE_ON, 0) != 0;

            String message = "Airplane Mode: " + (isAirplaneModeOn ? "ON" : "OFF");
            Log.d(TAG, message);
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }
}
