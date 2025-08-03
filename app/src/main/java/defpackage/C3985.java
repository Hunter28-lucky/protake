package defpackage;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.preference.PreferenceManager;
import com.blink.academy.film.zxing.camera.FrontLightMode;
import com.umeng.analytics.pro.am;

/* compiled from: AmbientLightManager.java */
/* renamed from: ࢯ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C3985 implements SensorEventListener {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Context f13932;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public C4091 f13933;

    /* renamed from: ԭ, reason: contains not printable characters */
    public Sensor f13934;

    public C3985(Context context) {
        this.f13932 = context;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        C4091 c4091 = this.f13933;
        if (c4091 != null) {
            if (f <= 45.0f) {
                c4091.m13037(true);
            } else if (f >= 450.0f) {
                c4091.m13037(false);
            }
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m12847(C4091 c4091) {
        this.f13933 = c4091;
        if (FrontLightMode.readPref(PreferenceManager.getDefaultSharedPreferences(this.f13932)) == FrontLightMode.AUTO) {
            SensorManager sensorManager = (SensorManager) this.f13932.getSystemService(am.ac);
            Sensor defaultSensor = sensorManager.getDefaultSensor(5);
            this.f13934 = defaultSensor;
            if (defaultSensor != null) {
                sensorManager.registerListener(this, defaultSensor, 3);
            }
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m12848() {
        if (this.f13934 != null) {
            ((SensorManager) this.f13932.getSystemService(am.ac)).unregisterListener(this);
            this.f13933 = null;
            this.f13934 = null;
        }
    }
}
