package com.example.heni.MyApp.utilities;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

import com.example.heni.MyApp.R;
import com.example.heni.MyApp.activities.ImageFullScreenActivity;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Created by heni on 4/9/17.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService{

    private static final String TAG = "MyFirebaseMsgService";
    private static final String TYPE_POST = "POST";

    //    notification data keys
    private static final String NOTIFICATION_KEY_TITLE = "title";
    private static final String NOTIFICATION_KEY_BODY = "subtitle";
    private static final String NOTIFICATION_KEY_TYPE = "type";
    private static final String NOTIFICATION_KEY_IMAGE = "image";

    private static final int ID_POST_NOTIFICATION_ID = 1;

    /**
     * Called when message is received.
     *
     * @param remoteMessage Object representing the message received from Firebase Cloud Messaging.
     */
    // [START receive_message]
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // [START_EXCLUDE]
        // There are two types of messages data messages and notification messages. Data messages are handled
        // here in onMessageReceived whether the app is in the foreground or background. Data messages are the type
        // traditionally used with GCM. Notification messages are only received here in onMessageReceived when the app
        // is in the foreground. When the app is in the background an automatically generated notification is displayed.
        // When the user taps on the notification they are returned to the app. Messages containing both notification
        // and data payloads are treated as notification messages. The Firebase console always sends notification
        // messages. For more see: https://firebase.google.com/docs/cloud-messaging/concept-options
        // [END_EXCLUDE]

        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: " + remoteMessage.getFrom());


        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "0 " + remoteMessage.getData());
            String notificationType = remoteMessage.getData().get(NOTIFICATION_KEY_TYPE);
            switch (notificationType) {
                case TYPE_POST:
                    onPostStatusNotificationReceived(remoteMessage.getData());
                    break;
            }
        } else {
            Log.d(TAG, "onMessageReceived: getdata is null");
        }

        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
        //sendNotification(remoteMessage.getNotification().getBody());
    }

    private void onPostStatusNotificationReceived(Map<String, String> data) {
        String title = data.get(NOTIFICATION_KEY_TITLE);
        String subtitle = data.get(NOTIFICATION_KEY_BODY);
        Intent intent = new Intent(this, ImageFullScreenActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        createNotification(title, subtitle, R.drawable.demo_cube, data.get(NOTIFICATION_KEY_IMAGE), intent, ID_POST_NOTIFICATION_ID, true);
    }

    private void createNotification(String title, String subtitle, int iconResID, String notificationImageUrl, Intent intent, int notificationID, boolean addParentToStack) {
        Intent parentIntent = new Intent(this, ImageFullScreenActivity.class);
        parentIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(this);
        taskStackBuilder.addNextIntent(intent);
        PendingIntent pendingIntent;
        if (addParentToStack) {
            pendingIntent = PendingIntent.getActivities(this, notificationID, new Intent[]{parentIntent, intent}, PendingIntent.FLAG_ONE_SHOT);
        } else {
            pendingIntent = PendingIntent.getActivities(this, notificationID, new Intent[]{intent}, PendingIntent.FLAG_ONE_SHOT);
        }

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        final NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(iconResID)
                .setColor(getResources().getColor(R.color.google_blue_100))
                .setContentTitle(title)
                .setContentText(subtitle)
                .setStyle(new NotificationCompat.BigTextStyle().setBigContentTitle(title).bigText(subtitle))
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        final NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        //if notification has
        if (notificationImageUrl == null || notificationImageUrl.length() == 0) {
            notificationManager.notify(notificationID/* ID of notification */, notificationBuilder.build());
        } else {
            Bitmap bitmap = getBitmapFromURL(notificationImageUrl);
            if (bitmap != null) {
                notificationBuilder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap));
                notificationManager.notify(notificationID/* ID of notification */, notificationBuilder.build());
            } else {
                notificationManager.notify(notificationID/* ID of notification */, notificationBuilder.build());
            }
        }
    }

    public Bitmap getBitmapFromURL(String imageURL) {
        try {
            URL url = new URL(imageURL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream inputStream = connection.getInputStream();
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

