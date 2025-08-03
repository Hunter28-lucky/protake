package okio;

import defpackage.C3921;
import defpackage.C4184;
import defpackage.C4955;
import java.util.Arrays;

/* compiled from: Segment.kt */
/* loaded from: classes2.dex */
public final class Segment {
    public static final Companion Companion = new Companion(null);
    public static final int SHARE_MINIMUM = 1024;
    public static final int SIZE = 8192;
    public final byte[] data;
    public int limit;
    public Segment next;
    public boolean owner;
    public int pos;
    public Segment prev;
    public boolean shared;

    /* compiled from: Segment.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(C4184 c4184) {
            this();
        }
    }

    public Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    public final void compact() {
        Segment segment = this.prev;
        int i = 0;
        if (!(segment != this)) {
            throw new IllegalStateException("cannot compact".toString());
        }
        if (segment == null) {
            C3921.m12675();
        }
        if (segment.owner) {
            int i2 = this.limit - this.pos;
            Segment segment2 = this.prev;
            if (segment2 == null) {
                C3921.m12675();
            }
            int i3 = 8192 - segment2.limit;
            Segment segment3 = this.prev;
            if (segment3 == null) {
                C3921.m12675();
            }
            if (!segment3.shared) {
                Segment segment4 = this.prev;
                if (segment4 == null) {
                    C3921.m12675();
                }
                i = segment4.pos;
            }
            if (i2 > i3 + i) {
                return;
            }
            Segment segment5 = this.prev;
            if (segment5 == null) {
                C3921.m12675();
            }
            writeTo(segment5, i2);
            pop();
            SegmentPool.recycle(this);
        }
    }

    public final Segment pop() {
        Segment segment = this.next;
        if (segment == this) {
            segment = null;
        }
        Segment segment2 = this.prev;
        if (segment2 == null) {
            C3921.m12675();
        }
        segment2.next = this.next;
        Segment segment3 = this.next;
        if (segment3 == null) {
            C3921.m12675();
        }
        segment3.prev = this.prev;
        this.next = null;
        this.prev = null;
        return segment;
    }

    public final Segment push(Segment segment) {
        C3921.m12667(segment, "segment");
        segment.prev = this;
        segment.next = this.next;
        Segment segment2 = this.next;
        if (segment2 == null) {
            C3921.m12675();
        }
        segment2.prev = segment;
        this.next = segment;
        return segment;
    }

    public final Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true, false);
    }

    public final Segment split(int i) {
        Segment segmentTake;
        if (!(i > 0 && i <= this.limit - this.pos)) {
            throw new IllegalArgumentException("byteCount out of range".toString());
        }
        if (i >= 1024) {
            segmentTake = sharedCopy();
        } else {
            segmentTake = SegmentPool.take();
            byte[] bArr = this.data;
            byte[] bArr2 = segmentTake.data;
            int i2 = this.pos;
            C4955.m14728(bArr, bArr2, 0, i2, i2 + i, 2, null);
        }
        segmentTake.limit = segmentTake.pos + i;
        this.pos += i;
        Segment segment = this.prev;
        if (segment == null) {
            C3921.m12675();
        }
        segment.push(segmentTake);
        return segmentTake;
    }

    public final Segment unsharedCopy() {
        byte[] bArr = this.data;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        C3921.m12663(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
        return new Segment(bArrCopyOf, this.pos, this.limit, false, true);
    }

    public final void writeTo(Segment segment, int i) {
        C3921.m12667(segment, "sink");
        if (!segment.owner) {
            throw new IllegalStateException("only owner can write".toString());
        }
        int i2 = segment.limit;
        if (i2 + i > 8192) {
            if (segment.shared) {
                throw new IllegalArgumentException();
            }
            int i3 = segment.pos;
            if ((i2 + i) - i3 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = segment.data;
            C4955.m14728(bArr, bArr, 0, i3, i2, 2, null);
            segment.limit -= segment.pos;
            segment.pos = 0;
        }
        byte[] bArr2 = this.data;
        byte[] bArr3 = segment.data;
        int i4 = segment.limit;
        int i5 = this.pos;
        C4955.m14726(bArr2, bArr3, i4, i5, i5 + i);
        segment.limit += i;
        this.pos += i;
    }

    public Segment(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        C3921.m12667(bArr, "data");
        this.data = bArr;
        this.pos = i;
        this.limit = i2;
        this.shared = z;
        this.owner = z2;
    }
}
