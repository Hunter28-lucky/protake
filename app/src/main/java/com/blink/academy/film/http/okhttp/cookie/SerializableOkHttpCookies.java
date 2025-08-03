package com.blink.academy.film.http.okhttp.cookie;

import defpackage.C2632;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/* loaded from: classes.dex */
public class SerializableOkHttpCookies implements Serializable {
    private transient C2632 clientCookies;
    private final transient C2632 cookies;

    public SerializableOkHttpCookies(C2632 c2632) {
        this.cookies = c2632;
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        String str = (String) objectInputStream.readObject();
        String str2 = (String) objectInputStream.readObject();
        long j = objectInputStream.readLong();
        String str3 = (String) objectInputStream.readObject();
        String str4 = (String) objectInputStream.readObject();
        boolean z = objectInputStream.readBoolean();
        boolean z2 = objectInputStream.readBoolean();
        boolean z3 = objectInputStream.readBoolean();
        C2632.C2633 c2633M9705 = new C2632.C2633().m9708(str).m9711(str2).m9705(j);
        C2632.C2633 c2633M9709 = (z3 ? c2633M9705.m9706(str3) : c2633M9705.m9703(str3)).m9709(str4);
        if (z) {
            c2633M9709 = c2633M9709.m9710();
        }
        if (z2) {
            c2633M9709 = c2633M9709.m9707();
        }
        this.clientCookies = c2633M9709.m9702();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.cookies.m9696());
        objectOutputStream.writeObject(this.cookies.m9701());
        objectOutputStream.writeLong(this.cookies.m9693());
        objectOutputStream.writeObject(this.cookies.m9692());
        objectOutputStream.writeObject(this.cookies.m9697());
        objectOutputStream.writeBoolean(this.cookies.m9699());
        objectOutputStream.writeBoolean(this.cookies.m9695());
        objectOutputStream.writeBoolean(this.cookies.m9694());
        objectOutputStream.writeBoolean(this.cookies.m9698());
    }

    public C2632 getCookies() {
        C2632 c2632 = this.cookies;
        C2632 c26322 = this.clientCookies;
        return c26322 != null ? c26322 : c2632;
    }
}
