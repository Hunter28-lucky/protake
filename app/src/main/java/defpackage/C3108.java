package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import androidx.core.view.ViewCompat;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.EnumMap;
import org.jcodec.platform.Platform;

/* compiled from: QRCodeEncoder.java */
/* renamed from: ӕ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C3108 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Context f11060;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public String f11061;

    /* renamed from: ԩ, reason: contains not printable characters */
    public String f11062;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public String f11063;

    /* renamed from: ԫ, reason: contains not printable characters */
    public BarcodeFormat f11064;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int f11065;

    public C3108(Context context, int i) {
        this.f11060 = context;
        this.f11065 = i;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static String m10697(CharSequence charSequence) {
        for (int i = 0; i < charSequence.length(); i++) {
            if (charSequence.charAt(i) > 255) {
                return Platform.UTF_8;
            }
        }
        return null;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public Bitmap m10698() throws WriterException {
        EnumMap enumMap;
        String str = this.f11061;
        if (str == null) {
            return null;
        }
        String strM10697 = m10697(str);
        if (strM10697 != null) {
            EnumMap enumMap2 = new EnumMap(EncodeHintType.class);
            enumMap2.put((EnumMap) EncodeHintType.CHARACTER_SET, (EncodeHintType) strM10697);
            enumMap = enumMap2;
        } else {
            enumMap = null;
        }
        try {
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            BarcodeFormat barcodeFormat = this.f11064;
            int i = this.f11065;
            BitMatrix bitMatrixEncode = multiFormatWriter.encode(str, barcodeFormat, i, i, enumMap);
            int width = bitMatrixEncode.getWidth();
            int height = bitMatrixEncode.getHeight();
            int[] iArr = new int[width * height];
            for (int i2 = 0; i2 < height; i2++) {
                int i3 = i2 * width;
                for (int i4 = 0; i4 < width; i4++) {
                    iArr[i3 + i4] = bitMatrixEncode.get(i4, i2) ? ViewCompat.MEASURED_STATE_MASK : -1;
                }
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
            return bitmapCreateBitmap;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public Bitmap m10699(String str) throws WriterException {
        EnumMap enumMap;
        this.f11061 = str;
        if (str == null) {
            return null;
        }
        String strM10697 = m10697(str);
        if (strM10697 != null) {
            EnumMap enumMap2 = new EnumMap(EncodeHintType.class);
            enumMap2.put((EnumMap) EncodeHintType.CHARACTER_SET, (EncodeHintType) strM10697);
            enumMap = enumMap2;
        } else {
            enumMap = null;
        }
        try {
            this.f11064 = BarcodeFormat.valueOf(BarcodeFormat.QR_CODE.toString());
            MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
            BarcodeFormat barcodeFormat = this.f11064;
            int i = this.f11065;
            BitMatrix bitMatrixEncode = multiFormatWriter.encode(str, barcodeFormat, i, i, enumMap);
            int width = bitMatrixEncode.getWidth();
            int height = bitMatrixEncode.getHeight();
            int[] iArr = new int[width * height];
            for (int i2 = 0; i2 < height; i2++) {
                int i3 = i2 * width;
                for (int i4 = 0; i4 < width; i4++) {
                    iArr[i3 + i4] = bitMatrixEncode.get(i4, i2) ? ViewCompat.MEASURED_STATE_MASK : -1;
                }
            }
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            bitmapCreateBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
            return bitmapCreateBitmap;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public String m10700() {
        return this.f11062;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public String m10701() {
        return this.f11063;
    }
}
