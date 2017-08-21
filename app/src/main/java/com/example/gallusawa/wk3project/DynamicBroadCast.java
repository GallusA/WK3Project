package com.example.gallusawa.wk3project;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

/**
 * Created by gallusawa on 8/21/17.
 */

public class DynamicBroadCast extends BroadcastReceiver {
    TextView etchanged;
    RecyclerView rvRandomsList;

    private static final String TAG = "DynamicBroadcast";

    public DynamicBroadCast() {}

    public DynamicBroadCast(TextView etchanged, RecyclerView rvRandomsList) {
        this.etchanged = etchanged;
        this.rvRandomsList = rvRandomsList;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        //Toast.makeText(context, "I am a dynamic receiver", Toast.LENGTH_SHORT).show();
        try{etchanged.setText(intent.getAction().toString());}catch(Exception ex){}
        switch (intent.getAction()) {
            case Intent.ACTION_AIRPLANE_MODE_CHANGED:
                Toast.makeText(context, "Airplane changed", Toast.LENGTH_LONG).show();
                //etchanged.setText("Airplane changed");
                break;
            case Intent.ACTION_POWER_CONNECTED:
                Toast.makeText(context, "Power connected", Toast.LENGTH_LONG).show();
//                etchanged.setText("Power connected");
                break;
            case Intent.ACTION_POWER_DISCONNECTED:
                Toast.makeText(context, "Power disconnected", Toast.LENGTH_LONG).show();
//                etchanged.setText("Power disconnected");
                break;
            case Intent.ACTION_SCREEN_ON:
                Toast.makeText(context, "Screen on", Toast.LENGTH_LONG).show();
//                etchanged.setText("Screen on");
                break;
            case Intent.ACTION_SCREEN_OFF:
                Toast.makeText(context, "Screen off", Toast.LENGTH_LONG).show();
//                etchanged.setText("Screen off");
                break;
            case Intent.ACTION_SET_WALLPAPER:
                Toast.makeText(context, "Set wallpaper", Toast.LENGTH_LONG).show();
//                etchanged.setText("Set wallpaper");
                break;
            case "loadFirstPage":
                Log.d(TAG, "onReceive: loadFirstPage");

                ArrayList<? extends Books> Books = intent.getParcelableArrayListExtra("Books");
                ArrayList<? extends com.example.gallusawa.wk3project.Books> BookSub = intent.getParcelableArrayListExtra("BookSub");
                boolean pages_validation = intent.getBooleanExtra("pages_validation",true);

                EventBus.getDefault().post(new MessageEvent("loadFirstPage",Books, BookSub, pages_validation));

                break;

            case "loadNextPage":
                Log.d(TAG, "onReceive: loadNextPage");

                ArrayList<Books> Book2 = intent.getParcelableArrayListExtra("Books");
                ArrayList<Books> BookSub2 = intent.getParcelableArrayListExtra("BookSub");
                boolean pages_validation2 = intent.getBooleanExtra("pages_validation",true);

                EventBus.getDefault().post(new MessageEvent("loadNextPage",Book2, BookSub2, pages_validation2));

                break;

            case "register":
               EventBus.getDefault().register(this);
                break;
            case "unregister":
                EventBus.getDefault().unregister(this);
                break;
        }
    }
}