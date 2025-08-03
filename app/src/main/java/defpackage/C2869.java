package defpackage;

import android.util.Log;
import defpackage.C4932;
import defpackage.InterfaceC3238;
import java.io.File;
import java.io.IOException;

/* compiled from: DiskLruCacheWrapper.java */
/* renamed from: Р, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2869 implements InterfaceC3238 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final File f10498;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final long f10499;

    /* renamed from: ԫ, reason: contains not printable characters */
    public C4932 f10501;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final C2400 f10500 = new C2400();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final C4830 f10497 = new C4830();

    @Deprecated
    public C2869(File file, long j) {
        this.f10498 = file;
        this.f10499 = j;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static InterfaceC3238 m10206(File file, long j) {
        return new C2869(file, j);
    }

    @Override // defpackage.InterfaceC3238
    /* renamed from: Ϳ, reason: contains not printable characters */
    public File mo10207(InterfaceC3773 interfaceC3773) {
        String strM14564 = this.f10497.m14564(interfaceC3773);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + strM14564 + " for for Key: " + interfaceC3773);
        }
        try {
            C4932.C4937 c4937M14681 = m10209().m14681(strM14564);
            if (c4937M14681 != null) {
                return c4937M14681.m14710(0);
            }
            return null;
        } catch (IOException e2) {
            if (!Log.isLoggable("DiskLruCacheWrapper", 5)) {
                return null;
            }
            Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e2);
            return null;
        }
    }

    @Override // defpackage.InterfaceC3238
    /* renamed from: Ԩ, reason: contains not printable characters */
    public void mo10208(InterfaceC3773 interfaceC3773, InterfaceC3238.InterfaceC3240 interfaceC3240) {
        C4932 c4932M10209;
        String strM14564 = this.f10497.m14564(interfaceC3773);
        this.f10500.m8892(strM14564);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + strM14564 + " for for Key: " + interfaceC3773);
            }
            try {
                c4932M10209 = m10209();
            } catch (IOException e2) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e2);
                }
            }
            if (c4932M10209.m14681(strM14564) != null) {
                return;
            }
            C4932.C4935 c4935M14679 = c4932M10209.m14679(strM14564);
            if (c4935M14679 == null) {
                throw new IllegalStateException("Had two simultaneous puts for: " + strM14564);
            }
            try {
                if (interfaceC3240.mo10903(c4935M14679.m14695(0))) {
                    c4935M14679.m14694();
                }
                c4935M14679.m14693();
            } catch (Throwable th) {
                c4935M14679.m14693();
                throw th;
            }
        } finally {
            this.f10500.m8893(strM14564);
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final synchronized C4932 m10209() throws IOException {
        if (this.f10501 == null) {
            this.f10501 = C4932.m14674(this.f10498, 1, 1, this.f10499);
        }
        return this.f10501;
    }
}
