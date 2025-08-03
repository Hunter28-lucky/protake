package defpackage;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import org.jcodec.containers.mps.MPSUtils;

/* loaded from: classes.dex */
public class pg {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static Drawable m7980(String str, Context context) {
        return m7981(str, context, MPSUtils.VIDEO_MIN);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static Drawable m7981(String str, Context context, int i) {
        ByteArrayInputStream byteArrayInputStream;
        try {
            byteArrayInputStream = new ByteArrayInputStream(ha.m6187(str));
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                if (i <= 0) {
                    i = 240;
                }
                options.inDensity = i;
                options.inTargetDensity = context.getResources().getDisplayMetrics().densityDpi;
                BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(byteArrayInputStream, null, options));
                m7982(byteArrayInputStream);
                return bitmapDrawable;
            } catch (Throwable unused) {
                m7982(byteArrayInputStream);
                return null;
            }
        } catch (Throwable unused2) {
            byteArrayInputStream = null;
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m7982(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable unused) {
            }
        }
    }
}
