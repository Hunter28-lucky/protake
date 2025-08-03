package org.tensorflow.lite.task.vision.detector;

import android.graphics.RectF;
import java.util.List;
import org.tensorflow.lite.support.label.Category;

/* loaded from: classes2.dex */
final class AutoValue_Detection extends Detection {
    private final RectF boundingBox;
    private final List<Category> categories;

    public AutoValue_Detection(RectF rectF, List<Category> list) {
        if (rectF == null) {
            throw new NullPointerException("Null boundingBox");
        }
        this.boundingBox = rectF;
        if (list == null) {
            throw new NullPointerException("Null categories");
        }
        this.categories = list;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Detection)) {
            return false;
        }
        Detection detection = (Detection) obj;
        return this.boundingBox.equals(detection.getBoundingBox()) && this.categories.equals(detection.getCategories());
    }

    @Override // org.tensorflow.lite.task.vision.detector.Detection
    public RectF getBoundingBox() {
        return this.boundingBox;
    }

    @Override // org.tensorflow.lite.task.vision.detector.Detection
    public List<Category> getCategories() {
        return this.categories;
    }

    public int hashCode() {
        return ((this.boundingBox.hashCode() ^ 1000003) * 1000003) ^ this.categories.hashCode();
    }

    public String toString() {
        return "Detection{boundingBox=" + this.boundingBox + ", categories=" + this.categories + "}";
    }
}
