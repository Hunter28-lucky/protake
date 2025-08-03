package defpackage;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: GifHeaderParser.java */
/* renamed from: Ȅ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2512 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public ByteBuffer f9316;

    /* renamed from: ԩ, reason: contains not printable characters */
    public C2883 f9317;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final byte[] f9315 = new byte[256];

    /* renamed from: Ԫ, reason: contains not printable characters */
    public int f9318 = 0;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m9264() {
        this.f9316 = null;
        this.f9317 = null;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final boolean m9265() {
        return this.f9317.f10551 != 0;
    }

    @NonNull
    /* renamed from: ԩ, reason: contains not printable characters */
    public C2883 m9266() {
        if (this.f9316 == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (m9265()) {
            return this.f9317;
        }
        m9274();
        if (!m9265()) {
            m9271();
            C2883 c2883 = this.f9317;
            if (c2883.f10552 < 0) {
                c2883.f10551 = 1;
            }
        }
        return this.f9317;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final int m9267() {
        try {
            return this.f9316.get() & ExifInterface.MARKER;
        } catch (Exception unused) {
            this.f9317.f10551 = 1;
            return 0;
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m9268() {
        this.f9317.f10553.f14202 = m9277();
        this.f9317.f10553.f14203 = m9277();
        this.f9317.f10553.f14204 = m9277();
        this.f9317.f10553.f14205 = m9277();
        int iM9267 = m9267();
        boolean z = (iM9267 & 128) != 0;
        int iPow = (int) Math.pow(2.0d, (iM9267 & 7) + 1);
        C4082 c4082 = this.f9317.f10553;
        c4082.f14206 = (iM9267 & 64) != 0;
        if (z) {
            c4082.f14212 = m9270(iPow);
        } else {
            c4082.f14212 = null;
        }
        this.f9317.f10553.f14211 = this.f9316.position();
        m9281();
        if (m9265()) {
            return;
        }
        C2883 c2883 = this.f9317;
        c2883.f10552++;
        c2883.f10554.add(c2883.f10553);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m9269() {
        int iM9267 = m9267();
        this.f9318 = iM9267;
        if (iM9267 <= 0) {
            return;
        }
        int i = 0;
        int i2 = 0;
        while (true) {
            try {
                i2 = this.f9318;
                if (i >= i2) {
                    return;
                }
                i2 -= i;
                this.f9316.get(this.f9315, i, i2);
                i += i2;
            } catch (Exception e2) {
                if (Log.isLoggable("GifHeaderParser", 3)) {
                    Log.d("GifHeaderParser", "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.f9318, e2);
                }
                this.f9317.f10551 = 1;
                return;
            }
        }
    }

    @Nullable
    /* renamed from: ԭ, reason: contains not printable characters */
    public final int[] m9270(int i) {
        byte[] bArr = new byte[i * 3];
        int[] iArr = null;
        try {
            this.f9316.get(bArr);
            iArr = new int[256];
            int i2 = 0;
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                int i5 = i4 + 1;
                int i6 = i5 + 1;
                int i7 = i2 + 1;
                iArr[i2] = ((bArr[i3] & ExifInterface.MARKER) << 16) | ViewCompat.MEASURED_STATE_MASK | ((bArr[i4] & ExifInterface.MARKER) << 8) | (bArr[i5] & ExifInterface.MARKER);
                i3 = i6;
                i2 = i7;
            }
        } catch (BufferUnderflowException e2) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e2);
            }
            this.f9317.f10551 = 1;
        }
        return iArr;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final void m9271() {
        m9272(Integer.MAX_VALUE);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final void m9272(int i) {
        boolean z = false;
        while (!z && !m9265() && this.f9317.f10552 <= i) {
            int iM9267 = m9267();
            if (iM9267 == 33) {
                int iM92672 = m9267();
                if (iM92672 == 1) {
                    m9280();
                } else if (iM92672 == 249) {
                    this.f9317.f10553 = new C4082();
                    m9273();
                } else if (iM92672 == 254) {
                    m9280();
                } else if (iM92672 != 255) {
                    m9280();
                } else {
                    m9269();
                    StringBuilder sb = new StringBuilder();
                    for (int i2 = 0; i2 < 11; i2++) {
                        sb.append((char) this.f9315[i2]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        m9276();
                    } else {
                        m9280();
                    }
                }
            } else if (iM9267 == 44) {
                C2883 c2883 = this.f9317;
                if (c2883.f10553 == null) {
                    c2883.f10553 = new C4082();
                }
                m9268();
            } else if (iM9267 != 59) {
                this.f9317.f10551 = 1;
            } else {
                z = true;
            }
        }
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final void m9273() {
        m9267();
        int iM9267 = m9267();
        C4082 c4082 = this.f9317.f10553;
        int i = (iM9267 & 28) >> 2;
        c4082.f14208 = i;
        if (i == 0) {
            c4082.f14208 = 1;
        }
        c4082.f14207 = (iM9267 & 1) != 0;
        int iM9277 = m9277();
        if (iM9277 < 2) {
            iM9277 = 10;
        }
        C4082 c40822 = this.f9317.f10553;
        c40822.f14210 = iM9277 * 10;
        c40822.f14209 = m9267();
        m9267();
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m9274() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            sb.append((char) m9267());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f9317.f10551 = 1;
            return;
        }
        m9275();
        if (!this.f9317.f10557 || m9265()) {
            return;
        }
        C2883 c2883 = this.f9317;
        c2883.f10550 = m9270(c2883.f10558);
        C2883 c28832 = this.f9317;
        c28832.f10561 = c28832.f10550[c28832.f10559];
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m9275() {
        this.f9317.f10555 = m9277();
        this.f9317.f10556 = m9277();
        int iM9267 = m9267();
        C2883 c2883 = this.f9317;
        c2883.f10557 = (iM9267 & 128) != 0;
        c2883.f10558 = (int) Math.pow(2.0d, (iM9267 & 7) + 1);
        this.f9317.f10559 = m9267();
        this.f9317.f10560 = m9267();
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m9276() {
        do {
            m9269();
            byte[] bArr = this.f9315;
            if (bArr[0] == 1) {
                this.f9317.f10562 = ((bArr[2] & ExifInterface.MARKER) << 8) | (bArr[1] & ExifInterface.MARKER);
            }
            if (this.f9318 <= 0) {
                return;
            }
        } while (!m9265());
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final int m9277() {
        return this.f9316.getShort();
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final void m9278() {
        this.f9316 = null;
        Arrays.fill(this.f9315, (byte) 0);
        this.f9317 = new C2883();
        this.f9318 = 0;
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public C2512 m9279(@NonNull ByteBuffer byteBuffer) {
        m9278();
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f9316 = byteBufferAsReadOnlyBuffer;
        byteBufferAsReadOnlyBuffer.position(0);
        this.f9316.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m9280() {
        int iM9267;
        do {
            iM9267 = m9267();
            this.f9316.position(Math.min(this.f9316.position() + iM9267, this.f9316.limit()));
        } while (iM9267 > 0);
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final void m9281() {
        m9267();
        m9280();
    }
}
