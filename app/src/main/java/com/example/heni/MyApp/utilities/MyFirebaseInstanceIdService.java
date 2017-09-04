package com.example.heni.MyApp.utilities;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by heni on 4/9/17.
 */

public class MyFirebaseInstanceIdService extends FirebaseInstanceIdService{

    private static final String TAG = "MyFirebaseIIDService";
    private static String deviceToken = "";

    public static String getDeviceToken() {
        if (deviceToken.equals("")) {
            deviceToken = FirebaseInstanceId.getInstance().getToken();
        }
        Log.i(TAG, "getDeviceToken: " + deviceToken);
        return deviceToken;
    }

    // [END refresh_token]

    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the InstanceID token
     * is initially generated so this is where you would retrieve the token.
     */
    // [START refresh_token]
    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + refreshedToken);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        //sendRegistrationToServer(refreshedToken);
        deviceToken = refreshedToken;
    }

    /**
     * Persist token to third-party servers.
     * <p>
     * Modify this method to associate the user's FCM InstanceID token with any server-side account
     * maintained by your application.
     *
     * @param token The new token.
     */
    private void sendRegistrationToServer(String token) {

        deviceToken = token;
        /*if (User.isLoggedIn(this)) {
            Log.i(TAG, "sendRegistrationToServer: sending token" + token);
            Call<JsonObject> reportDeviceToken = RetrofitHelper.getRetrofitService(this).registerDeviceToken(token);
            try {
                Response<JsonObject> jsonObject = reportDeviceToken.execute();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }*/
    }
}
