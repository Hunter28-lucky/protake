package defpackage;

import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import org.jcodec.containers.mp4.boxes.MetaValue;
import org.jcodec.movtool.MetadataEditor;

/* compiled from: MetaDataWriter.java */
/* renamed from: ܦ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3687 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final String f12805 = "ܦ";

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean f12806 = false;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final String f12807;

    /* renamed from: ԩ, reason: contains not printable characters */
    public String f12808;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public C3286 f12809;

    public C3687(String str) {
        this.f12807 = str;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public C3687 m11830(String str) {
        this.f12808 = str;
        return this;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public C3687 m11831(C3286 c3286) {
        this.f12809 = c3286;
        return this;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public boolean m11832() throws Throwable {
        File file = new File(this.f12807);
        if (!file.exists()) {
            if (this.f12806) {
                C4638.m14099(f12805, String.format("file not exists ! : %s", this.f12807));
            }
            return false;
        }
        try {
            MetadataEditor metadataEditorCreateFrom = MetadataEditor.createFrom(file);
            Map<String, MetaValue> keyedMeta = metadataEditorCreateFrom.getKeyedMeta();
            keyedMeta.put("com.blink.academy.protake.appVersion", MetaValue.createString("3.0.17"));
            String str = Build.MANUFACTURER;
            keyedMeta.put("CameraMaker", MetaValue.createString(str));
            String str2 = Build.MODEL;
            keyedMeta.put("CameraModel", MetaValue.createString(str2));
            keyedMeta.put("SystemVersion", MetaValue.createString("Android " + Build.VERSION.RELEASE));
            keyedMeta.put("com.blink.academy.protake.VFR", MetaValue.createString(this.f12809.m11010()));
            keyedMeta.put("com.blink.academy.protake.autoExposure", MetaValue.createString(this.f12809.m10983()));
            if (TextUtils.isEmpty(this.f12809.m10992())) {
                keyedMeta.put("com.blink.academy.protake.shutterSpeed", MetaValue.createString(this.f12809.m11007()));
                keyedMeta.put("com.blink.academy.protake.iso", MetaValue.createString(this.f12809.m10995()));
            } else {
                keyedMeta.put("com.blink.academy.protake.exposureBias", MetaValue.createString(this.f12809.m10992()));
            }
            keyedMeta.put("com.blink.academy.protake.WBMode", MetaValue.createString(this.f12809.m11012()));
            keyedMeta.put("com.blink.academy.protake.lens", MetaValue.createString(this.f12809.m10997()));
            if (!TextUtils.isEmpty(this.f12809.m10982())) {
                keyedMeta.put("com.blink.academy.protake.audioLevel", MetaValue.createString(this.f12809.m10982()));
            }
            if (!TextUtils.isEmpty(this.f12809.m11001())) {
                keyedMeta.put("com.blink.academy.protake.mic", MetaValue.createString(this.f12809.m11001()));
            }
            if (!TextUtils.isEmpty(this.f12809.m10981())) {
                keyedMeta.put("com.blink.academy.protake.audioAutoGain", MetaValue.createString(this.f12809.m10981()));
            }
            keyedMeta.put("com.blink.academy.protake.mode", MetaValue.createString(this.f12809.m11002()));
            if (!TextUtils.isEmpty(this.f12809.m11000())) {
                keyedMeta.put("com.blink.academy.protake.looks.style", MetaValue.createString(this.f12809.m11000()));
            }
            if (!TextUtils.isEmpty(this.f12809.m10999())) {
                keyedMeta.put("com.blink.academy.protake.looks.lutStrength", MetaValue.createString(this.f12809.m10999()));
            }
            if (!TextUtils.isEmpty(this.f12809.m10991())) {
                keyedMeta.put("com.blink.academy.protake.looks.contrast", MetaValue.createString(this.f12809.m10991()));
            }
            if (!TextUtils.isEmpty(this.f12809.m10986())) {
                keyedMeta.put("com.blink.academy.protake.looks.brightness", MetaValue.createString(this.f12809.m10986()));
            }
            if (!TextUtils.isEmpty(this.f12809.m10985())) {
                keyedMeta.put("com.blink.academy.protake.looks.black", MetaValue.createString(this.f12809.m10985()));
            }
            if (!TextUtils.isEmpty(this.f12809.m11011())) {
                keyedMeta.put("com.blink.academy.protake.looks.white", MetaValue.createString(this.f12809.m11011()));
            }
            if (!TextUtils.isEmpty(this.f12808)) {
                keyedMeta.put("com.blink.academy.protake.frameDrop", MetaValue.createString(this.f12808));
            }
            keyedMeta.put("com.blink.academy.protake.sharpness", MetaValue.createString(this.f12809.m11006()));
            keyedMeta.put("com.blink.academy.protake.noiseReduction", MetaValue.createString(this.f12809.m11003()));
            keyedMeta.put("com.blink.academy.protake.stabilization", MetaValue.createString(this.f12809.m11008()));
            keyedMeta.put("com.blink.academy.protake.flicker", MetaValue.createString(this.f12809.m10993()));
            keyedMeta.put("com.blink.academy.protake.framework", MetaValue.createString(this.f12809.m10994()));
            keyedMeta.put("com.blink.academy.protake.cameraUnit", MetaValue.createString(this.f12809.m10987()));
            keyedMeta.put("com.blink.academy.protake.reelNumber", MetaValue.createString(this.f12809.m11005()));
            keyedMeta.put("com.blink.academy.protake.clipCount", MetaValue.createString(this.f12809.m10988()));
            keyedMeta.put("com.blink.academy.protake.filenameSuffix", MetaValue.createString(this.f12809.m11009()));
            keyedMeta.put("com.blink.academy.protake.clipID", MetaValue.createString(this.f12809.m10989()));
            keyedMeta.put("com.blink.academy.protake.colorDepth", MetaValue.createString(this.f12809.m10990()));
            keyedMeta.put("com.blink.academy.protake.AndroidBundleVersion", MetaValue.createString(this.f12809.m10980()));
            if (!TextUtils.isEmpty(this.f12809.m10996())) {
                keyedMeta.put("com.blink.academy.protake.leica.mode", MetaValue.createString(this.f12809.m10996()));
            }
            keyedMeta.put("com.blink.academy.protake.accessories", MetaValue.createString(this.f12809.m10979()));
            keyedMeta.put("com.blink.academy.protake.battery", MetaValue.createString(this.f12809.m10984()));
            if (!TextUtils.isEmpty(this.f12809.m10998())) {
                keyedMeta.put("com.apple.quicktime.location.ISO6709", MetaValue.createString(this.f12809.m10998()));
            }
            keyedMeta.put("com.apple.quicktime.make", MetaValue.createString(str));
            keyedMeta.put("com.apple.quicktime.model", MetaValue.createString(str2));
            String str3 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.getDefault()).format(new Date());
            C4638.m14099(f12805, String.format("format : %s ", str3));
            keyedMeta.put("com.apple.quicktime.creationdate", MetaValue.createString(str3));
            metadataEditorCreateFrom.save(true);
            return true;
        } catch (IOException e2) {
            e2.printStackTrace();
            if (this.f12806) {
                C4638.m14099(f12805, String.format("MetadataEditor error : %s ", e2));
            }
            return false;
        }
    }
}
