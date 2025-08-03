package kotlinx.coroutines.flow;

import defpackage.C5199;
import defpackage.InterfaceC3421;
import defpackage.InterfaceC4230;
import defpackage.InterfaceC4355;
import defpackage.i4;

/* compiled from: Channels.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class FlowKt__ChannelsKt {
    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final <T> Object m7358(InterfaceC3421<? super T> interfaceC3421, InterfaceC4230<? extends T> interfaceC4230, InterfaceC4355<? super i4> interfaceC4355) throws Throwable {
        Object objM7359 = m7359(interfaceC3421, interfaceC4230, true, interfaceC4355);
        return objM7359 == C5199.m15170() ? objM7359 : i4.f6762;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x006b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0076 A[Catch: all -> 0x0055, TRY_LEAVE, TryCatch #0 {all -> 0x0055, blocks: (B:13:0x0032, B:28:0x0070, B:30:0x0076, B:36:0x0084, B:37:0x0085, B:18:0x004b), top: B:47:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0085 A[Catch: all -> 0x0055, TRY_LEAVE, TryCatch #0 {all -> 0x0055, blocks: (B:13:0x0032, B:28:0x0070, B:30:0x0076, B:36:0x0084, B:37:0x0085, B:18:0x004b), top: B:47:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r7v0, types: [؋, ؋<? super T>] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v17, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v18, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v24 */
    /* JADX WARN: Type inference failed for: r7v25 */
    /* JADX WARN: Type inference failed for: r7v3, types: [boolean] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.lang.Object, ؋] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x0095 -> B:14:0x0035). Please report as a decompilation issue!!! */
    /* renamed from: ԩ, reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T> java.lang.Object m7359(defpackage.InterfaceC3421<? super T> r7, defpackage.InterfaceC4230<? extends T> r8, boolean r9, defpackage.InterfaceC4355<? super defpackage.i4> r10) throws java.lang.Throwable {
        /*
            boolean r0 = r10 instanceof kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            if (r0 == 0) goto L13
            r0 = r10
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = (kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1 r0 = new kotlinx.coroutines.flow.FlowKt__ChannelsKt$emitAllImpl$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = defpackage.C5199.m15170()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L57
            if (r2 == r4) goto L41
            if (r2 != r3) goto L39
            boolean r7 = r0.Z$0
            java.lang.Object r8 = r0.L$1
            ਇ r8 = (defpackage.InterfaceC4230) r8
            java.lang.Object r9 = r0.L$0
            ؋ r9 = (defpackage.InterfaceC3421) r9
            defpackage.C4817.m14542(r10)     // Catch: java.lang.Throwable -> L55
        L35:
            r6 = r9
            r9 = r7
            r7 = r6
            goto L5d
        L39:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L41:
            boolean r7 = r0.Z$0
            java.lang.Object r8 = r0.L$1
            ਇ r8 = (defpackage.InterfaceC4230) r8
            java.lang.Object r9 = r0.L$0
            ؋ r9 = (defpackage.InterfaceC3421) r9
            defpackage.C4817.m14542(r10)     // Catch: java.lang.Throwable -> L55
            ļ r10 = (defpackage.C2351) r10     // Catch: java.lang.Throwable -> L55
            java.lang.Object r10 = r10.m8807()     // Catch: java.lang.Throwable -> L55
            goto L6f
        L55:
            r9 = move-exception
            goto L9c
        L57:
            defpackage.C4817.m14542(r10)
            defpackage.C3743.m11992(r7)
        L5d:
            r0.L$0 = r7     // Catch: java.lang.Throwable -> L98
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L98
            r0.Z$0 = r9     // Catch: java.lang.Throwable -> L98
            r0.label = r4     // Catch: java.lang.Throwable -> L98
            java.lang.Object r10 = r8.mo7332(r0)     // Catch: java.lang.Throwable -> L98
            if (r10 != r1) goto L6c
            return r1
        L6c:
            r6 = r9
            r9 = r7
            r7 = r6
        L6f:
            r2 = 0
            boolean r5 = defpackage.C2351.m8805(r10)     // Catch: java.lang.Throwable -> L55
            if (r5 == 0) goto L85
            java.lang.Throwable r9 = defpackage.C2351.m8802(r10)     // Catch: java.lang.Throwable -> L55
            if (r9 != 0) goto L84
            if (r7 == 0) goto L81
            defpackage.C5019.m14808(r8, r2)
        L81:
            i4 r7 = defpackage.i4.f6762
            return r7
        L84:
            throw r9     // Catch: java.lang.Throwable -> L55
        L85:
            java.lang.Object r10 = defpackage.C2351.m8803(r10)     // Catch: java.lang.Throwable -> L55
            r0.L$0 = r9     // Catch: java.lang.Throwable -> L55
            r0.L$1 = r8     // Catch: java.lang.Throwable -> L55
            r0.Z$0 = r7     // Catch: java.lang.Throwable -> L55
            r0.label = r3     // Catch: java.lang.Throwable -> L55
            java.lang.Object r10 = r9.emit(r10, r0)     // Catch: java.lang.Throwable -> L55
            if (r10 != r1) goto L35
            return r1
        L98:
            r7 = move-exception
            r6 = r9
            r9 = r7
            r7 = r6
        L9c:
            throw r9     // Catch: java.lang.Throwable -> L9d
        L9d:
            r10 = move-exception
            if (r7 == 0) goto La3
            defpackage.C5019.m14808(r8, r9)
        La3:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ChannelsKt.m7359(؋, ਇ, boolean, ન):java.lang.Object");
    }
}
