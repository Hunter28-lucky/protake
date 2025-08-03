package defpackage;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import io.jsonwebtoken.JwtParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.C2138;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: ClassReference.kt */
/* renamed from: ʟ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2690 implements InterfaceC2623<Object>, InterfaceC3526 {

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final C2691 f9982 = new C2691(null);

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final Map<Class<? extends InterfaceC2486<?>>, Integer> f9983;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final HashMap<String, String> f9984;

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final HashMap<String, String> f9985;

    /* renamed from: ՠ, reason: contains not printable characters */
    public static final HashMap<String, String> f9986;

    /* renamed from: ֈ, reason: contains not printable characters */
    public static final Map<String, String> f9987;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Class<?> f9988;

    /* compiled from: ClassReference.kt */
    /* renamed from: ʟ$Ϳ, reason: contains not printable characters */
    public static final class C2691 {
        public C2691() {
        }

        public /* synthetic */ C2691(C4184 c4184) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static {
        int i = 0;
        List listM10714 = C3131.m10714(InterfaceC4090.class, InterfaceC2392.class, InterfaceC2849.class, InterfaceC3697.class, InterfaceC4365.class, InterfaceC5304.class, InterfaceC2481.class, InterfaceC2484.class, InterfaceC2466.class, InterfaceC2550.class, InterfaceC5004.class, InterfaceC2391.class, InterfaceC2482.class, InterfaceC2393.class, InterfaceC4941.class, InterfaceC3908.class, InterfaceC2424.class, InterfaceC4981.class, InterfaceC4206.class, InterfaceC4458.class, InterfaceC3267.class, InterfaceC4959.class, InterfaceC4338.class);
        ArrayList arrayList = new ArrayList(C4362.m13522(listM10714, 10));
        for (Object obj : listM10714) {
            int i2 = i + 1;
            if (i < 0) {
                C3131.m10719();
            }
            arrayList.add(r3.m8147((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        f9983 = C2138.m7238(arrayList);
        HashMap<String, String> map = new HashMap<>();
        map.put(TypedValues.Custom.S_BOOLEAN, "kotlin.Boolean");
        map.put("char", "kotlin.Char");
        map.put("byte", "kotlin.Byte");
        map.put("short", "kotlin.Short");
        map.put("int", "kotlin.Int");
        map.put(TypedValues.Custom.S_FLOAT, "kotlin.Float");
        map.put("long", "kotlin.Long");
        map.put("double", "kotlin.Double");
        f9984 = map;
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("java.lang.Boolean", "kotlin.Boolean");
        map2.put("java.lang.Character", "kotlin.Char");
        map2.put("java.lang.Byte", "kotlin.Byte");
        map2.put("java.lang.Short", "kotlin.Short");
        map2.put("java.lang.Integer", "kotlin.Int");
        map2.put("java.lang.Float", "kotlin.Float");
        map2.put("java.lang.Long", "kotlin.Long");
        map2.put("java.lang.Double", "kotlin.Double");
        f9985 = map2;
        HashMap<String, String> map3 = new HashMap<>();
        map3.put("java.lang.Object", "kotlin.Any");
        map3.put("java.lang.String", "kotlin.String");
        map3.put("java.lang.CharSequence", "kotlin.CharSequence");
        map3.put("java.lang.Throwable", "kotlin.Throwable");
        map3.put("java.lang.Cloneable", "kotlin.Cloneable");
        map3.put("java.lang.Number", "kotlin.Number");
        map3.put("java.lang.Comparable", "kotlin.Comparable");
        map3.put("java.lang.Enum", "kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        map3.put("java.lang.Iterable", "kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "kotlin.collections.Iterator");
        map3.put("java.util.Collection", "kotlin.collections.Collection");
        map3.put("java.util.List", "kotlin.collections.List");
        map3.put("java.util.Set", "kotlin.collections.Set");
        map3.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        map3.put("java.util.Map", "kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        map3.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        map3.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        map3.putAll(map);
        map3.putAll(map2);
        Collection<String> collectionValues = map.values();
        C3921.m12665(collectionValues, "primitiveFqNames.values");
        for (String str : collectionValues) {
            StringBuilder sb = new StringBuilder();
            sb.append("kotlin.jvm.internal.");
            C3921.m12665(str, "kotlinName");
            sb.append(StringsKt__StringsKt.m7314(str, JwtParser.SEPARATOR_CHAR, null, 2, null));
            sb.append("CompanionObject");
            Pair pairM8147 = r3.m8147(sb.toString(), str + ".Companion");
            map3.put(pairM8147.m7209(), pairM8147.m7210());
        }
        for (Map.Entry<Class<? extends InterfaceC2486<?>>, Integer> entry : f9983.entrySet()) {
            map3.put(entry.getKey().getName(), "kotlin.Function" + entry.getValue().intValue());
        }
        f9986 = map3;
        LinkedHashMap linkedHashMap = new LinkedHashMap(C4432.m13665(map3.size()));
        for (Map.Entry entry2 : map3.entrySet()) {
            linkedHashMap.put(entry2.getKey(), StringsKt__StringsKt.m7314((String) entry2.getValue(), JwtParser.SEPARATOR_CHAR, null, 2, null));
        }
        f9987 = linkedHashMap;
    }

    public C2690(Class<?> cls) {
        C3921.m12666(cls, "jClass");
        this.f9988 = cls;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C2690) && C3921.m12662(C2313.m8679(this), C2313.m8679((InterfaceC2623) obj));
    }

    public int hashCode() {
        return C2313.m8679(this).hashCode();
    }

    public String toString() {
        return mo9911().toString() + " (Kotlin reflection is not available)";
    }

    @Override // defpackage.InterfaceC3526
    /* renamed from: Ϳ, reason: contains not printable characters */
    public Class<?> mo9911() {
        return this.f9988;
    }
}
