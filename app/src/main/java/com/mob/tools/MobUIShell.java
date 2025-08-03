package com.mob.tools;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.mob.commons.o;
import com.mob.tools.utils.ReflectHelper;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: classes2.dex */
public class MobUIShell extends Activity {
    private static HashMap<String, FakeActivity> a = new HashMap<>();
    private FakeActivity b;

    static {
        MobLog.getInstance().d("===============================", new Object[0]);
        MobLog.getInstance().d("MobTools " + "2024-08-26".replace("-0", Constants.ACCEPT_TIME_SEPARATOR_SERVER).replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "."), new Object[0]);
        MobLog.getInstance().d("===============================", new Object[0]);
    }

    public static String a(Object obj) {
        return a(String.valueOf(System.currentTimeMillis()), obj);
    }

    private boolean b() {
        if (this.b == null) {
            Intent intent = getIntent();
            Uri data = intent.getData();
            if (data != null && o.a("005l*ecfcdcde").equals(data.getScheme())) {
                FakeActivity fakeActivityA = a(data.getHost());
                this.b = fakeActivityA;
                if (fakeActivityA != null) {
                    MobLog.getInstance().i("MobUIShell found executor: " + this.b.getClass());
                    this.b.setActivity(this);
                    return true;
                }
            }
            try {
                String stringExtra = intent.getStringExtra(o.a("011=eddfdcdkdg-c.ddXd0de9li"));
                String stringExtra2 = intent.getStringExtra(o.a("013iPdl>i8dgdcCdNecdhdddkdf9li"));
                FakeActivity fakeActivityRemove = a.remove(stringExtra);
                this.b = fakeActivityRemove;
                if (fakeActivityRemove == null) {
                    FakeActivity fakeActivityRemove2 = a.remove(intent.getScheme());
                    this.b = fakeActivityRemove2;
                    if (fakeActivityRemove2 == null) {
                        FakeActivity fakeActivityA2 = a();
                        this.b = fakeActivityA2;
                        if (fakeActivityA2 == null) {
                            MobLog.getInstance().w(new RuntimeException("Executor lost! launchTime = " + stringExtra + ", executorName: " + stringExtra2));
                            return false;
                        }
                    }
                }
                MobLog.getInstance().i("MobUIShell found executor: " + this.b.getClass());
                this.b.setActivity(this);
            } catch (Throwable th) {
                MobLog.getInstance().w(th);
                return false;
            }
        }
        return true;
    }

    private boolean c() throws NoSuchFieldException, SecurityException {
        if (Build.VERSION.SDK_INT > 27) {
            return false;
        }
        try {
            Field declaredField = Activity.class.getDeclaredField(o.a("013l9ejdg]d<deKjEde?dVdiegdkfhec"));
            declaredField.setAccessible(true);
            ((ActivityInfo) declaredField.get(this)).screenOrientation = -1;
            declaredField.setAccessible(false);
            return true;
        } catch (Exception e2) {
            MobLog.getInstance().w(e2, "Fix orientation for 8.0 encountered exception", new Object[0]);
            return false;
        }
    }

    private boolean d() throws NoSuchMethodException, SecurityException {
        Exception e2;
        boolean zBooleanValue;
        if (Build.VERSION.SDK_INT > 27) {
            return false;
        }
        try {
            TypedArray typedArrayObtainStyledAttributes = this.b.activity.obtainStyledAttributes((int[]) Class.forName("com.android.internal.R$styleable").getField("Window").get(null));
            Method method = ActivityInfo.class.getMethod(o.a("0231defgeidhdfdkfgeddcdg_i]dk.d3fldhfkedecdfHd$dedkff"), TypedArray.class);
            method.setAccessible(true);
            zBooleanValue = ((Boolean) method.invoke(null, typedArrayObtainStyledAttributes)).booleanValue();
            try {
                method.setAccessible(false);
            } catch (Exception e3) {
                e2 = e3;
                MobLog.getInstance().w(e2);
                return zBooleanValue;
            }
        } catch (Exception e4) {
            e2 = e4;
            zBooleanValue = false;
        }
        return zBooleanValue;
    }

    @Override // android.app.Activity
    public void finish() {
        FakeActivity fakeActivity = this.b;
        if (fakeActivity == null || !fakeActivity.onFinish()) {
            super.finish();
        }
    }

    @Override // android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        FakeActivity fakeActivity = this.b;
        if (fakeActivity != null) {
            fakeActivity.onActivityResult(i, i2, intent);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        FakeActivity fakeActivity = this.b;
        if (fakeActivity != null) {
            fakeActivity.onConfigurationChanged(configuration);
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) throws NoSuchFieldException, SecurityException {
        if (!b()) {
            super.onCreate(bundle);
            finish();
            return;
        }
        MobLog.getInstance().d(this.b.getClass().getSimpleName() + " onCreate", new Object[0]);
        if (Build.VERSION.SDK_INT == 26 && d()) {
            c();
        }
        this.b.activity.getWindow().addFlags(Integer.MIN_VALUE);
        this.b.activity.getWindow().setStatusBarColor(0);
        super.onCreate(bundle);
        this.b.onCreate();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean zOnCreateOptionsMenu = super.onCreateOptionsMenu(menu);
        FakeActivity fakeActivity = this.b;
        return fakeActivity != null ? fakeActivity.onCreateOptionsMenu(menu) : zOnCreateOptionsMenu;
    }

    @Override // android.app.Activity
    public void onDestroy() {
        FakeActivity fakeActivity = this.b;
        if (fakeActivity != null) {
            fakeActivity.sendResult();
            MobLog.getInstance().d(this.b.getClass().getSimpleName() + " onDestroy", new Object[0]);
            this.b.onDestroy();
        }
        super.onDestroy();
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        try {
            FakeActivity fakeActivity = this.b;
            if (fakeActivity != null ? fakeActivity.onKeyEvent(i, keyEvent) : false) {
                return true;
            }
            return super.onKeyDown(i, keyEvent);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return false;
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        try {
            FakeActivity fakeActivity = this.b;
            if (fakeActivity != null ? fakeActivity.onKeyEvent(i, keyEvent) : false) {
                return true;
            }
            return super.onKeyUp(i, keyEvent);
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return false;
        }
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        FakeActivity fakeActivity = this.b;
        if (fakeActivity == null) {
            super.onNewIntent(intent);
        } else {
            fakeActivity.onNewIntent(intent);
        }
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        boolean zOnOptionsItemSelected = super.onOptionsItemSelected(menuItem);
        FakeActivity fakeActivity = this.b;
        return fakeActivity != null ? fakeActivity.onOptionsItemSelected(menuItem) : zOnOptionsItemSelected;
    }

    @Override // android.app.Activity
    public void onPause() {
        if (this.b != null) {
            MobLog.getInstance().d(this.b.getClass().getSimpleName() + " onPause", new Object[0]);
            this.b.onPause();
        }
        super.onPause();
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        FakeActivity fakeActivity = this.b;
        if (fakeActivity != null) {
            fakeActivity.onRequestPermissionsResult(i, strArr, iArr);
        }
    }

    @Override // android.app.Activity
    public void onRestart() {
        if (this.b != null) {
            MobLog.getInstance().d(this.b.getClass().getSimpleName() + " onRestart", new Object[0]);
            this.b.onRestart();
        }
        super.onRestart();
    }

    @Override // android.app.Activity
    public void onResume() {
        if (this.b != null) {
            MobLog.getInstance().d(this.b.getClass().getSimpleName() + " onResume", new Object[0]);
            this.b.onResume();
        }
        super.onResume();
    }

    @Override // android.app.Activity
    public void onStart() {
        if (this.b != null) {
            MobLog.getInstance().d(this.b.getClass().getSimpleName() + " onStart", new Object[0]);
            this.b.onStart();
        }
        super.onStart();
    }

    @Override // android.app.Activity
    public void onStop() {
        if (this.b != null) {
            MobLog.getInstance().d(this.b.getClass().getSimpleName() + " onStop", new Object[0]);
            this.b.onStop();
        }
        super.onStop();
    }

    @Override // android.app.Activity
    public void setContentView(int i) {
        setContentView(LayoutInflater.from(this).inflate(i, (ViewGroup) null));
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        if (Build.VERSION.SDK_INT == 26 && d()) {
            return;
        }
        super.setRequestedOrientation(i);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        if (b()) {
            StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
            int i2 = 0;
            while (i2 < stackTrace.length) {
                if (stackTrace[i2].toString().startsWith(o.a("0300hfdfQjYdfeleddfdkffelei2cPdhGi0df6h(elffMid,ehPdYdfdgdjeidhdfdgYi")) && (i2 = i2 + 2) < stackTrace.length) {
                    int iOnSetTheme = this.b.onSetTheme(i, stackTrace[i2].toString().startsWith(o.a("048'dfdkThJdhecde=h,eldf*eeWelejdgDd de%j:de=dXdiei?c2dh@i9dfYhVelJei1dhfhecdh.lXekdfdcdkdg'c^ejdg*dUde3jLde2d3di")));
                    if (iOnSetTheme > 0) {
                        super.setTheme(iOnSetTheme);
                        return;
                    }
                    return;
                }
                i2++;
            }
        }
        super.setTheme(i);
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i) {
        FakeActivity fakeActivity = this.b;
        if (fakeActivity != null) {
            fakeActivity.beforeStartActivityForResult(intent, i, null);
        }
        super.startActivityForResult(intent, i);
    }

    public static String a(String str, Object obj) {
        a.put(str, (FakeActivity) obj);
        return str;
    }

    @Override // android.app.Activity
    public void setContentView(View view) {
        if (view == null) {
            return;
        }
        super.setContentView(view);
        FakeActivity fakeActivity = this.b;
        if (fakeActivity != null) {
            fakeActivity.setContentView(view);
        }
    }

    private FakeActivity a(String str) {
        Object objNewInstance;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (str.startsWith(".")) {
                str = getPackageName() + str;
            }
            String strImportClass = ReflectHelper.importClass(str);
            if (TextUtils.isEmpty(strImportClass) || (objNewInstance = ReflectHelper.newInstance(strImportClass, new Object[0])) == null || !(objNewInstance instanceof FakeActivity)) {
                return null;
            }
            return (FakeActivity) objNewInstance;
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            return null;
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        FakeActivity fakeActivity = this.b;
        if (fakeActivity != null) {
            fakeActivity.beforeStartActivityForResult(intent, i, bundle);
        }
        super.startActivityForResult(intent, i, bundle);
    }

    @Override // android.app.Activity
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        if (view == null) {
            return;
        }
        if (layoutParams == null) {
            super.setContentView(view);
        } else {
            super.setContentView(view, layoutParams);
        }
        FakeActivity fakeActivity = this.b;
        if (fakeActivity != null) {
            fakeActivity.setContentView(view);
        }
    }

    public FakeActivity a() {
        String string;
        try {
            string = getPackageManager().getActivityInfo(getComponentName(), 128).metaData.getString(o.a("015hiMfhdfdcedLd*ejdgOdFde>jSdeUdJdi"));
        } catch (Throwable th) {
            MobLog.getInstance().w(th);
            string = null;
        }
        return a(string);
    }
}
