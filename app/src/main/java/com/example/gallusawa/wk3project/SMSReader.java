package com.example.gallusawa.wk3project;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import static android.Manifest.permission_group.SMS;

/**
 * Created by gallusawa on 8/21/17.
 */

public class SMSReader extends BroadcastReceiver {

 @Override
public void onReceive(Context context, Intent intent) {
    Bundle intentExtras = intent.getExtras();

    if (intentExtras != null) {

        Object[] message = (Object[]) intentExtras.get("pdus");

        ArrayList<SMS> messageList = new ArrayList<>();

        for (int i = 0; i < message.length; ++i) {
                /* Parse Each Message */
            SmsMessage sms = SmsMessage.createFromPdu((byte[]) message[i]);

            String phone = "SMS From: " + sms.getOriginatingAddress();
            String messages = sms.getMessageBody();

            messageList.add(new SMS(phone,message));

            Toast.makeText(context, phone + ": " + messages, Toast.LENGTH_SHORT).show();
        }
        EventBus.getDefault().post(messageList);
    }
}


}