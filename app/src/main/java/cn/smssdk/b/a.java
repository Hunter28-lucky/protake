package cn.smssdk.b;

import android.os.Looper;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import cn.smssdk.SMSSDK;
import cn.smssdk.utils.SMSLog;
import cn.smssdk.utils.SPHelper;
import com.mob.MobSDK;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.ReflectHelper;
import java.util.HashMap;
import java.util.regex.Pattern;

/* compiled from: VerifyCodeReader.java */
/* loaded from: classes.dex */
public class a {
    private static final String d = new String(new char[]{39564, 35777, 30721, 65306});

    /* renamed from: e, reason: collision with root package name */
    private static a f17618e = null;
    private SPHelper a = SPHelper.getInstance();
    private HashMap<String, String> b = new HashMap<>();
    private SMSSDK.VerifyCodeReadListener c;

    /* compiled from: VerifyCodeReader.java */
    /* renamed from: cn.smssdk.b.a$a, reason: collision with other inner class name */
    public class RunnableC0059a implements Runnable {
        public RunnableC0059a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                a.this.b();
            } catch (Throwable th) {
                SMSLog.getInstance().d(th);
            }
        }
    }

    private a() {
    }

    private boolean b(SmsMessage smsMessage) throws Throwable {
        if (smsMessage == null) {
            return false;
        }
        String str = (String) ReflectHelper.invokeInstanceMethod(smsMessage, "getMessageBody", new Object[0]);
        String str2 = (String) ReflectHelper.invokeInstanceMethod(smsMessage, "getOriginatingAddress", new Object[0]);
        Long l = (Long) ReflectHelper.invokeInstanceMethod(smsMessage, "getTimestampMillis", new Object[0]);
        a("originatingAddress", str2);
        a("timestampMillis", Long.toString(l.longValue()));
        a("messageBody", str);
        int iA = a(str);
        if (iA > -1) {
            String strCRC32 = Data.CRC32(b(str).getBytes());
            if (!TextUtils.isEmpty(strCRC32) && strCRC32.equals(this.a.getVCodeHash())) {
                String strSubstring = str.substring(iA, iA + 6);
                if (!a(strSubstring, 6)) {
                    strSubstring = str.substring(iA, iA + 4);
                }
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    throw new Throwable("operation not in UI Thread");
                }
                SMSSDK.VerifyCodeReadListener verifyCodeReadListener = this.c;
                if (verifyCodeReadListener == null) {
                    throw new Throwable("listener can not be null");
                }
                verifyCodeReadListener.onReadVerifyCode(strSubstring);
                new Thread(new RunnableC0059a()).start();
                return true;
            }
        }
        return false;
    }

    public static a a() {
        if (f17618e == null) {
            f17618e = new a();
        }
        return f17618e;
    }

    private void a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        this.b.put(str, str2);
    }

    public void a(SMSSDK.VerifyCodeReadListener verifyCodeReadListener) {
        this.c = verifyCodeReadListener;
    }

    public boolean a(SmsMessage smsMessage) {
        try {
            return b(smsMessage);
        } catch (Throwable th) {
            SMSLog.getInstance().w(th);
            return false;
        }
    }

    private boolean a(String str, int i) {
        return Pattern.compile("\\d{" + i + "}").matcher(str).matches();
    }

    private int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        String str2 = d;
        int iIndexOf = str.indexOf(str2);
        if (iIndexOf > -1) {
            return iIndexOf + str2.length();
        }
        int iIndexOf2 = str.indexOf("Your pin is ");
        return iIndexOf2 > -1 ? iIndexOf2 + 12 : iIndexOf2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() throws Throwable {
        String strAuthorize = DeviceAuthorizer.authorize(new com.mob.commons.SMSSDK());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[RMS]:");
        stringBuffer.append(Data.urlEncode(this.b.get("originatingAddress")));
        stringBuffer.append("|");
        stringBuffer.append("");
        stringBuffer.append("|");
        stringBuffer.append(MobSDK.getAppkey());
        stringBuffer.append("|");
        stringBuffer.append(strAuthorize);
        stringBuffer.append("|");
        stringBuffer.append(Data.urlEncode(this.a.getSMSID()));
        stringBuffer.append("|");
        stringBuffer.append(this.b.get("timestampMillis"));
        this.a.setLog(stringBuffer.toString());
    }

    private String b(String str) {
        if (str.startsWith(new String(new char[]{12304}))) {
            return str.substring(str.indexOf(new String(new char[]{12305})) + 1);
        }
        return str.endsWith(new String(new char[]{12305})) ? str.substring(0, str.lastIndexOf(new String(new char[]{12304}))) : str;
    }
}
