package defpackage;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

/* compiled from: DiskCacheStrategy.java */
/* renamed from: ڙ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC3541 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final AbstractC3541 f12339 = new C3542();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final AbstractC3541 f12340 = new C3543();

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final AbstractC3541 f12341 = new C3544();

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final AbstractC3541 f12342 = new C3545();

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final AbstractC3541 f12343 = new C3546();

    /* compiled from: DiskCacheStrategy.java */
    /* renamed from: ڙ$Ϳ, reason: contains not printable characters */
    public class C3542 extends AbstractC3541 {
        @Override // defpackage.AbstractC3541
        /* renamed from: Ϳ */
        public boolean mo11482() {
            return true;
        }

        @Override // defpackage.AbstractC3541
        /* renamed from: Ԩ */
        public boolean mo11483() {
            return true;
        }

        @Override // defpackage.AbstractC3541
        /* renamed from: ԩ */
        public boolean mo11484(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        @Override // defpackage.AbstractC3541
        /* renamed from: Ԫ */
        public boolean mo11485(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    }

    /* compiled from: DiskCacheStrategy.java */
    /* renamed from: ڙ$Ԩ, reason: contains not printable characters */
    public class C3543 extends AbstractC3541 {
        @Override // defpackage.AbstractC3541
        /* renamed from: Ϳ */
        public boolean mo11482() {
            return false;
        }

        @Override // defpackage.AbstractC3541
        /* renamed from: Ԩ */
        public boolean mo11483() {
            return false;
        }

        @Override // defpackage.AbstractC3541
        /* renamed from: ԩ */
        public boolean mo11484(DataSource dataSource) {
            return false;
        }

        @Override // defpackage.AbstractC3541
        /* renamed from: Ԫ */
        public boolean mo11485(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    }

    /* compiled from: DiskCacheStrategy.java */
    /* renamed from: ڙ$Ԫ, reason: contains not printable characters */
    public class C3544 extends AbstractC3541 {
        @Override // defpackage.AbstractC3541
        /* renamed from: Ϳ */
        public boolean mo11482() {
            return true;
        }

        @Override // defpackage.AbstractC3541
        /* renamed from: Ԩ */
        public boolean mo11483() {
            return false;
        }

        @Override // defpackage.AbstractC3541
        /* renamed from: ԩ */
        public boolean mo11484(DataSource dataSource) {
            return (dataSource == DataSource.DATA_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }

        @Override // defpackage.AbstractC3541
        /* renamed from: Ԫ */
        public boolean mo11485(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    }

    /* compiled from: DiskCacheStrategy.java */
    /* renamed from: ڙ$Ԭ, reason: contains not printable characters */
    public class C3545 extends AbstractC3541 {
        @Override // defpackage.AbstractC3541
        /* renamed from: Ϳ */
        public boolean mo11482() {
            return false;
        }

        @Override // defpackage.AbstractC3541
        /* renamed from: Ԩ */
        public boolean mo11483() {
            return true;
        }

        @Override // defpackage.AbstractC3541
        /* renamed from: ԩ */
        public boolean mo11484(DataSource dataSource) {
            return false;
        }

        @Override // defpackage.AbstractC3541
        /* renamed from: Ԫ */
        public boolean mo11485(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    }

    /* compiled from: DiskCacheStrategy.java */
    /* renamed from: ڙ$Ԯ, reason: contains not printable characters */
    public class C3546 extends AbstractC3541 {
        @Override // defpackage.AbstractC3541
        /* renamed from: Ϳ */
        public boolean mo11482() {
            return true;
        }

        @Override // defpackage.AbstractC3541
        /* renamed from: Ԩ */
        public boolean mo11483() {
            return true;
        }

        @Override // defpackage.AbstractC3541
        /* renamed from: ԩ */
        public boolean mo11484(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        @Override // defpackage.AbstractC3541
        /* renamed from: Ԫ */
        public boolean mo11485(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return ((z && dataSource == DataSource.DATA_DISK_CACHE) || dataSource == DataSource.LOCAL) && encodeStrategy == EncodeStrategy.TRANSFORMED;
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public abstract boolean mo11482();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public abstract boolean mo11483();

    /* renamed from: ԩ, reason: contains not printable characters */
    public abstract boolean mo11484(DataSource dataSource);

    /* renamed from: Ԫ, reason: contains not printable characters */
    public abstract boolean mo11485(boolean z, DataSource dataSource, EncodeStrategy encodeStrategy);
}
