package org.tensorflow.lite.task.vision.detector;

import android.graphics.RectF;
import com.google.auto.value.AutoValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.tensorflow.lite.support.label.Category;
import org.tensorflow.lite.task.core.annotations.UsedByReflection;

@AutoValue
@UsedByReflection
/* loaded from: classes2.dex */
public abstract class Detection {
    @UsedByReflection
    public static Detection create(RectF rectF, List<Category> list) {
        return new AutoValue_Detection(new RectF(rectF), Collections.unmodifiableList(new ArrayList(list)));
    }

    public abstract RectF getBoundingBox();

    public abstract List<Category> getCategories();
}
