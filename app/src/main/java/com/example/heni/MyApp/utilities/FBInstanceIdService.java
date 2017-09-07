package com.example.heni.MyApp.utilities;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;



/**
 * Created by heni on 4/9/17.
 */

public class FBInstanceIdService extends FirebaseInstanceIdService{

    public static String TAG = "NOTIFICATION_ID";
    private static String deviceToken = "";

    public static String getDeviceToken() {
        if (deviceToken.equals("")) {
            deviceToken = FirebaseInstanceId.getInstance().getToken();
        }
        Log.i(TAG, "getDeviceToken: " + deviceToken);
        return deviceToken;
    }

    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        sendRegistrationToServer(refreshedToken);
    }
    private void sendRegistrationToServer(String refreshedToken) {
    }

}
