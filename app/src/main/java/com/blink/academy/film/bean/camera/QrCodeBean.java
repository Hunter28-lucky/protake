package com.blink.academy.film.bean.camera;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class QrCodeBean implements Parcelable {
    public static final Parcelable.Creator<QrCodeBean> CREATOR = new C0114();
    private String k1;
    private int k10;
    private int k11;
    private int k12;
    private float k13;
    private int k14;
    private int k15;
    private int k16;
    private int k17;
    private String k18;
    private int k19;
    private String k2;
    private int k20;
    private int k21;
    private int k22;
    private int k23;
    private int k24;
    private int k25;
    private int k26;
    private String k27;
    private int k28;
    private int k29;
    private String k3;
    private int k30;
    private String k31;
    private int k32;
    private int k33;
    private int k34;
    private int k35;
    private int k36;
    private int k37;
    private int k38;
    private int k39;
    private String k4;
    private int k40;
    private int k41;
    private int k42;
    private String k43;
    private String k44;
    private int k45;
    private int k46;
    private int k47;
    private int k48;
    private String k49;
    private String k5;
    private float k50;
    private int k51;
    private int k52;
    private int k53;
    private int k54;
    private int k55;
    private int k56;
    private int k57;
    private int k58;
    private int k59;
    private String k6;
    private int k65;
    private int k66;
    private float k67;
    private int k68;
    private float k69;
    private long k7;
    private int k70;
    private int k71;
    private int k72;
    private int k73;
    private int k74;
    private int k75;
    private int k8;
    private int k9;

    /* renamed from: com.blink.academy.film.bean.camera.QrCodeBean$Ϳ, reason: contains not printable characters */
    public class C0114 implements Parcelable.Creator<QrCodeBean> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public QrCodeBean createFromParcel(Parcel parcel) {
            return new QrCodeBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: Ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public QrCodeBean[] newArray(int i) {
            return new QrCodeBean[i];
        }
    }

    public QrCodeBean() {
        this.k69 = 1.0f;
        this.k70 = 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAlwaysOnState() {
        return this.k25;
    }

    public int getAngleMode() {
        return this.k14;
    }

    public String getAppVersion() {
        return this.k4;
    }

    public int getArea() {
        return this.k29;
    }

    public int getAreaMode() {
        return this.k28;
    }

    public int getAudioLevel() {
        return this.k22;
    }

    public int getAutoAssistantsState() {
        return this.k57;
    }

    public String getAutoCameraName() {
        return this.k49;
    }

    public int getAutoFrontZoomPercent() {
        return this.k56;
    }

    public int getAutoGain() {
        return this.k24;
    }

    public float getAutoZoom() {
        return this.k50;
    }

    public int getBitrate() {
        return this.k9;
    }

    public int getBlackP() {
        return this.k35;
    }

    public int getBrightness() {
        return this.k34;
    }

    public String getCameraName() {
        return this.k18;
    }

    public String getCameraUnit() {
        return this.k43;
    }

    public String getConfigVersion() {
        return this.k3;
    }

    public int getContrast() {
        return this.k33;
    }

    public String getCropRation() {
        return this.k27;
    }

    public int getCurrentHz() {
        return this.k41;
    }

    public String getDeviceNo() {
        return this.k5;
    }

    public String getDisplayName() {
        return this.k2;
    }

    public int getDofAdapterState() {
        return this.k59;
    }

    public int getEV() {
        return this.k16;
    }

    public int getEdge() {
        return this.k39;
    }

    public int getExposureMode() {
        return this.k12;
    }

    public int getFPS() {
        return this.k10;
    }

    public int getFocus() {
        return this.k19;
    }

    public int getFrameDrop() {
        return this.k37;
    }

    public int getHdmiCleanState() {
        return this.k72;
    }

    public int getISO() {
        return this.k15;
    }

    public int getInputModeState() {
        return this.k48;
    }

    public int getLeicaMode() {
        return this.k46;
    }

    public int getLineState() {
        return this.k30;
    }

    public String getLutType() {
        return this.k31;
    }

    public int getMic() {
        return this.k23;
    }

    public int getNoiseReduction() {
        return this.k38;
    }

    public float getOpener() {
        return this.k13;
    }

    public int getPerformanceState() {
        return this.k73;
    }

    public int getPixelFormat() {
        return this.k71;
    }

    public int getPortraitAFMode() {
        return this.k68;
    }

    public float getPortraitAFValue() {
        return this.k69;
    }

    public float getPortraitAperture() {
        return this.k67;
    }

    public int getPortraitFPS() {
        return this.k66;
    }

    public int getPortraitIsLidar() {
        return this.k70;
    }

    public int getPortraitRes() {
        return this.k65;
    }

    public String getPresetId() {
        return this.k1;
    }

    public int getProMode() {
        return this.k26;
    }

    public int getRecBeeperState() {
        return this.k54;
    }

    public int getRecFlashState() {
        return this.k55;
    }

    public int getRecordMode() {
        return this.k42;
    }

    public String getReelNumber() {
        return this.k44;
    }

    public int getRepeatMode() {
        return this.k45;
    }

    public int getResolution() {
        return this.k8;
    }

    public int getSavePathType() {
        return this.k53;
    }

    public int getSelfieMirrorState() {
        return this.k74;
    }

    public int getStabilization() {
        return this.k40;
    }

    public int getStrength() {
        return this.k32;
    }

    public String getSystemNo() {
        return this.k6;
    }

    public int getTemp() {
        return this.k51;
    }

    public int getTimeCodeState() {
        return this.k75;
    }

    public int getTimeLapseMode() {
        return this.k11;
    }

    public int getTint() {
        return this.k52;
    }

    public long getUpdateStamp() {
        return this.k7;
    }

    public int getVideoFormatMode() {
        return this.k47;
    }

    public int getVolumeKeyRecordState() {
        return this.k58;
    }

    public int getWB() {
        return this.k17;
    }

    public int getWaveMode() {
        return this.k21;
    }

    public int getWhiteP() {
        return this.k36;
    }

    public int getZoom() {
        return this.k20;
    }

    public void setAlwaysOnState(int i) {
        this.k25 = i;
    }

    public void setAngelMode(int i) {
        this.k14 = i;
    }

    public void setAppVersion(String str) {
        this.k4 = str;
    }

    public void setArea(int i) {
        this.k29 = i;
    }

    public void setAreaMode(int i) {
        this.k28 = i;
    }

    public void setAudioLevel(int i) {
        this.k22 = i;
    }

    public void setAutoAssistantsState(int i) {
        this.k57 = i;
    }

    public void setAutoCameraName(String str) {
        this.k49 = str;
    }

    public void setAutoFrontZoomPercent(int i) {
        this.k56 = i;
    }

    public void setAutoGain(int i) {
        this.k24 = i;
    }

    public void setAutoZoom(float f) {
        this.k50 = f;
    }

    public void setBitrate(int i) {
        this.k9 = i;
    }

    public void setBlackP(int i) {
        this.k35 = i;
    }

    public void setBrightness(int i) {
        this.k34 = i;
    }

    public void setCameraName(String str) {
        this.k18 = str;
    }

    public void setCameraUnit(String str) {
        this.k43 = str;
    }

    public void setConfigVersion(String str) {
        this.k3 = str;
    }

    public void setContrast(int i) {
        this.k33 = i;
    }

    public void setCropRation(String str) {
        this.k27 = str;
    }

    public void setCurrentHz(int i) {
        this.k41 = i;
    }

    public void setDeviceNo(String str) {
        this.k5 = str;
    }

    public void setDisplayName(String str) {
        this.k2 = str;
    }

    public void setDofAdapterState(int i) {
        this.k59 = i;
    }

    public void setEV(int i) {
        this.k16 = i;
    }

    public void setEdge(int i) {
        this.k39 = i;
    }

    public void setExposureMode(int i) {
        this.k12 = i;
    }

    public void setFPS(int i) {
        this.k10 = i;
    }

    public void setFocus(int i) {
        this.k19 = i;
    }

    public void setFrameDrop(int i) {
        this.k37 = i;
    }

    public void setHdmiCleanState(int i) {
        this.k72 = i;
    }

    public void setISO(int i) {
        this.k15 = i;
    }

    public void setInputModeState(int i) {
        this.k48 = i;
    }

    public void setLeicaMode(int i) {
        this.k46 = i;
    }

    public void setLineState(int i) {
        this.k30 = i;
    }

    public void setLutType(String str) {
        this.k31 = str;
    }

    public void setMic(int i) {
        this.k23 = i;
    }

    public void setNoiseReduction(int i) {
        this.k38 = i;
    }

    public void setOpener(int i) {
        this.k13 = i;
    }

    public void setPerformanceState(int i) {
        this.k73 = i;
    }

    public void setPixelFormat(int i) {
        this.k71 = i;
    }

    public void setPortraitAFMode(int i) {
        this.k68 = i;
    }

    public void setPortraitAFValue(float f) {
        this.k69 = f;
    }

    public void setPortraitAperture(float f) {
        this.k67 = f;
    }

    public void setPortraitFPS(int i) {
        this.k66 = i;
    }

    public void setPortraitIsLidar(int i) {
        this.k70 = i;
    }

    public void setPortraitRes(int i) {
        this.k65 = i;
    }

    public void setPresetId(String str) {
        this.k1 = str;
    }

    public void setProMode(int i) {
        this.k26 = i;
    }

    public void setRecBeeperState(int i) {
        this.k54 = i;
    }

    public void setRecFlashState(int i) {
        this.k55 = i;
    }

    public void setRecordMode(int i) {
        this.k42 = i;
    }

    public void setReelNumber(String str) {
        this.k44 = str;
    }

    public void setRepeatMode(int i) {
        this.k45 = i;
    }

    public void setResolution(int i) {
        this.k8 = i;
    }

    public void setSavePathType(int i) {
        this.k53 = i;
    }

    public void setSelfieMirrorState(int i) {
        this.k74 = i;
    }

    public void setStabilization(int i) {
        this.k40 = i;
    }

    public void setStrength(int i) {
        this.k32 = i;
    }

    public void setSystemNo(String str) {
        this.k6 = str;
    }

    public void setTemp(int i) {
        this.k51 = i;
    }

    public void setTimeCodeState(int i) {
        this.k75 = i;
    }

    public void setTimeLapseMode(int i) {
        this.k11 = i;
    }

    public void setTint(int i) {
        this.k52 = i;
    }

    public void setUpdateStam(long j) {
        this.k7 = j;
    }

    public void setVideoFormatMode(int i) {
        this.k47 = i;
    }

    public void setVolumeKeyRecordState(int i) {
        this.k58 = i;
    }

    public void setWB(int i) {
        this.k17 = i;
    }

    public void setWaveMode(int i) {
        this.k21 = i;
    }

    public void setWhiteP(int i) {
        this.k36 = i;
    }

    public void setZoom(int i) {
        this.k20 = i;
    }

    public String toString() {
        return "QrCodeBean{presetId='" + this.k1 + "', displayName='" + this.k2 + "', configVersion='" + this.k3 + "', AppVersion='" + this.k4 + "', DeviceNo='" + this.k5 + "', SystemNo='" + this.k6 + "', UpdateStamp=" + this.k7 + ", Resolution=" + this.k8 + ", Bitrate=" + this.k9 + ", FPS=" + this.k10 + ", TimeLapseMode=" + this.k11 + ", ExposureMode=" + this.k12 + ", Opener=" + this.k13 + ", AngelMode=" + this.k14 + ", ISO=" + this.k15 + ", EV=" + this.k16 + ", WB=" + this.k17 + ", CameraName='" + this.k18 + "', Focus=" + this.k19 + ", Zoom=" + this.k20 + ", WaveMode=" + this.k21 + ", AudioLevel=" + this.k22 + ", Mic=" + this.k23 + ", AutoGain=" + this.k24 + ", AlwaysOnState=" + this.k25 + ", ProMode=" + this.k26 + ", CropRation='" + this.k27 + "', AreaMode=" + this.k28 + ", Area=" + this.k29 + ", LineState=" + this.k30 + ", LutName='" + this.k31 + "', Strength=" + this.k32 + ", Contrast=" + this.k33 + ", Brightness=" + this.k34 + ", BlackP=" + this.k35 + ", WhiteP=" + this.k36 + ", FrameDrop=" + this.k37 + ", NoiseReduction=" + this.k38 + ", Edge=" + this.k39 + ", Stabilization=" + this.k40 + ", CurrentHz=" + this.k41 + ", RecordMode=" + this.k42 + ", CameraUnit='" + this.k43 + "', ReelNumber='" + this.k44 + "', RepeatMode=" + this.k45 + ", LeicaMode=" + this.k46 + ", VideoFormatMode=" + this.k47 + ", InputModeState=" + this.k48 + ", AutoCameraName=" + this.k49 + ", AutoZoom=" + this.k50 + ", Temp=" + this.k51 + ", Tint=" + this.k52 + ", SavePathType=" + this.k53 + ", RecBeeperState=" + this.k54 + ", RecFlashState=" + this.k55 + ", AutoFrontZoomPercent=" + this.k56 + ", AutoAssistantsState=" + this.k57 + ", VolumeKeyRecordState=" + this.k58 + ", DofAdapterState=" + this.k59 + ", PortraitRes=" + this.k65 + ", PortraitFPS=" + this.k66 + ", PortraitAperture=" + this.k67 + ", PortraitAFMode=" + this.k68 + ", PortraitAFValue=" + this.k69 + ", PortraitIsLidar=" + this.k70 + ", PixcelFormat=" + this.k71 + ", HDMIClean=" + this.k72 + ", Performance=" + this.k73 + ", SelfieMirror=" + this.k74 + ", Timecode=" + this.k75 + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.k1);
        parcel.writeString(this.k2);
        parcel.writeString(this.k3);
        parcel.writeString(this.k4);
        parcel.writeString(this.k5);
        parcel.writeString(this.k6);
        parcel.writeLong(this.k7);
        parcel.writeInt(this.k8);
        parcel.writeInt(this.k9);
        parcel.writeInt(this.k10);
        parcel.writeInt(this.k11);
        parcel.writeInt(this.k12);
        parcel.writeFloat(this.k13);
        parcel.writeInt(this.k14);
        parcel.writeInt(this.k15);
        parcel.writeInt(this.k16);
        parcel.writeInt(this.k17);
        parcel.writeString(this.k18);
        parcel.writeInt(this.k19);
        parcel.writeInt(this.k20);
        parcel.writeInt(this.k21);
        parcel.writeInt(this.k22);
        parcel.writeInt(this.k23);
        parcel.writeInt(this.k24);
        parcel.writeInt(this.k25);
        parcel.writeInt(this.k26);
        parcel.writeString(this.k27);
        parcel.writeInt(this.k28);
        parcel.writeInt(this.k29);
        parcel.writeInt(this.k30);
        parcel.writeString(this.k31);
        parcel.writeInt(this.k32);
        parcel.writeInt(this.k33);
        parcel.writeInt(this.k34);
        parcel.writeInt(this.k35);
        parcel.writeInt(this.k36);
        parcel.writeInt(this.k37);
        parcel.writeInt(this.k38);
        parcel.writeInt(this.k39);
        parcel.writeInt(this.k40);
        parcel.writeInt(this.k41);
        parcel.writeInt(this.k42);
        parcel.writeString(this.k43);
        parcel.writeString(this.k44);
        parcel.writeInt(this.k45);
        parcel.writeInt(this.k46);
        parcel.writeInt(this.k47);
        parcel.writeInt(this.k48);
        parcel.writeString(this.k49);
        parcel.writeFloat(this.k50);
        parcel.writeInt(this.k51);
        parcel.writeInt(this.k52);
        parcel.writeInt(this.k53);
        parcel.writeInt(this.k54);
        parcel.writeInt(this.k55);
        parcel.writeInt(this.k56);
        parcel.writeInt(this.k57);
        parcel.writeInt(this.k58);
        parcel.writeInt(this.k59);
        parcel.writeInt(this.k65);
        parcel.writeInt(this.k66);
        parcel.writeFloat(this.k67);
        parcel.writeInt(this.k68);
        parcel.writeFloat(this.k69);
        parcel.writeInt(this.k70);
        parcel.writeInt(this.k71);
        parcel.writeInt(this.k72);
        parcel.writeInt(this.k73);
        parcel.writeInt(this.k74);
        parcel.writeInt(this.k75);
    }

    public QrCodeBean(Parcel parcel) {
        this.k69 = 1.0f;
        this.k70 = 1;
        this.k1 = parcel.readString();
        this.k2 = parcel.readString();
        this.k3 = parcel.readString();
        this.k4 = parcel.readString();
        this.k5 = parcel.readString();
        this.k6 = parcel.readString();
        this.k7 = parcel.readLong();
        this.k8 = parcel.readInt();
        this.k9 = parcel.readInt();
        this.k10 = parcel.readInt();
        this.k11 = parcel.readInt();
        this.k12 = parcel.readInt();
        this.k13 = parcel.readFloat();
        this.k14 = parcel.readInt();
        this.k15 = parcel.readInt();
        this.k16 = parcel.readInt();
        this.k17 = parcel.readInt();
        this.k18 = parcel.readString();
        this.k19 = parcel.readInt();
        this.k20 = parcel.readInt();
        this.k21 = parcel.readInt();
        this.k22 = parcel.readInt();
        this.k23 = parcel.readInt();
        this.k24 = parcel.readInt();
        this.k25 = parcel.readInt();
        this.k26 = parcel.readInt();
        this.k27 = parcel.readString();
        this.k28 = parcel.readInt();
        this.k29 = parcel.readInt();
        this.k30 = parcel.readInt();
        this.k31 = parcel.readString();
        this.k32 = parcel.readInt();
        this.k33 = parcel.readInt();
        this.k34 = parcel.readInt();
        this.k35 = parcel.readInt();
        this.k36 = parcel.readInt();
        this.k37 = parcel.readInt();
        this.k38 = parcel.readInt();
        this.k39 = parcel.readInt();
        this.k40 = parcel.readInt();
        this.k41 = parcel.readInt();
        this.k42 = parcel.readInt();
        this.k43 = parcel.readString();
        this.k44 = parcel.readString();
        this.k45 = parcel.readInt();
        this.k46 = parcel.readInt();
        this.k47 = parcel.readInt();
        this.k48 = parcel.readInt();
        this.k49 = parcel.readString();
        this.k50 = parcel.readFloat();
        this.k51 = parcel.readInt();
        this.k52 = parcel.readInt();
        this.k53 = parcel.readInt();
        this.k54 = parcel.readInt();
        this.k55 = parcel.readInt();
        this.k56 = parcel.readInt();
        this.k57 = parcel.readInt();
        this.k58 = parcel.readInt();
        this.k59 = parcel.readInt();
        this.k65 = parcel.readInt();
        this.k66 = parcel.readInt();
        this.k67 = parcel.readFloat();
        this.k68 = parcel.readInt();
        this.k69 = parcel.readFloat();
        this.k70 = parcel.readInt();
        this.k71 = parcel.readInt();
        this.k72 = parcel.readInt();
        this.k73 = parcel.readInt();
        this.k74 = parcel.readInt();
        this.k75 = parcel.readInt();
    }
}
