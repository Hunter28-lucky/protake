package defpackage;

import android.bluetooth.BluetoothAdapter;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.os.Build;
import android.util.SparseArray;
import androidx.core.content.ContextCompat;
import com.blink.academy.film.FilmApp;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: AudioHeadSetStateManager.java */
/* renamed from: ྉ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5075 {

    /* renamed from: ԭ, reason: contains not printable characters */
    public static boolean f16857 = false;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final String f16858 = "ྉ";

    /* renamed from: ԯ, reason: contains not printable characters */
    public static C5075 f16859;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public AudioDeviceInfo f16861 = null;

    /* renamed from: ԩ, reason: contains not printable characters */
    public AudioDeviceInfo f16862 = null;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public boolean f16863 = false;

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean f16864 = false;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean f16865 = false;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public SparseArray<AudioDeviceInfo> f16860 = new SparseArray<>();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m14898(int i) {
        switch (i) {
            case 0:
                return "unknown";
            case 1:
                return "builtin earpiece";
            case 2:
                return "builtin speaker";
            case 3:
                return "wired headset";
            case 4:
                return "wired headphones";
            case 5:
                return "line analog";
            case 6:
                return "line digital";
            case 7:
                return "bluetooth sco";
            case 8:
                return "bluetooth A2DP";
            case 9:
                return "HDMI";
            case 10:
            default:
                return String.valueOf(i);
            case 11:
                return "usb device";
            case 12:
                return "usb accessory";
            case 13:
                return "dock";
            case 14:
                return "fm";
            case 15:
                return "builtin mic";
            case 16:
                return "fm tuner";
            case 17:
                return "tv tuner";
            case 18:
                return "telephony";
            case 19:
                return "aux line";
            case 20:
                return "ip";
            case 21:
                return "bus";
            case 22:
                return "usb headset";
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static C5075 m14899() {
        if (f16859 == null) {
            synchronized (C5075.class) {
                if (f16859 == null) {
                    f16859 = new C5075();
                }
            }
        }
        return f16859;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static boolean m14900() {
        try {
            if (Build.VERSION.SDK_INT < 31 || ContextCompat.checkSelfPermission(FilmApp.m402(), "android.permission.BLUETOOTH_SCAN") == 0) {
                return BluetoothAdapter.getDefaultAdapter().getProfileConnectionState(1) != 0;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public SparseArray<AudioDeviceInfo> m14901() {
        return this.f16860;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean m14902() {
        return this.f16864;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public boolean m14903() {
        return this.f16863;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean m14904() throws JSONException {
        AudioManager audioManager = (AudioManager) FilmApp.m405().getSystemService("audio");
        this.f16861 = null;
        this.f16862 = null;
        AudioDeviceInfo[] devices = audioManager.getDevices(2);
        AudioDeviceInfo[] devices2 = audioManager.getDevices(1);
        AudioDeviceInfo[] devices3 = audioManager.getDevices(3);
        int length = devices != null ? devices.length : 0;
        int length2 = devices2 != null ? devices2.length : 0;
        JSONArray jSONArray = new JSONArray();
        if (devices3 != null) {
            for (AudioDeviceInfo audioDeviceInfo : devices3) {
                if (audioDeviceInfo.isSource()) {
                    if (audioDeviceInfo.getType() == 7) {
                        this.f16861 = audioDeviceInfo;
                    } else if (audioDeviceInfo.getType() == 3) {
                        this.f16862 = audioDeviceInfo;
                    } else if (audioDeviceInfo.getType() == 15) {
                        if (this.f16860.get(0) == null) {
                            this.f16860.put(0, audioDeviceInfo);
                        }
                    } else if (audioDeviceInfo.getType() == 11 && this.f16862 == null) {
                        this.f16862 = audioDeviceInfo;
                    }
                } else if (audioDeviceInfo.isSink()) {
                    if (audioDeviceInfo.getType() == 3) {
                        this.f16865 = true;
                    } else if (audioDeviceInfo.getType() == 7 && audioManager.isBluetoothA2dpOn() && m14900()) {
                        this.f16865 = true;
                    }
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("audio_device_name", audioDeviceInfo.getProductName().toString());
                    jSONObject.put("audio_device_id", audioDeviceInfo.getId());
                    jSONObject.put("audio_device_type", m14898(audioDeviceInfo.getType()));
                    jSONObject.put("audio_device_is_sink", audioDeviceInfo.isSink());
                    jSONObject.put("audio_device_is_source", audioDeviceInfo.isSource());
                    jSONObject.put("audio_device_channel_counts", Arrays.toString(audioDeviceInfo.getChannelCounts()));
                    jSONObject.put("audio_device_sample_rates", Arrays.toString(audioDeviceInfo.getSampleRates()));
                    jSONObject.put("audio_device_encodings", Arrays.toString(audioDeviceInfo.getEncodings()));
                    jSONArray.put(jSONObject);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
        if (f16857) {
            C4638.m14099(f16858, String.format("outLength : %s , intLength : %s  , jSONArray : %s ", Integer.valueOf(length), Integer.valueOf(length2), jSONArray));
        }
        return audioManager.isWiredHeadsetOn();
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m14905() throws JSONException {
        if (FilmApp.m405().m406()) {
            this.f16863 = false;
            this.f16864 = false;
            this.f16865 = false;
            long jNanoTime = System.nanoTime();
            boolean zM14900 = m14900();
            boolean zM14904 = m14904();
            if (zM14900) {
                this.f16864 = true;
                this.f16860.put(2, this.f16861);
            } else {
                this.f16864 = false;
                this.f16860.put(2, null);
            }
            if (zM14904 || this.f16862 != null) {
                this.f16863 = true;
                this.f16860.put(1, this.f16862);
            } else {
                this.f16863 = false;
                this.f16860.put(1, null);
            }
            long jNanoTime2 = System.nanoTime();
            if (f16857) {
                C4638.m14099(f16858, String.format("cost time : %s , blueToothHeadsetConnected : %s , wiredHeadsetOn : %s , mSparseArray : %s ", Long.valueOf((jNanoTime2 - jNanoTime) / 1000000), Boolean.valueOf(zM14900), Boolean.valueOf(zM14904), this.f16860));
            }
        }
    }
}
