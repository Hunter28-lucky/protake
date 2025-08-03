package cn.smssdk.gui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import cn.smssdk.SMSSDK;
import cn.smssdk.utils.SMSLog;

/* loaded from: classes.dex */
public class SMSReceiver extends BroadcastReceiver {
    private static final String ACTION_SMS_RECEIVER = "android.provider.Telephony.SMS_RECEIVED";
    private SMSSDK.VerifyCodeReadListener listener;

    public SMSReceiver(SMSSDK.VerifyCodeReadListener verifyCodeReadListener) {
        this.listener = verifyCodeReadListener;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        if (!ACTION_SMS_RECEIVER.equals(intent.getAction()) || (extras = intent.getExtras()) == null) {
            return;
        }
        Object[] objArr = (Object[]) extras.get("pdus");
        int length = objArr.length;
        SmsMessage[] smsMessageArr = new SmsMessage[length];
        for (int i = 0; i < objArr.length; i++) {
            smsMessageArr[i] = SmsMessage.createFromPdu((byte[]) objArr[i]);
        }
        for (int i2 = 0; i2 < length; i2++) {
            SmsMessage smsMessage = smsMessageArr[i2];
            if (smsMessage != null) {
                SMSSDK.readVerificationCode(smsMessage, this.listener);
            }
        }
    }

    public SMSReceiver() {
        SMSLog.getInstance().i("SMSReceiver:Please dynamically register an instance of this class with Context.registerReceiver.\r\nIf not, the SMSSDK.VerifyCodeReadListener will be null!");
    }
}
