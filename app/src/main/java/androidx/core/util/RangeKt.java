package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.Range;
import androidx.annotation.RequiresApi;
import defpackage.C3921;
import defpackage.InterfaceC3528;

/* compiled from: Range.kt */
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: classes.dex */
public final class RangeKt {
    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> and(Range<T> range, Range<T> range2) {
        C3921.m12666(range, "<this>");
        C3921.m12666(range2, "other");
        Range<T> rangeIntersect = range.intersect(range2);
        C3921.m12665(rangeIntersect, "intersect(other)");
        return rangeIntersect;
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> range, T t) {
        C3921.m12666(range, "<this>");
        C3921.m12666(t, "value");
        Range<T> rangeExtend = range.extend((Range<T>) t);
        C3921.m12665(rangeExtend, "extend(value)");
        return rangeExtend;
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> rangeTo(T t, T t2) {
        C3921.m12666(t, "<this>");
        C3921.m12666(t2, "that");
        return new Range<>(t, t2);
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> InterfaceC3528<T> toClosedRange(final Range<T> range) {
        C3921.m12666(range, "<this>");
        return (InterfaceC3528<T>) new InterfaceC3528<T>() { // from class: androidx.core.util.RangeKt.toClosedRange.1
            /* JADX WARN: Incorrect types in method signature: (TT;)Z */
            public boolean contains(Comparable comparable) {
                return InterfaceC3528.C3529.m11468(this, comparable);
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // defpackage.InterfaceC3528
            public Comparable getEndInclusive() {
                return range.getUpper();
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // defpackage.InterfaceC3528
            public Comparable getStart() {
                return range.getLower();
            }

            public boolean isEmpty() {
                return InterfaceC3528.C3529.m11469(this);
            }
        };
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> toRange(InterfaceC3528<T> interfaceC3528) {
        C3921.m12666(interfaceC3528, "<this>");
        return new Range<>(interfaceC3528.getStart(), interfaceC3528.getEndInclusive());
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> range, Range<T> range2) {
        C3921.m12666(range, "<this>");
        C3921.m12666(range2, "other");
        Range<T> rangeExtend = range.extend(range2);
        C3921.m12665(rangeExtend, "extend(other)");
        return rangeExtend;
    }
}
