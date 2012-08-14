package org.turpial.mobile;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class StreamService extends Service {
    
    public static String ACTION = "org.turpial.mobile.notifynewstuff";

    private static boolean isRunning = false;
    private static Thread backgroundThread = null;
    private static boolean notificationSystem = true;
    private static int interval = 20000;
    
    @Override
    public IBinder onBind(Intent arg0) {
        return null;
    }
    
    public void onCreate() {
        
    }
    
    public int onStartCommand(Intent intent, int flags, int startId) {
        isRunning = true;
        run();
        return startId;
    }
    
    private void run() {        
        backgroundThread = new Thread(new Runnable() {
            public void run() {
                while(isRunning) {
                    onRunning();
                    try {
                        Thread.sleep(interval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }                
            }
        });
        
        backgroundThread.start();
    }
    
    protected void onRunning() {
        Log.i("TurpialStreamService", "I am running");
        notifyNewStuff();
        launchMessage(ACTION);
    }
    
    public static void stop() {
        isRunning = false;
    }
    
    public static boolean isRunning() {
        return isRunning;
    }
    
    public void onDestroy() {
        isRunning = false;
    }
    
    protected static void notifyNewStuff() {
        if(StreamService.notificationSystem == true)
        {}
    }

    public static void setNotificationSystem(boolean notificationSystem) {
        StreamService.notificationSystem = notificationSystem;
    }

    public static boolean isNotificationSystem() {
        return notificationSystem;
    }
    
    private void launchMessage(String message)
    {
        Intent intent = new Intent();
        intent.setAction(message);
        sendBroadcast(intent, null);
    }

}