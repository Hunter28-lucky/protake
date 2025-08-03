package defpackage;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* compiled from: JvmClassMapping.kt */
/* renamed from: Ă, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C2313 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final <T> Class<T> m8678(InterfaceC2623<T> interfaceC2623) {
        C3921.m12666(interfaceC2623, "<this>");
        return (Class<T>) ((InterfaceC3526) interfaceC2623).mo9911();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final <T> Class<T> m8679(InterfaceC2623<T> interfaceC2623) {
        C3921.m12666(interfaceC2623, "<this>");
        Class<T> cls = (Class<T>) ((InterfaceC3526) interfaceC2623).mo9911();
        if (!cls.isPrimitive()) {
            return cls;
        }
        String name = cls.getName();
        switch (name.hashCode()) {
            case -1325958191:
                if (!name.equals("double")) {
                }
                break;
            case 104431:
                if (!name.equals("int")) {
                }
                break;
            case 3039496:
                if (!name.equals("byte")) {
                }
                break;
            case 3052374:
                if (!name.equals("char")) {
                }
                break;
            case 3327612:
                if (!name.equals("long")) {
                }
                break;
            case 3625364:
                if (!name.equals("void")) {
                }
                break;
            case 64711720:
                if (!name.equals(TypedValues.Custom.S_BOOLEAN)) {
                }
                break;
            case 97526364:
                if (!name.equals(TypedValues.Custom.S_FLOAT)) {
                }
                break;
            case 109413500:
                if (!name.equals("short")) {
                }
                break;
        }
        return cls;
    }
}
