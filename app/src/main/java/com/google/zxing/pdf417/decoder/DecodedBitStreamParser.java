package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import com.google.zxing.pdf417.PDF417ResultMetadata;
import java.math.BigInteger;
import java.util.Arrays;

/* loaded from: classes2.dex */
final class DecodedBitStreamParser {
    private static final int AL = 28;
    private static final int AS = 27;
    private static final int BEGIN_MACRO_PDF417_CONTROL_BLOCK = 928;
    private static final int BEGIN_MACRO_PDF417_OPTIONAL_FIELD = 923;
    private static final int BYTE_COMPACTION_MODE_LATCH = 901;
    private static final int BYTE_COMPACTION_MODE_LATCH_6 = 924;
    private static final int ECI_CHARSET = 927;
    private static final int ECI_GENERAL_PURPOSE = 926;
    private static final int ECI_USER_DEFINED = 925;
    private static final BigInteger[] EXP900;
    private static final int LL = 27;
    private static final int MACRO_PDF417_TERMINATOR = 922;
    private static final int MAX_NUMERIC_CODEWORDS = 15;
    private static final int ML = 28;
    private static final int MODE_SHIFT_TO_BYTE_COMPACTION_MODE = 913;
    private static final int NUMBER_OF_SEQUENCE_CODEWORDS = 2;
    private static final int NUMERIC_COMPACTION_MODE_LATCH = 902;
    private static final int PAL = 29;
    private static final int PL = 25;
    private static final int PS = 29;
    private static final int TEXT_COMPACTION_MODE_LATCH = 900;
    private static final char[] PUNCT_CHARS = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    private static final char[] MIXED_CHARS = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();

