package defpackage;

import java.lang.reflect.InvocationTargetException;
import kotlinx.coroutines.CoroutinesInternalError;

/* compiled from: DispatchedTask.kt */
/* renamed from: п, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC2893<T> extends g1 {

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f10568;

    public AbstractC2893(int i) {
        this.f10568 = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0081 A[Catch: all -> 0x00ae, DONT_GENERATE, TRY_LEAVE, TryCatch #3 {all -> 0x00ae, blocks: (B:3:0x0002, B:5:0x0019, B:23:0x007b, B:25:0x0081, B:33:0x00a4, B:36:0x00ad, B:35:0x00aa, B:8:0x001f, B:10:0x002d, B:12:0x0035, B:15:0x0041, B:17:0x0047, B:21:0x0077, B:19:0x005e, B:20:0x006c), top: B:50:0x0002, inners: #0 }] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void run() throws java.lang.IllegalAccessException, java.lang.IllegalArgumentException, java.lang.reflect.InvocationTargetException {
        /*
            r10 = this;
            h1 r0 = r10.f6646
            ન r1 = r10.mo8694()     // Catch: java.lang.Throwable -> Lae
            ĉ r1 = (defpackage.C2317) r1     // Catch: java.lang.Throwable -> Lae
            ન<T> r2 = r1.f8804     // Catch: java.lang.Throwable -> Lae
            java.lang.Object r1 = r1.f8806     // Catch: java.lang.Throwable -> Lae
            kotlin.coroutines.CoroutineContext r3 = r2.getContext()     // Catch: java.lang.Throwable -> Lae
            java.lang.Object r1 = kotlinx.coroutines.internal.ThreadContextKt.m7372(r3, r1)     // Catch: java.lang.Throwable -> Lae
            r0 r4 = kotlinx.coroutines.internal.ThreadContextKt.f7879     // Catch: java.lang.Throwable -> Lae
            r5 = 0
            if (r1 == r4) goto L1e
            f4 r4 = defpackage.C3079.m10653(r2, r3, r1)     // Catch: java.lang.Throwable -> Lae
            goto L1f
        L1e:
            r4 = r5
        L1f:
            kotlin.coroutines.CoroutineContext r6 = r2.getContext()     // Catch: java.lang.Throwable -> La1
            java.lang.Object r7 = r10.mo8695()     // Catch: java.lang.Throwable -> La1
            java.lang.Throwable r8 = r10.mo10261(r7)     // Catch: java.lang.Throwable -> La1
            if (r8 != 0) goto L3e
            int r9 = r10.f10568     // Catch: java.lang.Throwable -> La1
            boolean r9 = defpackage.C3490.m11406(r9)     // Catch: java.lang.Throwable -> La1
            if (r9 == 0) goto L3e
            Ⴠ$Ԩ r9 = defpackage.InterfaceC5238.f17362     // Catch: java.lang.Throwable -> La1
            kotlin.coroutines.CoroutineContext$Ϳ r6 = r6.get(r9)     // Catch: java.lang.Throwable -> La1
            Ⴠ r6 = (defpackage.InterfaceC5238) r6     // Catch: java.lang.Throwable -> La1
            goto L3f
        L3e:
            r6 = r5
        L3f:
            if (r6 == 0) goto L5c
            boolean r9 = r6.mo9831()     // Catch: java.lang.Throwable -> La1
            if (r9 != 0) goto L5c
            java.util.concurrent.CancellationException r6 = r6.mo9834()     // Catch: java.lang.Throwable -> La1
            r10.mo8693(r7, r6)     // Catch: java.lang.Throwable -> La1
            kotlin.Result$Ϳ r7 = kotlin.Result.f7828     // Catch: java.lang.Throwable -> La1
            java.lang.Object r6 = defpackage.C4817.m14541(r6)     // Catch: java.lang.Throwable -> La1
            java.lang.Object r6 = kotlin.Result.m7211(r6)     // Catch: java.lang.Throwable -> La1
            r2.resumeWith(r6)     // Catch: java.lang.Throwable -> La1
            goto L77
        L5c:
            if (r8 == 0) goto L6c
            kotlin.Result$Ϳ r6 = kotlin.Result.f7828     // Catch: java.lang.Throwable -> La1
            java.lang.Object r6 = defpackage.C4817.m14541(r8)     // Catch: java.lang.Throwable -> La1
            java.lang.Object r6 = kotlin.Result.m7211(r6)     // Catch: java.lang.Throwable -> La1
            r2.resumeWith(r6)     // Catch: java.lang.Throwable -> La1
            goto L77
        L6c:
            java.lang.Object r6 = r10.mo10262(r7)     // Catch: java.lang.Throwable -> La1
            java.lang.Object r6 = kotlin.Result.m7211(r6)     // Catch: java.lang.Throwable -> La1
            r2.resumeWith(r6)     // Catch: java.lang.Throwable -> La1
        L77:
            i4 r2 = defpackage.i4.f6762     // Catch: java.lang.Throwable -> La1
            if (r4 == 0) goto L81
            boolean r2 = r4.m6050()     // Catch: java.lang.Throwable -> Lae
            if (r2 == 0) goto L84
        L81:
            kotlinx.coroutines.internal.ThreadContextKt.m7370(r3, r1)     // Catch: java.lang.Throwable -> Lae
        L84:
            r0.mo6177()     // Catch: java.lang.Throwable -> L8e
            i4 r0 = defpackage.i4.f6762     // Catch: java.lang.Throwable -> L8e
            java.lang.Object r0 = kotlin.Result.m7211(r0)     // Catch: java.lang.Throwable -> L8e
            goto L99
        L8e:
            r0 = move-exception
            kotlin.Result$Ϳ r1 = kotlin.Result.f7828
            java.lang.Object r0 = defpackage.C4817.m14541(r0)
            java.lang.Object r0 = kotlin.Result.m7211(r0)
        L99:
            java.lang.Throwable r0 = kotlin.Result.m7213(r0)
            r10.m10263(r5, r0)
            goto Lcd
        La1:
            r2 = move-exception
            if (r4 == 0) goto Laa
            boolean r4 = r4.m6050()     // Catch: java.lang.Throwable -> Lae
            if (r4 == 0) goto Lad
        Laa:
            kotlinx.coroutines.internal.ThreadContextKt.m7370(r3, r1)     // Catch: java.lang.Throwable -> Lae
        Lad:
            throw r2     // Catch: java.lang.Throwable -> Lae
        Lae:
            r1 = move-exception
            kotlin.Result$Ϳ r2 = kotlin.Result.f7828     // Catch: java.lang.Throwable -> Lbb
            r0.mo6177()     // Catch: java.lang.Throwable -> Lbb
            i4 r0 = defpackage.i4.f6762     // Catch: java.lang.Throwable -> Lbb
            java.lang.Object r0 = kotlin.Result.m7211(r0)     // Catch: java.lang.Throwable -> Lbb
            goto Lc6
        Lbb:
            r0 = move-exception
            kotlin.Result$Ϳ r2 = kotlin.Result.f7828
            java.lang.Object r0 = defpackage.C4817.m14541(r0)
            java.lang.Object r0 = kotlin.Result.m7211(r0)
        Lc6:
            java.lang.Throwable r0 = kotlin.Result.m7213(r0)
            r10.m10263(r1, r0)
        Lcd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.AbstractC2893.run():void");
    }

    /* renamed from: Ϳ */
    public void mo8693(Object obj, Throwable th) {
    }

    /* renamed from: Ԩ */
    public abstract InterfaceC4355<T> mo8694();

    /* renamed from: Ԫ, reason: contains not printable characters */
    public Throwable mo10261(Object obj) {
        C2823 c2823 = obj instanceof C2823 ? (C2823) obj : null;
        if (c2823 == null) {
            return null;
        }
        return c2823.f10293;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: Ԭ, reason: contains not printable characters */
    public <T> T mo10262(Object obj) {
        return obj;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m10263(Throwable th, Throwable th2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (th == null && th2 == null) {
            return;
        }
        if (th != null && th2 != null) {
            C4147.m13130(th, th2);
        }
        if (th == null) {
            th = th2;
        }
        C3921.m12664(th);
        C4084.m13020(mo8694().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
    }

    /* renamed from: Ԯ */
    public abstract Object mo8695();
}
