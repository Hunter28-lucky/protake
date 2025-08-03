package defpackage;

import android.content.Context;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.blink.academy.film.support.stream.ts.TsConstants;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public class me {

    /* renamed from: ՠ, reason: contains not printable characters */
    public static me f7996;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public Context f7998;

    /* renamed from: ԩ, reason: contains not printable characters */
    public of f8000;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public String f8001;

    /* renamed from: ԫ, reason: contains not printable characters */
    public String f8002;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public ga f8003;

    /* renamed from: ԭ, reason: contains not printable characters */
    public ga f8004;

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final Object f7995 = new Object();

    /* renamed from: ֈ, reason: contains not printable characters */
    public static final String f7997 = ".UTSystemConfig" + File.separator + "Global";

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String f7999 = null;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public Pattern f8005 = Pattern.compile("[^0-9a-zA-Z=/+]+");

    public me(Context context) {
        this.f7998 = null;
        this.f8000 = null;
        this.f8001 = "xx_utdid_key";
        this.f8002 = "xx_utdid_domain";
        this.f8003 = null;
        this.f8004 = null;
        this.f7998 = context;
        this.f8004 = new ga(context, f7997, "Alvin2", false, true);
        this.f8003 = new ga(context, ".DataStorage", "ContextData", false, true);
        this.f8000 = new of();
        this.f8001 = String.format("K_%d", Integer.valueOf(xf.m8612(this.f8001)));
        this.f8002 = String.format("D_%d", Integer.valueOf(xf.m8612(this.f8002)));
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static me m7562(Context context) {
        if (context != null && f7996 == null) {
            synchronized (f7995) {
                if (f7996 == null) {
                    me meVar = new me(context);
                    f7996 = meVar;
                    meVar.m7570();
                }
            }
        }
        return f7996;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static String m7563(byte[] bArr) throws Exception {
        byte[] bArr2 = {69, 114, 116, -33, 125, -54, ExifInterface.MARKER_APP1, 86, -11, 11, -78, -96, -17, -99, TsConstants.ACESType_data, 23, -95, -126, -82, -64, 113, 116, -16, -103, 49, -30, 9, ExifInterface.MARKER_EOI, 33, -80, -68, -78, -117, 53, 30, -122, TsConstants.ACESType_data, -104, 74, -49, 106, 85, -38, -93};
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(mf.m7574(bArr2), mac.getAlgorithm()));
        return dc.m5940(mac.doFinal(bArr), 2);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public synchronized String m7564() {
        String strM7568 = m7568();
        this.f7999 = strM7568;
        if (!TextUtils.isEmpty(strM7568)) {
            return this.f7999;
        }
        try {
            byte[] bArrM7571 = m7571();
            if (bArrM7571 != null) {
                String strM5940 = dc.m5940(bArrM7571, 2);
                this.f7999 = strM5940;
                m7567(strM5940);
                String strM7709 = this.f8000.m7709(bArrM7571);
                if (strM7709 != null) {
                    m7569(strM7709);
                }
                return this.f7999;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return null;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final boolean m7565(String str) {
        if (str != null) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length() && !this.f8005.matcher(str).find()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public synchronized String m7566() {
        String str = this.f7999;
        if (str != null) {
            return str;
        }
        return m7564();
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m7567(String str) {
        ga gaVar;
        if (m7565(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() != 24 || (gaVar = this.f8004) == null) {
                return;
            }
            gaVar.m6082("UTDID2", str);
            this.f8004.m6083();
        }
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public synchronized String m7568() {
        String strM7572 = m7572();
        if (m7565(strM7572)) {
            m7569(this.f8000.m7708(strM7572));
            this.f7999 = strM7572;
            return strM7572;
        }
        String strM6081 = this.f8003.m6081(this.f8001);
        if (!xf.m8613(strM6081)) {
            String strM8633 = new yf().m8633(strM6081);
            if (!m7565(strM8633)) {
                strM8633 = this.f8000.m7710(strM6081);
            }
            if (m7565(strM8633) && !xf.m8613(strM8633)) {
                this.f7999 = strM8633;
                m7567(strM8633);
                return this.f7999;
            }
        }
        return null;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m7569(String str) {
        ga gaVar;
        if (str == null || (gaVar = this.f8003) == null || str.equals(gaVar.m6081(this.f8001))) {
            return;
        }
        this.f8003.m6082(this.f8001, str);
        this.f8003.m6083();
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m7570() {
        ga gaVar = this.f8004;
        if (gaVar != null) {
            if (xf.m8613(gaVar.m6081("UTDID2"))) {
                String strM6081 = this.f8004.m6081("UTDID");
                if (!xf.m8613(strM6081)) {
                    m7567(strM6081);
                }
            }
            boolean z = false;
            boolean z2 = true;
            if (!xf.m8613(this.f8004.m6081("DID"))) {
                this.f8004.m6085("DID");
                z = true;
            }
            if (!xf.m8613(this.f8004.m6081("EI"))) {
                this.f8004.m6085("EI");
                z = true;
            }
            if (xf.m8613(this.f8004.m6081("SI"))) {
                z2 = z;
            } else {
                this.f8004.m6085("SI");
            }
            if (z2) {
                this.f8004.m6083();
            }
        }
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final byte[] m7571() throws Exception {
        String strM7201;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int iNextInt = new Random().nextInt();
        byte[] bArrM6201 = hd.m6201(iCurrentTimeMillis);
        byte[] bArrM62012 = hd.m6201(iNextInt);
        byteArrayOutputStream.write(bArrM6201, 0, 4);
        byteArrayOutputStream.write(bArrM62012, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            strM7201 = ke.m7201(this.f7998);
        } catch (Exception unused) {
            strM7201 = "" + new Random().nextInt();
        }
        byteArrayOutputStream.write(hd.m6201(xf.m8612(strM7201)), 0, 4);
        byteArrayOutputStream.write(hd.m6201(xf.m8612(m7563(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final String m7572() {
        ga gaVar = this.f8004;
        if (gaVar == null) {
            return null;
        }
        String strM6081 = gaVar.m6081("UTDID2");
        if (xf.m8613(strM6081) || this.f8000.m7708(strM6081) == null) {
            return null;
        }
        return strM6081;
    }
}
