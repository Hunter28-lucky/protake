package org.tensorflow.lite.task.vision.classifier;

import com.google.auto.value.AutoValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.tensorflow.lite.support.label.Category;
import org.tensorflow.lite.task.core.annotations.UsedByReflection;

@AutoValue
@UsedByReflection
/* loaded from: classes2.dex */
public abstract class Classifications {
    @UsedByReflection
    public static Classifications create(List<Category> list, int i) {
        return new AutoValue_Classifications(Collections.unmodifiableList(new ArrayList(list)), i);
    }

    public abstract List<Category> getCategories();

    public abstract int getHeadIndex();
}
