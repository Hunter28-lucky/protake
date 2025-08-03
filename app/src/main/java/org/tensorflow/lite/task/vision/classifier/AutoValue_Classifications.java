package org.tensorflow.lite.task.vision.classifier;

import java.util.List;
import org.tensorflow.lite.support.label.Category;

/* loaded from: classes2.dex */
final class AutoValue_Classifications extends Classifications {
    private final List<Category> categories;
    private final int headIndex;

    public AutoValue_Classifications(List<Category> list, int i) {
        if (list == null) {
            throw new NullPointerException("Null categories");
        }
        this.categories = list;
        this.headIndex = i;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Classifications)) {
            return false;
        }
        Classifications classifications = (Classifications) obj;
        return this.categories.equals(classifications.getCategories()) && this.headIndex == classifications.getHeadIndex();
    }

    @Override // org.tensorflow.lite.task.vision.classifier.Classifications
    public List<Category> getCategories() {
        return this.categories;
    }

    @Override // org.tensorflow.lite.task.vision.classifier.Classifications
    public int getHeadIndex() {
        return this.headIndex;
    }

    public int hashCode() {
        return ((this.categories.hashCode() ^ 1000003) * 1000003) ^ this.headIndex;
    }

    public String toString() {
        return "Classifications{categories=" + this.categories + ", headIndex=" + this.headIndex + "}";
    }
}
