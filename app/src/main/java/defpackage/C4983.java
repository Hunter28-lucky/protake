package defpackage;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import androidx.annotation.NonNull;
import java.io.FileNotFoundException;
import java.io.IOException;

/* compiled from: AssetFileDescriptorLocalUriFetcher.java */
/* renamed from: ຨ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C4983 extends AbstractC3121<AssetFileDescriptor> {
    public C4983(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    @Override // defpackage.InterfaceC3129
    @NonNull
    /* renamed from: Ϳ */
    public Class<AssetFileDescriptor> mo7075() {
        return AssetFileDescriptor.class;
    }

    @Override // defpackage.AbstractC3121
    /* renamed from: ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public void mo8131(AssetFileDescriptor assetFileDescriptor) throws IOException {
        assetFileDescriptor.close();
    }

    @Override // defpackage.AbstractC3121
    /* renamed from: Ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public AssetFileDescriptor mo8132(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        AssetFileDescriptor assetFileDescriptorOpenAssetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
        if (assetFileDescriptorOpenAssetFileDescriptor != null) {
            return assetFileDescriptorOpenAssetFileDescriptor;
        }
        throw new FileNotFoundException("FileDescriptor is null for: " + uri);
    }
}
