package com.xiaomi.push;

import java.util.Map;

/* loaded from: classes2.dex */
public class ei implements eg {
    private eg a;

    public static class a {
        private static ei a = new ei();
    }

    public static ei a() {
        return a.a;
    }

    private ei() {
    }

    @Override // com.xiaomi.push.eg
    public void a(ef efVar) {
        eg egVar = this.a;
        if (egVar != null) {
            egVar.a(efVar);
        }
    }

    @Override // com.xiaomi.push.eg
    public void a(String str, Map<String, Object> map) {
        eg egVar = this.a;
        if (egVar != null) {
            egVar.a(str, map);
        }
    }
}
