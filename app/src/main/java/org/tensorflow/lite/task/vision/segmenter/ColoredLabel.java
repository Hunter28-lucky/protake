package org.tensorflow.lite.task.vision.segmenter;

import com.google.auto.value.AutoValue;
import org.tensorflow.lite.task.core.annotations.UsedByReflection;

@AutoValue
@UsedByReflection
/* loaded from: classes2.dex */
public abstract class ColoredLabel {
    @UsedByReflection
    public static ColoredLabel create(String str, String str2, int i) {
        return new AutoValue_ColoredLabel(str, str2, i);
    }

    public abstract int getArgb();

    public abstract String getDisplayName();

    public abstract String getlabel();
}
