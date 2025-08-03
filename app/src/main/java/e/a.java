package e;

/* loaded from: classes2.dex */
public enum a {
    CAMERA(0),
    PHONE(1);

    public final int a;

    a(int i) {
        this.a = i;
    }

    public static a a(int i) {
        a aVar = PHONE;
        return aVar.a == i ? aVar : CAMERA;
    }
}
