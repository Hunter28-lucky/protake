package com.blink.academy.film.support.socket;

import com.blink.academy.film.FilmApp;
import com.blink.academy.film.stream.ACMonitorInfoBean;
import com.blink.academy.film.stream.LinkManager;
import com.blink.academy.protake.R;
import defpackage.r1;

/* loaded from: classes.dex */
public class TransmitHelper {
    public static final int CAMERA_UNIT_A = 1;
    public static final String CAMERA_UNIT_A_CONTENT = "A";
    public static final int CAMERA_UNIT_B = 2;
    public static final String CAMERA_UNIT_B_CONTENT = "B";
    public static final int CAMERA_UNIT_C = 3;
    public static final int CAMERA_UNIT_CLOSE = 5;
    public static final String CAMERA_UNIT_C_CONTENT = "C";
    public static final int CAMERA_UNIT_D = 4;
    public static final String CAMERA_UNIT_D_CONTENT = "D";
    public static final int CAMERA_UNIT_NULL = 6;
    public static final int DEVICE_DRAWABLE_HIGH = 2131230860;
    public static final int DEVICE_DRAWABLE_LOW = 2131230860;
    public static final int DEVICE_DRAWABLE_MIDDLE = 2131230860;
    public static final int EQUIPMENT_CAMERA = 1;
    public static final int EQUIPMENT_MONITOR = 2;
    public static final int JOB_CAMERA = 2;
    public static final int JOB_CUSTOMER = 3;
    public static final int JOB_DIRECTOR = 1;
    public static final int JOB_OTHER = 4;
    public static final int MONITOR_CONNECTION_BANNED = 3;
    public static final int MONITOR_CONNECTION_CHOOSE_ONE = 5;
    public static final int MONITOR_CONNECTION_CONNECTING = 4;
    public static final int MONITOR_CONNECTION_FORBIDDEN = 8;
    public static final int MONITOR_CONNECTION_FULL = 1;
    public static final int MONITOR_CONNECTION_LOW_VERSION = 7;
    public static final int MONITOR_CONNECTION_NO_CAMERA = 6;
    public static final int MONITOR_CONNECTION_NO_SIGNAL = 2;
    public static final int MONITOR_CONNECTION_PAYMENT_REQURE = 9;
    public static final int MONITOR_PLAYER_FLAG_GOOD = 100;
    public static final int MONITOR_PLAYER_FLAG_KEEP = 101;
    public static final int MONITOR_PLAYER_FLAG_NG = 102;
    public static final int MONITOR_PLAYER_FLAG_NONE = 99;
    public static final int MONITOR_PLAY_BTN_ALL_DISABLE = 3;
    public static final int MONITOR_PLAY_BTN_ALL_ENABLE = 0;
    public static final int MONITOR_PLAY_BTN_UN_NEXT = 1;
    public static final int MONITOR_PLAY_BTN_UN_PRE = 2;
    public static final int MONITOR_PLAY_CONTROL_FORWARD = 1;
    public static final int MONITOR_PLAY_CONTROL_NEXT = 2;
    public static final int MONITOR_PLAY_CONTROL_PRE = -2;
    public static final int MONITOR_PLAY_CONTROL_REWIND = -1;
    public static final int MONITOR_RECORD_STATE_DISABLE = 0;
    public static final int MONITOR_RECORD_STATE_ENABLE = 1;
    public static final int MONITOR_RECORD_STATE_ENABLE_MASK = 16;
    public static final int MONITOR_RECORD_STATE_RECORDING = 1;
    public static final int MONITOR_RECORD_STATE_RECORDING_MASK = 1;
    public static final int MONITOR_RECORD_STATE_UN_RECORDING = 0;
    public static final int QUALITY_HIGH = 2;
    public static final int QUALITY_LATENCY = 3;
    public static final int QUALITY_QUICK = 1;
    public static final int SELECT_ANIMATE_TIME = 100;
    public static final int TRANSMIT_CONNECTING = 3;
    public static final int TRANSMIT_PLAYER = 1;
    public static final int TRANSMIT_RECORD = 0;
    public static final int TRANSMIT_UN_CONNECTED = 2;
    public static final int TYPE_DOUBLE = 2;
    public static final int TYPE_QUADRUPLE = 3;
    public static final int TYPE_SINGLE = 1;
    public static final int WIFI_CENTER_CIRCLE = 1;
    public static final int WIFI_CENTER_TEXT = 3;
    public static final int WIFI_CENTER_TRIANGLE = 2;
    public static final int WIFI_COLOR_DISABLE = 2131099697;
    public static final int WIFI_COLOR_HIGH = 2131099715;
    public static final int WIFI_COLOR_LOW = 2131099713;
    public static final int WIFI_COLOR_MIDDLE = 2131099716;
    public static final int WIFI_COLOR_NORMAL = 2131099717;
    public static final int WIFI_DRAWABLE_DISABLE = 2131230860;
    public static final int WIFI_DRAWABLE_HIGH = 2131230860;
    public static final int WIFI_DRAWABLE_LOW = 2131230860;
    public static final int WIFI_DRAWABLE_MIDDLE = 2131230860;
    public static final int WIFI_STATE_DISABLE = 4;
    public static final int WIFI_STATE_HIGH = 1;
    public static final int WIFI_STATE_LOW = 3;
    public static final int WIFI_STATE_MIDDLE = 2;
    public static final int WIFI_STATE_NORMAL = 5;
    private static boolean hasCheckBluetoothPermission;
    private static boolean hasCheckLocationPermission;
    private static TransmitHelper helper;
    private int connectionUnitType;
    private boolean isStartCameraTransmit;
    private boolean isStartMonitor;
    private int wifiStatus;
    private String connectionUnit = "";
    private int connectionNum = 0;

