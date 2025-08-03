package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.resource.bitmap.C1835;
import defpackage.C3475;
import defpackage.C4381;
import defpackage.C5068;
import defpackage.InterfaceC2731;
import defpackage.InterfaceC3907;
import defpackage.InterfaceC4536;
import defpackage.InterfaceC4950;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamBitmapDecoder.java */
/* renamed from: com.bumptech.glide.load.resource.bitmap.Ԩ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C1838 implements InterfaceC3907<InputStream, Bitmap> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final C1835 f5387;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final InterfaceC4950 f5388;

    /* compiled from: StreamBitmapDecoder.java */
    /* renamed from: com.bumptech.glide.load.resource.bitmap.Ԩ$Ϳ, reason: contains not printable characters */
    public static class C1839 implements C1835.InterfaceC1837 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final RecyclableBufferedInputStream f5389;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final C5068 f5390;

        public C1839(RecyclableBufferedInputStream recyclableBufferedInputStream, C5068 c5068) {
            this.f5389 = recyclableBufferedInputStream;
            this.f5390 = c5068;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.C1835.InterfaceC1837
        /* renamed from: Ϳ */
        public void mo5015() {
            this.f5389.m4992();
        }

        @Override // com.bumptech.glide.load.resource.bitmap.C1835.InterfaceC1837
        /* renamed from: Ԩ */
        public void mo5016(InterfaceC2731 interfaceC2731, Bitmap bitmap) throws IOException {
            IOException iOExceptionM14881 = this.f5390.m14881();
            if (iOExceptionM14881 != null) {
                if (bitmap == null) {
                    throw iOExceptionM14881;
                }
                interfaceC2731.mo9428(bitmap);
                throw iOExceptionM14881;
            }
        }
    }

    public C1838(C1835 c1835, InterfaceC4950 interfaceC4950) {
        this.f5387 = c1835;
        this.f5388 = interfaceC4950;
    }

    @Override // defpackage.InterfaceC3907
    /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public InterfaceC4536<Bitmap> mo5018(@NonNull InputStream inputStream, int i, int i2, @NonNull C3475 c3475) throws IOException {
        boolean z;
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z = false;
        } else {
            z = true;
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.f5388);
        }
        C5068 c5068M14880 = C5068.m14880(recyclableBufferedInputStream);
        try {
            return this.f5387.m5010(new C4381(c5068M14880), i, i2, c3475, new C1839(recyclableBufferedInputStream, c5068M14880));
        } finally {
            c5068M14880.release();
            if (z) {
                recyclableBufferedInputStream.release();
            }
        }
    }

    @Override // defpackage.InterfaceC3907
    /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public boolean mo5017(@NonNull InputStream inputStream, @NonNull C3475 c3475) {
        return this.f5387.m5012(inputStream);
    }
}
