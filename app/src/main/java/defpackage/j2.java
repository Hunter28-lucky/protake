package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import defpackage.InterfaceC3129;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ThumbFetcher.java */
/* loaded from: classes.dex */
public class j2 implements InterfaceC3129<InputStream> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Uri f7729;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final m2 f7730;

    /* renamed from: ԭ, reason: contains not printable characters */
    public InputStream f7731;

    /* compiled from: ThumbFetcher.java */
    /* renamed from: j2$Ϳ, reason: contains not printable characters */
    public static class C2119 implements k2 {

        /* renamed from: Ԩ, reason: contains not printable characters */
        public static final String[] f7732 = {"_data"};

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final ContentResolver f7733;

        public C2119(ContentResolver contentResolver) {
            this.f7733 = contentResolver;
        }

        @Override // defpackage.k2
        /* renamed from: Ϳ, reason: contains not printable characters */
        public Cursor mo7080(Uri uri) {
            return this.f7733.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f7732, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* compiled from: ThumbFetcher.java */
    /* renamed from: j2$Ԩ, reason: contains not printable characters */
    public static class C2120 implements k2 {

        /* renamed from: Ԩ, reason: contains not printable characters */
        public static final String[] f7734 = {"_data"};

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final ContentResolver f7735;

        public C2120(ContentResolver contentResolver) {
            this.f7735 = contentResolver;
        }

        @Override // defpackage.k2
        /* renamed from: Ϳ */
        public Cursor mo7080(Uri uri) {
            return this.f7735.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f7734, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    @VisibleForTesting
    public j2(Uri uri, m2 m2Var) {
        this.f7729 = uri;
        this.f7730 = m2Var;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static j2 m7072(Context context, Uri uri, k2 k2Var) {
        return new j2(uri, new m2(ComponentCallbacks2C3498.m11419(context).m11432().m4838(), k2Var, ComponentCallbacks2C3498.m11419(context).m11427(), context.getContentResolver()));
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static j2 m7073(Context context, Uri uri) {
        return m7072(context, uri, new C2119(context.getContentResolver()));
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static j2 m7074(Context context, Uri uri) {
        return m7072(context, uri, new C2120(context.getContentResolver()));
    }

    @Override // defpackage.InterfaceC3129
    public void cancel() {
    }

    @Override // defpackage.InterfaceC3129
    @NonNull
    /* renamed from: Ϳ, reason: contains not printable characters */
    public Class<InputStream> mo7075() {
        return InputStream.class;
    }

    @Override // defpackage.InterfaceC3129
    /* renamed from: Ԩ, reason: contains not printable characters */
    public void mo7076() throws IOException {
        InputStream inputStream = this.f7731;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // defpackage.InterfaceC3129
    @NonNull
    /* renamed from: Ԫ, reason: contains not printable characters */
    public DataSource mo7077() {
        return DataSource.LOCAL;
    }

    @Override // defpackage.InterfaceC3129
    /* renamed from: ԫ, reason: contains not printable characters */
    public void mo7078(@NonNull Priority priority, @NonNull InterfaceC3129.InterfaceC3130<? super InputStream> interfaceC3130) {
        try {
            InputStream inputStreamM7079 = m7079();
            this.f7731 = inputStreamM7079;
            interfaceC3130.mo4919(inputStreamM7079);
        } catch (FileNotFoundException e2) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e2);
            }
            interfaceC3130.mo4918(e2);
        }
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final InputStream m7079() throws FileNotFoundException {
        InputStream inputStreamM7536 = this.f7730.m7536(this.f7729);
        int iM7533 = inputStreamM7536 != null ? this.f7730.m7533(this.f7729) : -1;
        return iM7533 != -1 ? new C3141(inputStreamM7536, iM7533) : inputStreamM7536;
    }
}