    private void TransmitHelper() {
    }

    public static int buildMonitorState(int i, int i2) {
        return (i << 4) | i2;
    }

    public static TransmitHelper getInstance() {
        if (helper == null) {
            helper = new TransmitHelper();
        }
        return helper;
    }

    private static String getJobString(ACMonitorInfoBean aCMonitorInfoBean) {
        String job = aCMonitorInfoBean.getJob();
        job.hashCode();
        switch (job) {
            case "0":
                return FilmApp.m402().getResources().getString(R.string.MONITOR_SETTINGS_VALUE_JOB_DIRECTOR);
            case "1":
                return FilmApp.m402().getResources().getString(R.string.MONITOR_SETTINGS_VALUE_JOB_DP);
            case "2":
                return FilmApp.m402().getResources().getString(R.string.MONITOR_SETTINGS_VALUE_JOB_CLIENT);
            case "3":
                return FilmApp.m402().getResources().getString(R.string.MONITOR_SETTINGS_VALUE_JOB_OTHERS);
            default:
                return "";
        }
    }

    public static String getMessage(ACMonitorInfoBean aCMonitorInfoBean) {
        StringBuilder sb = new StringBuilder();
        if (r1.m8143(aCMonitorInfoBean.getSuffix())) {
            sb.append(aCMonitorInfoBean.getSuffix());
        }
        if (r1.m8143(aCMonitorInfoBean.getJob())) {
            String jobString = getJobString(aCMonitorInfoBean);
            sb.append(" (");
            sb.append(jobString);
            sb.append(")");
        }
        return sb.toString();
    }

    public static int getMonitorEnableState(int i) {
        return (i & 16) >> 4;
    }

    public static int getMonitorRecordState(int i) {
        return i & 1;
    }

    public static String getShowHintMessage(ACMonitorInfoBean aCMonitorInfoBean) {
        StringBuilder sb = new StringBuilder();
        if (r1.m8143(aCMonitorInfoBean.getSuffix())) {
            sb.append(aCMonitorInfoBean.getSuffix());
        }
        if (r1.m8143(aCMonitorInfoBean.getJob())) {
            String jobString = getJobString(aCMonitorInfoBean);
            sb.append("（");
            sb.append(jobString);
            sb.append("）");
        }
        return sb.toString();
    }

    public static int getSignalColor(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? R.color.colorWhite : R.color.color30White : R.color.colorTransmitButton : R.color.colorTransmitYellow : R.color.colorTransmitGreen;
    }

    public static boolean hasCheckBluetoothPermission() {
        return hasCheckBluetoothPermission;
    }

    public static boolean hasCheckLocationPermission() {
        return hasCheckLocationPermission;
    }

    public static void setHasCheckBluetoothPermission(boolean z) {
        hasCheckBluetoothPermission = z;
    }

    public static void setHasCheckLocationPermission(boolean z) {
        hasCheckLocationPermission = z;
    }

    public void connectionUnit(String str) {
        this.connectionUnit = str;
    }

    public int getConnectionNum() {
        return this.connectionNum;
    }

    public int getConnectionUnitType() {
        return this.connectionUnitType;
    }

    public int getHasConnectionNum() {
        return Math.min(LinkManager.getInstance().getClientListSize(), 4);
    }

    public String getSelectUnitString(int i) {
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "" : CAMERA_UNIT_D_CONTENT : CAMERA_UNIT_C_CONTENT : CAMERA_UNIT_B_CONTENT : "A";
    }

    public int getWifiStatus() {
        return this.wifiStatus;
    }

    public boolean isStartCameraTransmit() {
        return this.isStartCameraTransmit;
    }

    public boolean isStartMonitor() {
        return this.isStartMonitor;
    }

    public void setConnectionNum(int i) {
        this.connectionNum = i;
    }

    public void setConnectionUnit(String str) {
        this.connectionUnit = str;
    }

    public void setConnectionUnitType(int i) {
        this.connectionUnitType = i;
    }

    public void setStartCameraTransmit(boolean z) {
        this.isStartCameraTransmit = z;
    }

    public void setStartMonitor(boolean z) {
        this.isStartMonitor = z;
    }

    public void setWifiStatus(int i) {
        this.wifiStatus = i;
    }
}
