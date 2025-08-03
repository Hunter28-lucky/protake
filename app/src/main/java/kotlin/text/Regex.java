package kotlin.text;

import defpackage.C3921;
import defpackage.C4184;
import java.io.Serializable;
import java.util.Set;
import java.util.regex.Pattern;

/* compiled from: Regex.kt */
/* loaded from: classes2.dex */
public final class Regex implements Serializable {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final C2145 f7850 = new C2145(null);
    private Set<Object> _options;
    private final Pattern nativePattern;

    /* compiled from: Regex.kt */
    public static final class Serialized implements Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: ԫ, reason: contains not printable characters */
        public static final C2144 f7851 = new C2144(null);
        private final int flags;
        private final String pattern;

        /* compiled from: Regex.kt */
        /* renamed from: kotlin.text.Regex$Serialized$Ϳ, reason: contains not printable characters */
        public static final class C2144 {
            public C2144() {
            }

            public /* synthetic */ C2144(C4184 c4184) {
                this();
            }
        }

        public Serialized(String str, int i) {
            C3921.m12666(str, "pattern");
            this.pattern = str;
            this.flags = i;
        }

        private final Object readResolve() {
            Pattern patternCompile = Pattern.compile(this.pattern, this.flags);
            C3921.m12665(patternCompile, "compile(pattern, flags)");
            return new Regex(patternCompile);
        }
    }

    /* compiled from: Regex.kt */
    /* renamed from: kotlin.text.Regex$Ϳ, reason: contains not printable characters */
    public static final class C2145 {
        public C2145() {
        }

        public /* synthetic */ C2145(C4184 c4184) {
            this();
        }
    }

    public Regex(Pattern pattern) {
        C3921.m12666(pattern, "nativePattern");
        this.nativePattern = pattern;
    }

    private final Object writeReplace() {
        String strPattern = this.nativePattern.pattern();
        C3921.m12665(strPattern, "nativePattern.pattern()");
        return new Serialized(strPattern, this.nativePattern.flags());
    }

    public String toString() {
        String string = this.nativePattern.toString();
        C3921.m12665(string, "nativePattern.toString()");
        return string;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final boolean m7263(CharSequence charSequence) {
        C3921.m12666(charSequence, "input");
        return this.nativePattern.matcher(charSequence).matches();
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final String m7264(CharSequence charSequence, String str) {
        C3921.m12666(charSequence, "input");
        C3921.m12666(str, "replacement");
        String strReplaceAll = this.nativePattern.matcher(charSequence).replaceAll(str);
        C3921.m12665(strReplaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return strReplaceAll;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public Regex(String str) {
        C3921.m12666(str, "pattern");
        Pattern patternCompile = Pattern.compile(str);
        C3921.m12665(patternCompile, "compile(pattern)");
        this(patternCompile);
    }
}
