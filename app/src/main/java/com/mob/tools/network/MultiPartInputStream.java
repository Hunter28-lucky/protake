package com.mob.tools.network;

import com.mob.tools.proguard.PublicMemberKeeper;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes2.dex */
public class MultiPartInputStream extends InputStream implements PublicMemberKeeper {
    private ArrayList<InputStream> a = new ArrayList<>();
    private int b;

    private boolean a() {
        ArrayList<InputStream> arrayList = this.a;
        return arrayList == null || arrayList.size() <= 0;
    }

    public void addInputStream(InputStream inputStream) throws Throwable {
        this.a.add(inputStream);
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (a()) {
            return 0;
        }
        return this.a.get(this.b).available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Iterator<InputStream> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().close();
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (a()) {
            return -1;
        }
        int i = this.a.get(this.b).read();
        while (i < 0) {
            int i2 = this.b + 1;
            this.b = i2;
            if (i2 >= this.a.size()) {
                break;
            }
            i = this.a.get(this.b).read();
        }
        return i;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        throw new IOException();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (a()) {
            return -1;
        }
        int i3 = this.a.get(this.b).read(bArr, i, i2);
        while (i3 < 0) {
            int i4 = this.b + 1;
            this.b = i4;
            if (i4 >= this.a.size()) {
                break;
            }
            i3 = this.a.get(this.b).read(bArr, i, i2);
        }
        return i3;
    }
}
