package defpackage;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Handler;
import android.util.Log;
import android.view.SurfaceHolder;
import com.google.zxing.PlanarYUVLuminanceSource;
import java.io.IOException;

/* compiled from: CameraManager.java */
/* renamed from: र, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C4091 {

    /* renamed from: ׯ, reason: contains not printable characters */
    public static final String f14216 = "र";

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Context f14217;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final C3929 f14218;

    /* renamed from: ԩ, reason: contains not printable characters */
    public C2928 f14219;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public C5140 f14220;

    /* renamed from: ԫ, reason: contains not printable characters */
    public Rect f14221;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public Rect f14222;

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean f14223;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public boolean f14224;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f14225 = -1;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f14226;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f14227;

    /* renamed from: ֏, reason: contains not printable characters */
    public final C3775 f14228;

    public C4091(Context context) {
        this.f14217 = context;
        C3929 c3929 = new C3929(context);
        this.f14218 = c3929;
        this.f14228 = new C3775(c3929);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static int m13027(int i, int i2, int i3) {
        int i4 = (i * 5) / 8;
        return i4 < i2 ? i2 : Math.min(i4, i3);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public PlanarYUVLuminanceSource m13028(byte[] bArr, int i, int i2) {
        if (m13031() == null) {
            return null;
        }
        return new PlanarYUVLuminanceSource(bArr, i, i2, 0, 0, i, i2, false);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public synchronized void m13029() {
        C2928 c2928 = this.f14219;
        if (c2928 != null) {
            c2928.m10328().release();
            this.f14219 = null;
            this.f14221 = null;
            this.f14222 = null;
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public synchronized Rect m13030() {
        if (this.f14221 == null) {
            if (this.f14219 == null) {
                return null;
            }
            Point pointM12695 = this.f14218.m12695();
            if (pointM12695 == null) {
                return null;
            }
            int iM13027 = m13027(pointM12695.x, 240, 1200);
            int iM130272 = m13027(pointM12695.y, 240, 675);
            int i = (pointM12695.x - iM13027) / 2;
            int i2 = (pointM12695.y - iM130272) / 2;
            this.f14221 = new Rect(i, i2, iM13027 + i, iM130272 + i2);
            Log.d(f14216, "Calculated framing rect: " + this.f14221);
        }
        return this.f14221;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public synchronized Rect m13031() {
        if (this.f14222 == null) {
            Rect rectM13030 = m13030();
            if (rectM13030 == null) {
                return null;
            }
            Rect rect = new Rect(rectM13030);
            Point pointM12694 = this.f14218.m12694();
            Point pointM12695 = this.f14218.m12695();
            if (pointM12694 != null && pointM12695 != null) {
                int i = rect.left;
                int i2 = pointM12694.x;
                int i3 = pointM12695.x;
                rect.left = (i * i2) / i3;
                rect.right = (rect.right * i2) / i3;
                int i4 = rect.top;
                int i5 = pointM12694.y;
                int i6 = pointM12695.y;
                rect.top = (i4 * i5) / i6;
                rect.bottom = (rect.bottom * i5) / i6;
                this.f14222 = rect;
            }
            return null;
        }
        return this.f14222;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public synchronized boolean m13032() {
        return this.f14219 != null;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public synchronized void m13033(SurfaceHolder surfaceHolder) throws IOException {
        int i;
        C2928 c2928M12990 = this.f14219;
        if (c2928M12990 == null) {
            c2928M12990 = C4061.m12990(this.f14225);
            if (c2928M12990 == null) {
                throw new IOException("Camera.open() failed to return object from driver");
            }
            this.f14219 = c2928M12990;
        }
        if (!this.f14223) {
            this.f14223 = true;
            this.f14218.m12697(c2928M12990);
            int i2 = this.f14226;
            if (i2 > 0 && (i = this.f14227) > 0) {
                m13036(i2, i);
                this.f14226 = 0;
                this.f14227 = 0;
            }
        }
        Camera cameraM10328 = c2928M12990.m10328();
        Camera.Parameters parameters = cameraM10328.getParameters();
        String strFlatten = parameters == null ? null : parameters.flatten();
        try {
            this.f14218.m12699(c2928M12990, false);
        } catch (RuntimeException unused) {
            String str = f14216;
            Log.w(str, "Camera rejected parameters. Setting only minimal safe-mode parameters");
            Log.i(str, "Resetting to saved camera params: " + strFlatten);
            if (strFlatten != null) {
                Camera.Parameters parameters2 = cameraM10328.getParameters();
                parameters2.unflatten(strFlatten);
                try {
                    cameraM10328.setParameters(parameters2);
                    this.f14218.m12699(c2928M12990, true);
                } catch (RuntimeException unused2) {
                    Log.w(f14216, "Camera rejected even safe-mode parameters! No configuration");
                }
            }
        }
        cameraM10328.setPreviewDisplay(surfaceHolder);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public synchronized void m13034(Handler handler, int i) {
        C2928 c2928 = this.f14219;
        if (c2928 != null && this.f14224) {
            this.f14228.m12079(handler, i);
            c2928.m10328().setOneShotPreviewCallback(this.f14228);
        }
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public synchronized void m13035(int i) {
        this.f14225 = i;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public synchronized void m13036(int i, int i2) {
        if (this.f14223) {
            Point pointM12695 = this.f14218.m12695();
            int i3 = pointM12695.x;
            if (i > i3) {
                i = i3;
            }
            int i4 = pointM12695.y;
            if (i2 > i4) {
                i2 = i4;
            }
            int i5 = (i3 - i) / 2;
            int i6 = (i4 - i2) / 2;
            this.f14221 = new Rect(i5, i6, i + i5, i2 + i6);
            Log.d(f14216, "Calculated manual framing rect: " + this.f14221);
            this.f14222 = null;
        } else {
            this.f14226 = i;
            this.f14227 = i2;
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public synchronized void m13037(boolean z) {
        C2928 c2928 = this.f14219;
        if (c2928 != null && z != this.f14218.m12696(c2928.m10328())) {
            C5140 c5140 = this.f14220;
            boolean z2 = c5140 != null;
            if (z2) {
                c5140.m15053();
                this.f14220 = null;
            }
            this.f14218.m12700(c2928.m10328(), z);
            if (z2) {
                C5140 c51402 = new C5140(this.f14217, c2928.m10328());
                this.f14220 = c51402;
                c51402.m15052();
            }
        }
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public synchronized void m13038() {
        C2928 c2928 = this.f14219;
        if (c2928 != null && !this.f14224) {
            c2928.m10328().startPreview();
            this.f14224 = true;
            this.f14220 = new C5140(this.f14217, c2928.m10328());
        }
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public synchronized void m13039() {
        C5140 c5140 = this.f14220;
        if (c5140 != null) {
            c5140.m15053();
            this.f14220 = null;
        }
        C2928 c2928 = this.f14219;
        if (c2928 != null && this.f14224) {
            c2928.m10328().stopPreview();
            this.f14228.m12079(null, 0);
            this.f14224 = false;
        }
    }
}
