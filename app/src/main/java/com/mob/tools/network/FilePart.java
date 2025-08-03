package com.mob.tools.network;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class FilePart extends HTTPPart {
    private File a;

    @Override // com.mob.tools.network.HTTPPart
    public InputStream a() throws Throwable {
        return new FileInputStream(this.a);
    }

    @Override // com.mob.tools.network.HTTPPart
    public long b() throws Throwable {
        return this.a.length();
    }

    public void setFile(File file) {
        this.a = file;
    }

    public String toString() {
        return this.a.toString();
    }

    public void setFile(String str) {
        this.a = new File(str);
    }
}
