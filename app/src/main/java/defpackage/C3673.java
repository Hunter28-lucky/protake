package defpackage;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.List;

/* compiled from: ResourceDrawableDecoder.java */
/* renamed from: ܞ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3673 implements InterfaceC3907<Uri, Drawable> {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Context f12747;

    public C3673(Context context) {
        this.f12747 = context.getApplicationContext();
    }

    @Override // defpackage.InterfaceC3907
    @Nullable
    /* renamed from: ԩ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public InterfaceC4536<Drawable> mo5018(@NonNull Uri uri, int i, int i2, @NonNull C3475 c3475) throws NumberFormatException {
        int iM11817 = m11817(uri);
        String authority = uri.getAuthority();
        return C2476.m9074(C5026.m14816(this.f12747, authority.equals(this.f12747.getPackageName()) ? this.f12747 : m11815(uri, authority), iM11817));
    }

    @NonNull
    /* renamed from: Ԫ, reason: contains not printable characters */
    public final Context m11815(Uri uri, String str) {
        try {
            return this.f12747.createPackageContext(str, 0);
        } catch (PackageManager.NameNotFoundException e2) {
            throw new IllegalArgumentException("Failed to obtain context or unrecognized Uri format for: " + uri, e2);
        }
    }

    @Override // defpackage.InterfaceC3907
    /* renamed from: ԫ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public boolean mo5017(@NonNull Uri uri, @NonNull C3475 c3475) {
        return uri.getScheme().equals("android.resource");
    }

    @DrawableRes
    /* renamed from: Ԭ, reason: contains not printable characters */
    public final int m11817(Uri uri) throws NumberFormatException {
        Integer numValueOf;
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() == 2) {
            String authority = uri.getAuthority();
            numValueOf = Integer.valueOf(this.f12747.getResources().getIdentifier(pathSegments.get(1), pathSegments.get(0), authority));
        } else if (pathSegments.size() == 1) {
            try {
                numValueOf = Integer.valueOf(pathSegments.get(0));
            } catch (NumberFormatException unused) {
            }
        } else {
            numValueOf = null;
        }
        if (numValueOf == null) {
            throw new IllegalArgumentException("Unrecognized Uri format: " + uri);
        }
        if (numValueOf.intValue() != 0) {
            return numValueOf.intValue();
        }
        throw new IllegalArgumentException("Failed to obtain resource id for: " + uri);
    }
}
