package defpackage;

import androidx.collection.ArrayMap;
import com.blink.academy.film.videotools.camera.AspectRatio;
import java.util.SortedSet;
import java.util.TreeSet;

/* compiled from: SizeMap.java */
/* renamed from: ඥ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4808 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final ArrayMap<AspectRatio, SortedSet<C2375>> f16288 = new ArrayMap<>();

    public String toString() {
        return "SizeMap{mRatios=" + this.f16288 + '}';
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean m14528(C2375 c2375) {
        for (AspectRatio aspectRatio : this.f16288.keySet()) {
            if (aspectRatio.m2076(c2375)) {
                SortedSet<C2375> sortedSet = this.f16288.get(aspectRatio);
                if (sortedSet.contains(c2375)) {
                    return false;
                }
                sortedSet.add(c2375);
                return true;
            }
        }
        TreeSet treeSet = new TreeSet();
        treeSet.add(c2375);
        this.f16288.put(AspectRatio.m2074(c2375.m8846(), c2375.m8843()), treeSet);
        return true;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m14529() {
        this.f16288.clear();
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public SortedSet<C2375> m14530(AspectRatio aspectRatio) {
        return this.f16288.get(aspectRatio);
    }
}
