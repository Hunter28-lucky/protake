package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import defpackage.InterfaceC3129;
import defpackage.InterfaceC4900;
import java.io.File;
import java.io.FileNotFoundException;

/* compiled from: MediaStoreFileLoader.java */
/* renamed from: ʝ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C2686 implements InterfaceC4900<Uri, File> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Context f9960;

    /* compiled from: MediaStoreFileLoader.java */
    /* renamed from: ʝ$Ϳ, reason: contains not printable characters */
    public static final class C2687 implements InterfaceC5295<Uri, File> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final Context f9961;

        public C2687(Context context) {
            this.f9961 = context;
        }

        @Override // defpackage.InterfaceC5295
        @NonNull
        /* renamed from: Ԩ */
        public InterfaceC4900<Uri, File> mo12(C4057 c4057) {
            return new C2686(this.f9961);
        }
    }

    /* compiled from: MediaStoreFileLoader.java */
    /* renamed from: ʝ$Ԩ, reason: contains not printable characters */
    public static class C2688 implements InterfaceC3129<File> {

        /* renamed from: ԭ, reason: contains not printable characters */
        public static final String[] f9962 = {"_data"};

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Context f9963;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final Uri f9964;

        public C2688(Context context, Uri uri) {
            this.f9963 = context;
            this.f9964 = uri;
        }

        @Override // defpackage.InterfaceC3129
        public void cancel() {
        }

        @Override // defpackage.InterfaceC3129
        @NonNull
        /* renamed from: Ϳ */
        public Class<File> mo7075() {
            return File.class;
        }

        @Override // defpackage.InterfaceC3129
        /* renamed from: Ԩ */
        public void mo7076() {
        }

        @Override // defpackage.InterfaceC3129
        @NonNull
        /* renamed from: Ԫ */
        public DataSource mo7077() {
            return DataSource.LOCAL;
        }

        @Override // defpackage.InterfaceC3129
        /* renamed from: ԫ */
        public void mo7078(@NonNull Priority priority, @NonNull InterfaceC3129.InterfaceC3130<? super File> interfaceC3130) {
            Cursor cursorQuery = this.f9963.getContentResolver().query(this.f9964, f9962, null, null, null);
            if (cursorQuery != null) {
                try {
                    string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")) : null;
                } finally {
                    cursorQuery.close();
                }
            }
            if (!TextUtils.isEmpty(string)) {
                interfaceC3130.mo4919(new File(string));
                return;
            }
            interfaceC3130.mo4918(new FileNotFoundException("Failed to find file path for: " + this.f9964));
        }
    }

    public C2686(Context context) {
        this.f9960 = context;
    }

    @Override // defpackage.InterfaceC4900
    /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public InterfaceC4900.C4901<File> mo8(@NonNull Uri uri, int i, int i2, @NonNull C3475 c3475) {
        return new InterfaceC4900.C4901<>(new C2969(uri), new C2688(this.f9960, uri));
    }

    @Override // defpackage.InterfaceC4900
    /* renamed from: Ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public boolean mo7(@NonNull Uri uri) {
        return C2551.m9392(uri);
    }
}
