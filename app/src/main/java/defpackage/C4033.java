package defpackage;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import defpackage.InterfaceC3129;
import defpackage.InterfaceC4900;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: FileLoader.java */
/* renamed from: ऍ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4033<Data> implements InterfaceC4900<File, Data> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final InterfaceC4038<Data> f14010;

    /* compiled from: FileLoader.java */
    /* renamed from: ऍ$Ϳ, reason: contains not printable characters */
    public static class C4034<Data> implements InterfaceC5295<File, Data> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final InterfaceC4038<Data> f14011;

        public C4034(InterfaceC4038<Data> interfaceC4038) {
            this.f14011 = interfaceC4038;
        }

        @Override // defpackage.InterfaceC5295
        @NonNull
        /* renamed from: Ԩ */
        public final InterfaceC4900<File, Data> mo12(@NonNull C4057 c4057) {
            return new C4033(this.f14011);
        }
    }

    /* compiled from: FileLoader.java */
    /* renamed from: ऍ$Ԩ, reason: contains not printable characters */
    public static class C4035 extends C4034<ParcelFileDescriptor> {

        /* compiled from: FileLoader.java */
        /* renamed from: ऍ$Ԩ$Ϳ, reason: contains not printable characters */
        public class C4036 implements InterfaceC4038<ParcelFileDescriptor> {
            @Override // defpackage.C4033.InterfaceC4038
            /* renamed from: Ϳ, reason: contains not printable characters */
            public Class<ParcelFileDescriptor> mo12916() {
                return ParcelFileDescriptor.class;
            }

            @Override // defpackage.C4033.InterfaceC4038
            /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
            public void mo12917(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                parcelFileDescriptor.close();
            }

            @Override // defpackage.C4033.InterfaceC4038
            /* renamed from: ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
            public ParcelFileDescriptor mo12918(File file) throws FileNotFoundException {
                return ParcelFileDescriptor.open(file, 268435456);
            }
        }

        public C4035() {
            super(new C4036());
        }
    }

    /* compiled from: FileLoader.java */
    /* renamed from: ऍ$Ԫ, reason: contains not printable characters */
    public static final class C4037<Data> implements InterfaceC3129<Data> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final File f14012;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC4038<Data> f14013;

        /* renamed from: ԭ, reason: contains not printable characters */
        public Data f14014;

        public C4037(File file, InterfaceC4038<Data> interfaceC4038) {
            this.f14012 = file;
            this.f14013 = interfaceC4038;
        }

        @Override // defpackage.InterfaceC3129
        public void cancel() {
        }

        @Override // defpackage.InterfaceC3129
        @NonNull
        /* renamed from: Ϳ */
        public Class<Data> mo7075() {
            return this.f14013.mo12916();
        }

        @Override // defpackage.InterfaceC3129
        /* renamed from: Ԩ */
        public void mo7076() {
            Data data = this.f14014;
            if (data != null) {
                try {
                    this.f14013.mo12917(data);
                } catch (IOException unused) {
                }
            }
        }

        @Override // defpackage.InterfaceC3129
        @NonNull
        /* renamed from: Ԫ */
        public DataSource mo7077() {
            return DataSource.LOCAL;
        }

        /* JADX WARN: Type inference failed for: r3v3, types: [Data, java.lang.Object] */
        @Override // defpackage.InterfaceC3129
        /* renamed from: ԫ */
        public void mo7078(@NonNull Priority priority, @NonNull InterfaceC3129.InterfaceC3130<? super Data> interfaceC3130) {
            try {
                Data dataMo12918 = this.f14013.mo12918(this.f14012);
                this.f14014 = dataMo12918;
                interfaceC3130.mo4919(dataMo12918);
            } catch (FileNotFoundException e2) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e2);
                }
                interfaceC3130.mo4918(e2);
            }
        }
    }

    /* compiled from: FileLoader.java */
    /* renamed from: ऍ$Ԭ, reason: contains not printable characters */
    public interface InterfaceC4038<Data> {
        /* renamed from: Ϳ */
        Class<Data> mo12916();

        /* renamed from: Ԩ */
        void mo12917(Data data) throws IOException;

        /* renamed from: ԩ */
        Data mo12918(File file) throws FileNotFoundException;
    }

    /* compiled from: FileLoader.java */
    /* renamed from: ऍ$Ԯ, reason: contains not printable characters */
    public static class C4039 extends C4034<InputStream> {

        /* compiled from: FileLoader.java */
        /* renamed from: ऍ$Ԯ$Ϳ, reason: contains not printable characters */
        public class C4040 implements InterfaceC4038<InputStream> {
            @Override // defpackage.C4033.InterfaceC4038
            /* renamed from: Ϳ */
            public Class<InputStream> mo12916() {
                return InputStream.class;
            }

            @Override // defpackage.C4033.InterfaceC4038
            /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
            public void mo12917(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // defpackage.C4033.InterfaceC4038
            /* renamed from: ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
            public InputStream mo12918(File file) throws FileNotFoundException {
                return new FileInputStream(file);
            }
        }

        public C4039() {
            super(new C4040());
        }
    }

    public C4033(InterfaceC4038<Data> interfaceC4038) {
        this.f14010 = interfaceC4038;
    }

    @Override // defpackage.InterfaceC4900
    /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public InterfaceC4900.C4901<Data> mo8(@NonNull File file, int i, int i2, @NonNull C3475 c3475) {
        return new InterfaceC4900.C4901<>(new C2969(file), new C4037(file, this.f14010));
    }

    @Override // defpackage.InterfaceC4900
    /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public boolean mo7(@NonNull File file) {
        return true;
    }
}
