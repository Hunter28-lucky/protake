package okio;

import defpackage.C3921;
import defpackage.C4905;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: SegmentPool.kt */
/* loaded from: classes2.dex */
public final class SegmentPool {
    private static final int HASH_BUCKET_COUNT;
    private static final AtomicReference<Segment>[] hashBuckets;
    public static final SegmentPool INSTANCE = new SegmentPool();
    private static final int MAX_SIZE = 65536;
    private static final Segment LOCK = new Segment(new byte[0], 0, 0, false, false);

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        HASH_BUCKET_COUNT = iHighestOneBit;
        AtomicReference<Segment>[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i = 0; i < iHighestOneBit; i++) {
            atomicReferenceArr[i] = new AtomicReference<>();
        }
        hashBuckets = atomicReferenceArr;
    }

    private SegmentPool() {
    }

    private final AtomicReference<Segment> firstRef() {
        Thread threadCurrentThread = Thread.currentThread();
        C3921.m12663(threadCurrentThread, "Thread.currentThread()");
        return hashBuckets[(int) (threadCurrentThread.getId() & (HASH_BUCKET_COUNT - 1))];
    }

    public static final void recycle(Segment segment) {
        AtomicReference<Segment> atomicReferenceFirstRef;
        Segment segment2;
        C3921.m12667(segment, "segment");
        if (!(segment.next == null && segment.prev == null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (segment.shared || (segment2 = (atomicReferenceFirstRef = INSTANCE.firstRef()).get()) == LOCK) {
            return;
        }
        int i = segment2 != null ? segment2.limit : 0;
        if (i >= MAX_SIZE) {
            return;
        }
        segment.next = segment2;
        segment.pos = 0;
        segment.limit = i + 8192;
        if (C4905.m14631(atomicReferenceFirstRef, segment2, segment)) {
            return;
        }
        segment.next = null;
    }

    public static final Segment take() {
        AtomicReference<Segment> atomicReferenceFirstRef = INSTANCE.firstRef();
        Segment segment = LOCK;
        Segment andSet = atomicReferenceFirstRef.getAndSet(segment);
        if (andSet == segment) {
            return new Segment();
        }
        if (andSet == null) {
            atomicReferenceFirstRef.set(null);
            return new Segment();
        }
        atomicReferenceFirstRef.set(andSet.next);
        andSet.next = null;
        andSet.limit = 0;
        return andSet;
    }

    public final int getByteCount() {
        Segment segment = firstRef().get();
        if (segment != null) {
            return segment.limit;
        }
        return 0;
    }

    public final int getMAX_SIZE() {
        return MAX_SIZE;
    }
}
