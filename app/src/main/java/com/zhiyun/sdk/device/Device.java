package com.zhiyun.sdk.device;

import com.zhiyun.sdk.callbaks.AngleCallback;
import com.zhiyun.sdk.callbaks.Callback;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public abstract class Device {
    public static final int CONNECTING = 1;
    public static final int KEY_EVENT_CLICKED = 2819;
    public static final int KEY_EVENT_DOUBLE_CLICKED = 2822;
    public static final int KEY_EVENT_PRESSED = 2817;
    public static final int KEY_EVENT_PRESS_1S = 2820;
    public static final int KEY_EVENT_PRESS_3S = 2821;
    public static final int KEY_EVENT_RELEASED = 2818;
    public static final int KEY_EVENT_TRIPLE_CLICKED = 2823;
    public static final int KEY_TYPE_CCW = 2570;
    public static final int KEY_TYPE_CW = 2569;
    public static final int KEY_TYPE_DISP = 2573;
    public static final int KEY_TYPE_DOWN = 2562;
    public static final int KEY_TYPE_FLASH = 2574;
    public static final int KEY_TYPE_FN = 2571;
    public static final int KEY_TYPE_FOCUS_CCW = 2582;
    public static final int KEY_TYPE_FOCUS_CW = 2581;
    public static final int KEY_TYPE_LEFT = 2564;
    public static final int KEY_TYPE_MENU = 2572;
    public static final int KEY_TYPE_MODE = 2563;
    public static final int KEY_TYPE_PHOTOS = 2566;
    public static final int KEY_TYPE_RECORD = 2576;
    public static final int KEY_TYPE_RIGHT = 2565;
    public static final int KEY_TYPE_SIDE_CCW = 2578;
    public static final int KEY_TYPE_SIDE_CW = 2577;
    public static final int KEY_TYPE_SWITCH = 2575;
    public static final int KEY_TYPE_T = 2567;
    public static final int KEY_TYPE_UP = 2561;
    public static final int KEY_TYPE_W = 2568;
    public static final int KEY_TYPE_ZOOM_CCW = 2580;
    public static final int KEY_TYPE_ZOOM_CW = 2579;
    public static final int NO_CONNECTION = 0;
    public static final int TO_BE_CONNECTED = 2;
    public static final int TO_BE_MISSED = 3;
    private StatusListener a;
    private KeyListener b;
    private FuncListener c;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DeviceStatus {
    }

    public interface FuncListener {
        void onFuncEvent(int i, int i2);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface KeyEvent {
    }

    public interface KeyListener {
        void onKeyEvent(int i, int i2, int i3);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface KeyType {
    }

    public interface StateListener {
        void onState();
    }

    public interface StatusListener {
        void onStateChanged(int i);
    }

    public void a(int i) {
        StatusListener statusListener = this.a;
        if (statusListener != null) {
            statusListener.onStateChanged(i);
        }
    }

    public abstract void cancelMove();

    public abstract void connect();

    public abstract void disconnect();

    public abstract void getAngle(AngleCallback angleCallback);

    public abstract String getIdentifier();

    public abstract String getModelName();

    public abstract int getRSSI();

    public abstract boolean isConnected();

    public abstract boolean isMoving();

    public abstract String marketingName();

    public abstract void moveTo(float f, float f2, float f3, int i, Callback<Boolean> callback);

    public abstract boolean send(byte[] bArr);

    public abstract void setCameraMode();

    public void setFuncListener(FuncListener funcListener) {
        this.c = funcListener;
    }

    public void setKeyListener(KeyListener keyListener) {
        this.b = keyListener;
    }

    public abstract void setPhoneMode();

    public void setStateListener(StatusListener statusListener) {
        this.a = statusListener;
    }

    public void a(int i, int i2, int i3) {
        KeyListener keyListener = this.b;
        if (keyListener != null) {
            keyListener.onKeyEvent(i, i2, i3);
        }
    }

    public void a(int i, int i2) {
        FuncListener funcListener = this.c;
        if (funcListener != null) {
            funcListener.onFuncEvent(i, i2);
        }
    }
}
