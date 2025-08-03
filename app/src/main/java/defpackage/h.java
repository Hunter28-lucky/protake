package defpackage;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import defpackage.InterfaceC3507;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: StandardGifDecoder.java */
/* loaded from: classes.dex */
public class h implements InterfaceC3507 {

    /* renamed from: ކ, reason: contains not printable characters */
    public static final String f6662 = "h";

    /* renamed from: Ϳ, reason: contains not printable characters */
    @ColorInt
    public int[] f6663;

    /* renamed from: Ԩ, reason: contains not printable characters */
    @ColorInt
    public final int[] f6664;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final InterfaceC3507.InterfaceC3508 f6665;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public ByteBuffer f6666;

    /* renamed from: ԫ, reason: contains not printable characters */
    public byte[] f6667;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public short[] f6668;

    /* renamed from: ԭ, reason: contains not printable characters */
    public byte[] f6669;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public byte[] f6670;

    /* renamed from: ԯ, reason: contains not printable characters */
    public byte[] f6671;

    /* renamed from: ՠ, reason: contains not printable characters */
    @ColorInt
    public int[] f6672;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f6673;

    /* renamed from: ֏, reason: contains not printable characters */
    public C2883 f6674;

    /* renamed from: ׯ, reason: contains not printable characters */
    public Bitmap f6675;

    /* renamed from: ؠ, reason: contains not printable characters */
    public boolean f6676;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f6677;

    /* renamed from: ށ, reason: contains not printable characters */
    public int f6678;

    /* renamed from: ނ, reason: contains not printable characters */
    public int f6679;

    /* renamed from: ރ, reason: contains not printable characters */
    public int f6680;

    /* renamed from: ބ, reason: contains not printable characters */
    @Nullable
    public Boolean f6681;

    /* renamed from: ޅ, reason: contains not printable characters */
    @NonNull
    public Bitmap.Config f6682;

    public h(@NonNull InterfaceC3507.InterfaceC3508 interfaceC3508, C2883 c2883, ByteBuffer byteBuffer, int i) {
        this(interfaceC3508);
        m6123(c2883, byteBuffer, i);
    }

    @Override // defpackage.InterfaceC3507
    public void clear() {
        this.f6674 = null;
        byte[] bArr = this.f6671;
        if (bArr != null) {
            this.f6665.mo11449(bArr);
        }
        int[] iArr = this.f6672;
        if (iArr != null) {
            this.f6665.mo11451(iArr);
        }
        Bitmap bitmap = this.f6675;
        if (bitmap != null) {
            this.f6665.mo11448(bitmap);
        }
        this.f6675 = null;
        this.f6666 = null;
        this.f6681 = null;
        byte[] bArr2 = this.f6667;
        if (bArr2 != null) {
            this.f6665.mo11449(bArr2);
        }
    }

    @Override // defpackage.InterfaceC3507
    @Nullable
    /* renamed from: Ϳ, reason: contains not printable characters */
    public synchronized Bitmap mo6106() {
        if (this.f6674.f10552 <= 0 || this.f6673 < 0) {
            String str = f6662;
            if (Log.isLoggable(str, 3)) {
                Log.d(str, "Unable to decode frame, frameCount=" + this.f6674.f10552 + ", framePointer=" + this.f6673);
            }
            this.f6677 = 1;
        }
        int i = this.f6677;
        if (i != 1 && i != 2) {
            this.f6677 = 0;
            if (this.f6667 == null) {
                this.f6667 = this.f6665.mo11450(255);
            }
            C4082 c4082 = this.f6674.f10554.get(this.f6673);
            int i2 = this.f6673 - 1;
            C4082 c40822 = i2 >= 0 ? this.f6674.f10554.get(i2) : null;
            int[] iArr = c4082.f14212;
            if (iArr == null) {
                iArr = this.f6674.f10550;
            }
            this.f6663 = iArr;
            if (iArr != null) {
                if (c4082.f14207) {
                    System.arraycopy(iArr, 0, this.f6664, 0, iArr.length);
                    int[] iArr2 = this.f6664;
                    this.f6663 = iArr2;
                    iArr2[c4082.f14209] = 0;
                }
                return m6124(c4082, c40822);
            }
            String str2 = f6662;
            if (Log.isLoggable(str2, 3)) {
                Log.d(str2, "No valid color table found for frame #" + this.f6673);
            }
            this.f6677 = 1;
            return null;
        }
        String str3 = f6662;
        if (Log.isLoggable(str3, 3)) {
            Log.d(str3, "Unable to decode frame, status=" + this.f6677);
        }
        return null;
    }

