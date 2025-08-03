package io.reactivex.internal.functions;

import defpackage.AbstractC4585;
import defpackage.C3671;
import defpackage.C3906;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2485;
import defpackage.InterfaceC2568;
import defpackage.InterfaceC2825;
import defpackage.InterfaceC2857;
import defpackage.InterfaceC2881;
import defpackage.InterfaceC2954;
import defpackage.InterfaceC3482;
import defpackage.InterfaceC3809;
import defpackage.InterfaceC4178;
import defpackage.InterfaceC4216;
import defpackage.InterfaceC4399;
import defpackage.InterfaceC4719;
import defpackage.InterfaceC5246;
import defpackage.InterfaceC5247;
import defpackage.o2;
import io.reactivex.exceptions.OnErrorNotImplementedException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class Functions {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final InterfaceC2368<Object, Object> f6796 = new C1997();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final Runnable f6797 = new RunnableC1993();

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final InterfaceC3809 f6798 = new C1990();

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final InterfaceC2857<Object> f6799 = new C1991();

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final InterfaceC2857<Throwable> f6800 = new C1995();

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final InterfaceC2857<Throwable> f6801 = new C2006();

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final InterfaceC4719 f6802 = new C1992();

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final InterfaceC4178<Object> f6803 = new C2011();

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final InterfaceC4178<Object> f6804 = new C1996();

    /* renamed from: ՠ, reason: contains not printable characters */
    public static final Callable<Object> f6805 = new CallableC2005();

    /* renamed from: ֈ, reason: contains not printable characters */
    public static final Comparator<Object> f6806 = new C2001();

    /* renamed from: ֏, reason: contains not printable characters */
    public static final InterfaceC2857<Subscription> f6807 = new C2000();

    public enum HashSetCallable implements Callable<Set<Object>> {
        INSTANCE;

        @Override // java.util.concurrent.Callable
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public Set<Object> call() throws Exception {
            return new HashSet();
        }
    }

    public enum NaturalComparator implements Comparator<Object> {
        INSTANCE;

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$Ϳ, reason: contains not printable characters */
    public static final class C1976<T> implements InterfaceC2857<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC3809 f6812;

        public C1976(InterfaceC3809 interfaceC3809) {
            this.f6812 = interfaceC3809;
        }

        @Override // defpackage.InterfaceC2857
        public void accept(T t) throws Exception {
            this.f6812.run();
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$Ԩ, reason: contains not printable characters */
    public static final class C1977<T1, T2, R> implements InterfaceC2368<Object[], R> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5247<? super T1, ? super T2, ? extends R> f6813;

        public C1977(InterfaceC5247<? super T1, ? super T2, ? extends R> interfaceC5247) {
            this.f6813 = interfaceC5247;
        }

        @Override // defpackage.InterfaceC2368
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 2) {
                return this.f6813.apply(objArr[0], objArr[1]);
            }
            throw new IllegalArgumentException("Array of size 2 expected but got " + objArr.length);
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$Ԫ, reason: contains not printable characters */
    public static final class C1978<T1, T2, T3, R> implements InterfaceC2368<Object[], R> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC3482<T1, T2, T3, R> f6814;

        public C1978(InterfaceC3482<T1, T2, T3, R> interfaceC3482) {
            this.f6814 = interfaceC3482;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.InterfaceC2368
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 3) {
                return (R) this.f6814.m11336(objArr[0], objArr[1], objArr[2]);
            }
            throw new IllegalArgumentException("Array of size 3 expected but got " + objArr.length);
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$Ԭ, reason: contains not printable characters */
    public static final class C1979<T1, T2, T3, T4, R> implements InterfaceC2368<Object[], R> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC4216<T1, T2, T3, T4, R> f6815;

        public C1979(InterfaceC4216<T1, T2, T3, T4, R> interfaceC4216) {
            this.f6815 = interfaceC4216;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.InterfaceC2368
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 4) {
                return (R) this.f6815.m13295(objArr[0], objArr[1], objArr[2], objArr[3]);
            }
            throw new IllegalArgumentException("Array of size 4 expected but got " + objArr.length);
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$Ԯ, reason: contains not printable characters */
    public static final class C1980<T1, T2, T3, T4, T5, R> implements InterfaceC2368<Object[], R> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC2568<T1, T2, T3, T4, T5, R> f6816;

        public C1980(InterfaceC2568<T1, T2, T3, T4, T5, R> interfaceC2568) {
            this.f6816 = interfaceC2568;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.InterfaceC2368
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 5) {
                return (R) this.f6816.m9424(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4]);
            }
            throw new IllegalArgumentException("Array of size 5 expected but got " + objArr.length);
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$ՠ, reason: contains not printable characters */
    public static final class C1981<T1, T2, T3, T4, T5, T6, R> implements InterfaceC2368<Object[], R> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC2485<T1, T2, T3, T4, T5, T6, R> f6817;

        public C1981(InterfaceC2485<T1, T2, T3, T4, T5, T6, R> interfaceC2485) {
            this.f6817 = interfaceC2485;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.InterfaceC2368
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 6) {
                return (R) this.f6817.m9080(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5]);
            }
            throw new IllegalArgumentException("Array of size 6 expected but got " + objArr.length);
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$ֈ, reason: contains not printable characters */
    public static final class C1982<T1, T2, T3, T4, T5, T6, T7, R> implements InterfaceC2368<Object[], R> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC2825<T1, T2, T3, T4, T5, T6, T7, R> f6818;

        public C1982(InterfaceC2825<T1, T2, T3, T4, T5, T6, T7, R> interfaceC2825) {
            this.f6818 = interfaceC2825;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.InterfaceC2368
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 7) {
                return (R) this.f6818.m10170(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6]);
            }
            throw new IllegalArgumentException("Array of size 7 expected but got " + objArr.length);
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$֏, reason: contains not printable characters */
    public static final class C1983<T1, T2, T3, T4, T5, T6, T7, T8, R> implements InterfaceC2368<Object[], R> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC4399<T1, T2, T3, T4, T5, T6, T7, T8, R> f6819;

        public C1983(InterfaceC4399<T1, T2, T3, T4, T5, T6, T7, T8, R> interfaceC4399) {
            this.f6819 = interfaceC4399;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.InterfaceC2368
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 8) {
                return (R) this.f6819.m13590(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7]);
            }
            throw new IllegalArgumentException("Array of size 8 expected but got " + objArr.length);
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$ׯ, reason: contains not printable characters */
    public static final class C1984<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements InterfaceC2368<Object[], R> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC2954<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> f6820;

        public C1984(InterfaceC2954<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> interfaceC2954) {
            this.f6820 = interfaceC2954;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // defpackage.InterfaceC2368
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public R apply(Object[] objArr) throws Exception {
            if (objArr.length == 9) {
                return (R) this.f6820.m10366(objArr[0], objArr[1], objArr[2], objArr[3], objArr[4], objArr[5], objArr[6], objArr[7], objArr[8]);
            }
            throw new IllegalArgumentException("Array of size 9 expected but got " + objArr.length);
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$ؠ, reason: contains not printable characters */
    public static final class CallableC1985<T> implements Callable<List<T>> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final int f6821;

        public CallableC1985(int i) {
            this.f6821 = i;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public List<T> call() throws Exception {
            return new ArrayList(this.f6821);
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$ހ, reason: contains not printable characters */
    public static final class C1986<T> implements InterfaceC4178<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC2881 f6822;

        public C1986(InterfaceC2881 interfaceC2881) {
            this.f6822 = interfaceC2881;
        }

        @Override // defpackage.InterfaceC4178
        public boolean test(T t) throws Exception {
            return !this.f6822.mo6378();
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$ށ, reason: contains not printable characters */
    public static class C1987 implements InterfaceC2857<Subscription> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final int f6823;

        public C1987(int i) {
            this.f6823 = i;
        }

        @Override // defpackage.InterfaceC2857
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void accept(Subscription subscription) throws Exception {
            subscription.request(this.f6823);
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$ނ, reason: contains not printable characters */
    public static final class C1988<T, U> implements InterfaceC2368<T, U> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Class<U> f6824;

        public C1988(Class<U> cls) {
            this.f6824 = cls;
        }

        @Override // defpackage.InterfaceC2368
        public U apply(T t) throws Exception {
            return this.f6824.cast(t);
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$ރ, reason: contains not printable characters */
    public static final class C1989<T, U> implements InterfaceC4178<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Class<U> f6825;

        public C1989(Class<U> cls) {
            this.f6825 = cls;
        }

        @Override // defpackage.InterfaceC4178
        public boolean test(T t) throws Exception {
            return this.f6825.isInstance(t);
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$ބ, reason: contains not printable characters */
    public static final class C1990 implements InterfaceC3809 {
        @Override // defpackage.InterfaceC3809
        public void run() {
        }

        public String toString() {
            return "EmptyAction";
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$ޅ, reason: contains not printable characters */
    public static final class C1991 implements InterfaceC2857<Object> {
        @Override // defpackage.InterfaceC2857
        public void accept(Object obj) {
        }

        public String toString() {
            return "EmptyConsumer";
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$ކ, reason: contains not printable characters */
    public static final class C1992 implements InterfaceC4719 {
        @Override // defpackage.InterfaceC4719
        public void accept(long j) {
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$އ, reason: contains not printable characters */
    public static final class RunnableC1993 implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
        }

        public String toString() {
            return "EmptyRunnable";
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$ވ, reason: contains not printable characters */
    public static final class C1994<T> implements InterfaceC4178<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final T f6826;

        public C1994(T t) {
            this.f6826 = t;
        }

        @Override // defpackage.InterfaceC4178
        public boolean test(T t) throws Exception {
            return C4246.m13351(t, this.f6826);
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$މ, reason: contains not printable characters */
    public static final class C1995 implements InterfaceC2857<Throwable> {
        @Override // defpackage.InterfaceC2857
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            C3671.m11803(th);
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$ފ, reason: contains not printable characters */
    public static final class C1996 implements InterfaceC4178<Object> {
        @Override // defpackage.InterfaceC4178
        public boolean test(Object obj) {
            return false;
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$ދ, reason: contains not printable characters */
    public static final class C1997 implements InterfaceC2368<Object, Object> {
        @Override // defpackage.InterfaceC2368
        public Object apply(Object obj) {
            return obj;
        }

        public String toString() {
            return "IdentityFunction";
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$ތ, reason: contains not printable characters */
    public static final class CallableC1998<T, U> implements Callable<U>, InterfaceC2368<T, U> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final U f6827;

        public CallableC1998(U u) {
            this.f6827 = u;
        }

        @Override // defpackage.InterfaceC2368
        public U apply(T t) throws Exception {
            return this.f6827;
        }

        @Override // java.util.concurrent.Callable
        public U call() throws Exception {
            return this.f6827;
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$ލ, reason: contains not printable characters */
    public static final class C1999<T> implements InterfaceC2368<List<T>, List<T>> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Comparator<? super T> f6828;

        public C1999(Comparator<? super T> comparator) {
            this.f6828 = comparator;
        }

        @Override // defpackage.InterfaceC2368
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public List<T> apply(List<T> list) {
            Collections.sort(list, this.f6828);
            return list;
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$ގ, reason: contains not printable characters */
    public static final class C2000 implements InterfaceC2857<Subscription> {
        @Override // defpackage.InterfaceC2857
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void accept(Subscription subscription) throws Exception {
            subscription.request(Long.MAX_VALUE);
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$ޏ, reason: contains not printable characters */
    public static final class C2001 implements Comparator<Object> {
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$ސ, reason: contains not printable characters */
    public static final class C2002<T> implements InterfaceC3809 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC2857<? super C3906<T>> f6829;

        public C2002(InterfaceC2857<? super C3906<T>> interfaceC2857) {
            this.f6829 = interfaceC2857;
        }

        @Override // defpackage.InterfaceC3809
        public void run() throws Exception {
            this.f6829.accept(C3906.m12645());
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$ޑ, reason: contains not printable characters */
    public static final class C2003<T> implements InterfaceC2857<Throwable> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC2857<? super C3906<T>> f6830;

        public C2003(InterfaceC2857<? super C3906<T>> interfaceC2857) {
            this.f6830 = interfaceC2857;
        }

        @Override // defpackage.InterfaceC2857
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            this.f6830.accept(C3906.m12646(th));
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$ޒ, reason: contains not printable characters */
    public static final class C2004<T> implements InterfaceC2857<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC2857<? super C3906<T>> f6831;

        public C2004(InterfaceC2857<? super C3906<T>> interfaceC2857) {
            this.f6831 = interfaceC2857;
        }

        @Override // defpackage.InterfaceC2857
        public void accept(T t) throws Exception {
            this.f6831.accept(C3906.m12647(t));
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$ޓ, reason: contains not printable characters */
    public static final class CallableC2005 implements Callable<Object> {
        @Override // java.util.concurrent.Callable
        public Object call() {
            return null;
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$ޔ, reason: contains not printable characters */
    public static final class C2006 implements InterfaceC2857<Throwable> {
        @Override // defpackage.InterfaceC2857
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void accept(Throwable th) {
            C3671.m11803(new OnErrorNotImplementedException(th));
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$ޕ, reason: contains not printable characters */
    public static final class C2007<T> implements InterfaceC2368<T, o2<T>> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final TimeUnit f6832;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final AbstractC4585 f6833;

        public C2007(TimeUnit timeUnit, AbstractC4585 abstractC4585) {
            this.f6832 = timeUnit;
            this.f6833 = abstractC4585;
        }

        @Override // defpackage.InterfaceC2368
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public o2<T> apply(T t) throws Exception {
            return new o2<>(t, this.f6833.m14050(this.f6832), this.f6832);
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$ޖ, reason: contains not printable characters */
    public static final class C2008<K, T> implements InterfaceC5246<Map<K, T>, T> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final InterfaceC2368<? super T, ? extends K> f6834;

        public C2008(InterfaceC2368<? super T, ? extends K> interfaceC2368) {
            this.f6834 = interfaceC2368;
        }

        @Override // defpackage.InterfaceC5246
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void accept(Map<K, T> map, T t) throws Exception {
            map.put(this.f6834.apply(t), t);
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$ޗ, reason: contains not printable characters */
    public static final class C2009<K, V, T> implements InterfaceC5246<Map<K, V>, T> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final InterfaceC2368<? super T, ? extends V> f6835;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final InterfaceC2368<? super T, ? extends K> f6836;

        public C2009(InterfaceC2368<? super T, ? extends V> interfaceC2368, InterfaceC2368<? super T, ? extends K> interfaceC23682) {
            this.f6835 = interfaceC2368;
            this.f6836 = interfaceC23682;
        }

        @Override // defpackage.InterfaceC5246
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void accept(Map<K, V> map, T t) throws Exception {
            map.put(this.f6836.apply(t), this.f6835.apply(t));
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$ޘ, reason: contains not printable characters */
    public static final class C2010<K, V, T> implements InterfaceC5246<Map<K, Collection<V>>, T> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final InterfaceC2368<? super K, ? extends Collection<? super V>> f6837;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final InterfaceC2368<? super T, ? extends V> f6838;

        /* renamed from: ԩ, reason: contains not printable characters */
        public final InterfaceC2368<? super T, ? extends K> f6839;

        public C2010(InterfaceC2368<? super K, ? extends Collection<? super V>> interfaceC2368, InterfaceC2368<? super T, ? extends V> interfaceC23682, InterfaceC2368<? super T, ? extends K> interfaceC23683) {
            this.f6837 = interfaceC2368;
            this.f6838 = interfaceC23682;
            this.f6839 = interfaceC23683;
        }

        @Override // defpackage.InterfaceC5246
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void accept(Map<K, Collection<V>> map, T t) throws Exception {
            K kApply = this.f6839.apply(t);
            Collection<? super V> collectionApply = (Collection) map.get(kApply);
            if (collectionApply == null) {
                collectionApply = this.f6837.apply(kApply);
                map.put(kApply, collectionApply);
            }
            collectionApply.add(this.f6838.apply(t));
        }
    }

    /* renamed from: io.reactivex.internal.functions.Functions$ޙ, reason: contains not printable characters */
    public static final class C2011 implements InterfaceC4178<Object> {
        @Override // defpackage.InterfaceC4178
        public boolean test(Object obj) {
            return true;
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static <T> InterfaceC2857<T> m6313(InterfaceC3809 interfaceC3809) {
        return new C1976(interfaceC3809);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static <T> InterfaceC4178<T> m6314() {
        return (InterfaceC4178<T>) f6804;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static <T> InterfaceC4178<T> m6315() {
        return (InterfaceC4178<T>) f6803;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static <T> InterfaceC2857<T> m6316(int i) {
        return new C1987(i);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static <T, U> InterfaceC2368<T, U> m6317(Class<U> cls) {
        return new C1988(cls);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static <T> Callable<List<T>> m6318(int i) {
        return new CallableC1985(i);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static <T> Callable<Set<T>> m6319() {
        return HashSetCallable.INSTANCE;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static <T> InterfaceC2857<T> m6320() {
        return (InterfaceC2857<T>) f6799;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static <T> InterfaceC4178<T> m6321(T t) {
        return new C1994(t);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static <T> InterfaceC2368<T, T> m6322() {
        return (InterfaceC2368<T, T>) f6796;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static <T, U> InterfaceC4178<T> m6323(Class<U> cls) {
        return new C1989(cls);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static <T> Callable<T> m6324(T t) {
        return new CallableC1998(t);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public static <T, U> InterfaceC2368<T, U> m6325(U u) {
        return new CallableC1998(u);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public static <T> InterfaceC2368<List<T>, List<T>> m6326(Comparator<? super T> comparator) {
        return new C1999(comparator);
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public static <T> Comparator<T> m6327() {
        return NaturalComparator.INSTANCE;
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public static <T> Comparator<T> m6328() {
        return (Comparator<T>) f6806;
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public static <T> InterfaceC3809 m6329(InterfaceC2857<? super C3906<T>> interfaceC2857) {
        return new C2002(interfaceC2857);
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public static <T> InterfaceC2857<Throwable> m6330(InterfaceC2857<? super C3906<T>> interfaceC2857) {
        return new C2003(interfaceC2857);
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public static <T> InterfaceC2857<T> m6331(InterfaceC2857<? super C3906<T>> interfaceC2857) {
        return new C2004(interfaceC2857);
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public static <T> Callable<T> m6332() {
        return (Callable<T>) f6805;
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public static <T> InterfaceC4178<T> m6333(InterfaceC2881 interfaceC2881) {
        return new C1986(interfaceC2881);
    }

    /* renamed from: އ, reason: contains not printable characters */
    public static <T> InterfaceC2368<T, o2<T>> m6334(TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return new C2007(timeUnit, abstractC4585);
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public static <T1, T2, R> InterfaceC2368<Object[], R> m6335(InterfaceC5247<? super T1, ? super T2, ? extends R> interfaceC5247) {
        C4246.m13353(interfaceC5247, "f is null");
        return new C1977(interfaceC5247);
    }

    /* renamed from: މ, reason: contains not printable characters */
    public static <T1, T2, T3, R> InterfaceC2368<Object[], R> m6336(InterfaceC3482<T1, T2, T3, R> interfaceC3482) {
        C4246.m13353(interfaceC3482, "f is null");
        return new C1978(interfaceC3482);
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public static <T1, T2, T3, T4, R> InterfaceC2368<Object[], R> m6337(InterfaceC4216<T1, T2, T3, T4, R> interfaceC4216) {
        C4246.m13353(interfaceC4216, "f is null");
        return new C1979(interfaceC4216);
    }

    /* renamed from: ދ, reason: contains not printable characters */
    public static <T1, T2, T3, T4, T5, R> InterfaceC2368<Object[], R> m6338(InterfaceC2568<T1, T2, T3, T4, T5, R> interfaceC2568) {
        C4246.m13353(interfaceC2568, "f is null");
        return new C1980(interfaceC2568);
    }

    /* renamed from: ތ, reason: contains not printable characters */
    public static <T1, T2, T3, T4, T5, T6, R> InterfaceC2368<Object[], R> m6339(InterfaceC2485<T1, T2, T3, T4, T5, T6, R> interfaceC2485) {
        C4246.m13353(interfaceC2485, "f is null");
        return new C1981(interfaceC2485);
    }

    /* renamed from: ލ, reason: contains not printable characters */
    public static <T1, T2, T3, T4, T5, T6, T7, R> InterfaceC2368<Object[], R> m6340(InterfaceC2825<T1, T2, T3, T4, T5, T6, T7, R> interfaceC2825) {
        C4246.m13353(interfaceC2825, "f is null");
        return new C1982(interfaceC2825);
    }

    /* renamed from: ގ, reason: contains not printable characters */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> InterfaceC2368<Object[], R> m6341(InterfaceC4399<T1, T2, T3, T4, T5, T6, T7, T8, R> interfaceC4399) {
        C4246.m13353(interfaceC4399, "f is null");
        return new C1983(interfaceC4399);
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> InterfaceC2368<Object[], R> m6342(InterfaceC2954<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> interfaceC2954) {
        C4246.m13353(interfaceC2954, "f is null");
        return new C1984(interfaceC2954);
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public static <T, K> InterfaceC5246<Map<K, T>, T> m6343(InterfaceC2368<? super T, ? extends K> interfaceC2368) {
        return new C2008(interfaceC2368);
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public static <T, K, V> InterfaceC5246<Map<K, V>, T> m6344(InterfaceC2368<? super T, ? extends K> interfaceC2368, InterfaceC2368<? super T, ? extends V> interfaceC23682) {
        return new C2009(interfaceC23682, interfaceC2368);
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public static <T, K, V> InterfaceC5246<Map<K, Collection<V>>, T> m6345(InterfaceC2368<? super T, ? extends K> interfaceC2368, InterfaceC2368<? super T, ? extends V> interfaceC23682, InterfaceC2368<? super K, ? extends Collection<? super V>> interfaceC23683) {
        return new C2010(interfaceC23683, interfaceC23682, interfaceC2368);
    }
}
