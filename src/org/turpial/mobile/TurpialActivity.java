package org.turpial.mobile;

import org.apache.cordova.*;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

public class TurpialActivity extends DroidGap {

    public class NotificationReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(StreamService.ACTION)){
                sendJavascript("serviceListener.sendStuff();");
            }
        }
    }
    
    private NotificationReceiver receiver = new NotificationReceiver();
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        IntentFilter filter = new IntentFilter(StreamService.ACTION);
        this.registerReceiver(receiver, filter);
        super.onCreate(savedInstanceState);
        super.loadUrl("file:///android_asset/www/accounts.html");
    }
    
    public void onStart() {
        super.onStart();
        if(!StreamService.isRunning()) {
            Intent startServiceIntent = new Intent(this, StreamService.class);
            startService(startServiceIntent);
        }
    }
    
    public void onDestroy() {
        super.onDestroy();
        try {
            this.unregisterReceiver(receiver);
        } catch(Exception ex){}
    }
    
    
}
