package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import defpackage.InterfaceC2392;
import defpackage.InterfaceC4365;
import defpackage.i4;

/* compiled from: TextView.kt */
/* loaded from: classes.dex */
public final class TextViewKt$addTextChangedListener$textWatcher$1 implements TextWatcher {
    public final /* synthetic */ InterfaceC2392<Editable, i4> $afterTextChanged;
    public final /* synthetic */ InterfaceC4365<CharSequence, Integer, Integer, Integer, i4> $beforeTextChanged;
    public final /* synthetic */ InterfaceC4365<CharSequence, Integer, Integer, Integer, i4> $onTextChanged;

    /* JADX WARN: Multi-variable type inference failed */
    public TextViewKt$addTextChangedListener$textWatcher$1(InterfaceC2392<? super Editable, i4> interfaceC2392, InterfaceC4365<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, i4> interfaceC4365, InterfaceC4365<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, i4> interfaceC43652) {
        this.$afterTextChanged = interfaceC2392;
        this.$beforeTextChanged = interfaceC4365;
        this.$onTextChanged = interfaceC43652;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
        this.$afterTextChanged.invoke(editable);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.$beforeTextChanged.invoke(charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.$onTextChanged.invoke(charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }
}