    @Override // defpackage.InterfaceC3507
    /* renamed from: Ԩ, reason: contains not printable characters */
    public void mo6107() {
        this.f6673 = (this.f6673 + 1) % this.f6674.f10552;
    }

    @Override // defpackage.InterfaceC3507
    /* renamed from: ԩ, reason: contains not printable characters */
    public int mo6108() {
        return this.f6674.f10552;
    }

    @Override // defpackage.InterfaceC3507
    /* renamed from: Ԫ, reason: contains not printable characters */
    public int mo6109() {
        int i;
        if (this.f6674.f10552 <= 0 || (i = this.f6673) < 0) {
            return 0;
        }
        return m6119(i);
    }

    @Override // defpackage.InterfaceC3507
    /* renamed from: ԫ, reason: contains not printable characters */
    public void mo6110(@NonNull Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888 || config == Bitmap.Config.RGB_565) {
            this.f6682 = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888 + " or " + Bitmap.Config.RGB_565);
    }

    @Override // defpackage.InterfaceC3507
    @NonNull
    /* renamed from: Ԭ, reason: contains not printable characters */
    public ByteBuffer mo6111() {
        return this.f6666;
    }

    @Override // defpackage.InterfaceC3507
    /* renamed from: ԭ, reason: contains not printable characters */
    public void mo6112() {
        this.f6673 = -1;
    }

    @Override // defpackage.InterfaceC3507
    /* renamed from: Ԯ, reason: contains not printable characters */
    public int mo6113() {
        return this.f6673;
    }

    @Override // defpackage.InterfaceC3507
    /* renamed from: ԯ, reason: contains not printable characters */
    public int mo6114() {
        return this.f6666.limit() + this.f6671.length + (this.f6672.length * 4);
    }

    @ColorInt
    /* renamed from: ՠ, reason: contains not printable characters */
    public final int m6115(int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = i; i9 < this.f6678 + i; i9++) {
            byte[] bArr = this.f6671;
            if (i9 >= bArr.length || i9 >= i2) {
                break;
            }
            int i10 = this.f6663[bArr[i9] & ExifInterface.MARKER];
            if (i10 != 0) {
                i4 += (i10 >> 24) & 255;
                i5 += (i10 >> 16) & 255;
                i6 += (i10 >> 8) & 255;
                i7 += i10 & 255;
                i8++;
            }
        }
        int i11 = i + i3;
        for (int i12 = i11; i12 < this.f6678 + i11; i12++) {
            byte[] bArr2 = this.f6671;
            if (i12 >= bArr2.length || i12 >= i2) {
                break;
            }
            int i13 = this.f6663[bArr2[i12] & ExifInterface.MARKER];
            if (i13 != 0) {
                i4 += (i13 >> 24) & 255;
                i5 += (i13 >> 16) & 255;
                i6 += (i13 >> 8) & 255;
                i7 += i13 & 255;
                i8++;
            }
        }
        if (i8 == 0) {
            return 0;
        }
        return ((i4 / i8) << 24) | ((i5 / i8) << 16) | ((i6 / i8) << 8) | (i7 / i8);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final void m6116(C4082 c4082) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr = this.f6672;
        int i6 = c4082.f14205;
        int i7 = this.f6678;
        int i8 = i6 / i7;
        int i9 = c4082.f14203 / i7;
        int i10 = c4082.f14204 / i7;
        int i11 = c4082.f14202 / i7;
        boolean z = this.f6673 == 0;
        int i12 = this.f6680;
        int i13 = this.f6679;
        byte[] bArr = this.f6671;
        int[] iArr2 = this.f6663;
        Boolean bool = this.f6681;
        int i14 = 8;
        int i15 = 0;
        int i16 = 0;
        int i17 = 1;
        while (i15 < i8) {
            Boolean bool2 = bool;
            if (c4082.f14206) {
                if (i16 >= i8) {
                    i = i8;
                    int i18 = i17 + 1;
                    if (i18 == 2) {
                        i17 = i18;
                        i16 = 4;
                    } else if (i18 == 3) {
                        i17 = i18;
                        i14 = 4;
                        i16 = 2;
                    } else if (i18 != 4) {
                        i17 = i18;
                    } else {
                        i17 = i18;
                        i16 = 1;
                        i14 = 2;
                    }
                } else {
                    i = i8;
                }
                i2 = i16 + i14;
            } else {
                i = i8;
                i2 = i16;
                i16 = i15;
            }
            int i19 = i16 + i9;
            boolean z2 = i7 == 1;
            if (i19 < i13) {
                int i20 = i19 * i12;
                int i21 = i20 + i11;
                int i22 = i21 + i10;
                int i23 = i20 + i12;
                if (i23 < i22) {
                    i22 = i23;
                }
                i3 = i2;
                int i24 = i15 * i7 * c4082.f14204;
                if (z2) {
                    int i25 = i21;
                    while (i25 < i22) {
                        int i26 = i9;
                        int i27 = iArr2[bArr[i24] & ExifInterface.MARKER];
                        if (i27 != 0) {
                            iArr[i25] = i27;
                        } else if (z && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i24 += i7;
                        i25++;
                        i9 = i26;
                    }
                } else {
                    i5 = i9;
                    int i28 = ((i22 - i21) * i7) + i24;
                    int i29 = i21;
                    while (true) {
                        i4 = i10;
                        if (i29 < i22) {
                            int iM6115 = m6115(i24, i28, c4082.f14204);
                            if (iM6115 != 0) {
                                iArr[i29] = iM6115;
                            } else if (z && bool2 == null) {
                                bool2 = Boolean.TRUE;
                            }
                            i24 += i7;
                            i29++;
                            i10 = i4;
                        }
                    }
                    bool = bool2;
                    i15++;
                    i9 = i5;
                    i10 = i4;
                    i8 = i;
                    i16 = i3;
                }
            } else {
                i3 = i2;
            }
            i5 = i9;
            i4 = i10;
            bool = bool2;
            i15++;
            i9 = i5;
            i10 = i4;
            i8 = i;
            i16 = i3;
        }
        Boolean bool3 = bool;
        if (this.f6681 == null) {
            this.f6681 = Boolean.valueOf(bool3 == null ? false : bool3.booleanValue());
        }
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m6117(C4082 c4082) {
        C4082 c40822 = c4082;
        int[] iArr = this.f6672;
        int i = c40822.f14205;
        int i2 = c40822.f14203;
        int i3 = c40822.f14204;
        int i4 = c40822.f14202;
        boolean z = this.f6673 == 0;
        int i5 = this.f6680;
        byte[] bArr = this.f6671;
        int[] iArr2 = this.f6663;
        int i6 = 0;
        byte b = -1;
        while (i6 < i) {
            int i7 = (i6 + i2) * i5;
            int i8 = i7 + i4;
            int i9 = i8 + i3;
            int i10 = i7 + i5;
            if (i10 < i9) {
                i9 = i10;
            }
            int i11 = c40822.f14204 * i6;
            int i12 = i8;
            while (i12 < i9) {
                byte b2 = bArr[i11];
                int i13 = i;
                int i14 = b2 & ExifInterface.MARKER;
                if (i14 != b) {
                    int i15 = iArr2[i14];
                    if (i15 != 0) {
                        iArr[i12] = i15;
                    } else {
                        b = b2;
                    }
                }
                i11++;
                i12++;
                i = i13;
            }
            i6++;
            c40822 = c4082;
        }
        this.f6681 = Boolean.valueOf(this.f6681 == null && z && b != -1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v15, types: [short] */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m6118(C4082 c4082) {
        int i;
        int i2;
        short s;
        h hVar = this;
        if (c4082 != null) {
            hVar.f6666.position(c4082.f14211);
        }
        if (c4082 == null) {
            C2883 c2883 = hVar.f6674;
            i = c2883.f10555;
            i2 = c2883.f10556;
        } else {
            i = c4082.f14204;
            i2 = c4082.f14205;
        }
        int i3 = i * i2;
        byte[] bArr = hVar.f6671;
        if (bArr == null || bArr.length < i3) {
            hVar.f6671 = hVar.f6665.mo11450(i3);
        }
        byte[] bArr2 = hVar.f6671;
        if (hVar.f6668 == null) {
            hVar.f6668 = new short[4096];
        }
        short[] sArr = hVar.f6668;
        if (hVar.f6669 == null) {
            hVar.f6669 = new byte[4096];
        }
        byte[] bArr3 = hVar.f6669;
        if (hVar.f6670 == null) {
            hVar.f6670 = new byte[4097];
        }
        byte[] bArr4 = hVar.f6670;
        int iM6122 = m6122();
        int i4 = 1 << iM6122;
        int i5 = i4 + 1;
        int i6 = i4 + 2;
        int i7 = iM6122 + 1;
        int i8 = (1 << i7) - 1;
        int i9 = 0;
        for (int i10 = 0; i10 < i4; i10++) {
            sArr[i10] = 0;
            bArr3[i10] = (byte) i10;
        }
        byte[] bArr5 = hVar.f6667;
        int i11 = i7;
        int i12 = i6;
        int i13 = i8;
        int iM6121 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = -1;
        while (true) {
            if (i9 >= i3) {
                break;
            }
            if (iM6121 == 0) {
                iM6121 = m6121();
                if (iM6121 <= 0) {
                    hVar.f6677 = 3;
                    break;
                }
                i14 = 0;
            }
            i16 += (bArr5[i14] & ExifInterface.MARKER) << i15;
            i14++;
            iM6121--;
            int i21 = i15 + 8;
            int i22 = i12;
            int i23 = i11;
            int i24 = i20;
            int i25 = i7;
            int i26 = i18;
            while (true) {
                if (i21 < i23) {
                    i20 = i24;
                    i12 = i22;
                    i15 = i21;
                    hVar = this;
                    i18 = i26;
                    i7 = i25;
                    i11 = i23;
                    break;
                }
                int i27 = i6;
                int i28 = i16 & i13;
                i16 >>= i23;
                i21 -= i23;
                if (i28 == i4) {
                    i13 = i8;
                    i23 = i25;
                    i22 = i27;
                    i6 = i22;
                    i24 = -1;
                } else {
                    if (i28 == i5) {
                        i15 = i21;
                        i18 = i26;
                        i12 = i22;
                        i7 = i25;
                        i6 = i27;
                        i20 = i24;
                        i11 = i23;
                        hVar = this;
                        break;
                    }
                    if (i24 == -1) {
                        bArr2[i17] = bArr3[i28];
                        i17++;
                        i9++;
                        i24 = i28;
                        i26 = i24;
                        i6 = i27;
                        i21 = i21;
                    } else {
                        if (i28 >= i22) {
                            bArr4[i19] = (byte) i26;
                            i19++;
                            s = i24;
                        } else {
                            s = i28;
                        }
                        while (s >= i4) {
                            bArr4[i19] = bArr3[s];
                            i19++;
                            s = sArr[s];
                        }
                        i26 = bArr3[s] & ExifInterface.MARKER;
                        byte b = (byte) i26;
                        bArr2[i17] = b;
                        while (true) {
                            i17++;
                            i9++;
                            if (i19 <= 0) {
                                break;
                            }
                            i19--;
                            bArr2[i17] = bArr4[i19];
                        }
                        byte[] bArr6 = bArr4;
                        if (i22 < 4096) {
                            sArr[i22] = (short) i24;
                            bArr3[i22] = b;
                            i22++;
                            if ((i22 & i13) == 0 && i22 < 4096) {
                                i23++;
                                i13 += i22;
                            }
                        }
                        i24 = i28;
                        i6 = i27;
                        i21 = i21;
                        bArr4 = bArr6;
                    }
                }
            }
        }
        Arrays.fill(bArr2, i17, i3, (byte) 0);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public int m6119(int i) {
        if (i >= 0) {
            C2883 c2883 = this.f6674;
            if (i < c2883.f10552) {
                return c2883.f10554.get(i).f14210;
            }
        }
        return -1;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final Bitmap m6120() {
        Boolean bool = this.f6681;
        Bitmap bitmapMo11446 = this.f6665.mo11446(this.f6680, this.f6679, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.f6682);
        bitmapMo11446.setHasAlpha(true);
        return bitmapMo11446;
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final int m6121() {
        int iM6122 = m6122();
        if (iM6122 <= 0) {
            return iM6122;
        }
        ByteBuffer byteBuffer = this.f6666;
        byteBuffer.get(this.f6667, 0, Math.min(iM6122, byteBuffer.remaining()));
        return iM6122;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final int m6122() {
        return this.f6666.get() & ExifInterface.MARKER;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public synchronized void m6123(@NonNull C2883 c2883, @NonNull ByteBuffer byteBuffer, int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
        }
        int iHighestOneBit = Integer.highestOneBit(i);
        this.f6677 = 0;
        this.f6674 = c2883;
        this.f6673 = -1;
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f6666 = byteBufferAsReadOnlyBuffer;
        byteBufferAsReadOnlyBuffer.position(0);
        this.f6666.order(ByteOrder.LITTLE_ENDIAN);
        this.f6676 = false;
        Iterator<C4082> it = c2883.f10554.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (it.next().f14208 == 3) {
                this.f6676 = true;
                break;
            }
        }
        this.f6678 = iHighestOneBit;
        int i2 = c2883.f10555;
        this.f6680 = i2 / iHighestOneBit;
        int i3 = c2883.f10556;
        this.f6679 = i3 / iHighestOneBit;
        this.f6671 = this.f6665.mo11450(i2 * i3);
        this.f6672 = this.f6665.mo11447(this.f6680 * this.f6679);
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final Bitmap m6124(C4082 c4082, C4082 c40822) {
        int i;
        int i2;
        Bitmap bitmap;
        int[] iArr = this.f6672;
        int i3 = 0;
        if (c40822 == null) {
            Bitmap bitmap2 = this.f6675;
            if (bitmap2 != null) {
                this.f6665.mo11448(bitmap2);
            }
            this.f6675 = null;
            Arrays.fill(iArr, 0);
        }
        if (c40822 != null && c40822.f14208 == 3 && this.f6675 == null) {
            Arrays.fill(iArr, 0);
        }
        if (c40822 != null && (i2 = c40822.f14208) > 0) {
            if (i2 == 2) {
                if (!c4082.f14207) {
                    C2883 c2883 = this.f6674;
                    int i4 = c2883.f10561;
                    if (c4082.f14212 == null || c2883.f10559 != c4082.f14209) {
                        i3 = i4;
                    }
                } else if (this.f6673 == 0) {
                    this.f6681 = Boolean.TRUE;
                }
                int i5 = c40822.f14205;
                int i6 = this.f6678;
                int i7 = i5 / i6;
                int i8 = c40822.f14203 / i6;
                int i9 = c40822.f14204 / i6;
                int i10 = c40822.f14202 / i6;
                int i11 = this.f6680;
                int i12 = (i8 * i11) + i10;
                int i13 = (i7 * i11) + i12;
                while (i12 < i13) {
                    int i14 = i12 + i9;
                    for (int i15 = i12; i15 < i14; i15++) {
                        iArr[i15] = i3;
                    }
                    i12 += this.f6680;
                }
            } else if (i2 == 3 && (bitmap = this.f6675) != null) {
                int i16 = this.f6680;
                bitmap.getPixels(iArr, 0, i16, 0, 0, i16, this.f6679);
            }
        }
        m6118(c4082);
        if (c4082.f14206 || this.f6678 != 1) {
            m6116(c4082);
        } else {
            m6117(c4082);
        }
        if (this.f6676 && ((i = c4082.f14208) == 0 || i == 1)) {
            if (this.f6675 == null) {
                this.f6675 = m6120();
            }
            Bitmap bitmap3 = this.f6675;
            int i17 = this.f6680;
            bitmap3.setPixels(iArr, 0, i17, 0, 0, i17, this.f6679);
        }
        Bitmap bitmapM6120 = m6120();
        int i18 = this.f6680;
        bitmapM6120.setPixels(iArr, 0, i18, 0, 0, i18, this.f6679);
        return bitmapM6120;
    }

    public h(@NonNull InterfaceC3507.InterfaceC3508 interfaceC3508) {
        this.f6664 = new int[256];
        this.f6682 = Bitmap.Config.ARGB_8888;
        this.f6665 = interfaceC3508;
        this.f6674 = new C2883();
    }
}
