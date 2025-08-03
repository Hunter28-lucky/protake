package defpackage;

import androidx.annotation.NonNull;
import defpackage.InterfaceC3238;
import java.io.File;

/* compiled from: DataCacheWriter.java */
/* renamed from: ၑ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5147<DataType> implements InterfaceC3238.InterfaceC3240 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final InterfaceC3823<DataType> f17078;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final DataType f17079;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final C3475 f17080;

    public C5147(InterfaceC3823<DataType> interfaceC3823, DataType datatype, C3475 c3475) {
        this.f17078 = interfaceC3823;
        this.f17079 = datatype;
        this.f17080 = c3475;
    }

    @Override // defpackage.InterfaceC3238.InterfaceC3240
    /* renamed from: Ϳ */
    public boolean mo10903(@NonNull File file) {
        return this.f17078.mo7881(this.f17079, file, this.f17080);
    }
}
