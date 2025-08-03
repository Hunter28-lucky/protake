package com.efs.sdk.base.core.e;

import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.processor.action.ILogEncryptAction;

/* loaded from: classes.dex */
public final class b implements ILogEncryptAction {
    @Override // com.efs.sdk.base.processor.action.ILogEncryptAction
    public final byte[] decrypt(String str, byte[] bArr) {
        try {
            return com.efs.sdk.base.core.util.b.a.a(bArr, str);
        } catch (Exception e2) {
            Log.e("efs.base", "aes decrypt error", e2);
            return null;
        }
    }

    @Override // com.efs.sdk.base.processor.action.ILogEncryptAction
    public final byte[] encrypt(String str, byte[] bArr) {
        try {
            return com.efs.sdk.base.core.util.b.a.b(bArr, str);
        } catch (Exception e2) {
            Log.e("efs.base", "aes encrypt error", e2);
            return null;
        }
    }

    @Override // com.efs.sdk.base.processor.action.ILogEncryptAction
    public final int getDeVal() {
        return 2;
    }
}
