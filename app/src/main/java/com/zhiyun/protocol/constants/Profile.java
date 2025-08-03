package com.zhiyun.protocol.constants;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.zhiyun.protocol.utils.f;
import com.zhiyun.protocol.utils.g;
import java.io.File;
import java.lang.reflect.Type;
import java.util.Arrays;

/* loaded from: classes2.dex */
class Profile {
    public static final int LINK_BLE = 0;
    public static final int LINK_BLE_AUTO_SWITCH_WIFI = 4;
    public static final int LINK_BLE_SWITCH_WIFI = 1;
    public static final int LINK_BLE_TO_WIFI = 2;
    public static final int LINK_WIFI = 3;
    private static Gson gson;
    public int accessory;
    public int activate;

    @SerializedName("autotune")
    public int autoTune;
    public int battery;
    public int calibration;
    public int carry;
    public int ccs;
    public int digitalZoom;

    @SerializedName("forceversion")
    public float forceVersion;

    @SerializedName("ble_hid")
    public int hid;
    public int hvswitch;
    public int jsonData;
    public int links;
    public int motionControl;
    public int motorStrengthAdjustNotify;

    @SerializedName("moveline")
    public int moveLine;

    @SerializedName("bleMtu")
    public int mtu;
    public int oem;
    public int photo;

    @SerializedName("resetPosition")
    public int resetMethod;

    @SerializedName("usrscene")
    @JsonAdapter(SceneModeDeserializer.class)
    public SceneMode[] sceneModes;

    @SerializedName("storymode")
    public int storyMode;
    public int tracking;
    public int update;
    public int video;

    @SerializedName("wifichannel")
    public int wifiChannel;

    @SerializedName("keyredefine")
    @JsonAdapter(KeyRedefineDeserializer.class)
    public KeyRedefine[] keyRedefine = new KeyRedefine[0];

    @JsonAdapter(CameraManufacturersDeserializer.class)
    public CameraManufacturer[] cameraList = {CameraManufacturer.CLOSE, CameraManufacturer.CANON, CameraManufacturer.SONY, CameraManufacturer.PANASONIC};

    @JsonAdapter(MotorStrengthDeserializer.class)
    public Strength[] motorStrength = {Strength.LOW, Strength.MEDIUM, Strength.HIGH};

    @SerializedName("motorStrengthCustom")
    public int[][] motorStrengthCustom = {new int[]{0, 0}, new int[]{0, 0}, new int[]{0, 0}};

    @SerializedName("gimbalMode")
    @JsonAdapter(WorkingModeDeserializer.class)
    public WorkingMode[] workingModes = {WorkingMode.PF, WorkingMode.L, WorkingMode.F};

    @SerializedName("movelimit")
    public float[][] moveLimit = {new float[]{-90.0f, 90.0f}, new float[]{-45.0f, 45.0f}, new float[]{-180.0f, 180.0f}};

    @SerializedName("joystickspeed")
    @JsonAdapter(JoystickSpeedDeserializer.class)
    public JoystickSpeed[] joystickSpeed = {JoystickSpeed.VALUE};

    public static class CameraManufacturersDeserializer implements JsonDeserializer<CameraManufacturer[]> {
        private CameraManufacturersDeserializer() {
        }

