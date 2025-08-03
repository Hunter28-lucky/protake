package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import defpackage.C3921;
import defpackage.InterfaceC2392;
import defpackage.InterfaceC4365;
import defpackage.i4;

/* compiled from: TextView.kt */
/* loaded from: classes.dex */
public final class TextViewKt {
    public static final TextWatcher addTextChangedListener(TextView textView, InterfaceC4365<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, i4> interfaceC4365, InterfaceC4365<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, i4> interfaceC43652, InterfaceC2392<? super Editable, i4> interfaceC2392) {
        C3921.m12666(textView, "<this>");
        C3921.m12666(interfaceC4365, "beforeTextChanged");
        C3921.m12666(interfaceC43652, "onTextChanged");
        C3921.m12666(interfaceC2392, "afterTextChanged");
        TextViewKt$addTextChangedListener$textWatcher$1 textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(interfaceC2392, interfaceC4365, interfaceC43652);
        textView.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    public static /* synthetic */ TextWatcher addTextChangedListener$default(TextView textView, InterfaceC4365 interfaceC4365, InterfaceC4365 interfaceC43652, InterfaceC2392 interfaceC2392, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC4365 = new InterfaceC4365<CharSequence, Integer, Integer, Integer, i4>() { // from class: androidx.core.widget.TextViewKt.addTextChangedListener.1
                @Override // defpackage.InterfaceC4365
                public /* bridge */ /* synthetic */ i4 invoke(CharSequence charSequence, Integer num, Integer num2, Integer num3) {
                    invoke(charSequence, num.intValue(), num2.intValue(), num3.intValue());
                    return i4.f6762;
                }

                public final void invoke(CharSequence charSequence, int i2, int i3, int i4) {
                }
            };
        }
        if ((i & 2) != 0) {
            interfaceC43652 = new InterfaceC4365<CharSequence, Integer, Integer, Integer, i4>() { // from class: androidx.core.widget.TextViewKt.addTextChangedListener.2
                @Override // defpackage.InterfaceC4365
                public /* bridge */ /* synthetic */ i4 invoke(CharSequence charSequence, Integer num, Integer num2, Integer num3) {
                    invoke(charSequence, num.intValue(), num2.intValue(), num3.intValue());
                    return i4.f6762;
                }

                public final void invoke(CharSequence charSequence, int i2, int i3, int i4) {
                }
            };
        }
        if ((i & 4) != 0) {
            interfaceC2392 = new InterfaceC2392<Editable, i4>() { // from class: androidx.core.widget.TextViewKt.addTextChangedListener.3
                @Override // defpackage.InterfaceC2392
                public /* bridge */ /* synthetic */ i4 invoke(Editable editable) {
                    invoke2(editable);
                    return i4.f6762;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Editable editable) {
                }
            };
        }
        C3921.m12666(textView, "<this>");
        C3921.m12666(interfaceC4365, "beforeTextChanged");
        C3921.m12666(interfaceC43652, "onTextChanged");
        C3921.m12666(interfaceC2392, "afterTextChanged");
        TextViewKt$addTextChangedListener$textWatcher$1 textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(interfaceC2392, interfaceC4365, interfaceC43652);
        textView.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    public static final TextWatcher doAfterTextChanged(TextView textView, final InterfaceC2392<? super Editable, i4> interfaceC2392) {
        C3921.m12666(textView, "<this>");
        C3921.m12666(interfaceC2392, "action");
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                interfaceC2392.invoke(editable);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        textView.addTextChangedListener(textWatcher);
        return textWatcher;
    }

    public static final TextWatcher doBeforeTextChanged(TextView textView, final InterfaceC4365<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, i4> interfaceC4365) {
        C3921.m12666(textView, "<this>");
        C3921.m12666(interfaceC4365, "action");
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                interfaceC4365.invoke(charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }
        };
        textView.addTextChangedListener(textWatcher);
        return textWatcher;
    }

    public static final TextWatcher doOnTextChanged(TextView textView, final InterfaceC4365<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, i4> interfaceC4365) {
        C3921.m12666(textView, "<this>");
        C3921.m12666(interfaceC4365, "action");
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                interfaceC4365.invoke(charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
            }
        };
        textView.addTextChangedListener(textWatcher);
        return textWatcher;
    }
}
