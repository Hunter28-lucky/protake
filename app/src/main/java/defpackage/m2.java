package defpackage;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.C1840;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* compiled from: ThumbnailStreamOpener.java */
/* loaded from: classes.dex */
public class m2 {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final C4191 f7982 = new C4191();

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final C4191 f7983;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final k2 f7984;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final InterfaceC4950 f7985;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final ContentResolver f7986;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final List<ImageHeaderParser> f7987;

    public m2(List<ImageHeaderParser> list, k2 k2Var, InterfaceC4950 interfaceC4950, ContentResolver contentResolver) {
        this(list, f7982, k2Var, interfaceC4950, contentResolver);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int m7533(Uri uri) throws IOException {
        InputStream inputStreamOpenInputStream = null;
        try {
            try {
                inputStreamOpenInputStream = this.f7986.openInputStream(uri);
                int iM5021 = C1840.m5021(this.f7987, inputStreamOpenInputStream, this.f7985);
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return iM5021;
            } catch (IOException | NullPointerException e2) {
                if (Log.isLoggable("ThumbStreamOpener", 3)) {
                    Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e2);
                }
                if (inputStreamOpenInputStream == null) {
                    return -1;
                }
                try {
                    inputStreamOpenInputStream.close();
                    return -1;
                } catch (IOException unused2) {
                    return -1;
                }
            }
        } catch (Throwable th) {
            if (0 != 0) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException unused3) {
                }
            }
            throw th;
        }
    }

    @Nullable
    /* renamed from: Ԩ, reason: contains not printable characters */
    public final String m7534(@NonNull Uri uri) {
        Cursor cursorMo7080 = this.f7984.mo7080(uri);
        if (cursorMo7080 != null) {
            try {
                if (cursorMo7080.moveToFirst()) {
                    return cursorMo7080.getString(0);
                }
            } finally {
                cursorMo7080.close();
            }
        }
        if (cursorMo7080 != null) {
        }
        return null;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final boolean m7535(File file) {
        return this.f7983.m13217(file) && 0 < this.f7983.m13219(file);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public InputStream m7536(Uri uri) throws FileNotFoundException {
        String strM7534 = m7534(uri);
        if (TextUtils.isEmpty(strM7534)) {
            return null;
        }
        File fileM13218 = this.f7983.m13218(strM7534);
        if (!m7535(fileM13218)) {
            return null;
        }
        Uri uriFromFile = Uri.fromFile(fileM13218);
        try {
            return this.f7986.openInputStream(uriFromFile);
        } catch (NullPointerException e2) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + uriFromFile).initCause(e2));
        }
    }

    public m2(List<ImageHeaderParser> list, C4191 c4191, k2 k2Var, InterfaceC4950 interfaceC4950, ContentResolver contentResolver) {
        this.f7983 = c4191;
        this.f7984 = k2Var;
        this.f7985 = interfaceC4950;
        this.f7986 = contentResolver;
        this.f7987 = list;
    }
}
