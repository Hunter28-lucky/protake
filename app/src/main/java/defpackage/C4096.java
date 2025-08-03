package defpackage;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import java.io.IOException;

/* compiled from: FileDescriptorAssetPathFetcher.java */
/* renamed from: व, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4096 extends AbstractC4984<ParcelFileDescriptor> {
    public C4096(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // defpackage.InterfaceC3129
    @NonNull
    /* renamed from: Ϳ */
    public Class<ParcelFileDescriptor> mo7075() {
        return ParcelFileDescriptor.class;
    }

    @Override // defpackage.AbstractC4984
    /* renamed from: ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public void mo7660(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }

    @Override // defpackage.AbstractC4984
    /* renamed from: Ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public ParcelFileDescriptor mo7661(AssetManager assetManager, String str) throws IOException {
        return assetManager.openFd(str).getParcelFileDescriptor();
    }
}
