package com.example.heni.bannersonhomepage.utilities;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.heni.bannersonhomepage.R;

/**
 * Created by heni on 8/7/17.
 */

public class MyHelper {

    private static final String TAG = "EEC helper tag";
    static String KEY = "1234567812345678";
    public static void hideStatusBar(Activity activity) {
        try {
            activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
            activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Checks if either of wifi and cellular data is on or not. If device do not have connection due to turned off adapter shows message in textView
     *
     * @param context: : context of activity on which this request made
     * @return true for data adapter on
     */
    public static boolean isDataAdapterOn(Context context) {
        //Log.d("Data adapter check initiated"," ");
        try {
            ConnectivityManager connectivityManager
                    = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return (activeNetworkInfo != null && activeNetworkInfo.isConnected());
        } catch (Exception e) {
            return false;
        }
    }

    public static void toastNoInternetMessage(Context context) {
        Toast.makeText(context, "Please connect to the Internet.", Toast.LENGTH_SHORT).show();
    }

    public static void startIWProgressRing(LinearLayout llProgressHolder) {
        llProgressHolder.setVisibility(View.VISIBLE);
        AnimationDrawable animationDrawable;
        ImageView imgProgress = (ImageView) llProgressHolder.findViewById(R.id.img_progress);
        imgProgress.setBackgroundResource(R.drawable.img_progress_anim);
        animationDrawable = (AnimationDrawable) imgProgress.getBackground();
        imgProgress.setVisibility(View.VISIBLE);
        animationDrawable.start();
    }
}
