package cn.smssdk;

import android.app.Activity;
import android.content.res.Resources;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import cn.smssdk.SMSSDK;
import cn.smssdk.net.login.LoginCore;
import cn.smssdk.ui.AlertPage;
import cn.smssdk.utils.SMSLog;
import cn.smssdk.utils.SmsResHelper;
import cn.smssdk.wrapper.MobVerifyWrapper;
import cn.smssdk.wrapper.TokenVerifyException;
import cn.smssdk.wrapper.TokenVerifyResult;
import com.mob.MobCommunicator;
import com.mob.MobSDK;
import com.mob.commons.ForbThrowable;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.DH;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class SMSSDKCore {
    private HashSet<EventHandler> a;
    private cn.smssdk.net.f b;
    private cn.smssdk.b.a c;
    private String d;

    /* renamed from: e, reason: collision with root package name */
    private HashMap<Character, ArrayList<String[]>> f17617e;
    private HashMap<String, String> f;
    private ArrayList<HashMap<String, Object>> g;

    public class a implements Runnable {
        public final /* synthetic */ Object a;

        public a(Object obj) {
            this.a = obj;
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException, Resources.NotFoundException {
            Object[] objArr = (Object[]) this.a;
            int i = 0;
            String str = (String) objArr[0];
            String strSubstring = (String) objArr[1];
            String str2 = (String) objArr[2];
            if (strSubstring.startsWith("+")) {
                strSubstring = strSubstring.substring(1);
            }
            try {
                if (SMSSDKCore.this.f == null || SMSSDKCore.this.f.size() <= 0) {
                    SMSSDKCore.this.l();
                }
                SMSSDKCore.this.b.a(str, strSubstring, str2);
                i = -1;
                th = null;
            } catch (Throwable th) {
                th = th;
            }
            SMSSDKCore.this.a(8, i, th);
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException, Resources.NotFoundException {
            SMSSDKCore.this.a(8, 0, SMSSDKCore.b(614, (Throwable) null));
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SMSSDKCore.f();
                SMSSDKCore.this.b.b();
            } catch (Throwable unused) {
                SMSLog.getInstance().d(SMSLog.FORMAT_SIMPLE, "Privacy not granted, stop init token");
            }
        }
    }

    public class d extends cn.smssdk.wrapper.a<TokenVerifyResult> {
        public d() {
        }

        @Override // cn.smssdk.wrapper.a
        public void a(TokenVerifyResult tokenVerifyResult) throws JSONException, Resources.NotFoundException {
            SMSSDKCore.this.a(9, -1, tokenVerifyResult);
        }

        @Override // cn.smssdk.wrapper.a
        public void a(TokenVerifyException tokenVerifyException) throws JSONException, Resources.NotFoundException {
            SMSSDKCore.this.a(9, 0, tokenVerifyException);
        }
    }

    public class e extends cn.smssdk.net.login.d {
        public e() {
        }

        @Override // cn.smssdk.net.login.d
        public void a() throws JSONException, Resources.NotFoundException {
            SMSSDKCore.this.a(10, -1, (Object) null);
        }

        @Override // cn.smssdk.net.login.d
        public void a(Throwable th) throws JSONException, Resources.NotFoundException {
            SMSSDKCore.this.a(10, 0, th);
        }
    }

    public class f implements Runnable {
        public f(SMSSDKCore sMSSDKCore) {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                SMSSDKCore.f();
                cn.smssdk.logger.d.d().b();
            } catch (Throwable unused) {
                SMSLog.getInstance().d(SMSLog.FORMAT_SIMPLE, "Privacy not granted, stop init token");
            }
        }
    }

    public class g extends Thread {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        public g(int i, Object obj) {
            this.a = i;
            this.b = obj;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws JSONException, Resources.NotFoundException {
            try {
                synchronized (SMSSDKCore.this.a) {
                    Iterator it = SMSSDKCore.this.a.iterator();
                    while (it.hasNext()) {
                        ((EventHandler) it.next()).beforeEvent(this.a, this.b);
                    }
                }
                SMSSDKCore.f();
                SMSSDKCore.this.b(this.a, this.b);
            } catch (Throwable th) {
                SMSSDKCore.this.a(this.a, 0, th);
            }
        }
    }

    public class h implements Runnable {
        public final /* synthetic */ Object a;

        public h(Object obj) {
            this.a = obj;
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException, Resources.NotFoundException {
            int i = 0;
            try {
                if (SMSSDKCore.this.f == null || SMSSDKCore.this.f.size() <= 0) {
                    SMSSDKCore.this.l();
                }
                Object[] objArr = (Object[]) this.a;
                String strSubstring = (String) objArr[0];
                String str = (String) objArr[1];
                String str2 = (String) objArr[2];
                String str3 = (String) objArr[3];
                if (strSubstring.startsWith("+")) {
                    strSubstring = strSubstring.substring(1);
                }
                OnSendMessageHandler onSendMessageHandler = (OnSendMessageHandler) objArr[4];
                if (onSendMessageHandler != null && onSendMessageHandler.onSendMessage(strSubstring, str)) {
                    throw new UserInterruptException();
                }
                th = Boolean.valueOf(SMSSDKCore.this.b.a(strSubstring, str, str2, str3));
                i = -1;
            } catch (Throwable th) {
                th = th;
            }
            SMSSDKCore.this.a(2, i, th);
        }
    }

    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException, Resources.NotFoundException {
            SMSSDKCore.this.a(2, 0, SMSSDKCore.b(614, (Throwable) null));
        }
    }

    public class j implements Runnable {
        public final /* synthetic */ Object a;

        public j(Object obj) {
            this.a = obj;
        }

        @Override // java.lang.Runnable
        public void run() throws Throwable {
            int i = 0;
            try {
                if (SMSSDKCore.this.f == null || SMSSDKCore.this.f.size() <= 0) {
                    SMSSDKCore.this.l();
                }
                String[] strArr = (String[]) this.a;
                String strSubstring = strArr[0];
                String str = strArr[1];
                String str2 = strArr[2];
                if (strSubstring.startsWith("+")) {
                    strSubstring = strSubstring.substring(1);
                }
                th = SMSSDKCore.this.b.b(str2, strSubstring, str);
                i = -1;
            } catch (Throwable th) {
                th = th;
            }
            SMSSDKCore.this.a(3, i, th);
        }
    }

    public class k implements Runnable {
        public k() {
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException, Resources.NotFoundException {
            SMSSDKCore.this.a(3, 0, SMSSDKCore.b(614, (Throwable) null));
        }
    }

    public SMSSDKCore(SMSSDK.InitFlag initFlag) {
        cn.smssdk.a.a();
        this.a = new HashSet<>();
        this.b = cn.smssdk.net.f.d();
        this.c = cn.smssdk.b.a.a();
    }

    public static void f() throws Throwable {
        int iIsAuth;
        if (MobSDK.isForb()) {
            throw new ForbThrowable();
        }
        try {
            iIsAuth = MobSDK.isAuth();
            try {
                SMSLog.getInstance().d(SMSLog.FORMAT, "SMSSDKCore", "checkBusiness", "isAuth: " + iIsAuth);
            } catch (Throwable unused) {
                SMSLog.getInstance().w(SMSLog.FORMAT, "SMSSDKCore", "checkBusiness", "Not privacy version, do work!");
                if (iIsAuth == 1) {
                } else {
                    return;
                }
            }
        } catch (Throwable unused2) {
            iIsAuth = 1;
        }
        if (iIsAuth == 1 && iIsAuth != 2) {
            throw b(TypedValues.MotionType.TYPE_QUANTIZE_INTERPOLATOR_ID, (Throwable) null);
        }
    }

    private boolean g() {
        try {
            ReflectHelper.importClass("com.mob.mobverify.MobVerify");
            SMSLog.getInstance().d("has mobverify component", new Object[0]);
            return true;
        } catch (Throwable unused) {
            SMSLog.getInstance().d("no mobverify component", new Object[0]);
            return false;
        }
    }

    private void h() throws JSONException, Resources.NotFoundException {
        a(6, 0, b(613, (Throwable) null));
    }

    private void i() throws JSONException, Resources.NotFoundException {
        c();
    }

    private void j() throws JSONException, Resources.NotFoundException {
        a(7, 0, b(613, (Throwable) null));
    }

    private void k() throws JSONException, Resources.NotFoundException {
        int i2;
        try {
            th = l();
            i2 = -1;
        } catch (Throwable th) {
            th = th;
            i2 = 0;
        }
        a(1, i2, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList<HashMap<String, Object>> l() throws Throwable {
        if (this.g == null || this.b.c()) {
            this.g = this.b.a();
        }
        ArrayList<HashMap<String, Object>> arrayList = this.g;
        if (arrayList != null) {
            Iterator<HashMap<String, Object>> it = arrayList.iterator();
            while (it.hasNext()) {
                HashMap<String, Object> next = it.next();
                String str = (String) next.get("zone");
                String str2 = (String) next.get("rule");
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    if (this.f == null) {
                        this.f = new HashMap<>();
                    }
                    this.f.put(str, str2);
                }
            }
        } else {
            SMSLog.getInstance().w(SMSLog.FORMAT, "SMSSDKCore", "saveCountryRules", "WARNING: Get 'countryData' from server error!");
            this.g = new ArrayList<>();
        }
        return this.g;
    }

    public void e() {
        new Thread(new f(this)).start();
    }

    public void b() {
        new Thread(new c()).start();
    }

    public void c() throws JSONException, Resources.NotFoundException {
        if (g()) {
            MobVerifyWrapper.a(new d());
        } else {
            a(9, 0, b(617, (Throwable) null));
        }
    }

    public void d() {
        synchronized (this.a) {
            Iterator<EventHandler> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onUnregister();
            }
            this.a.clear();
        }
    }

    private void e(Object obj) {
        a(3, new j(obj), new k());
    }

    public void b(EventHandler eventHandler) {
        synchronized (this.a) {
            if (eventHandler != null) {
                if (this.a.contains(eventHandler)) {
                    eventHandler.onUnregister();
                    this.a.remove(eventHandler);
                }
            }
        }
    }

    private void c(Object obj) {
        a(8, new a(obj), new b());
    }

    public void a(String str, TokenVerifyResult tokenVerifyResult) {
        new LoginCore().a(str, tokenVerifyResult, new e());
    }

    public void a(EventHandler eventHandler) {
        synchronized (this.a) {
            if (eventHandler != null) {
                if (!this.a.contains(eventHandler)) {
                    this.a.add(eventHandler);
                    eventHandler.onRegister();
                }
            }
        }
    }

    private void d(Object obj) throws JSONException, Resources.NotFoundException {
        a(5, 0, b(613, (Throwable) null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i2, Object obj) throws JSONException, Resources.NotFoundException {
        cn.smssdk.logger.d.d().b(i2);
        switch (i2) {
            case 1:
                k();
                break;
            case 2:
                b(obj);
                break;
            case 3:
                e(obj);
                break;
            case 4:
                a(obj);
                break;
            case 5:
                d(obj);
                break;
            case 6:
                h();
                break;
            case 7:
                j();
                break;
            case 8:
                c(obj);
                break;
            case 9:
                i();
                break;
        }
    }

    public void a(int i2, Object obj) {
        new g(i2, obj).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v33, types: [com.mob.MobCommunicator$NetworkError, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v34, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v35, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARN: Type inference failed for: r0v47 */
    /* JADX WARN: Type inference failed for: r0v48 */
    /* JADX WARN: Type inference failed for: r0v49 */
    /* JADX WARN: Type inference failed for: r0v50 */
    /* JADX WARN: Type inference failed for: r0v51 */
    /* JADX WARN: Type inference failed for: r0v52 */
    public void a(int i2, int i3, Object obj) throws JSONException, Resources.NotFoundException {
        ?? A;
        Object objA = obj;
        if (cn.smssdk.utils.a.c.booleanValue()) {
            if (i3 == -1) {
                SMSLog.getInstance().d(SMSLog.FORMAT, "SMSSDKCore", "throwResult", "afterEvent. event: " + cn.smssdk.utils.c.a(i2) + ", result: " + cn.smssdk.utils.c.b(i3));
            } else {
                SMSLog.getInstance().e(SMSLog.FORMAT, "SMSSDKCore", "throwResult", "afterEvent. event: " + cn.smssdk.utils.c.a(i2) + ", result: " + cn.smssdk.utils.c.b(i3));
            }
        }
        if (objA != null && (objA instanceof Throwable)) {
            if (objA instanceof TokenVerifyException) {
                TokenVerifyException tokenVerifyException = (TokenVerifyException) objA;
                int code = tokenVerifyException.getCode();
                String message = tokenVerifyException.getMessage();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(NotificationCompat.CATEGORY_STATUS, code);
                    jSONObject.put("detail", message);
                    objA = new Throwable(jSONObject.toString(), tokenVerifyException);
                } catch (JSONException e2) {
                    SMSLog.getInstance().w(e2);
                }
            } else {
                if (objA instanceof MobCommunicator.NetworkError) {
                    A = (MobCommunicator.NetworkError) objA;
                    String message2 = A.getMessage();
                    if (!TextUtils.isEmpty(message2)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(message2);
                            String strOptString = jSONObject2.optString(com.umeng.analytics.pro.d.O);
                            int iOptInt = jSONObject2.optInt(NotificationCompat.CATEGORY_STATUS);
                            if (jSONObject2.optInt("httpStatus") != 200) {
                                if (ResHelper.getStringRes(MobSDK.getContext(), "smssdk_error_desc_" + iOptInt) > 0) {
                                    A = b(iOptInt, (Throwable) A);
                                } else {
                                    A = a(619, strOptString, (Throwable) A);
                                }
                            } else {
                                A = a(619, strOptString, (Throwable) A);
                            }
                        } catch (Throwable unused) {
                            A = a(619, message2, (Throwable) A);
                        }
                    }
                } else {
                    Throwable th = (Throwable) objA;
                    String message3 = th.getMessage();
                    if (!TextUtils.isEmpty(message3)) {
                        try {
                            JSONObject jSONObject3 = new JSONObject(message3);
                            SMSLog.getInstance().e(SMSLog.FORMAT, "SMSSDKCore", "throwResult", "Throwable message: " + jSONObject3);
                            int iOptInt2 = jSONObject3.optInt(NotificationCompat.CATEGORY_STATUS);
                            String strOptString2 = jSONObject3.optString("detail");
                            if (TextUtils.isEmpty(strOptString2) && ((iOptInt2 >= 400 && iOptInt2 <= 500) || iOptInt2 >= 600)) {
                                int stringRes = ResHelper.getStringRes(MobSDK.getContext(), "smssdk_error_desc_" + iOptInt2);
                                if (stringRes > 0) {
                                    strOptString2 = MobSDK.getContext().getResources().getString(stringRes);
                                    JSONObject jSONObject4 = new JSONObject();
                                    jSONObject4.put(NotificationCompat.CATEGORY_STATUS, iOptInt2);
                                    jSONObject4.put("detail", strOptString2);
                                    objA = new Throwable(jSONObject4.toString(), th);
                                }
                            }
                            if (TextUtils.isEmpty(strOptString2)) {
                                objA = a(615, message3, th);
                            }
                            A = objA;
                        } catch (Throwable th2) {
                            SMSLog.getInstance().d(th2, SMSLog.FORMAT_SIMPLE, new Object[0]);
                            if (th instanceof SocketTimeoutException) {
                                A = b(616, th);
                            } else {
                                A = a(615, message3, th);
                            }
                        }
                    } else if (th instanceof SocketTimeoutException) {
                        A = b(616, th);
                    } else {
                        A = b(619, th);
                    }
                    SMSLog.getInstance().w(th);
                }
                objA = A;
            }
        }
        SMSLog.getInstance().d(SMSLog.FORMAT, "SMSSDKCore", "throwResult", "Data put into afterEvent: " + objA);
        cn.smssdk.logger.d.d().a(i2, objA);
        synchronized (this.a) {
            Iterator<EventHandler> it = this.a.iterator();
            while (it.hasNext()) {
                try {
                    it.next().afterEvent(i2, i3, objA);
                } catch (Throwable th3) {
                    SMSLog.getInstance().d(th3, SMSLog.FORMAT_SIMPLE, "Outer exception encountered");
                }
            }
        }
    }

    private void b(Object obj) {
        a(2, new h(obj), new i());
    }

    public String[] b(String str) {
        SMSLog.getInstance().d(SMSLog.FORMAT, "SMSSDKCore", "getCountryByMCC", "mcc: " + str);
        try {
            f();
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Iterator<Map.Entry<Character, ArrayList<String[]>>> it = a().entrySet().iterator();
            while (it.hasNext()) {
                ArrayList<String[]> value = it.next().getValue();
                int size = value == null ? 0 : value.size();
                for (int i2 = 0; i2 < size; i2++) {
                    String[] strArr = value.get(i2);
                    if (strArr.length < 4) {
                        SMSLog.getInstance().d("MCC not found in the country: " + strArr[0], new Object[0]);
                    } else {
                        String str2 = strArr[3];
                        if (str2.indexOf("|") < 0) {
                            if (str2.startsWith(str)) {
                                return strArr;
                            }
                        } else {
                            for (String str3 : str2.split("\\|")) {
                                if (str3.startsWith(str)) {
                                    return strArr;
                                }
                            }
                        }
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            SMSLog.getInstance().e(th, SMSLog.FORMAT, "SMSSDKCore", "getGroupedCountryList", "Can not do work currently!");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Throwable b(int i2, Throwable th) throws Resources.NotFoundException {
        String string = MobSDK.getContext().getResources().getString(ResHelper.getStringRes(MobSDK.getContext(), "smssdk_error_desc_" + i2));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_STATUS, i2);
            jSONObject.put("detail", string);
        } catch (Throwable unused) {
        }
        return new Throwable(jSONObject.toString(), th);
    }

    private void a(Object obj) throws JSONException, Resources.NotFoundException {
        a(4, 0, b(613, (Throwable) null));
    }

    public HashMap<Character, ArrayList<String[]>> a() throws Resources.NotFoundException {
        ArrayList<String[]> arrayList;
        try {
            f();
            String appLanguage = DH.SyncMtd.getAppLanguage();
            SMSLog.getInstance().d("appLanguage:" + appLanguage, new Object[0]);
            if (appLanguage != null && !appLanguage.equals(this.d)) {
                this.d = appLanguage;
                this.f17617e = null;
            }
            HashMap<Character, ArrayList<String[]>> map = this.f17617e;
            if (map != null && map.size() > 0) {
                return this.f17617e;
            }
            LinkedHashMap linkedHashMap = null;
            for (char c2 = 'A'; c2 <= 'Z'; c2 = (char) (c2 + 1)) {
                int stringArrayRes = ResHelper.getStringArrayRes(MobSDK.getContext(), "smssdk_country_group_" + Character.toLowerCase(c2));
                if (stringArrayRes > 0) {
                    String[] stringArray = MobSDK.getContext().getResources().getStringArray(stringArrayRes);
                    if (stringArray != null) {
                        arrayList = null;
                        for (String str : stringArray) {
                            String[] strArrSplit = str.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                            if (arrayList == null) {
                                arrayList = new ArrayList<>();
                            }
                            arrayList.add(strArrSplit);
                        }
                    } else {
                        arrayList = null;
                    }
                    if (arrayList != null) {
                        if (linkedHashMap == null) {
                            linkedHashMap = new LinkedHashMap();
                        }
                        linkedHashMap.put(Character.valueOf(c2), arrayList);
                    }
                }
            }
            if (linkedHashMap == null) {
                this.f17617e = cn.smssdk.utils.a.a();
            } else {
                this.f17617e = linkedHashMap;
            }
            return this.f17617e;
        } catch (Throwable th) {
            SMSLog.getInstance().e(th, SMSLog.FORMAT, "SMSSDKCore", "getGroupedCountryList", "Can not do work currently!");
            return new HashMap<>();
        }
    }

    public String[] a(String str) {
        try {
            f();
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            Iterator<Map.Entry<Character, ArrayList<String[]>>> it = a().entrySet().iterator();
            while (it.hasNext()) {
                ArrayList<String[]> value = it.next().getValue();
                int size = value == null ? 0 : value.size();
                for (int i2 = 0; i2 < size; i2++) {
                    String[] strArr = value.get(i2);
                    if (strArr != null && strArr.length > 2 && str.equals(strArr[2])) {
                        return strArr;
                    }
                }
            }
            return null;
        } catch (Throwable th) {
            SMSLog.getInstance().e(th, SMSLog.FORMAT, "SMSSDKCore", "getGroupedCountryList", "Can not do work currently!");
            return null;
        }
    }

    public void a(SmsMessage smsMessage, SMSSDK.VerifyCodeReadListener verifyCodeReadListener) {
        try {
            f();
            this.c.a(verifyCodeReadListener);
            this.c.a(smsMessage);
        } catch (Throwable th) {
            SMSLog.getInstance().e(th, SMSLog.FORMAT, "SMSSDKCore", "getGroupedCountryList", "Can not do work currently!");
            if (verifyCodeReadListener != null) {
                verifyCodeReadListener.onReadVerifyCode(null);
            }
        }
    }

    public void a(Activity activity, OnDialogListener onDialogListener) {
        new cn.smssdk.ui.a(activity, onDialogListener).show();
    }

    private static Throwable a(int i2, String str, Throwable th) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(NotificationCompat.CATEGORY_STATUS, i2);
            jSONObject.put("detail", str);
        } catch (Throwable unused) {
        }
        return new Throwable(jSONObject.toString(), th);
    }

    private void a(final int i2, Runnable runnable, Runnable runnable2) {
        if (!cn.smssdk.utils.b.c().b() || cn.smssdk.utils.b.c().a()) {
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        SMSLog.getInstance().d(SMSLog.FORMAT, "SMSSDKCore", "showDialog", "AlertPage.isShow(): " + AlertPage.isShow());
        String string = SmsResHelper.getString(ResHelper.getStringRes(MobSDK.getContext(), "smssdk_authorize_msg_sms"));
        if (AlertPage.isShow()) {
            AlertPage.setMsg(string);
            AlertPage.setActions(runnable, runnable2);
        } else {
            AlertPage alertPage = new AlertPage();
            AlertPage.setMsg(string);
            AlertPage.setActions(runnable, runnable2);
            alertPage.showForResult(MobSDK.getContext(), null, new FakeActivity() { // from class: cn.smssdk.SMSSDKCore.12

                /* renamed from: cn.smssdk.SMSSDKCore$12$a */
                public class a implements Runnable {
                    public final /* synthetic */ HashMap a;

                    public a(HashMap map) {
                        this.a = map;
                    }

                    @Override // java.lang.Runnable
                    public void run() throws JSONException, Resources.NotFoundException {
                        try {
                            if (!"true".equals(String.valueOf(this.a.get("res")))) {
                                SMSLog.getInstance().d(SMSLog.FORMAT, "SMSSDKCore", "showDialog", "AlertPage: FALSE clicked");
                                Iterator it = ((ArrayList) this.a.get("cancelActions")).iterator();
                                while (it.hasNext()) {
                                    Runnable runnable = (Runnable) it.next();
                                    if (runnable != null) {
                                        runnable.run();
                                    }
                                }
                                return;
                            }
                            SMSLog.getInstance().d(SMSLog.FORMAT, "SMSSDKCore", "showDialog", "AlertPage: TRUE clicked");
                            cn.smssdk.utils.b.c().a(true);
                            Iterator it2 = ((ArrayList) this.a.get("okActions")).iterator();
                            while (it2.hasNext()) {
                                Runnable runnable2 = (Runnable) it2.next();
                                if (runnable2 != null) {
                                    runnable2.run();
                                }
                            }
                        } catch (Throwable th) {
                            SMSLog.getInstance().d(th);
                            AnonymousClass12 anonymousClass12 = AnonymousClass12.this;
                            SMSSDKCore.this.a(i2, 0, th);
                        }
                    }
                }

                @Override // com.mob.tools.FakeActivity
                public void onResult(HashMap<String, Object> map) {
                    new Thread(new a(map)).start();
                }
            });
        }
    }
}
