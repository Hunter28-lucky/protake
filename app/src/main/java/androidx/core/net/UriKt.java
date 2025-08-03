package androidx.core.net;

import android.net.Uri;
import defpackage.C3921;
import java.io.File;

/* compiled from: Uri.kt */
/* loaded from: classes.dex */
public final class UriKt {
    public static final File toFile(Uri uri) {
        C3921.m12666(uri, "<this>");
        if (!C3921.m12662(uri.getScheme(), "file")) {
            throw new IllegalArgumentException(("Uri lacks 'file' scheme: " + uri).toString());
        }
        String path = uri.getPath();
        if (path != null) {
            return new File(path);
        }
        throw new IllegalArgumentException(("Uri path is null: " + uri).toString());
    }

    public static final Uri toUri(String str) {
        C3921.m12666(str, "<this>");
        Uri uri = Uri.parse(str);
        C3921.m12665(uri, "parse(this)");
        return uri;
    }

    public static final Uri toUri(File file) {
        C3921.m12666(file, "<this>");
        Uri uriFromFile = Uri.fromFile(file);
        C3921.m12665(uriFromFile, "fromFile(this)");
        return uriFromFile;
    }
}
