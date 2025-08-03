package okio;

import defpackage.C3921;
import defpackage.InterfaceC2392;
import defpackage.i4;
import org.jcodec.containers.mxf.model.BER;

/* compiled from: Utf8.kt */
/* loaded from: classes2.dex */
public final class Utf8 {
    public static final int HIGH_SURROGATE_HEADER = 55232;
    public static final int LOG_SURROGATE_HEADER = 56320;
    public static final int MASK_2BYTES = 3968;
    public static final int MASK_3BYTES = -123008;
    public static final int MASK_4BYTES = 3678080;
    public static final byte REPLACEMENT_BYTE = 63;
    public static final char REPLACEMENT_CHARACTER = 65533;
    public static final int REPLACEMENT_CODE_POINT = 65533;

    public static final boolean isIsoControl(int i) {
        return (i >= 0 && 31 >= i) || (127 <= i && 159 >= i);
    }

    public static final boolean isUtf8Continuation(byte b) {
        return (b & 192) == 128;
    }

    public static final int process2Utf8Bytes(byte[] bArr, int i, int i2, InterfaceC2392<? super Integer, i4> interfaceC2392) {
        C3921.m12667(bArr, "$this$process2Utf8Bytes");
        C3921.m12667(interfaceC2392, "yield");
        int i3 = i + 1;
        Integer numValueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i2 <= i3) {
            interfaceC2392.invoke(numValueOf);
            return 1;
        }
        byte b = bArr[i];
        byte b2 = bArr[i3];
        if (!((b2 & 192) == 128)) {
            interfaceC2392.invoke(numValueOf);
            return 1;
        }
        int i4 = (b2 ^ BER.ASN_LONG_LEN) ^ (b << 6);
        if (i4 < 128) {
            interfaceC2392.invoke(numValueOf);
            return 2;
        }
        interfaceC2392.invoke(Integer.valueOf(i4));
        return 2;
    }

    public static final int process3Utf8Bytes(byte[] bArr, int i, int i2, InterfaceC2392<? super Integer, i4> interfaceC2392) {
        C3921.m12667(bArr, "$this$process3Utf8Bytes");
        C3921.m12667(interfaceC2392, "yield");
        int i3 = i + 2;
        Integer numValueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i2 <= i3) {
            interfaceC2392.invoke(numValueOf);
            int i4 = i + 1;
            if (i2 > i4) {
                if ((bArr[i4] & 192) == 128) {
                    return 2;
                }
            }
            return 1;
        }
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        if (!((b2 & 192) == 128)) {
            interfaceC2392.invoke(numValueOf);
            return 1;
        }
        byte b3 = bArr[i3];
        if (!((b3 & 192) == 128)) {
            interfaceC2392.invoke(numValueOf);
            return 2;
        }
        int i5 = ((b3 ^ BER.ASN_LONG_LEN) ^ (b2 << 6)) ^ (b << 12);
        if (i5 < 2048) {
            interfaceC2392.invoke(numValueOf);
            return 3;
        }
        if (55296 <= i5 && 57343 >= i5) {
            interfaceC2392.invoke(numValueOf);
            return 3;
        }
        interfaceC2392.invoke(Integer.valueOf(i5));
        return 3;
    }

    public static final int process4Utf8Bytes(byte[] bArr, int i, int i2, InterfaceC2392<? super Integer, i4> interfaceC2392) {
        C3921.m12667(bArr, "$this$process4Utf8Bytes");
        C3921.m12667(interfaceC2392, "yield");
        int i3 = i + 3;
        Integer numValueOf = Integer.valueOf(REPLACEMENT_CODE_POINT);
        if (i2 <= i3) {
            interfaceC2392.invoke(numValueOf);
            int i4 = i + 1;
            if (i2 > i4) {
                if ((bArr[i4] & 192) == 128) {
                    int i5 = i + 2;
                    if (i2 > i5) {
                        if ((bArr[i5] & 192) == 128) {
                            return 3;
                        }
                    }
                    return 2;
                }
            }
            return 1;
        }
        byte b = bArr[i];
        byte b2 = bArr[i + 1];
        if (!((b2 & 192) == 128)) {
            interfaceC2392.invoke(numValueOf);
            return 1;
        }
        byte b3 = bArr[i + 2];
        if (!((b3 & 192) == 128)) {
            interfaceC2392.invoke(numValueOf);
            return 2;
        }
        byte b4 = bArr[i3];
        if (!((b4 & 192) == 128)) {
            interfaceC2392.invoke(numValueOf);
            return 3;
        }
        int i6 = (((b4 ^ BER.ASN_LONG_LEN) ^ (b3 << 6)) ^ (b2 << 12)) ^ (b << 18);
        if (i6 > 1114111) {
            interfaceC2392.invoke(numValueOf);
            return 4;
        }
        if (55296 <= i6 && 57343 >= i6) {
            interfaceC2392.invoke(numValueOf);
            return 4;
        }
        if (i6 < 65536) {
            interfaceC2392.invoke(numValueOf);
            return 4;
        }
        interfaceC2392.invoke(Integer.valueOf(i6));
        return 4;
    }

    public static final void processUtf16Chars(byte[] bArr, int i, int i2, InterfaceC2392<? super Character, i4> interfaceC2392) {
        int i3;
        C3921.m12667(bArr, "$this$processUtf16Chars");
        C3921.m12667(interfaceC2392, "yield");
        int i4 = i;
        while (i4 < i2) {
            byte b = bArr[i4];
            if (b >= 0) {
                interfaceC2392.invoke(Character.valueOf((char) b));
                i4++;
                while (i4 < i2) {
                    byte b2 = bArr[i4];
                    if (b2 >= 0) {
                        i4++;
                        interfaceC2392.invoke(Character.valueOf((char) b2));
                    }
                }
            } else {
                if ((b >> 5) == -2) {
                    int i5 = i4 + 1;
                    if (i2 > i5) {
                        byte b3 = bArr[i5];
                        if ((b3 & 192) == 128) {
                            int i6 = (b << 6) ^ (b3 ^ BER.ASN_LONG_LEN);
                            interfaceC2392.invoke(Character.valueOf(i6 < 128 ? (char) REPLACEMENT_CODE_POINT : (char) i6));
                            i3 = 2;
                        }
                    }
                    interfaceC2392.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                    i3 = 1;
                } else if ((b >> 4) == -2) {
                    int i7 = i4 + 2;
                    if (i2 <= i7) {
                        interfaceC2392.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                        int i8 = i4 + 1;
                        if (i2 > i8) {
                            if ((bArr[i8] & 192) == 128) {
                                i3 = 2;
                            }
                        }
                        i3 = 1;
                    } else {
                        byte b4 = bArr[i4 + 1];
                        if ((b4 & 192) == 128) {
                            byte b5 = bArr[i7];
                            if ((b5 & 192) == 128) {
                                int i9 = (b << 12) ^ ((b5 ^ BER.ASN_LONG_LEN) ^ (b4 << 6));
                                interfaceC2392.invoke(Character.valueOf((i9 >= 2048 && (55296 > i9 || 57343 < i9)) ? (char) i9 : (char) REPLACEMENT_CODE_POINT));
                                i3 = 3;
                            } else {
                                interfaceC2392.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                                i3 = 2;
                            }
                        } else {
                            interfaceC2392.invoke(Character.valueOf((char) REPLACEMENT_CODE_POINT));
                            i3 = 1;
                        }
                    }
                } else if ((b >> 3) == -2) {
                    int i10 = i4 + 3;
                    if (i2 <= i10) {
                        interfaceC2392.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                        int i11 = i4 + 1;
                        if (i2 > i11) {
                            if ((bArr[i11] & 192) == 128) {
                                int i12 = i4 + 2;
                                if (i2 > i12) {
                                    if ((bArr[i12] & 192) == 128) {
                                        i3 = 3;
                                    }
                                }
                                i3 = 2;
                            }
                        }
                        i3 = 1;
                    } else {
                        byte b6 = bArr[i4 + 1];
                        if ((b6 & 192) == 128) {
                            byte b7 = bArr[i4 + 2];
                            if ((b7 & 192) == 128) {
                                byte b8 = bArr[i10];
                                if ((b8 & 192) == 128) {
                                    int i13 = (b << 18) ^ (((b8 ^ BER.ASN_LONG_LEN) ^ (b7 << 6)) ^ (b6 << 12));
                                    if (i13 <= 1114111 && ((55296 > i13 || 57343 < i13) && i13 >= 65536 && i13 != 65533)) {
                                        interfaceC2392.invoke(Character.valueOf((char) ((i13 >>> 10) + HIGH_SURROGATE_HEADER)));
                                        interfaceC2392.invoke(Character.valueOf((char) ((i13 & 1023) + LOG_SURROGATE_HEADER)));
                                    } else {
                                        interfaceC2392.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                                    }
                                    i3 = 4;
                                } else {
                                    interfaceC2392.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                                    i3 = 3;
                                }
                            } else {
                                interfaceC2392.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                                i3 = 2;
                            }
                        } else {
                            interfaceC2392.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                            i3 = 1;
                        }
                    }
                } else {
                    interfaceC2392.invoke(Character.valueOf(REPLACEMENT_CHARACTER));
                    i4++;
                }
                i4 += i3;
            }
        }
    }

    public static final void processUtf8Bytes(String str, int i, int i2, InterfaceC2392<? super Byte, i4> interfaceC2392) {
        int i3;
        char cCharAt;
        C3921.m12667(str, "$this$processUtf8Bytes");
        C3921.m12667(interfaceC2392, "yield");
        while (i < i2) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 < 128) {
                interfaceC2392.invoke(Byte.valueOf((byte) cCharAt2));
                i++;
                while (i < i2 && str.charAt(i) < 128) {
                    interfaceC2392.invoke(Byte.valueOf((byte) str.charAt(i)));
                    i++;
                }
            } else {
                if (cCharAt2 < 2048) {
                    interfaceC2392.invoke(Byte.valueOf((byte) ((cCharAt2 >> 6) | 192)));
                    interfaceC2392.invoke(Byte.valueOf((byte) ((cCharAt2 & '?') | 128)));
                } else if (55296 > cCharAt2 || 57343 < cCharAt2) {
                    interfaceC2392.invoke(Byte.valueOf((byte) ((cCharAt2 >> '\f') | 224)));
                    interfaceC2392.invoke(Byte.valueOf((byte) (((cCharAt2 >> 6) & 63) | 128)));
                    interfaceC2392.invoke(Byte.valueOf((byte) ((cCharAt2 & '?') | 128)));
                } else if (cCharAt2 > 56319 || i2 <= (i3 = i + 1) || 56320 > (cCharAt = str.charAt(i3)) || 57343 < cCharAt) {
                    interfaceC2392.invoke(Byte.valueOf(REPLACEMENT_BYTE));
                } else {
                    int iCharAt = ((cCharAt2 << '\n') + str.charAt(i3)) - 56613888;
                    interfaceC2392.invoke(Byte.valueOf((byte) ((iCharAt >> 18) | 240)));
                    interfaceC2392.invoke(Byte.valueOf((byte) (((iCharAt >> 12) & 63) | 128)));
                    interfaceC2392.invoke(Byte.valueOf((byte) (((iCharAt >> 6) & 63) | 128)));
                    interfaceC2392.invoke(Byte.valueOf((byte) ((iCharAt & 63) | 128)));
                    i += 2;
                }
                i++;
            }
        }
    }

    public static final void processUtf8CodePoints(byte[] bArr, int i, int i2, InterfaceC2392<? super Integer, i4> interfaceC2392) {
        int i3;
        C3921.m12667(bArr, "$this$processUtf8CodePoints");
        C3921.m12667(interfaceC2392, "yield");
        int i4 = i;
        while (i4 < i2) {
            byte b = bArr[i4];
            if (b >= 0) {
                interfaceC2392.invoke(Integer.valueOf(b));
                i4++;
                while (i4 < i2) {
                    byte b2 = bArr[i4];
                    if (b2 >= 0) {
                        i4++;
                        interfaceC2392.invoke(Integer.valueOf(b2));
                    }
                }
            } else {
                if ((b >> 5) == -2) {
                    int i5 = i4 + 1;
                    if (i2 > i5) {
                        byte b3 = bArr[i5];
                        if ((b3 & 192) == 128) {
                            int i6 = (b << 6) ^ (b3 ^ BER.ASN_LONG_LEN);
                            interfaceC2392.invoke(i6 < 128 ? Integer.valueOf(REPLACEMENT_CODE_POINT) : Integer.valueOf(i6));
                            i3 = 2;
                        }
                    }
                    interfaceC2392.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                    i3 = 1;
                } else if ((b >> 4) == -2) {
                    int i7 = i4 + 2;
                    if (i2 <= i7) {
                        interfaceC2392.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                        int i8 = i4 + 1;
                        if (i2 > i8) {
                            if ((bArr[i8] & 192) == 128) {
                                i3 = 2;
                            }
                        }
                        i3 = 1;
                    } else {
                        byte b4 = bArr[i4 + 1];
                        if ((b4 & 192) == 128) {
                            byte b5 = bArr[i7];
                            if ((b5 & 192) == 128) {
                                int i9 = (b << 12) ^ ((b5 ^ BER.ASN_LONG_LEN) ^ (b4 << 6));
                                interfaceC2392.invoke((i9 >= 2048 && (55296 > i9 || 57343 < i9)) ? Integer.valueOf(i9) : Integer.valueOf(REPLACEMENT_CODE_POINT));
                                i3 = 3;
                            } else {
                                interfaceC2392.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                                i3 = 2;
                            }
                        } else {
                            interfaceC2392.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                            i3 = 1;
                        }
                    }
                } else if ((b >> 3) == -2) {
                    int i10 = i4 + 3;
                    if (i2 <= i10) {
                        interfaceC2392.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                        int i11 = i4 + 1;
                        if (i2 > i11) {
                            if ((bArr[i11] & 192) == 128) {
                                int i12 = i4 + 2;
                                if (i2 > i12) {
                                    if ((bArr[i12] & 192) == 128) {
                                        i3 = 3;
                                    }
                                }
                                i3 = 2;
                            }
                        }
                        i3 = 1;
                    } else {
                        byte b6 = bArr[i4 + 1];
                        if ((b6 & 192) == 128) {
                            byte b7 = bArr[i4 + 2];
                            if ((b7 & 192) == 128) {
                                byte b8 = bArr[i10];
                                if ((b8 & 192) == 128) {
                                    int i13 = (b << 18) ^ (((b8 ^ BER.ASN_LONG_LEN) ^ (b7 << 6)) ^ (b6 << 12));
                                    interfaceC2392.invoke((i13 <= 1114111 && (55296 > i13 || 57343 < i13) && i13 >= 65536) ? Integer.valueOf(i13) : Integer.valueOf(REPLACEMENT_CODE_POINT));
                                    i3 = 4;
                                } else {
                                    interfaceC2392.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                                    i3 = 3;
                                }
                            } else {
                                interfaceC2392.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                                i3 = 2;
                            }
                        } else {
                            interfaceC2392.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                            i3 = 1;
                        }
                    }
                } else {
                    interfaceC2392.invoke(Integer.valueOf(REPLACEMENT_CODE_POINT));
                    i4++;
                }
                i4 += i3;
            }
        }
    }

    public static final long size(String str) {
        return size$default(str, 0, 0, 3, null);
    }

    public static final long size(String str, int i) {
        return size$default(str, i, 0, 2, null);
    }

    public static final long size(String str, int i, int i2) {
        int i3;
        C3921.m12667(str, "$this$utf8Size");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i).toString());
        }
        if (!(i2 >= i)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i2 + " < " + i).toString());
        }
        if (!(i2 <= str.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i2 + " > " + str.length()).toString());
        }
        long j = 0;
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt < 128) {
                j++;
            } else {
                if (cCharAt < 2048) {
                    i3 = 2;
                } else if (cCharAt < 55296 || cCharAt > 57343) {
                    i3 = 3;
                } else {
                    int i4 = i + 1;
                    char cCharAt2 = i4 < i2 ? str.charAt(i4) : (char) 0;
                    if (cCharAt > 56319 || cCharAt2 < 56320 || cCharAt2 > 57343) {
                        j++;
                        i = i4;
                    } else {
                        j += 4;
                        i += 2;
                    }
                }
                j += i3;
            }
            i++;
        }
        return j;
    }

    public static /* synthetic */ long size$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return size(str, i, i2);
    }
}
