package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: ResourceRecycler.java */
/* renamed from: ස, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4849 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean f16371;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final Handler f16372 = new Handler(Looper.getMainLooper(), new C4850());

    /* compiled from: ResourceRecycler.java */
    /* renamed from: ස$Ϳ, reason: contains not printable characters */
    public static final class C4850 implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((InterfaceC4536) message.obj).recycle();
            return true;
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m14580(InterfaceC4536<?> interfaceC4536) {
        j5.m7084();
        if (this.f16371) {
            this.f16372.obtainMessage(1, interfaceC4536).sendToTarget();
            return;
        }
        this.f16371 = true;
        interfaceC4536.recycle();
        this.f16371 = false;
    }
}
