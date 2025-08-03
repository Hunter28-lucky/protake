package defpackage;

import android.content.res.AssetManager;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: StreamAssetPathFetcher.java */
/* loaded from: classes.dex */
public class o extends AbstractC4984<InputStream> {
    public o(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // defpackage.InterfaceC3129
    @NonNull
    /* renamed from: Ϳ */
    public Class<InputStream> mo7075() {
        return InputStream.class;
    }

    @Override // defpackage.AbstractC4984
    /* renamed from: ԭ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public void mo7660(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // defpackage.AbstractC4984
    /* renamed from: Ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public InputStream mo7661(AssetManager assetManager, String str) throws IOException {
        return assetManager.open(str);
    }
}
