package android.view.accessibility;

import android.annotation.NonNull;
import android.annotation.Nullable;
import android.graphics.Region;
import android.os.Parcelable;
import android.view.View;
import java.util.Map;

/* loaded from: classes.dex */
public final /* synthetic */ class AccessibilityNodeInfo$TouchDelegateInfo implements Parcelable {
    static {
        throw new NoClassDefFoundError();
    }

    public /* synthetic */ AccessibilityNodeInfo$TouchDelegateInfo(@NonNull Map<Region, View> map) {
    }

    @NonNull
    public native /* synthetic */ Region getRegionAt(int i);

    public native /* synthetic */ int getRegionCount();

    @Nullable
    public native /* synthetic */ AccessibilityNodeInfo getTargetForRegion(@NonNull Region region);
}
