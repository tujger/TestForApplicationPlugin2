package com.edeqa.testforapplicationplugin2;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;

import com.edeqa.waytous.WaytousPlugin;

import java.util.List;

/**
 * Created 8/16/2017.
 */

public class PluginService extends com.edeqa.waytous.PluginService {
    static final String LOG_TAG = "ResPluginService2";

    public void onStart(Intent intent, int startId) {
        super.onStart( intent, startId );
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public IBinder onBind(Intent intent) {
        return binder;
    }

    private final WaytousPlugin.Stub binder =
            new WaytousPlugin.Stub() {

                @Override
                public String getType() throws RemoteException {
                    System.out.println(LOG_TAG + ":getType");
                    return LOG_TAG;
                }

                @Override
                public void start() throws RemoteException {
                    System.out.println(LOG_TAG + ":start");
                }

                @Override
                public void finish() throws RemoteException {
                    System.out.println(LOG_TAG + ":finish");

                }

                @Override
                public List<String> events() throws RemoteException {
                    System.out.println(LOG_TAG + ":events");

                    return null;
                }

                @Override
                public void setContext(Bundle var1) throws RemoteException {
                    System.out.println(LOG_TAG + ":setcontext:"+var1);

                }

                @Override
                public boolean onEvent(String var1, Bundle var2) throws RemoteException {
                    System.out.println(LOG_TAG + ":onevent:"+var1+":"+var2.getSerializable("object"));
                    return true;
                }

                @Override
                public void setLoggingLevel(Bundle var1) throws RemoteException {
                    System.out.println(LOG_TAG + ":setlogginglevel:"+var1);

                }
            };
}

