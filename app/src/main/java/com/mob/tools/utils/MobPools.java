package com.mob.tools.utils;

import com.mob.tools.MobLog;
import com.mob.tools.proguard.PublicMemberKeeper;

/* loaded from: classes2.dex */
public final class MobPools implements PublicMemberKeeper {

    public interface Pool<T> extends PublicMemberKeeper {
        T acquire();

        boolean release(T t);
    }

    public static class SimplePool<T> implements Pool<T> {
        private final Object[] a;
        private int b;

        public SimplePool(int i) {
            if (i <= 0) {
                throw new IllegalArgumentException("The max pool size must be > 0");
            }
            this.a = new Object[i];
        }

        private boolean a(T t) {
            for (int i = 0; i < this.b; i++) {
                if (this.a[i] == t) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.mob.tools.utils.MobPools.Pool
        public T acquire() {
            int i = this.b;
            if (i > 0) {
                int i2 = i - 1;
                try {
                    Object[] objArr = this.a;
                    T t = (T) objArr[i2];
                    objArr[i2] = null;
                    this.b = i - 1;
                    return t;
                } catch (Throwable th) {
                    MobLog.getInstance().d(th);
                }
            }
            return null;
        }

        @Override // com.mob.tools.utils.MobPools.Pool
        public boolean release(T t) {
            if (a(t)) {
                throw new IllegalStateException("Already in the pool!");
            }
            int i = this.b;
            Object[] objArr = this.a;
            if (i >= objArr.length) {
                return false;
            }
            objArr[i] = t;
            this.b = i + 1;
            return true;
        }
    }

    private MobPools() {
    }

    public static class SynchronizedPool<T> extends SimplePool<T> {
        private final Object a;

        public SynchronizedPool(int i, Object obj) {
            super(i);
            this.a = obj;
        }

        @Override // com.mob.tools.utils.MobPools.SimplePool, com.mob.tools.utils.MobPools.Pool
        public T acquire() {
            T t;
            synchronized (this.a) {
                t = (T) super.acquire();
            }
            return t;
        }

        @Override // com.mob.tools.utils.MobPools.SimplePool, com.mob.tools.utils.MobPools.Pool
        public boolean release(T t) {
            boolean zRelease;
            synchronized (this.a) {
                zRelease = super.release(t);
            }
            return zRelease;
        }

        public SynchronizedPool(int i) {
            this(i, new Object());
        }
    }
}
