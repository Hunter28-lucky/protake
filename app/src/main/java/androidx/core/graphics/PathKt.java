package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Path;
import androidx.annotation.RequiresApi;
import com.umeng.analytics.pro.am;
import defpackage.C3921;
import java.util.Collection;

/* compiled from: Path.kt */
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: classes.dex */
public final class PathKt {
    @RequiresApi(19)
    public static final Path and(Path path, Path path2) {
        C3921.m12666(path, "<this>");
        C3921.m12666(path2, am.ax);
        Path path3 = new Path();
        path3.op(path, path2, Path.Op.INTERSECT);
        return path3;
    }

    @RequiresApi(26)
    public static final Iterable<PathSegment> flatten(Path path, float f) {
        C3921.m12666(path, "<this>");
        Collection<PathSegment> collectionFlatten = PathUtils.flatten(path, f);
        C3921.m12665(collectionFlatten, "flatten(this, error)");
        return collectionFlatten;
    }

    public static /* synthetic */ Iterable flatten$default(Path path, float f, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.5f;
        }
        return flatten(path, f);
    }

    @RequiresApi(19)
    public static final Path minus(Path path, Path path2) {
        C3921.m12666(path, "<this>");
        C3921.m12666(path2, am.ax);
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.DIFFERENCE);
        return path3;
    }

    @RequiresApi(19)
    public static final Path or(Path path, Path path2) {
        C3921.m12666(path, "<this>");
        C3921.m12666(path2, am.ax);
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.UNION);
        return path3;
    }

    @RequiresApi(19)
    public static final Path plus(Path path, Path path2) {
        C3921.m12666(path, "<this>");
        C3921.m12666(path2, am.ax);
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.UNION);
        return path3;
    }

    @RequiresApi(19)
    public static final Path xor(Path path, Path path2) {
        C3921.m12666(path, "<this>");
        C3921.m12666(path2, am.ax);
        Path path3 = new Path(path);
        path3.op(path2, Path.Op.XOR);
        return path3;
    }
}