    /* renamed from: com.google.zxing.pdf417.decoder.DecodedBitStreamParser$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode;

        static {
            int[] iArr = new int[Mode.values().length];
            $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode = iArr;
            try {
                iArr[Mode.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[Mode.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        EXP900 = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = bigIntegerValueOf;
        int i = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = EXP900;
            if (i >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i] = bigIntegerArr2[i - 1].multiply(bigIntegerValueOf);
            i++;
        }
    }

    private DecodedBitStreamParser() {
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Failed to find switch 'out' block (already processed)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.calcSwitchOut(SwitchRegionMaker.java:200)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.process(SwitchRegionMaker.java:61)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:112)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:95)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:281)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:64)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeEndlessLoop(LoopRegionMaker.java:281)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:64)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:101)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:66)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:48)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    /* JADX WARN: Failed to find 'out' block for switch in B:34:0x0077. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0045 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0021 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int byteCompaction(int r16, int[] r17, java.nio.charset.Charset r18, int r19, java.lang.StringBuilder r20) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.byteCompaction(int, int[], java.nio.charset.Charset, int, java.lang.StringBuilder):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.zxing.common.DecoderResult decode(int[] r6, java.lang.String r7) throws com.google.zxing.FormatException {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r1 = r6.length
            r2 = 1
            int r1 = r1 << r2
            r0.<init>(r1)
            java.nio.charset.Charset r1 = java.nio.charset.StandardCharsets.ISO_8859_1
            r2 = r6[r2]
            com.google.zxing.pdf417.PDF417ResultMetadata r3 = new com.google.zxing.pdf417.PDF417ResultMetadata
            r3.<init>()
            r4 = 2
        L12:
            r5 = 0
            r5 = r6[r5]
            if (r4 >= r5) goto L6d
            r5 = 913(0x391, float:1.28E-42)
            if (r2 == r5) goto L58
            switch(r2) {
                case 900: goto L53;
                case 901: goto L4e;
                case 902: goto L49;
                default: goto L1e;
            }
        L1e:
            switch(r2) {
                case 922: goto L44;
                case 923: goto L44;
                case 924: goto L4e;
                case 925: goto L41;
                case 926: goto L3e;
                case 927: goto L2d;
                case 928: goto L28;
                default: goto L21;
            }
        L21:
            int r4 = r4 + (-1)
            int r2 = textCompaction(r6, r4, r0)
            goto L60
        L28:
            int r2 = decodeMacroBlock(r6, r4, r3)
            goto L60
        L2d:
            int r2 = r4 + 1
            r1 = r6[r4]
            com.google.zxing.common.CharacterSetECI r1 = com.google.zxing.common.CharacterSetECI.getCharacterSetECIByValue(r1)
            java.lang.String r1 = r1.name()
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)
            goto L60
        L3e:
            int r2 = r4 + 2
            goto L60
        L41:
            int r2 = r4 + 1
            goto L60
        L44:
            com.google.zxing.FormatException r6 = com.google.zxing.FormatException.getFormatInstance()
            throw r6
        L49:
            int r2 = numericCompaction(r6, r4, r0)
            goto L60
        L4e:
            int r2 = byteCompaction(r2, r6, r1, r4, r0)
            goto L60
        L53:
            int r2 = textCompaction(r6, r4, r0)
            goto L60
        L58:
            int r2 = r4 + 1
            r4 = r6[r4]
            char r4 = (char) r4
            r0.append(r4)
        L60:
            int r4 = r6.length
            if (r2 >= r4) goto L68
            int r4 = r2 + 1
            r2 = r6[r2]
            goto L12
        L68:
            com.google.zxing.FormatException r6 = com.google.zxing.FormatException.getFormatInstance()
            throw r6
        L6d:
            int r6 = r0.length()
            if (r6 == 0) goto L81
            com.google.zxing.common.DecoderResult r6 = new com.google.zxing.common.DecoderResult
            java.lang.String r0 = r0.toString()
            r1 = 0
            r6.<init>(r1, r0, r1, r7)
            r6.setOther(r3)
            return r6
        L81:
            com.google.zxing.FormatException r6 = com.google.zxing.FormatException.getFormatInstance()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.decode(int[], java.lang.String):com.google.zxing.common.DecoderResult");
    }

    private static String decodeBase900toBase10(int[] iArr, int i) throws FormatException {
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        for (int i2 = 0; i2 < i; i2++) {
            bigIntegerAdd = bigIntegerAdd.add(EXP900[(i - i2) - 1].multiply(BigInteger.valueOf(iArr[i2])));
        }
        String string = bigIntegerAdd.toString();
        if (string.charAt(0) == '1') {
            return string.substring(1);
        }
        throw FormatException.getFormatInstance();
    }

    private static int decodeMacroBlock(int[] iArr, int i, PDF417ResultMetadata pDF417ResultMetadata) throws FormatException {
        if (i + 2 > iArr[0]) {
            throw FormatException.getFormatInstance();
        }
        int[] iArr2 = new int[2];
        int i2 = 0;
        while (i2 < 2) {
            iArr2[i2] = iArr[i];
            i2++;
            i++;
        }
        pDF417ResultMetadata.setSegmentIndex(Integer.parseInt(decodeBase900toBase10(iArr2, 2)));
        StringBuilder sb = new StringBuilder();
        int iTextCompaction = textCompaction(iArr, i, sb);
        pDF417ResultMetadata.setFileId(sb.toString());
        int i3 = iArr[iTextCompaction];
        if (i3 == MACRO_PDF417_TERMINATOR) {
            pDF417ResultMetadata.setLastSegment(true);
            return iTextCompaction + 1;
        }
        if (i3 != BEGIN_MACRO_PDF417_OPTIONAL_FIELD) {
            return iTextCompaction;
        }
        int i4 = iTextCompaction + 1;
        int[] iArr3 = new int[iArr[0] - i4];
        boolean z = false;
        int i5 = 0;
        while (i4 < iArr[0] && !z) {
            int i6 = i4 + 1;
            int i7 = iArr[i4];
            if (i7 < 900) {
                iArr3[i5] = i7;
                i4 = i6;
                i5++;
            } else {
                if (i7 != MACRO_PDF417_TERMINATOR) {
                    throw FormatException.getFormatInstance();
                }
                pDF417ResultMetadata.setLastSegment(true);
                i4 = i6 + 1;
                z = true;
            }
        }
        pDF417ResultMetadata.setOptionalData(Arrays.copyOf(iArr3, i5));
        return i4;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void decodeTextCompaction(int[] iArr, int[] iArr2, int i, StringBuilder sb) {
        Mode mode;
        int i2;
        Mode mode2 = Mode.ALPHA;
        Mode mode3 = mode2;
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = iArr[i3];
            char c = ' ';
            switch (AnonymousClass1.$SwitchMap$com$google$zxing$pdf417$decoder$DecodedBitStreamParser$Mode[mode2.ordinal()]) {
                case 1:
                    if (i4 < 26) {
                        i2 = i4 + 65;
                        c = (char) i2;
                        break;
                    } else {
                        if (i4 == 900) {
                            mode2 = Mode.ALPHA;
                        } else if (i4 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                            switch (i4) {
                                case 27:
                                    mode2 = Mode.LOWER;
                                    break;
                                case 28:
                                    mode2 = Mode.MIXED;
                                    break;
                                case 29:
                                    mode = Mode.PUNCT_SHIFT;
                                    c = 0;
                                    Mode mode4 = mode;
                                    mode3 = mode2;
                                    mode2 = mode4;
                                    break;
                            }
                        } else {
                            sb.append((char) iArr2[i3]);
                        }
                        c = 0;
                        break;
                    }
                case 2:
                    if (i4 < 26) {
                        i2 = i4 + 97;
                        c = (char) i2;
                        break;
                    } else {
                        if (i4 == 900) {
                            mode2 = Mode.ALPHA;
                        } else if (i4 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                            switch (i4) {
                                case 27:
                                    mode = Mode.ALPHA_SHIFT;
                                    c = 0;
                                    Mode mode42 = mode;
                                    mode3 = mode2;
                                    mode2 = mode42;
                                    break;
                                case 28:
                                    mode2 = Mode.MIXED;
                                    break;
                                case 29:
                                    mode = Mode.PUNCT_SHIFT;
                                    c = 0;
                                    Mode mode422 = mode;
                                    mode3 = mode2;
                                    mode2 = mode422;
                                    break;
                            }
                        } else {
                            sb.append((char) iArr2[i3]);
                        }
                        c = 0;
                        break;
                    }
                    break;
                case 3:
                    if (i4 < 25) {
                        c = MIXED_CHARS[i4];
                        break;
                    } else {
                        if (i4 == 900) {
                            mode2 = Mode.ALPHA;
                        } else if (i4 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                            switch (i4) {
                                case 25:
                                    mode2 = Mode.PUNCT;
                                    break;
                                case 27:
                                    mode2 = Mode.LOWER;
                                    break;
                                case 28:
                                    mode2 = Mode.ALPHA;
                                    break;
                                case 29:
                                    mode = Mode.PUNCT_SHIFT;
                                    c = 0;
                                    Mode mode4222 = mode;
                                    mode3 = mode2;
                                    mode2 = mode4222;
                                    break;
                            }
                        } else {
                            sb.append((char) iArr2[i3]);
                        }
                        c = 0;
                        break;
                    }
                    break;
                case 4:
                    if (i4 < 29) {
                        c = PUNCT_CHARS[i4];
                        break;
                    } else {
                        if (i4 == 29 || i4 == 900) {
                            mode2 = Mode.ALPHA;
                        } else if (i4 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                            sb.append((char) iArr2[i3]);
                        }
                        c = 0;
                        break;
                    }
                case 5:
                    if (i4 < 26) {
                        c = (char) (i4 + 65);
                    } else if (i4 != 26) {
                        mode2 = i4 != 900 ? mode3 : Mode.ALPHA;
                        c = 0;
                        break;
                    }
                    mode2 = mode3;
                    break;
                case 6:
                    if (i4 < 29) {
                        c = PUNCT_CHARS[i4];
                    } else if (i4 == 29 || i4 == 900) {
                        mode2 = Mode.ALPHA;
                        c = 0;
                        break;
                    } else {
                        if (i4 == MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                            sb.append((char) iArr2[i3]);
                        }
                        c = 0;
                    }
                    mode2 = mode3;
                    break;
                default:
                    c = 0;
                    break;
            }
            if (c != 0) {
                sb.append(c);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int numericCompaction(int[] r7, int r8, java.lang.StringBuilder r9) throws com.google.zxing.FormatException {
        /*
            r0 = 15
            int[] r0 = new int[r0]
            r1 = 0
            r2 = r1
            r3 = r2
        L7:
            r4 = r7[r1]
            if (r8 >= r4) goto L45
            if (r2 != 0) goto L45
            int r5 = r8 + 1
            r8 = r7[r8]
            r6 = 1
            if (r5 != r4) goto L15
            r2 = r6
        L15:
            r4 = 900(0x384, float:1.261E-42)
            if (r8 >= r4) goto L1e
            r0[r3] = r8
            int r3 = r3 + 1
            goto L2f
        L1e:
            if (r8 == r4) goto L2c
            r4 = 901(0x385, float:1.263E-42)
            if (r8 == r4) goto L2c
            r4 = 928(0x3a0, float:1.3E-42)
            if (r8 == r4) goto L2c
            switch(r8) {
                case 922: goto L2c;
                case 923: goto L2c;
                case 924: goto L2c;
                default: goto L2b;
            }
        L2b:
            goto L2f
        L2c:
            int r5 = r5 + (-1)
            r2 = r6
        L2f:
            int r4 = r3 % 15
            if (r4 == 0) goto L39
            r4 = 902(0x386, float:1.264E-42)
            if (r8 == r4) goto L39
            if (r2 == 0) goto L43
        L39:
            if (r3 <= 0) goto L43
            java.lang.String r8 = decodeBase900toBase10(r0, r3)
            r9.append(r8)
            r3 = r1
        L43:
            r8 = r5
            goto L7
        L45:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.numericCompaction(int[], int, java.lang.StringBuilder):int");
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x0033. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x0036. Please report as an issue. */
    private static int textCompaction(int[] iArr, int i, StringBuilder sb) {
        int i2 = iArr[0];
        int[] iArr2 = new int[(i2 - i) << 1];
        int[] iArr3 = new int[(i2 - i) << 1];
        boolean z = false;
        int i3 = 0;
        while (i < iArr[0] && !z) {
            int i4 = i + 1;
            int i5 = iArr[i];
            if (i5 < 900) {
                iArr2[i3] = i5 / 30;
                iArr2[i3 + 1] = i5 % 30;
                i3 += 2;
            } else if (i5 != MODE_SHIFT_TO_BYTE_COMPACTION_MODE) {
                if (i5 != 928) {
                    switch (i5) {
                        case 900:
                            iArr2[i3] = 900;
                            i3++;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i5) {
                            }
                    }
                }
                i = i4 - 1;
                z = true;
            } else {
                iArr2[i3] = MODE_SHIFT_TO_BYTE_COMPACTION_MODE;
                i = i4 + 1;
                iArr3[i3] = iArr[i4];
                i3++;
            }
            i = i4;
        }
        decodeTextCompaction(iArr2, iArr3, i3, sb);
        return i;
    }
}