        @Override // com.google.gson.JsonDeserializer
        public CameraManufacturer[] deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
            if (Profile.isNotArrayOrEmpty(jsonElement)) {
                return new CameraManufacturer[0];
            }
            JsonArray asJsonArray = jsonElement.getAsJsonArray();
            int size = asJsonArray.size();
            if (size == 1 && asJsonArray.get(0).getAsInt() == CameraManufacturer.CLOSE.value) {
                return new CameraManufacturer[0];
            }
            CameraManufacturer[] cameraManufacturerArr = new CameraManufacturer[size];
            for (int i = 0; i < size; i++) {
                cameraManufacturerArr[i] = CameraManufacturer.from(asJsonArray.get(i).getAsInt());
            }
            return cameraManufacturerArr;
        }
    }

    public static class Hex2String implements JsonDeserializer<byte[]> {
        private Hex2String() {
        }

        @Override // com.google.gson.JsonDeserializer
        public byte[] deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
            String asString = jsonElement.getAsString();
            int length = asString.length();
            byte[] bArr = new byte[length / 2];
            for (int i = 0; i < length; i += 2) {
                bArr[i / 2] = (byte) ((Character.digit(asString.charAt(i), 16) << 4) | Character.digit(asString.charAt(i + 1), 16));
            }
            return bArr;
        }
    }

    public static class JoystickSpeedDeserializer implements JsonDeserializer<JoystickSpeed[]> {
        private JoystickSpeedDeserializer() {
        }

        @Override // com.google.gson.JsonDeserializer
        public JoystickSpeed[] deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
            JsonArray asJsonArray = jsonElement.getAsJsonArray();
            if (Profile.isNotArrayOrEmpty(asJsonArray)) {
                return new JoystickSpeed[0];
            }
            JoystickSpeed[] joystickSpeedArr = new JoystickSpeed[asJsonArray.size()];
            for (int i = 0; i < asJsonArray.size(); i++) {
                joystickSpeedArr[i] = JoystickSpeed.valueOf(asJsonArray.get(i).getAsInt());
            }
            return joystickSpeedArr;
        }
    }

    public static class KeyRedefineDeserializer implements JsonDeserializer<KeyRedefine[]> {
        private KeyRedefineDeserializer() {
        }

        private KeyRedefine decodeKeyRedefine(JsonArray jsonArray) {
            int asInt = jsonArray.get(0).getAsInt();
            int asInt2 = jsonArray.get(1).getAsInt();
            JsonArray asJsonArray = jsonArray.get(2).getAsJsonArray();
            int size = asJsonArray.size();
            int[] iArr = new int[size];
            for (int i = 0; i < size; i++) {
                iArr[i] = asJsonArray.get(i).getAsInt();
            }
            KeyRedefine keyRedefine = new KeyRedefine();
            keyRedefine.setKeyType(0);
            keyRedefine.setKeyGroup(asInt);
            keyRedefine.setKeyValue(asInt2);
            keyRedefine.setKeyEvents(iArr);
            return keyRedefine;
        }

        @Override // com.google.gson.JsonDeserializer
        public KeyRedefine[] deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
            if (Profile.isNotArrayOrEmpty(jsonElement)) {
                return null;
            }
            JsonArray asJsonArray = jsonElement.getAsJsonArray();
            int size = asJsonArray.size();
            KeyRedefine[] keyRedefineArr = new KeyRedefine[asJsonArray.size()];
            for (int i = 0; i < size; i++) {
                JsonElement jsonElement2 = asJsonArray.get(i);
                if (!Profile.isNotArrayOrEmpty(jsonElement2)) {
                    keyRedefineArr[i] = decodeKeyRedefine(jsonElement2.getAsJsonArray());
                }
            }
            return keyRedefineArr;
        }
    }

    public static class MotorStrengthDeserializer implements JsonDeserializer<Strength[]> {
        private MotorStrengthDeserializer() {
        }

        @Override // com.google.gson.JsonDeserializer
        public Strength[] deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
            if (Profile.isNotArrayOrEmpty(jsonElement)) {
                return new Strength[0];
            }
            JsonArray asJsonArray = jsonElement.getAsJsonArray();
            Strength[] strengthArr = new Strength[asJsonArray.size()];
            for (int i = 0; i < asJsonArray.size(); i++) {
                strengthArr[i] = Strength.from(asJsonArray.get(i).getAsInt());
            }
            return strengthArr;
        }
    }

    public static class SceneModeDeserializer implements JsonDeserializer<SceneMode[]> {
        private SceneModeDeserializer() {
        }

        @Override // com.google.gson.JsonDeserializer
        public SceneMode[] deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
            JsonArray asJsonArray = jsonElement.getAsJsonArray();
            if (Profile.isNotArrayOrEmpty(asJsonArray)) {
                return null;
            }
            if (asJsonArray.get(0).getAsInt() == -1) {
                return null;
            }
            SceneMode[] sceneModeArr = new SceneMode[asJsonArray.size()];
            for (int i = 0; i < asJsonArray.size(); i++) {
                sceneModeArr[i] = SceneMode.valueOf(asJsonArray.get(i).getAsInt());
            }
            return sceneModeArr;
        }
    }

    public static class WorkingModeDeserializer implements JsonDeserializer<WorkingMode[]> {
        private WorkingModeDeserializer() {
        }

        @Override // com.google.gson.JsonDeserializer
        public WorkingMode[] deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
            if (Profile.isNotArrayOrEmpty(jsonElement)) {
                return new WorkingMode[0];
            }
            JsonArray asJsonArray = jsonElement.getAsJsonArray();
            WorkingMode[] workingModeArr = new WorkingMode[asJsonArray.size()];
            for (int i = 0; i < asJsonArray.size(); i++) {
                workingModeArr[i] = WorkingMode.from(asJsonArray.get(i).getAsInt());
            }
            return workingModeArr;
        }
    }

    public static Profile create(String str) {
        if (gson == null) {
            gson = new GsonBuilder().create();
        }
        String strC = f.c("profiles" + File.separator + str);
        return g.a(strC) ? (Profile) gson.fromJson(strC, Profile.class) : new Profile();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isNotArrayOrEmpty(JsonElement jsonElement) {
        return jsonElement.isJsonNull() || !jsonElement.isJsonArray() || jsonElement.getAsJsonArray().size() == 0;
    }

    public String toString() {
        return "Profile{battery=" + this.battery + ", ccs=" + this.ccs + ", update=" + this.update + ", motionControl=" + this.motionControl + ", photo=" + this.photo + ", video=" + this.video + ", digitalZoom=" + this.digitalZoom + ", moveLine=" + this.moveLine + ", jsonData=" + this.jsonData + ", links=" + this.links + ", carry=" + this.carry + ", hid=" + this.hid + ", mtu=" + this.mtu + ", tracking=" + this.tracking + ", autoTune=" + this.autoTune + ", oem=" + this.oem + ", wifiChannel=" + this.wifiChannel + ", accessory=" + this.accessory + ", keyRedefine=" + Arrays.toString(this.keyRedefine) + ", cameraManufacturers=" + Arrays.toString(this.cameraList) + ", resetMethod=" + this.resetMethod + '}';
    }
}
