package com.example.geolocationwitharduino;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver {
    private static MessageListener mListener;

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle data = intent.getExtras();
        if (data != null && data.containsKey("pdus")) {
            Object[] pdus = (Object[]) data.get("pdus");
            if (pdus != null) {
                int nbrOfpdus = pdus.length;
                String message = "";
                for (int i = 0; i < nbrOfpdus; i++) {
                    SmsMessage smsMessage = SmsMessage.createFromPdu((byte[])pdus[i]);
                    if (smsMessage.getDisplayOriginatingAddress().equals(context.getString(R.string.arduino_gsm_number))) {
                        message += smsMessage.getMessageBody();
                    }
                }
                Log.i("SmsReceiver", message);
                mListener.messageReceived(message);
            }
        }
    }

    public static void bindListener(MessageListener listener){
        mListener = listener;
    }
}
