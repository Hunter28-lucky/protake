package okio.internal;

import defpackage.C3921;
import defpackage.C4955;
import defpackage.InterfaceC3697;
import defpackage.i4;
import okio.Buffer;
import okio.ByteString;
import okio.Segment;
import okio.SegmentedByteString;
import okio.Util;

/* compiled from: SegmentedByteString.kt */
/* loaded from: classes2.dex */
public final class SegmentedByteStringKt {
    public static final int binarySearch(int[] iArr, int i, int i2, int i3) {
        C3921.m12667(iArr, "$this$binarySearch");
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i) {
                i2 = i5 + 1;
            } else {
                if (i6 <= i) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return (-i2) - 1;
    }

    public static final boolean commonEquals(SegmentedByteString segmentedByteString, Object obj) {
        C3921.m12667(segmentedByteString, "$this$commonEquals");
        if (obj == segmentedByteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == segmentedByteString.size() && segmentedByteString.rangeEquals(0, byteString, 0, segmentedByteString.size())) {
                return true;
            }
        }
        return false;
    }

    public static final int commonGetSize(SegmentedByteString segmentedByteString) {
        C3921.m12667(segmentedByteString, "$this$commonGetSize");
        return segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length - 1];
    }

    public static final int commonHashCode(SegmentedByteString segmentedByteString) {
        C3921.m12667(segmentedByteString, "$this$commonHashCode");
        int hashCode$okio = segmentedByteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = segmentedByteString.getSegments$okio().length;
        int i = 0;
        int i2 = 1;
        int i3 = 0;
        while (i < length) {
            int i4 = segmentedByteString.getDirectory$okio()[length + i];
            int i5 = segmentedByteString.getDirectory$okio()[i];
            byte[] bArr = segmentedByteString.getSegments$okio()[i];
            int i6 = (i5 - i3) + i4;
            while (i4 < i6) {
                i2 = (i2 * 31) + bArr[i4];
                i4++;
            }
            i++;
            i3 = i5;
        }
        segmentedByteString.setHashCode$okio(i2);
        return i2;
    }

    public static final byte commonInternalGet(SegmentedByteString segmentedByteString, int i) {
        C3921.m12667(segmentedByteString, "$this$commonInternalGet");
        Util.checkOffsetAndCount(segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length - 1], i, 1L);
        int iSegment = segment(segmentedByteString, i);
        return segmentedByteString.getSegments$okio()[iSegment][(i - (iSegment == 0 ? 0 : segmentedByteString.getDirectory$okio()[iSegment - 1])) + segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + iSegment]];
    }

    public static final boolean commonRangeEquals(SegmentedByteString segmentedByteString, int i, ByteString byteString, int i2, int i3) {
        C3921.m12667(segmentedByteString, "$this$commonRangeEquals");
        C3921.m12667(byteString, "other");
        if (i < 0 || i > segmentedByteString.size() - i3) {
            return false;
        }
        int i4 = i3 + i;
        int iSegment = segment(segmentedByteString, i);
        while (i < i4) {
            int i5 = iSegment == 0 ? 0 : segmentedByteString.getDirectory$okio()[iSegment - 1];
            int i6 = segmentedByteString.getDirectory$okio()[iSegment] - i5;
            int i7 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + iSegment];
            int iMin = Math.min(i4, i6 + i5) - i;
            if (!byteString.rangeEquals(i2, segmentedByteString.getSegments$okio()[iSegment], i7 + (i - i5), iMin)) {
                return false;
            }
            i2 += iMin;
            i += iMin;
            iSegment++;
        }
        return true;
    }

    public static final ByteString commonSubstring(SegmentedByteString segmentedByteString, int i, int i2) {
        C3921.m12667(segmentedByteString, "$this$commonSubstring");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("beginIndex=" + i + " < 0").toString());
        }
        if (!(i2 <= segmentedByteString.size())) {
            throw new IllegalArgumentException(("endIndex=" + i2 + " > length(" + segmentedByteString.size() + ')').toString());
        }
        int i3 = i2 - i;
        if (!(i3 >= 0)) {
            throw new IllegalArgumentException(("endIndex=" + i2 + " < beginIndex=" + i).toString());
        }
        if (i == 0 && i2 == segmentedByteString.size()) {
            return segmentedByteString;
        }
        if (i == i2) {
            return ByteString.EMPTY;
        }
        int iSegment = segment(segmentedByteString, i);
        int iSegment2 = segment(segmentedByteString, i2 - 1);
        byte[][] bArr = (byte[][]) C4955.m14731(segmentedByteString.getSegments$okio(), iSegment, iSegment2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (iSegment <= iSegment2) {
            int i4 = 0;
            int i5 = iSegment;
            while (true) {
                iArr[i4] = Math.min(segmentedByteString.getDirectory$okio()[i5] - i, i3);
                int i6 = i4 + 1;
                iArr[i4 + bArr.length] = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + i5];
                if (i5 == iSegment2) {
                    break;
                }
                i5++;
                i4 = i6;
            }
        }
        int i7 = iSegment != 0 ? segmentedByteString.getDirectory$okio()[iSegment - 1] : 0;
        int length = bArr.length;
        iArr[length] = iArr[length] + (i - i7);
        return new SegmentedByteString(bArr, iArr);
    }

    public static final byte[] commonToByteArray(SegmentedByteString segmentedByteString) {
        C3921.m12667(segmentedByteString, "$this$commonToByteArray");
        byte[] bArr = new byte[segmentedByteString.size()];
        int length = segmentedByteString.getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int i4 = segmentedByteString.getDirectory$okio()[length + i];
            int i5 = segmentedByteString.getDirectory$okio()[i];
            int i6 = i5 - i2;
            C4955.m14726(segmentedByteString.getSegments$okio()[i], bArr, i3, i4, i4 + i6);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    public static final void commonWrite(SegmentedByteString segmentedByteString, Buffer buffer, int i, int i2) {
        C3921.m12667(segmentedByteString, "$this$commonWrite");
        C3921.m12667(buffer, "buffer");
        int i3 = i2 + i;
        int iSegment = segment(segmentedByteString, i);
        while (i < i3) {
            int i4 = iSegment == 0 ? 0 : segmentedByteString.getDirectory$okio()[iSegment - 1];
            int i5 = segmentedByteString.getDirectory$okio()[iSegment] - i4;
            int i6 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + iSegment];
            int iMin = Math.min(i3, i5 + i4) - i;
            int i7 = i6 + (i - i4);
            Segment segment = new Segment(segmentedByteString.getSegments$okio()[iSegment], i7, i7 + iMin, true, false);
            Segment segment2 = buffer.head;
            if (segment2 == null) {
                segment.prev = segment;
                segment.next = segment;
                buffer.head = segment;
            } else {
                if (segment2 == null) {
                    C3921.m12675();
                }
                Segment segment3 = segment2.prev;
                if (segment3 == null) {
                    C3921.m12675();
                }
                segment3.push(segment);
            }
            i += iMin;
            iSegment++;
        }
        buffer.setSize$okio(buffer.size() + segmentedByteString.size());
    }

    public static final void forEachSegment(SegmentedByteString segmentedByteString, InterfaceC3697<? super byte[], ? super Integer, ? super Integer, i4> interfaceC3697) {
        C3921.m12667(segmentedByteString, "$this$forEachSegment");
        C3921.m12667(interfaceC3697, "action");
        int length = segmentedByteString.getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = segmentedByteString.getDirectory$okio()[length + i];
            int i4 = segmentedByteString.getDirectory$okio()[i];
            interfaceC3697.m11844(segmentedByteString.getSegments$okio()[i], Integer.valueOf(i3), Integer.valueOf(i4 - i2));
            i++;
            i2 = i4;
        }
    }

    public static final int segment(SegmentedByteString segmentedByteString, int i) {
        C3921.m12667(segmentedByteString, "$this$segment");
        int iBinarySearch = binarySearch(segmentedByteString.getDirectory$okio(), i + 1, 0, segmentedByteString.getSegments$okio().length);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void forEachSegment(SegmentedByteString segmentedByteString, int i, int i2, InterfaceC3697<? super byte[], ? super Integer, ? super Integer, i4> interfaceC3697) {
        int iSegment = segment(segmentedByteString, i);
        while (i < i2) {
            int i3 = iSegment == 0 ? 0 : segmentedByteString.getDirectory$okio()[iSegment - 1];
            int i4 = segmentedByteString.getDirectory$okio()[iSegment] - i3;
            int i5 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + iSegment];
            int iMin = Math.min(i2, i4 + i3) - i;
            interfaceC3697.m11844(segmentedByteString.getSegments$okio()[iSegment], Integer.valueOf(i5 + (i - i3)), Integer.valueOf(iMin));
            i += iMin;
            iSegment++;
        }
    }

    public static final boolean commonRangeEquals(SegmentedByteString segmentedByteString, int i, byte[] bArr, int i2, int i3) {
        C3921.m12667(segmentedByteString, "$this$commonRangeEquals");
        C3921.m12667(bArr, "other");
        if (i < 0 || i > segmentedByteString.size() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int i4 = i3 + i;
        int iSegment = segment(segmentedByteString, i);
        while (i < i4) {
            int i5 = iSegment == 0 ? 0 : segmentedByteString.getDirectory$okio()[iSegment - 1];
            int i6 = segmentedByteString.getDirectory$okio()[iSegment] - i5;
            int i7 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + iSegment];
            int iMin = Math.min(i4, i6 + i5) - i;
            if (!Util.arrayRangeEquals(segmentedByteString.getSegments$okio()[iSegment], i7 + (i - i5), bArr, i2, iMin)) {
                return false;
            }
            i2 += iMin;
            i += iMin;
            iSegment++;
        }
        return true;
    }
}
