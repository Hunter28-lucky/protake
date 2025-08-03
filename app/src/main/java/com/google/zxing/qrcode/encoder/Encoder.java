package com.google.zxing.qrcode.encoder;

import androidx.exifinterface.media.ExifInterface;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.common.reedsolomon.GenericGF;
import com.google.zxing.common.reedsolomon.ReedSolomonEncoder;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.Version;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import org.jcodec.codecs.mjpeg.JpegConst;

/* loaded from: classes2.dex */
public final class Encoder {
    private static final int[] ALPHANUMERIC_TABLE = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};
    public static final String DEFAULT_BYTE_MODE_ENCODING = "ISO-8859-1";

    /* renamed from: com.google.zxing.qrcode.encoder.Encoder$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$zxing$qrcode$decoder$Mode;

        static {
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$com$google$zxing$qrcode$decoder$Mode = iArr;
            try {
                iArr[Mode.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$zxing$qrcode$decoder$Mode[Mode.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private Encoder() {
    }

    public static void append8BitBytes(String str, BitArray bitArray, String str2) throws WriterException, UnsupportedEncodingException {
        try {
            for (byte b : str.getBytes(str2)) {
                bitArray.appendBits(b, 8);
            }
        } catch (UnsupportedEncodingException e2) {
            throw new WriterException(e2);
        }
    }

    public static void appendAlphanumericBytes(CharSequence charSequence, BitArray bitArray) throws WriterException {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int alphanumericCode = getAlphanumericCode(charSequence.charAt(i));
            if (alphanumericCode == -1) {
                throw new WriterException();
            }
            int i2 = i + 1;
            if (i2 < length) {
                int alphanumericCode2 = getAlphanumericCode(charSequence.charAt(i2));
                if (alphanumericCode2 == -1) {
                    throw new WriterException();
                }
                bitArray.appendBits((alphanumericCode * 45) + alphanumericCode2, 11);
                i += 2;
            } else {
                bitArray.appendBits(alphanumericCode, 6);
                i = i2;
            }
        }
    }

    public static void appendBytes(String str, Mode mode, BitArray bitArray, String str2) throws WriterException, UnsupportedEncodingException {
        int i = AnonymousClass1.$SwitchMap$com$google$zxing$qrcode$decoder$Mode[mode.ordinal()];
        if (i == 1) {
            appendNumericBytes(str, bitArray);
            return;
        }
        if (i == 2) {
            appendAlphanumericBytes(str, bitArray);
            return;
        }
        if (i == 3) {
            append8BitBytes(str, bitArray, str2);
        } else if (i == 4) {
            appendKanjiBytes(str, bitArray);
        } else {
            throw new WriterException("Invalid mode: " + mode);
        }
    }

    private static void appendECI(CharacterSetECI characterSetECI, BitArray bitArray) {
        bitArray.appendBits(Mode.ECI.getBits(), 4);
        bitArray.appendBits(characterSetECI.getValue(), 8);
    }

    public static void appendKanjiBytes(String str, BitArray bitArray) throws WriterException, UnsupportedEncodingException {
        int i;
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i2 = 0; i2 < length; i2 += 2) {
                int i3 = ((bytes[i2] & ExifInterface.MARKER) << 8) | (bytes[i2 + 1] & ExifInterface.MARKER);
                int i4 = 33088;
                if (i3 >= 33088 && i3 <= 40956) {
                    i = i3 - i4;
                } else if (i3 < 57408 || i3 > 60351) {
                    i = -1;
                } else {
                    i4 = 49472;
                    i = i3 - i4;
                }
                if (i == -1) {
                    throw new WriterException("Invalid byte sequence");
                }
                bitArray.appendBits(((i >> 8) * 192) + (i & 255), 13);
            }
        } catch (UnsupportedEncodingException e2) {
            throw new WriterException(e2);
        }
    }

    public static void appendLengthInfo(int i, Version version, Mode mode, BitArray bitArray) throws WriterException {
        int characterCountBits = mode.getCharacterCountBits(version);
        int i2 = 1 << characterCountBits;
        if (i < i2) {
            bitArray.appendBits(i, characterCountBits);
            return;
        }
        throw new WriterException(i + " is bigger than " + (i2 - 1));
    }

    public static void appendModeInfo(Mode mode, BitArray bitArray) {
        bitArray.appendBits(mode.getBits(), 4);
    }

    public static void appendNumericBytes(CharSequence charSequence, BitArray bitArray) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int iCharAt = charSequence.charAt(i) - '0';
            int i2 = i + 2;
            if (i2 < length) {
                bitArray.appendBits((iCharAt * 100) + ((charSequence.charAt(i + 1) - '0') * 10) + (charSequence.charAt(i2) - '0'), 10);
                i += 3;
            } else {
                i++;
                if (i < length) {
                    bitArray.appendBits((iCharAt * 10) + (charSequence.charAt(i) - '0'), 7);
                    i = i2;
                } else {
                    bitArray.appendBits(iCharAt, 4);
                }
            }
        }
    }

    private static int calculateBitsNeeded(Mode mode, BitArray bitArray, BitArray bitArray2, Version version) {
        return bitArray.getSize() + mode.getCharacterCountBits(version) + bitArray2.getSize();
    }

    private static int calculateMaskPenalty(ByteMatrix byteMatrix) {
        return MaskUtil.applyMaskPenaltyRule1(byteMatrix) + MaskUtil.applyMaskPenaltyRule2(byteMatrix) + MaskUtil.applyMaskPenaltyRule3(byteMatrix) + MaskUtil.applyMaskPenaltyRule4(byteMatrix);
    }

    private static int chooseMaskPattern(BitArray bitArray, ErrorCorrectionLevel errorCorrectionLevel, Version version, ByteMatrix byteMatrix) throws WriterException {
        int i = Integer.MAX_VALUE;
        int i2 = -1;
        for (int i3 = 0; i3 < 8; i3++) {
            MatrixUtil.buildMatrix(bitArray, errorCorrectionLevel, version, i3, byteMatrix);
            int iCalculateMaskPenalty = calculateMaskPenalty(byteMatrix);
            if (iCalculateMaskPenalty < i) {
                i2 = i3;
                i = iCalculateMaskPenalty;
            }
        }
        return i2;
    }

    public static Mode chooseMode(String str) {
        return chooseMode(str, null);
    }

    private static Version chooseVersion(int i, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        for (int i2 = 1; i2 <= 40; i2++) {
            Version versionForNumber = Version.getVersionForNumber(i2);
            if (willFit(i, versionForNumber, errorCorrectionLevel)) {
                return versionForNumber;
            }
        }
        throw new WriterException("Data too big");
    }

    public static QRCode encode(String str, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        return encode(str, errorCorrectionLevel, null);
    }

    public static byte[] generateECBytes(byte[] bArr, int i) {
        int length = bArr.length;
        int[] iArr = new int[length + i];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & ExifInterface.MARKER;
        }
        new ReedSolomonEncoder(GenericGF.QR_CODE_FIELD_256).encode(iArr, i);
        byte[] bArr2 = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr2[i3] = (byte) iArr[length + i3];
        }
        return bArr2;
    }

    public static int getAlphanumericCode(int i) {
        int[] iArr = ALPHANUMERIC_TABLE;
        if (i < iArr.length) {
            return iArr[i];
        }
        return -1;
    }

    public static void getNumDataBytesAndNumECBytesForBlockID(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) throws WriterException {
        if (i4 >= i3) {
            throw new WriterException("Block ID too large");
        }
        int i5 = i % i3;
        int i6 = i3 - i5;
        int i7 = i / i3;
        int i8 = i7 + 1;
        int i9 = i2 / i3;
        int i10 = i9 + 1;
        int i11 = i7 - i9;
        int i12 = i8 - i10;
        if (i11 != i12) {
            throw new WriterException("EC bytes mismatch");
        }
        if (i3 != i6 + i5) {
            throw new WriterException("RS blocks mismatch");
        }
        if (i != ((i9 + i11) * i6) + ((i10 + i12) * i5)) {
            throw new WriterException("Total bytes mismatch");
        }
        if (i4 < i6) {
            iArr[0] = i9;
            iArr2[0] = i11;
        } else {
            iArr[0] = i10;
            iArr2[0] = i12;
        }
    }

    public static BitArray interleaveWithECBytes(BitArray bitArray, int i, int i2, int i3) throws WriterException {
        if (bitArray.getSizeInBytes() != i2) {
            throw new WriterException("Number of bits and data bytes does not match");
        }
        ArrayList arrayList = new ArrayList(i3);
        int i4 = 0;
        int iMax = 0;
        int iMax2 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            getNumDataBytesAndNumECBytesForBlockID(i, i2, i3, i5, iArr, iArr2);
            int i6 = iArr[0];
            byte[] bArr = new byte[i6];
            bitArray.toBytes(i4 << 3, bArr, 0, i6);
            byte[] bArrGenerateECBytes = generateECBytes(bArr, iArr2[0]);
            arrayList.add(new BlockPair(bArr, bArrGenerateECBytes));
            iMax = Math.max(iMax, i6);
            iMax2 = Math.max(iMax2, bArrGenerateECBytes.length);
            i4 += iArr[0];
        }
        if (i2 != i4) {
            throw new WriterException("Data bytes does not match offset");
        }
        BitArray bitArray2 = new BitArray();
        for (int i7 = 0; i7 < iMax; i7++) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                byte[] dataBytes = ((BlockPair) it.next()).getDataBytes();
                if (i7 < dataBytes.length) {
                    bitArray2.appendBits(dataBytes[i7], 8);
                }
            }
        }
        for (int i8 = 0; i8 < iMax2; i8++) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                byte[] errorCorrectionBytes = ((BlockPair) it2.next()).getErrorCorrectionBytes();
                if (i8 < errorCorrectionBytes.length) {
                    bitArray2.appendBits(errorCorrectionBytes[i8], 8);
                }
            }
        }
        if (i == bitArray2.getSizeInBytes()) {
            return bitArray2;
        }
        throw new WriterException("Interleaving error: " + i + " and " + bitArray2.getSizeInBytes() + " differ.");
    }

    private static boolean isOnlyDoubleByteKanji(String str) throws UnsupportedEncodingException {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                int i2 = bytes[i] & ExifInterface.MARKER;
                if ((i2 < 129 || i2 > 159) && (i2 < 224 || i2 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static Version recommendVersion(ErrorCorrectionLevel errorCorrectionLevel, Mode mode, BitArray bitArray, BitArray bitArray2) throws WriterException {
        return chooseVersion(calculateBitsNeeded(mode, bitArray, bitArray2, chooseVersion(calculateBitsNeeded(mode, bitArray, bitArray2, Version.getVersionForNumber(1)), errorCorrectionLevel)), errorCorrectionLevel);
    }

    public static void terminateBits(int i, BitArray bitArray) throws WriterException {
        int i2 = i << 3;
        if (bitArray.getSize() > i2) {
            throw new WriterException("data bits cannot fit in the QR Code" + bitArray.getSize() + " > " + i2);
        }
        for (int i3 = 0; i3 < 4 && bitArray.getSize() < i2; i3++) {
            bitArray.appendBit(false);
        }
        int size = bitArray.getSize() & 7;
        if (size > 0) {
            while (size < 8) {
                bitArray.appendBit(false);
                size++;
            }
        }
        int sizeInBytes = i - bitArray.getSizeInBytes();
        for (int i4 = 0; i4 < sizeInBytes; i4++) {
            bitArray.appendBits((i4 & 1) == 0 ? JpegConst.APPC : 17, 8);
        }
        if (bitArray.getSize() != i2) {
            throw new WriterException("Bits size does not equal capacity");
        }
    }

    private static boolean willFit(int i, Version version, ErrorCorrectionLevel errorCorrectionLevel) {
        return version.getTotalCodewords() - version.getECBlocksForLevel(errorCorrectionLevel).getTotalECCodewords() >= (i + 7) / 8;
    }

    private static Mode chooseMode(String str, String str2) {
        if ("Shift_JIS".equals(str2) && isOnlyDoubleByteKanji(str)) {
            return Mode.KANJI;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= '0' && cCharAt <= '9') {
                z2 = true;
            } else {
                if (getAlphanumericCode(cCharAt) == -1) {
                    return Mode.BYTE;
                }
                z = true;
            }
        }
        return z ? Mode.ALPHANUMERIC : z2 ? Mode.NUMERIC : Mode.BYTE;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x009c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.zxing.qrcode.encoder.QRCode encode(java.lang.String r8, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r9, java.util.Map<com.google.zxing.EncodeHintType, ?> r10) throws com.google.zxing.WriterException, java.io.UnsupportedEncodingException {
        /*
            r0 = 1
            r1 = 0
            if (r10 == 0) goto Le
            com.google.zxing.EncodeHintType r2 = com.google.zxing.EncodeHintType.CHARACTER_SET
            boolean r2 = r10.containsKey(r2)
            if (r2 == 0) goto Le
            r2 = r0
            goto Lf
        Le:
            r2 = r1
        Lf:
            java.lang.String r3 = "ISO-8859-1"
            if (r2 == 0) goto L1e
            com.google.zxing.EncodeHintType r4 = com.google.zxing.EncodeHintType.CHARACTER_SET
            java.lang.Object r4 = r10.get(r4)
            java.lang.String r4 = r4.toString()
            goto L1f
        L1e:
            r4 = r3
        L1f:
            com.google.zxing.qrcode.decoder.Mode r5 = chooseMode(r8, r4)
            com.google.zxing.common.BitArray r6 = new com.google.zxing.common.BitArray
            r6.<init>()
            com.google.zxing.qrcode.decoder.Mode r7 = com.google.zxing.qrcode.decoder.Mode.BYTE
            if (r5 != r7) goto L3d
            if (r2 != 0) goto L34
            boolean r2 = r3.equals(r4)
            if (r2 != 0) goto L3d
        L34:
            com.google.zxing.common.CharacterSetECI r2 = com.google.zxing.common.CharacterSetECI.getCharacterSetECIByName(r4)
            if (r2 == 0) goto L3d
            appendECI(r2, r6)
        L3d:
            if (r10 == 0) goto L48
            com.google.zxing.EncodeHintType r2 = com.google.zxing.EncodeHintType.GS1_FORMAT
            boolean r2 = r10.containsKey(r2)
            if (r2 == 0) goto L48
            goto L49
        L48:
            r0 = r1
        L49:
            if (r0 == 0) goto L64
            com.google.zxing.EncodeHintType r0 = com.google.zxing.EncodeHintType.GS1_FORMAT
            java.lang.Object r0 = r10.get(r0)
            java.lang.String r0 = r0.toString()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L64
            com.google.zxing.qrcode.decoder.Mode r0 = com.google.zxing.qrcode.decoder.Mode.FNC1_FIRST_POSITION
            appendModeInfo(r0, r6)
        L64:
            appendModeInfo(r5, r6)
            com.google.zxing.common.BitArray r0 = new com.google.zxing.common.BitArray
            r0.<init>()
            appendBytes(r8, r5, r0, r4)
            if (r10 == 0) goto L9c
            com.google.zxing.EncodeHintType r1 = com.google.zxing.EncodeHintType.QR_VERSION
            boolean r2 = r10.containsKey(r1)
            if (r2 == 0) goto L9c
            java.lang.Object r10 = r10.get(r1)
            java.lang.String r10 = r10.toString()
            int r10 = java.lang.Integer.parseInt(r10)
            com.google.zxing.qrcode.decoder.Version r10 = com.google.zxing.qrcode.decoder.Version.getVersionForNumber(r10)
            int r1 = calculateBitsNeeded(r5, r6, r0, r10)
            boolean r1 = willFit(r1, r10, r9)
            if (r1 == 0) goto L94
            goto La0
        L94:
            com.google.zxing.WriterException r8 = new com.google.zxing.WriterException
            java.lang.String r9 = "Data too big for requested version"
            r8.<init>(r9)
            throw r8
        L9c:
            com.google.zxing.qrcode.decoder.Version r10 = recommendVersion(r9, r5, r6, r0)
        La0:
            com.google.zxing.common.BitArray r1 = new com.google.zxing.common.BitArray
            r1.<init>()
            r1.appendBitArray(r6)
            if (r5 != r7) goto Laf
            int r8 = r0.getSizeInBytes()
            goto Lb3
        Laf:
            int r8 = r8.length()
        Lb3:
            appendLengthInfo(r8, r10, r5, r1)
            r1.appendBitArray(r0)
            com.google.zxing.qrcode.decoder.Version$ECBlocks r8 = r10.getECBlocksForLevel(r9)
            int r0 = r10.getTotalCodewords()
            int r2 = r8.getTotalECCodewords()
            int r0 = r0 - r2
            terminateBits(r0, r1)
            int r2 = r10.getTotalCodewords()
            int r8 = r8.getNumBlocks()
            com.google.zxing.common.BitArray r8 = interleaveWithECBytes(r1, r2, r0, r8)
            com.google.zxing.qrcode.encoder.QRCode r0 = new com.google.zxing.qrcode.encoder.QRCode
            r0.<init>()
            r0.setECLevel(r9)
            r0.setMode(r5)
            r0.setVersion(r10)
            int r1 = r10.getDimensionForVersion()
            com.google.zxing.qrcode.encoder.ByteMatrix r2 = new com.google.zxing.qrcode.encoder.ByteMatrix
            r2.<init>(r1, r1)
            int r1 = chooseMaskPattern(r8, r9, r10, r2)
            r0.setMaskPattern(r1)
            com.google.zxing.qrcode.encoder.MatrixUtil.buildMatrix(r8, r9, r10, r1, r2)
            r0.setMatrix(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.encoder.Encoder.encode(java.lang.String, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel, java.util.Map):com.google.zxing.qrcode.encoder.QRCode");
    }
}
