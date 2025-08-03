package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import com.umeng.analytics.pro.am;
import defpackage.C3921;
import defpackage.InterfaceC2392;
import defpackage.InterfaceC4947;
import defpackage.i4;
import java.util.Iterator;

/* compiled from: Region.kt */
/* loaded from: classes.dex */
public final class RegionKt {

    /* compiled from: Region.kt */
    /* renamed from: androidx.core.graphics.RegionKt$iterator$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<Rect>, InterfaceC4947 {
        private boolean hasMore;
        private final RegionIterator iterator;
        private final Rect rect;

        public AnonymousClass1(Region region) {
            RegionIterator regionIterator = new RegionIterator(region);
            this.iterator = regionIterator;
            Rect rect = new Rect();
            this.rect = rect;
            this.hasMore = regionIterator.next(rect);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.hasMore;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Rect next() {
            if (!this.hasMore) {
                throw new IndexOutOfBoundsException();
            }
            Rect rect = new Rect(this.rect);
            this.hasMore = this.iterator.next(this.rect);
            return rect;
        }
    }

    public static final Region and(Region region, Rect rect) {
        C3921.m12666(region, "<this>");
        C3921.m12666(rect, "r");
        Region region2 = new Region(region);
        region2.op(rect, Region.Op.INTERSECT);
        return region2;
    }

    public static final boolean contains(Region region, Point point) {
        C3921.m12666(region, "<this>");
        C3921.m12666(point, am.ax);
        return region.contains(point.x, point.y);
    }

    public static final void forEach(Region region, InterfaceC2392<? super Rect, i4> interfaceC2392) {
        C3921.m12666(region, "<this>");
        C3921.m12666(interfaceC2392, "action");
        RegionIterator regionIterator = new RegionIterator(region);
        while (true) {
            Rect rect = new Rect();
            if (!regionIterator.next(rect)) {
                return;
            } else {
                interfaceC2392.invoke(rect);
            }
        }
    }

    public static final Iterator<Rect> iterator(Region region) {
        C3921.m12666(region, "<this>");
        return new AnonymousClass1(region);
    }

    public static final Region minus(Region region, Rect rect) {
        C3921.m12666(region, "<this>");
        C3921.m12666(rect, "r");
        Region region2 = new Region(region);
        region2.op(rect, Region.Op.DIFFERENCE);
        return region2;
    }

    public static final Region not(Region region) {
        C3921.m12666(region, "<this>");
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    public static final Region or(Region region, Rect rect) {
        C3921.m12666(region, "<this>");
        C3921.m12666(rect, "r");
        Region region2 = new Region(region);
        region2.union(rect);
        return region2;
    }

    public static final Region plus(Region region, Rect rect) {
        C3921.m12666(region, "<this>");
        C3921.m12666(rect, "r");
        Region region2 = new Region(region);
        region2.union(rect);
        return region2;
    }

    public static final Region unaryMinus(Region region) {
        C3921.m12666(region, "<this>");
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    public static final Region xor(Region region, Rect rect) {
        C3921.m12666(region, "<this>");
        C3921.m12666(rect, "r");
        Region region2 = new Region(region);
        region2.op(rect, Region.Op.XOR);
        return region2;
    }

    public static final Region and(Region region, Region region2) {
        C3921.m12666(region, "<this>");
        C3921.m12666(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.INTERSECT);
        return region3;
    }

    public static final Region minus(Region region, Region region2) {
        C3921.m12666(region, "<this>");
        C3921.m12666(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.DIFFERENCE);
        return region3;
    }

    public static final Region or(Region region, Region region2) {
        C3921.m12666(region, "<this>");
        C3921.m12666(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.UNION);
        return region3;
    }

    public static final Region plus(Region region, Region region2) {
        C3921.m12666(region, "<this>");
        C3921.m12666(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.UNION);
        return region3;
    }

    public static final Region xor(Region region, Region region2) {
        C3921.m12666(region, "<this>");
        C3921.m12666(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.XOR);
        return region3;
    }
}
