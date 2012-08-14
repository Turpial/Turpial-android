package org.turpial.mobile;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class StreamBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent startServiceIntent = new Intent(context, StreamService.class);
        context.startService(startServiceIntent);
    }
}
