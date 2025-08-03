package cn.smssdk;

import android.app.Activity;
import android.content.res.Resources;
import android.telephony.SmsMessage;
import cn.smssdk.utils.DHelper;
import cn.smssdk.utils.SMSLog;
import cn.smssdk.wrapper.TokenVerifyResult;
import com.mob.MobSDK;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONException;

/* loaded from: classes.dex */
public class SMSSDK {
    public static final int EVENT_GET_CONTACTS = 4;
    public static final int EVENT_GET_FRIENDS_IN_APP = 6;
    public static final int EVENT_GET_NEW_FRIENDS_COUNT = 7;
    public static final int EVENT_GET_SUPPORTED_COUNTRIES = 1;
    public static final int EVENT_GET_VERIFICATION_CODE = 2;
    public static final int EVENT_GET_VERIFY_TOKEN_CODE = 9;
    public static final int EVENT_GET_VOICE_VERIFICATION_CODE = 8;
    public static final int EVENT_SUBMIT_USER_INFO = 5;
    public static final int EVENT_SUBMIT_VERIFICATION_CODE = 3;
    public static final int EVENT_VERIFY_LOGIN = 10;
    public static final int RESULT_COMPLETE = -1;
    public static final int RESULT_ERROR = 0;
    private static SMSSDKCore a;
    private static InitFlag b = InitFlag.DEFAULT;
    private static volatile boolean c = false;
    private static volatile boolean d = false;

    public enum InitFlag {
        DEFAULT,
        WARNNING_READCONTACT,
        WARNNING_READCONTACT_DIALOG_MODE,
        DISABLE_CONTACT
    }

    public interface VerifyCodeReadListener {
        void onReadVerifyCode(String str);
    }

    static {
        SMSLog.prepare();
        a();
    }

    private static boolean a() {
        if (!c) {
            synchronized (SMSSDK.class) {
                if (!c) {
                    if (MobSDK.isForb()) {
                        SMSLog.getInstance().d(SMSLog.FORMAT_SIMPLE, "Privacy not granted, stop init");
                        return false;
                    }
                    if (DHelper.support()) {
                        Object objInit = DHelper.init();
                        synchronized (objInit) {
                            try {
                                objInit.wait(5000L);
                            } catch (InterruptedException e2) {
                                SMSLog.getInstance().e(SMSLog.FORMAT_SIMPLE, e2.toString());
                            }
                            d = true;
                            SMSLog.getInstance().d(SMSLog.FORMAT_SIMPLE, "DH dhResponsed");
                            SMSSDKCore sMSSDKCore = new SMSSDKCore(b);
                            a = sMSSDKCore;
                            sMSSDKCore.b();
                            a.e();
                        }
                    } else {
                        d = false;
                    }
                    c = true;
                }
            }
        }
        return d;
    }

    @Deprecated
    public static void getContacts(boolean z) {
        if (a()) {
            a.a(4, Boolean.valueOf(z));
        }
    }

    public static String[] getCountry(String str) {
        if (a()) {
            return a.a(str);
        }
        return null;
    }

    public static String[] getCountryByMCC(String str) {
        if (a()) {
            return a.b(str);
        }
        return null;
    }

    @Deprecated
    public static void getFriendsInApp() {
        if (a()) {
            a.a(6, (Object) null);
        }
    }

    public static HashMap<Character, ArrayList<String[]>> getGroupedCountryList() {
        return !a() ? new HashMap<>() : a.a();
    }

    @Deprecated
    public static void getNewFriendsCount() {
        if (a()) {
            a.a(7, (Object) null);
        }
    }

    public static void getSupportedCountries() {
        if (a()) {
            a.a(1, (Object) null);
        }
    }

    public static void getToken() throws JSONException, Resources.NotFoundException {
        if (a()) {
            a.c();
        }
    }

    public static void getVerificationCode(String str, String str2) {
        getVerificationCode((String) null, str, str2);
    }

    public static String getVersion() {
        return "3.7.8";
    }

    public static void getVoiceVerifyCode(String str, String str2) {
        getVoiceVerifyCode(str, str2, null);
    }

    public static void login(String str, TokenVerifyResult tokenVerifyResult) {
        if (a()) {
            a.a(str, tokenVerifyResult);
        }
    }

    public static void readVerificationCode(SmsMessage smsMessage, VerifyCodeReadListener verifyCodeReadListener) {
        if (a()) {
            a.a(smsMessage, verifyCodeReadListener);
        }
    }

    public static void registerEventHandler(EventHandler eventHandler) {
        if (a()) {
            a.a(eventHandler);
        }
    }

    @Deprecated
    public static synchronized void setAskPermisionOnReadContact(boolean z) {
    }

    @Deprecated
    public static void setInitFlag(InitFlag initFlag) {
        b = initFlag;
    }

    @Deprecated
    public static void showAuthorizeDialog(Activity activity, OnDialogListener onDialogListener) {
        if (a()) {
            a.a(activity, onDialogListener);
        }
    }

    @Deprecated
    public static void submitUserInfo(String str, String str2, String str3, String str4, String str5) {
        if (a()) {
            a.a(5, new String[]{str, str2, str3, str4, str5});
        }
    }

    public static void submitVerificationCode(String str, String str2, String str3) {
        if (a()) {
            a.a(3, new String[]{str, str2, str3});
        }
    }

    public static void unregisterAllEventHandler() {
        if (a()) {
            a.d();
        }
    }

    public static void unregisterEventHandler(EventHandler eventHandler) {
        if (a()) {
            a.b(eventHandler);
        }
    }

    public static void getVerificationCode(String str, String str2, OnSendMessageHandler onSendMessageHandler) {
        getVerificationCode(str, str2, null, onSendMessageHandler);
    }

    public static void getVoiceVerifyCode(String str, String str2, String str3) {
        if (a()) {
            a.a(8, new String[]{str2, str, str3});
        }
    }

    public static void getVerificationCode(String str, String str2, String str3) {
        getVerificationCode(str2, str3, str, null);
    }

    public static void getVerificationCode(String str, String str2, String str3, OnSendMessageHandler onSendMessageHandler) {
        getVerificationCode(str, str2, null, str3, onSendMessageHandler);
    }

    public static void getVerificationCode(String str, String str2, String str3, String str4, OnSendMessageHandler onSendMessageHandler) {
        if (a()) {
            a.a(2, new Object[]{str, str2, str3, str4, onSendMessageHandler});
        }
    }
}
