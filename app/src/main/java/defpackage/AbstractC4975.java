package defpackage;

import android.content.Context;
import android.view.View;
import defpackage.AbstractC4975.InterfaceC4976;
import defpackage.AbstractC4975.InterfaceC4977;
import defpackage.C5159;
import java.util.List;

/* compiled from: FilmBaseViewHolder.java */
/* renamed from: ຣ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC4975<T extends C5159, M extends InterfaceC4976, N extends InterfaceC4977<T>> extends AbstractC2769<T> {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public N f16734;

    /* renamed from: ԭ, reason: contains not printable characters */
    public M f16735;

    /* compiled from: FilmBaseViewHolder.java */
    /* renamed from: ຣ$Ϳ, reason: contains not printable characters */
    public interface InterfaceC4976 {
        /* renamed from: ԭ */
        void mo1557(int i);

        /* renamed from: Ԯ */
        void mo1558(int i);
    }

    /* compiled from: FilmBaseViewHolder.java */
    /* renamed from: ຣ$Ԩ, reason: contains not printable characters */
    public interface InterfaceC4977<T> {
        /* renamed from: Ϳ */
        List<T> mo11699();
    }

    /* compiled from: FilmBaseViewHolder.java */
    /* renamed from: ຣ$Ԫ, reason: contains not printable characters */
    public interface InterfaceC4978 extends InterfaceC4976 {
        /* renamed from: Ϳ */
        void mo2828(int i);

        /* renamed from: Ԩ */
        void mo2829(int i);
    }

    /* compiled from: FilmBaseViewHolder.java */
    /* renamed from: ຣ$Ԭ, reason: contains not printable characters */
    public interface InterfaceC4979 extends InterfaceC4976 {
        /* renamed from: ԫ */
        void mo4147(int i);

        /* renamed from: Ԭ */
        void mo4148(int i);

        /* renamed from: ԯ */
        void mo4149(int i);
    }

    /* compiled from: FilmBaseViewHolder.java */
    /* renamed from: ຣ$Ԯ, reason: contains not printable characters */
    public interface InterfaceC4980 extends InterfaceC4976 {
        /* renamed from: Ϳ */
        void mo3673(int i);

        /* renamed from: Ԩ */
        void mo3674(int i);

        /* renamed from: ԩ */
        void mo3675();

        /* renamed from: Ԫ */
        void mo3676(float f);
    }

    public AbstractC4975(View view, Context context, N n, M m) {
        super(view, context);
        this.f16734 = n;
        this.f16735 = m;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public N m14765() {
        return this.f16734;
    }
}
