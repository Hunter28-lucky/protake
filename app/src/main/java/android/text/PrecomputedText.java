package android.text;

import android.annotation.NonNull;

/* loaded from: classes.dex */
public /* synthetic */ class PrecomputedText implements Spannable {

    public final /* synthetic */ class Params {
        static {
            throw new NoClassDefFoundError();
        }

        public native /* synthetic */ int getBreakStrategy();

        public native /* synthetic */ int getHyphenationFrequency();

        @NonNull
        public native /* synthetic */ TextDirectionHeuristic getTextDirection();

        @NonNull
        public native /* synthetic */ TextPaint getTextPaint();
    }

    static {
        throw new NoClassDefFoundError();
    }

    public static native /* synthetic */ PrecomputedText create(@NonNull CharSequence charSequence, @NonNull Params params);

    public native /* synthetic */ int getParagraphCount();

    public native /* synthetic */ int getParagraphEnd(int i);

    public native /* synthetic */ int getParagraphStart(int i);

    @Override // android.text.Spanned
    public native /* synthetic */ <T> T[] getSpans(int i, int i2, Class<T> cls);

    @Override // android.text.Spannable
    public native /* synthetic */ void removeSpan(Object obj);

    @Override // android.text.Spannable
    public native /* synthetic */ void setSpan(Object obj, int i, int i2, int i3);
}
