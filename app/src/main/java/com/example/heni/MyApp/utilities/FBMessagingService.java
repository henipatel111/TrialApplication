package com.example.heni.MyApp.utilities;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;
import android.widget.Toast;

import com.example.heni.MyApp.R;
import com.example.heni.MyApp.activities.ImageFullScreenActivity;
import com.example.heni.MyApp.activities.MainActivity;
import com.example.heni.MyApp.fragments.NotificationFragment;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Map;

/**
 * Created by heni on 4/9/17.
 */

public class FBMessagingService extends FirebaseMessagingService{

   /* private static final String TAG = "MyFirebaseMsgService";
    private static final String TYPE_POST = "POST";

    //    notification data keys
    private static final String NOTIFICATION_KEY_TITLE = "title";
    private static final String NOTIFICATION_KEY_BODY = "subtitle";
    private static final String NOTIFICATION_KEY_TYPE = "type";
    private static final String NOTIFICATION_KEY_IMAGE = "image";

    private static final int ID_POST_NOTIFICATION_ID = 1;


    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        // ...

        // TODO(developer): Handle FCM messages here.
        // Not getting messages here? See why this may be: https://goo.gl/39bRNJ
        Log.d(TAG, "From: " + remoteMessage.getFrom());

        // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
        }

        // Check if message contains a notification payload.
        *//*if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }*//*
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

        // Also if you intend on generating your own notifications as a result of a received FCM
        // message, here is where that should be initiated. See sendNotification method below.
    }

    private void onPostStatusNotificationReceived(Map<String, String> data) {
        String title = data.get(NOTIFICATION_KEY_TITLE);
        String subtitle = data.get(NOTIFICATION_KEY_BODY);
        Intent intent = new Intent(this, NotificationFragment.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        createNotification(title, subtitle, R.drawable.demo_cube, data.get(NOTIFICATION_KEY_IMAGE), intent, ID_POST_NOTIFICATION_ID, true);
    }

    private void createNotification(String title, String subtitle, int demo_cube, String s, Intent intent, int idPostNotificationId, boolean b) {

        Intent parentIntent = new Intent(this, NotificationFragment.class);
        parentIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(this);
        taskStackBuilder.addNextIntent(intent);

        PendingIntent pendingIntent;
        if (b) {
            pendingIntent = PendingIntent.getActivities(this, idPostNotificationId, new Intent[]{parentIntent, intent}, PendingIntent.FLAG_ONE_SHOT);
        } else {
            pendingIntent = PendingIntent.getActivities(this, idPostNotificationId, new Intent[]{intent}, PendingIntent.FLAG_ONE_SHOT);
        }

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.demo_cube)
                        .setContentTitle(title)
                        .setContentText(subtitle)
                        .setStyle(new NotificationCompat.BigTextStyle().setBigContentTitle(title).bigText(subtitle))
                        .setAutoCancel(true)
                        .setSound(defaultSoundUri)
                        .setContentIntent(pendingIntent);

        Intent notificationIntent = new Intent(this, NotificationFragment.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }*/

    private static final String TAG = "MyFirebaseMsgService";
    /**
     * Called when message is received.
     *
     * @param remoteMessage Object representing the message received from Firebase Cloud Messaging.
     */
// [START receive_message]
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

    // TODO(developer): Handle FCM messages here.
        Log.d(TAG, "From: " + remoteMessage.getFrom());
    // Check if message contains a data payload.
        if (remoteMessage.getData().size() > 0) {
            Toast.makeText(this, "Got the notification", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Message data payload: " + remoteMessage.getData());
            sendNotification(remoteMessage.getMessageType());
        }
    // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            Toast.makeText(this, "Did not get the notification", Toast.LENGTH_SHORT).show();
            Log.d(TAG, "Message Notification Body: " + remoteMessage.getNotification().getBody());
        }
    }


    /**
     * Create and show a simple notification containing the received FCM message.
     *
     * @param messageBody FCM message body received.
     */
    private void sendNotification(String messageBody) {
        /*Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 *//* Request code *//*, intent,
                PendingIntent.FLAG_ONE_SHOT);
        Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.demo_cube)
                .setContentTitle("FCM Message")
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0 *//* ID of notification *//*, notificationBuilder.build());*/

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.demo_cube)
                        .setContentTitle("FCM Notifications Example")
                        .setContentText(messageBody);

        Intent notificationIntent = new Intent(this, NotificationFragment.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());
    }
}
